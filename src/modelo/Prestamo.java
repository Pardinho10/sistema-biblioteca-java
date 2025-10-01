// ============================================================================
// CLASE: Prestamo 
// ============================================================================
package modelo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase Prestamo - Representa un préstamo de material a un usuario.
 * Relaciona un Usuario con un Material.
 */
public class Prestamo {
    private int id;
    private Usuario usuario;
    private Material material;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean activo; // true = aún no devuelto, false = ya devuelto
    
    // Csontructor
    public Prestamo(int id, Usuario usuario, Material material){
        this.id = id;
        this.usuario = usuario;
        this.material = material;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = null; // Aún no se ha devuelto
        this.activo = true; // valor por defecto
    }
    // Método para reistrar la devolucion
    public void registrarDevolucion(){
        this.fechaDevolucion = LocalDate.now();
        this.activo = false;
        material.devolver(); // Marca el material como disponible
    }
    
    // Getters, no lleva Setters por que no 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Material getMaterial() {
        return material;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean isActivo() {
        return activo;
    }
    
    
   @Override
   public String toString(){
       DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       String estado = activo ? "ACTIVO": "FINALIADO";
       String devolucion = fechaDevolucion != null ? fechaDevolucion.format(formato) : 
               "Pendiente";
       
       return String.format("Préstamo ID: %d | Usuario: %s | Material: %s | Fecha: %s | Devolución: %s | Estado: %s",
               id, usuario.getNombre(), material.getTitulo(), fechaPrestamo.format(formato),
               devolucion, estado);
   }
    
}
