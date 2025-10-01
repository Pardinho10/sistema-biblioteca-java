// ============================================================================
// CLASE: Bibliotecario (Hereda de Clase Persona)
// ============================================================================
package modelo;
/**
 * Clase Bibliotecario - Representa a un empleado de la biblioteca.
 * Hereda de Persona y tiene permisos especiales en el sistema.
 */
public class Bibliotecario extends Persona{
    private String turno; // "MAÑANA", "TARDE", "NOCHE"
    private int antiguedad; // años trabajando
    
    //Cosntructor
    public Bibliotecario(int id, String nombre, String apellido, String documento, String telefono, 
            String turno, int antiguedad){
        super(id, nombre, apellido, documento, telefono);
        this.turno = turno;
        this.antiguedad = antiguedad;
    }
    
    //Implementación del método abstracto 
    @Override
    public String obtenerRol(){
        return "BIBLIOTECARIO";
    }
    
    //Método especifico de Bibliotecario
    public boolean tieneMasDe5Anios(){
        return antiguedad > 5;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    @Override
    public String toString(){
        return super.toString() + " | Turno: " + turno +
                " | Antiguedad: " + antiguedad + " años";
    }
}
