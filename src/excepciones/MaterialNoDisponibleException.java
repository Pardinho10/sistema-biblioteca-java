// ============================================================================
// CLASE BASE: MaterialNoDisponibleException
// ============================================================================
package excepciones;
/**
 * Excepción personalizada que se lanza cuando un material no está disponible para préstamo.
 * Por ejemplo: cuando un libro ya está prestado a otro usuario.
 */
public class MaterialNoDisponibleException extends Exception{
    //Constructor que recibe un mensaje descriptivo del error
    public MaterialNoDisponibleException(String mensaje){
        super(mensaje);
    }
}
