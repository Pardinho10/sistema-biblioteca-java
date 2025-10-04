// ============================================================================
// CLASE: SistemaBiblioteca - Main - Inicio de nuestra aplicación
// ============================================================================
/**
 * Clase principal del sistema - Punto de entrada de la aplicación.
 * 
 * RESPONSABILIDAD: Únicamente iniciar la aplicación.
 * 
 * Esta clase es extremadamente simple y solo delega la ejecución
 * a la clase MenuConsola que maneja toda la interacción con el usuario.
 * 
 * Ventajas de este diseño:
 * 1. Separación de responsabilidades clara
 * 2. Fácil de mantener y extender
 * 3. Posibilidad de crear múltiples interfaces (GUI, Web, etc.) sin tocar el main
 * 4. Testing más sencillo
 * 5. Código más profesional y organizado
 */
package sistemagestionbiblioteca;
import ui.MenuConsola;
/**
 *
 * @author Pardinho
 */
public class SistemaBiblioteca {
    /**
     * Método main - Punto de entrada de la aplicación Java.
     * 
     * Solo crea una instancia de MenuConsola y la inicia.
     * Todo el resto de la lógica está delegado a otras clases.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Iniciamos nuestra aplicación
        // Creamos interfaz en Consola
        MenuConsola menu = new MenuConsola();
        // Iniciar sistema
        menu.iniciar();
    }
    
}
