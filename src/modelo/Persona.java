// ============================================================================
// CLASE BASE: Persona (Abstracción y Herencia)
// ============================================================================
package modelo;
/**
 * Clase abstracta Persona - Representa a cualquier persona en el sistema.
 * Es abstracta porque no vamos a crear "personas genéricas", sino específicas:
 * Usuario o Bibliotecario.
 * 
 * Contiene los atributos comunes a todas las personas.
 */
public abstract class Persona {
    //Atributos protegidos que pueden ser accedidos por clases hijas
    protected int id;
    protected String nombre;
    protected String apellido;
    protected String documento;
    protected String telefono;
    
    //Constructor
    public Persona(int id, String nombre, String apellido, String documento, String telefono){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.telefono = telefono;
    }
    
    // Método abstracto - DEBE ser implementado por las clases hijas
    // Cada tipo de persona se presentará de forma diferente
    public abstract String obtenerRol();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //Metodo para mostrar la informacion de la persona
    @Override
    public String toString(){
        return String.format("ID: %d | Nombre: %s | Doc: %s | Tel: %s | Rol: %s",
                            id, nombre, documento, telefono, obtenerRol());
    }
}
