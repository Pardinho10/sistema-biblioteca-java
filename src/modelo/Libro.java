// ============================================================================
// CLASE: Libro (Hereda de Clase Material)
// ============================================================================
package modelo;
/**
 * Clase Libro - Representa un libro específico en la biblioteca.
 * Hereda de Material y agrega atributos propios de los libros.
 *//**
 * Clase Libro - Representa un libro específico en la biblioteca.
 * Hereda de Material y agrega atributos propios de los libros.
 */
public class Libro extends Material{
    private String isbn;
    private int numeroPaginas;
    private String editorial;
    
    // Constructor -usas super() para llmar al constructor de clase padre
    public Libro(int id, String titulo, String autor, int anioPublicacion, 
            String isbn, int numeroPaginas, String editorial ){
            super(id, titulo, autor, anioPublicacion);
            this.isbn = isbn;
            this.numeroPaginas = numeroPaginas;
            this.editorial = editorial;
    }
    
    // Cosntructor sobrecargado - version simplificada
    public Libro(int id, String titulo, String autor, int anioPublicacion, 
            String isbn){
        this(id, titulo, autor, anioPublicacion, isbn, 0, "Desconocida");
    }
    
    // Implementacion del metodo abstracto
    @Override
    public String obtenerTipo(){
        return "LIBRO";
    }
    
    // Getters y Setters

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    @Override
    public String toString(){
        return super.toString() + " | ISBN: " + isbn + " | Páginas: " + numeroPaginas;
    }
    
    
    
    
}
