// ============================================================================
// CLASE: Menú consola ()
// ============================================================================
package ui;

import servicio.BibliotecaServicio;
import modelo.*;
import excepciones.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Clase MenuConsola - Maneja toda la interacción con el usuario por consola.
 *
 * RESPONSABILIDAD: Presentación y captura de datos. Esta clase se encarga SOLO
 * de la interfaz de usuario, NO de la lógica de negocio.
 *
 * Separación de responsabilidades: - MenuConsola: Interfaz de usuario (Vista) -
 * BibliotecaServicio: Lógica de negocio (Controlador/Servicio) - Modelo: Datos
 * (Entidades)
 */
public class MenuConsola {

    // Servicio que contiene toda la logica de negocio
    private BibliotecaServicio servicio;
    // Scanner para leer entrada de usuario
    private Scanner scanner;

    /**
     * Constructor - inicializa el servicio y el scanner
     */
    public MenuConsola() {
        this.servicio = new BibliotecaServicio();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el banner de bienvenida
     */
    private void mostrarBienvenida() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  SISTEMA DE GESTIÓN DE BIBLIOTECAS    ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    /**
     * Muestra el mensaje de despedida
     */
    private void mostrarDespedida() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║  ¡Gracias por usar el sistema!        ║");
        System.out.println("║  Hasta pronto.                         ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    /**
     * Muestra el menú principal
     */
    private void mostrarMenuPrincipal() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           MENÚ PRINCIPAL");
        System.out.println("=".repeat(40));
        System.out.println("1. Gestión de Materiales");
        System.out.println("2. Gestión de Usuarios");
        System.out.println("3. Gestión de Bibliotecarios");
        System.out.println("4. Gestión de Préstamos");
        System.out.println("5. Ver Estadísticas");
        System.out.println("0. Salir");
        System.out.println("=".repeat(40));
    }

    /**
     * Método principal que inicia el sistema. Este es el punto de entrada de la
     * aplicación desde el main.
     */
    public void iniciar() {
        // Cargar datos de ejemplo
        cargarDatosEjemplo();
        boolean salir = false;
        mostrarBienvenida();

        // Bucle principal del menú
        while (!salir) {
            try {
                mostrarMenuPrincipal();
                int opcion = leerEnteroSeguro("Seleccione una opción");
                switch (opcion) {
                    case 1:
                        menuMateriales();
                        break;
                    case 2:
                        menuUsuarios();
                        break;
                    case 3:
                        menuBibliotecarios();
                        break;
                    case 4:
                        menuPrestamos();
                        break;
                    case 5:
                        mostrarEstadisticas();
                        break;
                    case 0:
                        salir = true;
                        mostrarDespedida();
                        break;
                    default:
                        System.out.println("❌ Opción inválida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error inesperado: " + e.getMessage());
            }
            // Cerrar el scanner al finalizar
            scanner.close();
        }
    }

    // ========== MENÚ MATERIALES ==========
    private void menuMateriales() {
        System.out.println("\n--- GESTIÓN DE MATERIALES ---");
        System.out.println("1. Registrar Libro");
        System.out.println("2. Registrar Revista");
        System.out.println("3. Listar todos los Materiales");
        System.out.println("4. Buscar Material por Título");
        System.out.println("0. Volver");

        int opcion = leerEnteroSeguro("Opcion: ");
        switch (opcion) {
            case 1:
                registrarLibro();
                break;
            case 2:
                registrarRevista();
                break;
            case 3:
                listarMateriales();
                break;
            case 4:
                buscarMaterialPorTitulo();
                break;
        }

    }

    private void registrarLibro() {
        try {
            System.out.println("\n--- REGISTRAR LIBRO ---");
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            System.out.println("Autor: ");
            String autor = scanner.nextLine();
            int anio = leerEnteroSeguro("Año de publicación: ");
            System.out.println("ISBN: ");
            String isbn = scanner.nextLine();
            int numPaginas = leerEnteroSeguro("Número de paginas");
            System.out.println("Editorial: ");
            String editorial = scanner.nextLine();

            int id = servicio.registrarLibro(titulo, autor, anio,
                    isbn, numPaginas, editorial);
            System.out.println("✅ Libro registrado exitosamente con ID: " + id);

        } catch (Exception e) {
            System.out.println("❌ Error al registrar libro: " + e.getMessage());
        }
    }

    private void registrarRevista() {
        try {
            System.out.println("\n--- REGISTRAR REVISTA ---");
            System.out.println("Título: ");
            String titulo = scanner.nextLine();

            System.out.println("Autor/Editor: ");
            String autor = scanner.nextLine();

            int anio = leerEnteroSeguro("Año: ");
            int edicion = leerEnteroSeguro("Número de edición: ");

            System.out.println("Mes de publicación: ");
            String mes = scanner.nextLine();

            System.out.println("Categoría: ");
            String categoria = scanner.nextLine();

            int id = servicio.registrarRevista(titulo, autor,
                    anio, edicion, mes, categoria);
            System.out.println("✅ Revista registrada exitosamente con ID: " + id);

        } catch (Exception e) {
            System.out.println("❌ Error al registrar revista: " + e.getMessage());
        }
    }

    private void listarMateriales() {
        List<Material> materiales = servicio.obtenerTodosMateriales();

        if (materiales.isEmpty()) {
            System.out.println("📚 No hay materiales registrados.");
            return;
        }

        System.out.println("\n" + "=".repeat(80));
        System.out.println("                          LISTA DE MATERIALES");
        System.out.println("=".repeat(80));

        for (Material mat : materiales) {
            System.out.println(mat);
        }
        System.out.println("=".repeat(80));
    }

    private void buscarMaterialPorTitulo() {
        System.out.print("\nIngrese el título a buscar: ");
        String titulo = scanner.nextLine();

        List<Material> resultados = servicio.buscarMaterialesPorTitulo(titulo);

        if (resultados.isEmpty()) {
            System.out.println("❌ No se encontraron materiales con ese título.");
            return;
        }

        System.out.println("\n📚 Resultados encontrados: " + resultados.size());
        for (Material m : resultados) {
            System.out.println(m);
        }
    }

    // ========== MENÚ USUARIOS ==========
    private void menuUsuarios() {
        System.out.println("\n--- GESTIÓN DE USUARIOS ---");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Listar todos los Usuarios");
        System.out.println("0. Volver");

        int opcion = leerEnteroSeguro("Opción");

        switch (opcion) {
            case 1:
                registrarUsuario();
                break;
            case 2:
                listarUsuarios();
            default:
                throw new AssertionError();
        }
    }

    private void registrarUsuarios() {
        try {
            System.out.println("\n--- REGISTRAR USUARIO ---");
            System.out.print("Nombre completo: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellido completo: ");
            String apellido = scanner.nextLine();

            System.out.println("Documento (DNI/CI): ");
            String documento = scanner.nextLine();

            System.out.println("Teléfono: ");
            String tel = scanner.nextLine();

            System.out.println("Email: ");
            String correo = scanner.nextLine();

            // Validación: el servicio lanzará excepción si el email está vacío
            int id = servicio.registrarUsuario(nombre, apellido, documento, tel, correo);
            System.out.println("✅ Usuario registrado exitosamente con ID: " + id);

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error al registrar usuario: " + e.getMessage());
        }
    }

    private void listarUsuarios() {
        List<Usuario> usu = servicio.obtenerTodosUsuarios();

        if (usu.isEmpty()) {
            System.out.println("👥 No hay usuarios registrados.");
            return;
        }

        System.out.println("\n" + "=".repeat(80));
        System.out.println("                          LISTA DE USUARIOS");
        System.out.println("=".repeat(80));

        for (Usuario usuarillo : usu) {
            System.out.println(usuarillo);
        }
        System.out.println("=".repeat(80));
    }

    // ========== MENÚ BIBLIOTECARIOS ==========
    private void menuBibliotecarios() {
        System.out.println("\n--- GESTIÓN DE BIBLIOTECARIOS ---");
        System.out.println("1. Registrar Bibliotecario");
        System.out.println("2. Listar todos los Bibliotecarios");
        System.out.println("0. Volver");

        int opcion = leerEnteroSeguro("Opción: ");

        switch (opcion) {
            case 1:
                registrarBibliotecario();
                break;
            case 2:
                listarBibliotecarios();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void resgistrarBibliotecario() {
        try {
            System.out.println("\n--- REGISTRAR BIBLIOTECARIO ---");
            System.out.print("Nombre completo: ");
            String nombre = scanner.nextLine();

            System.out.println("Apellido completo: ");
            String apellido = scanner.nextLine();

            System.out.println("Documento (DNI/CI)");
            String docu = scanner.nextLine();

            System.out.println("Teléfono: ");
            String tel = scanner.nextLine();

            System.out.print("Turno (MAÑANA/TARDE/NOCHE): ");
            String turno = scanner.nextLine().toUpperCase();

            int antiguedad = leerEnteroSeguro("Años de antiguedad: ");

            int id = servicio.registrarBibliotecario(nombre,
                    apellido, docu, tel, turno, antiguedad);
            System.out.println("✅ Bibliotecario registrado exitosamente con ID: " + id);
        } catch (Exception e) {
            System.out.println("❌ Error al registrar bibliotecario: " + e.getMessage());
        }
    }

    private void listarBibliotecarios() {
        List<Bibliotecario> bibliotecarios = servicio.obtenerTodosBibliotecarios();

        if (bibliotecarios.isEmpty()) {
            System.out.println("👨‍💼 No hay bibliotecarios registrados.");
            return;
        }
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                       LISTA DE BIBLIOTECARIOS");
        System.out.println("=".repeat(80));
        
        for (Bibliotecario b : bibliotecarios) {
            System.out.println(b);
            if (b.tieneMasDe5Anios()) {
                System.out.println("  ⭐ Bibliotecario con más de 5 años de experiencia");
            }
        }
        System.out.println("=".repeat(80));
    }
    
    // ========== MENÚ PRÉSTAMOS ==========
    
    private void menuPrestamos() {
        System.out.println("\n--- GESTIÓN DE PRÉSTAMOS ---");
        System.out.println("1. Realizar Préstamo");
        System.out.println("2. Devolver Material");
        System.out.println("3. Listar Préstamos Activos");
        System.out.println("4. Listar Todos los Préstamos");
        System.out.println("0. Volver");
        
        
    }

// ========== MÉTODOS AUXILIARES ==========
    /**
     * Lee un entero de forma segura, manejando excepciones de entrada inválida.
     * Ejemplo de manejo de excepciones estándar de Java
     * (InputMismatchException)
     */
    private int leerEnteroSeguro(String mensaje) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.println(mensaje);
                numero = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Debe ingresar un número entero.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
        return numero;
    }

}
