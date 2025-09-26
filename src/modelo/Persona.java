package modelo;

/**
 *
 * @author Pardinho
 */
// ========== CLASE ABSTRACTA PERSONA ==========
// Ejemplo de herencia y polimorfismo
// sin modificador para ser solo accedido desde el mismo package (package-private)
public abstract class Persona {
    //Encapsulación: atributos privados
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    
    public Persona(String nombre, String apellido,String cedula, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
    }
    
    // Getters y Setters (Encapsulación)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    // Método abstracto - debe ser implementado por las clases hijas
    public abstract String getTipoPersona();
    
    //Método concreto que pueden utilizar las clases hijas

     public String getInformacionBasica() {
        return "Nombre: " + nombre + ", Cédula: " + cedula + ", Edad: " + edad;
    }
    
}

