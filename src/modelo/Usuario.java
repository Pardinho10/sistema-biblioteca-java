package modelo;

/**
 *
 * @author Pardinho
 */

// ========== CLASE USUARIO (HEREDA DE PERSONA) ==========
public class Usuario extends Persona {
    private String email;
    private int librosEnPrestamo;
    private final int LIMITE_LIBROS = 4; //Constante
    
    // Constructor - llama al constructor de la clase padre
    public Usuario(String nombre, String apellido, String cedula, int edad, String email){
        super(nombre, apellido, cedula, edad); //llamada al constructor padre
        this.email = email;
        this.librosEnPrestamo = 0;
    }
    
    //Implementación del metodo abstracto
    @Override
    public String getTipoPersona(){
        return "Usuario";
    }
    
    //Getters y Setters especificos

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLibrosEnPrestamo() {
        return librosEnPrestamo;
    }

    public void setLibrosEnPrestamo(int librosEnPrestamo) {
        this.librosEnPrestamo = librosEnPrestamo;
    }
    
    public boolean puedeTomarPrestamo(){
        return librosEnPrestamo < LIMITE_LIBROS;
    }
    
    public void incrmentarPrestamos(){
        if (puedeTomarPrestamo()) {
            librosEnPrestamo++;
        }
    }
    
    public void decrementarPrestamo(){
        if (librosEnPrestamo > 0) {
            librosEnPrestamo--;
        }
    }
    
    // Sobrescritura del toString para mejor visualización
    @Override
    public String toString() {
        return getTipoPersona() + " - " + getInformacionBasica() + 
               ", Email: " + email + ", Libros en préstamo: " + librosEnPrestamo;
    }
}
