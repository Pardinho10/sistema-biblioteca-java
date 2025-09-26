
package servicio;
import java.util.Scanner;
/**
 *
 * @author Pardinho
 */
public class SistemaBiblioteca {
    private Scanner scanner;
    
    //Constructor
    public SistemaBiblioteca(){
        scanner = new Scanner(System.in);
    }
    
    
    public void listarUsuarios(){
        System.out.println("\n=== LISTA DE USUARIOS ===");
        
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
                        //registrarUsuario();
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
