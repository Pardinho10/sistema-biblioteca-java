// ============================================================================
// CLASE: Usuario (Hereda de Clase Persona)
// ============================================================================
package modelo;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase Usuario - Representa a un usuario de la biblioteca.
 * Hereda de Persona y agrega funcionalidad específica de usuarios.
 */
public class Usuario extends Persona{
    private String email;
    private List<Integer> historialPrestamos; //IDs de los prestamos
    
    //Constructor
    public Usuario(int id, String nombre, String apellido, String documento, String telefono, String email){
        super(id, nombre, apellido, documento, telefono); //Llama al constructor de la clase padre
        this.email = email;
        this.historialPrestamos = new ArrayList<>();
        
    }
    
    //implementación del método abtsracto de Persona
    @Override
    public String obtenerRol(){
        return "USUARIO";
    }
    
    // Método especifico de Usuario
    public void agregarPrestamo(int idPrestamo){
        historialPrestamos.add(idPrestamo);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getHistorialPrestamos() {
        return historialPrestamos;
    }
    @Override
    public String toString(){
        return super.toString() + " | Email: " + email;
    }
    
}
