// ============================================================================
// CLASE: BibliotecaServicio 
// ============================================================================
package servicio;

import modelo.*;
import excepciones.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase BibliotecaServicio - Gestiona toda la lógica de negocio del sistema.
 * Usa colecciones (ArrayList y HashMap) que son fáciles de migrar a base de
 * datos.
 *
 * HashMap se usa para búsquedas rápidas por ID. ArrayList para mantener listas
 * ordenadas.
 */
public class BibliotecaServicio {
    // Colecciones para almacenar datos (simula tablas de base de datos)

    private Map<Integer, Material> materiales; // Clave: ID, Valor: Material
    private Map<Integer, Usuario> usuarios; //Clave: ID, Valor: Usuario
    private Map<Integer, Bibliotecario> bibliotecarios;
    private Map<Integer, Prestamo> prestamos;
    // Contadores para generar IDs autoincremantales (simula AUTOINCREMENT de BD)
    private int contadorMateriales;
    private int contadorUsuarios;
    private int contadorBibliotecarios;
    private int contadorPrestamos;

    // Constructor
    public BibliotecaServicio() {
        materiales = new HashMap<>();
        usuarios = new HashMap<>();
        bibliotecarios = new HashMap<>();
        prestamos = new HashMap<>();

        contadorMateriales = 1;
        contadorUsuarios = 1;
        contadorBibliotecarios = 1;
        contadorPrestamos = 1;
    }

    // ========== MÉTODOS PARA MATERIALES ==========
    /**
     * Registra un libro en el sistema
     *
     * @return ID del libro registrado
     */
    public int registrarLibro(String titulo, String autor, int anio,
            String isbn, int pagina, String editorial) {
        Libro libro = new Libro(contadorMateriales, titulo, autor,
                anio, isbn, pagina, editorial);
        materiales.put(contadorMateriales, libro);
        return contadorMateriales++;
    }

    /**
     * Registra una revista en el sistema
     *
     * @return ID de la revista registrada
     */
    public int registrarRevista(String titulo, String autor, int anio,
            int edicion, String mes, String categoria) {
        Revista revista = new Revista(contadorMateriales, titulo, autor,
                edicion, edicion, mes, categoria);
        materiales.put(contadorMateriales, revista);
        return contadorMateriales++;
    }

    /**
     * Obtiene todos los materiales (Polimorfismo: puede devolver Libros y
     * Revistas juntos)
     */
    public List<Material> obtenerTodosMateriales() {
        return new ArrayList<>(materiales.values());
    }

    /**
     * Busca un material por ID
     */
    public Material buscarMaterialesPorID(int id) {
        return materiales.get(id);
    }

    /**
     * Busca materiales por título (búsqueda parcial)
     */
    public List<Material> buscarMaterialesPorTitulo(String titulo) {
        List<Material> resultado = new ArrayList<>();
        for (Material m : materiales.values()) {
            if (m.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    // ========== MÉTODOS PARA USUARIOS ==========
    /**
     * Registra un usuario en el sistema Valida que el email no esté vacío
     */
    public int registrarUsuario(String nombre, String apellido, String documento,
            String tel, String email) throws IllegalArgumentException {
        // Validación básica
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede estar vacio");
        }

        Usuario usuario = new Usuario(contadorUsuarios, nombre, apellido, documento, tel, email);
        usuarios.put(contadorUsuarios, usuario);
        return contadorUsuarios++;
    }

    /**
     * Obtiene todos los usuarios
     */
    public List<Usuario> obtenerTodosUsuarios() {
        return new ArrayList<>(usuarios.values());
    }

    /**
     * Busca un usuario por ID y lanza excepción si no existe
     */
    public Usuario buscarUsuarioPorId(int id) throws UsuarioNoEncontradoException {
        Usuario usuario = usuarios.get(id);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException("Usuario con ID " + id
                    + "no encontrado");
        }
        return usuario;
    }

    // ========== MÉTODOS PARA BIBLIOTECARIOS ==========
    public int registrarBibliotecario(String nombre, String apellido, String documento,
            String tel, String turno, int antigue) {
        Bibliotecario biblio = new Bibliotecario(contadorBibliotecarios, nombre, apellido, documento, turno, turno, antigue);
        bibliotecarios.put(contadorBibliotecarios, biblio);
        return contadorBibliotecarios++;
    }

    public List<Bibliotecario> obtenerTodosBibliotecarios() {
        return new ArrayList<>(bibliotecarios.values());
    }

    // ========== MÉTODOS PARA PRÉSTAMOS ==========
    /**
     * Realiza un préstamo de material a un usuario. Valida que el material esté
     * disponible y que el usuario exista.
     */
    public int realizarPrestamo(int idUsuario, int idMaterial) throws
            UsuarioNoEncontradoException, MaterialNoDisponibleException {
        // Buscar usuario (lanza una excepcion si no existe)
        Usuario usuario = buscarUsuarioPorId(idUsuario);

        // Buscar material
        Material material = materiales.get(idMaterial);
        if (material == null) {
            throw new IllegalArgumentException("Material no encontrado");
        }

        // Verificar disponibilidad
        if (!material.estaDisponible()) {
            throw new MaterialNoDisponibleException("El material '"
                    + material.getTitulo() + "' no está disponible para préstamo");
        }
        // Crear prestamo
        Prestamo prestamo = new Prestamo(contadorPrestamos, usuario, material);
        prestamos.put(contadorPrestamos, prestamo);

        // Marcar material como prestado
        material.prestar();

        // Agregar al historial del usuario
        usuario.agregarPrestamo(contadorPrestamos);

        return contadorPrestamos++;
    }

    /**
     * Registra la devolución de un material
     */
    public void devolverMaterial(int idPrestamo) throws IllegalArgumentException {
        Prestamo presta = prestamos.get(idPrestamo);
        if (presta == null) {
            throw new IllegalArgumentException("Préstamo con encontrado");
        }

        if (!presta.isActivo()) {
            throw new IllegalArgumentException("Préstamo devuelto con anterioridad");
        }

        presta.registrarDevolucion();
    }

    /**
     * Obtiene todos los préstamos activos
     */
    public List<Prestamo> obtenerPrestamosActivos() {
        List<Prestamo> activos = new ArrayList<>();
        for (Prestamo p : prestamos.values()) {
            if (p.isActivo()) {
                activos.add(p);
            }
        }
        return activos;
    }

    /**
     * Obtiene todos los préstamos (activos e inactivos)
     */
    public List<Prestamo> obtenerTodosPrestamos() {
        return new ArrayList<>(prestamos.values());
    }

    /**
     * Obtiene estadísticas básicas del sistema
     */
    public String obtenerEstadisticas() {
        int materialesDisponibles = 0;
        for (Material m : materiales.values()) {
            if (m.estaDisponible()) {
                materialesDisponibles++;
            }
        }

        int prestamosActivos = obtenerPrestamosActivos().size();

        return String.format(
                "=== ESTADÍSTICAS ===\n"
                + "Total Materiales: %d (Disponibles: %d, Prestados: %d)\n"
                + "Total Usuarios: %d\n"
                + "Total Bibliotecarios: %d\n"
                + "Préstamos Activos: %d\n"
                + "Préstamos Totales: %d", 
                materiales.size(), materialesDisponibles, materiales.size() - materialesDisponibles,
                usuarios.size(), bibliotecarios.size(), prestamosActivos, prestamos.size());
    }
    
}
