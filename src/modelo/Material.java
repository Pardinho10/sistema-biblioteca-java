// ============================================================================
// CLASE: Material (Implementa de Prestable)
// ============================================================================
package modelo;
import interfaz.Prestable;
/**
 * Clase abstracta Material - Representa cualquier material de la biblioteca.
 * Es abstracta porque no creamos "materiales genéricos", sino específicos: Libro, Revista, etc.
 * 
 * Implementa Prestable porque todos los materiales pueden prestarse.
 */
public abstract class Material implements Prestable{
    protected int id;
    protected String titulo;
    protected String autor;
    protected int anioPublicacion;
    protected boolean disponible; //true = disponible, false = prestado
    
    //Constructor
    public Material(int id, String titulo, String autor, int anioPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true; //Por defecto el material esta disponible
    }
    
    // Implementacion de los metodos de la interfaz Prestable
    @Override
    public void prestar(){
        this.disponible = false;
    }
    
    @Override
    public void devolver(){
        this.disponible = true;
    }
    
    @Override
    public boolean estaDisponible(){
        return disponible;
    }
    
    // Método abstracto - cada tipo de material mostrará su tipo
    public abstract String obtenerTipo();
    
    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString(){
        String estado = disponible ? "DISPONIBLE" : "PRESTADO"; // if ternario
        return String.format("ID: %d | %s | Título: %s | Autor: %s | Año: %d | Estado: %s",
                id, obtenerTipo(), titulo, autor, anioPublicacion, estado);
    }
}
        
