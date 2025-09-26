package modelo;

/**
 *
 * @author Pardinho
 */

// ========== CLASE BIBLIOTECARIO (HEREDA DE PERSONA) ==========
public class Bibliotecario extends Persona{
    private String turno;
    private double salario;
    
    //Constructor - llama al constructor de la clase padre
    public Bibliotecario(String nombre, String apellido, String cedula, int edad, String turno, double salario){
        super(nombre, apellido, cedula, edad);//llamada al constructor padre 
        this.turno = turno;
        this.salario = salario;
    }
    
    @Override
    public String getTipoPersona(){
        return "Bibliotecario";
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return getTipoPersona() + " - " + getInformacionBasica() + 
                ", Turno: " + turno + ", Salario: " + salario;
    }
    
    
}
