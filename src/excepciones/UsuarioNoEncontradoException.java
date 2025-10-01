// ============================================================================
// CLASE: UsuarioNoEncontradoException
// ============================================================================
package excepciones;
/**
 * Excepción personalizada que se lanza cuando no se encuentra un usuario en el sistema.
 * Útil para operaciones de búsqueda o préstamo.
 */
public class UsuarioNoEncontradoException extends Exception{
    
    public UsuarioNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
