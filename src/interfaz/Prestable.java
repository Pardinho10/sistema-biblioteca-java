/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;
/**
 * Interfaz que define el comportamiento de los materiales que pueden ser prestados.
 * Cualquier clase que implemente esta interfaz DEBE tener estos métodos.
 */
public interface Prestable {
    /**
     * Marca el material como prestado
     */    
    void prestar();
    
    /**
     * Marca el material como devuelto (disponible nuevamente)
     */
    void devolver();
    
    /**
     * Verifica si el material está disponible para préstamo
     * @return true si está disponible, false si está prestado
     */
    boolean estaDisponible();
}
