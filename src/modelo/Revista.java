// ============================================================================
// CLASE: Revista (Hereda de Clase Material)
// ============================================================================
package modelo;
/**
 * Clase Revista - Representa una revista en la biblioteca.
 * Hereda de Material y agrega atributos específicos de revistas.
 */
public class Revista extends Material {
    private int numeroEdicion;
    private String mesPublicacion;
    private String categoria; // "CIENCIA", "TECNOLOGIA", "DEPORTES", etc.
    
    // Constructor
    public Revista(int id, String titulo, String autor, int anioPublicacion,
            int numeroEdicion, String mesPublicacion, String categoria){
        super(id, titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
        this.mesPublicacion = mesPublicacion;
        this.categoria = categoria;
    }
    
    @Override
    public String obtenerTipo(){
        return "REVISTA";
    } 
    
    // Getters y Setters

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public String getMesPublicacion() {
        return mesPublicacion;
    }

    public void setMesPublicacion(String mesPublicacion) {
        this.mesPublicacion = mesPublicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString(){
        return super.toString() + " | Edicion: " + numeroEdicion +
                " | Mes: " + mesPublicacion + " | Categoria: " + categoria;
    }
    
}
