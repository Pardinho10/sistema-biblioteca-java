package modelo;

/**
 *
 * @author Pardinho
 */

// ========== CLASE LIBRO ==========
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;
    private boolean disponible;
    private String usuarioPrestamo; //Cédula del usuario que tiene el libro
    
    // Constructor sobrecargado - ejemplo de sobrecarga de constructores
    public Libro(String isbn, String titulo, String autor){
        this(isbn, titulo, autor, "General"); //llama al constructor completo
    }
    // 2 constructores, si se eleige el primero, la categoria sera sempre "General", 
    // si se elige el segundo se deb seleccionar categoria
    public Libro(String isbn, String titulo, String autor, String categoria){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.usuarioPrestamo = null;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getUsuarioPrestamo() {
        return usuarioPrestamo;
    }

    public void setUsuarioPrestamo(String usuarioPrestamo) {
        this.usuarioPrestamo = usuarioPrestamo;
    }
    
    //metodo de negocio
    public void prestar(String cedulaUsuario){
        this.disponible = false;
        this.usuarioPrestamo = cedulaUsuario;
    }
    
    public void devolver(){
        this.disponible = true;
        this.usuarioPrestamo = null;
    }
    
    @Override
    public String toString(){
        String estado = disponible ? "Disponible" : "Prestado a: " + usuarioPrestamo; //if ternario
        return "Libro [ISBN: " + isbn + ", Titulo: " + titulo + ", Autor: " + autor + ", Categoria: " + categoria +
                ", Estado: " + estado + "]";
    }

}
