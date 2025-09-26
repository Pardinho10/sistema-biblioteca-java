
package servicio;
import modelo.Bibliotecario;
import modelo.Libro;
import modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author Pardinho
 */

// ========== CLASE PRINCIPAL DEL SISTEMA ==========
public class SistemaBiblioteca {
   // Estructuras de almacenamiento básicas (fáciles de adaptar a BD)
    private Map<String, Usuario> usuarios; //key: cedula
    private Map<String, Libro> libros; //key: isbn
    private List<Bibliotecario> bibliotecarios;
    private Scanner scanner;
    
    //Constructor
    public SistemaBiblioteca(){
        usuarios = new HashMap<>();
        libros = new HashMap<>();
        bibliotecarios = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    //Mostramos datos de ejemplo
    
    public void cargarDatosEjemplo(){
        //Creamos usuarios
        Usuario usu1 = new Usuario("Juan" , "Pérez", "12345678", 25, "juan@email.com");
        Usuario usu2 = new Usuario("María", "García", "87654321", 30, "maria@email.com");
        usuarios.put(usu1.getCedula(), usu1);
        usuarios.put(usu2.getCedula(), usu2);
        
        //Creamos bibliotecarios
        Bibliotecario bib1 = new Bibliotecario("Ana", "López", "11111111", 35, "Mañana", 2500.0);
        Bibliotecario bib2 = new Bibliotecario("Carlos", "Ruiz", "22222222", 40, "Tarde", 2700.0);
        bibliotecarios.add(bib1);
        bibliotecarios.add(bib2);
        
        //Creamos libros
        Libro libro1 = new Libro("978-123-456", "Cien Años de Soledad", "Gabriel García Márquez", "Literatura");
        Libro libro2 = new Libro("978-789-012", "Java: The Complete Reference", "Herbert Schildt", "Programación");
        Libro libro3 = new Libro("978-345-678", "1984", "George Orwell", "Ciencia Ficción");
        libros.put(libro1.getIsbn(), libro1);
        libros.put(libro2.getIsbn(), libro2);
        libros.put(libro3.getIsbn(), libro3);

    }
    
     // ========== MÉTODOS DE GESTIÓN DE USUARIOS ==========
        public void registrarUsuario(){
            try {
                System.out.println("\n=== REGISTRAR USUARIO===");
                System.out.println("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.println("Apellido: ");
                String apellido = scanner.nextLine();
                System.out.println("Cedula: ");
                String cedula = scanner.nextLine();
                //validación que verifica si el usuario ya existe
                if (usuarios.containsKey(cedula)) {
                    System.out.println("Error: Ya existe un usuario con esa cedula");
                    return;
                }
                System.out.println("Edad: ");
                int edad = Integer.parseInt(scanner.nextLine());
                
                System.out.println("Email: ");
                String email = scanner.nextLine();
                
                //Creamos una nueva isntancia de Usuario
                Usuario nuevoUsuario = new Usuario(nombre, apellido, cedula, edad, email);
                usuarios.put(nuevoUsuario.getCedula(), nuevoUsuario);
                
                System.out.println("Usuario registrado exitosamente: " + nuevoUsuario);// metodo toString
                
            } catch (NumberFormatException e) {
                System.out.println("Error La edad debe ser un número valido");
            } catch (Exception e){
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }    
    
    public void listarUsuarios(){
        System.out.println("\n=== LISTA DE USUARIOS ===");
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados");
            return;
        }
        for(Usuario usuario : usuarios.values()){
            System.out.println(usuario);
        }
    }
    
    // ========== MENÚ PRINCIPAL ==========
    public void mostrarMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("       SISTEMA DE GESTIÓN DE BIBLIOTECA");
        System.out.println("=".repeat(50));
        System.out.println("1.  Registrar usuario");
        System.out.println("2.  Listar usuarios");
        System.out.println("3.  Registrar libro");
        System.out.println("4.  Listar todos los libros");
        System.out.println("5.  Listar libros disponibles");
        System.out.println("6.  Buscar libros");
        System.out.println("7.  Prestar libro");
        System.out.println("8.  Devolver libro");
        System.out.println("9.  Listar bibliotecarios");
        System.out.println("0.  Salir");
        System.out.println("=".repeat(50));
        System.out.print("Seleccione una opción: ");
    }
    
    // Método principal para ejecutar el sistema
    public void ejecutar(){
        System.out.println("=============SISTEMA DE GESTION DE BIBLIOTECA============");
        
        while (true) {            
            try {
                mostrarMenu();
                int opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        registrarUsuario();
                        break;
                    case 2:
                        listarUsuarios();
                        break;
                    default:
                        throw new AssertionError();
                }
                
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                System.out.println("\nPresione enter para continuar...");
                scanner.nextLine();
            }
        }
    }
}
