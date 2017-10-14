/*
 * Clase que contiene las funciones de la clase persona
 */
package segurosservir.clientes;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.swing.*;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import segurosservir.*;

/**
 * Clase Persona
 * @author Felipe Cadavid y Jeison Velasquez
 * @since 08-10-2017
 */

public class Clientes {
    
    private String nombre;
    private int edad;
    private LocalDate fechaNacimiento;
    private int documento;
    private long expectativaDias;
    private long diasvividos;
    static final int EXPECTATIVAVIDA = 78;

    /**
     * Constructor 
     */
    public Clientes(){
    }
           
    /**
     * Método que almacena la fecha de nacimiento una vez ingresada por el cliente
     * @param entradaFecha - Recibe un parámetro cadena con la fecha
     */
    public void setFechaNacimiento(String entradaFecha) throws DateTimeParseException {
        try{
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fNacimiento = LocalDate.parse(entradaFecha, fmt);
            this.fechaNacimiento = fNacimiento;
        }catch(DateTimeParseException e){
            JOptionPane.showMessageDialog(null, "Formato de entrada inválido", "Uh-Oh!", ERROR_MESSAGE);
            setFechaNacimiento(JOptionPane.showInputDialog("Ingrese Fecha de Nacimiento"));
        }
    }
    /**
     * Calcula la edad de la persona basado en la fecha de nacimiento
     */
    public void calcularEdad(){
        Period periodo = Period.between(fechaNacimiento, LocalDate.now());
        this.edad = periodo.getYears();
    }
    
    /**
     * Calcula la cantidad de dias vividos por la persona dada la fecha de nacimiento
     */
    public void calcularDiasVividos(){
        this.diasvividos = ChronoUnit.DAYS.between(fechaNacimiento, LocalDate.now());
    }
    
    /**
     * Calcula la expectativa de vida dada la expectativa de vida promedio
     */
    public void calcularExpectativa(){
        this.expectativaDias = ChronoUnit.DAYS.between(LocalDate.now(),fechaNacimiento.plusYears(EXPECTATIVAVIDA));
    }
     
    /**
     * Devuelve los datos de este objeto como una cadena
     * @return Retorna una cadena 
     */
    @Override
    public String toString(){
      return "Nombre: "+ this.nombre +".\n"
              + "Edad: "+ this.edad + ". Fecha de nacimiento: "+ this.fechaNacimiento +".\n"
              + "Segun expectativa de vida tiene: "+ this.expectativaDias +" días restantes.\n"
              + "Ha vivido " + this.diasvividos +" dias. \n";
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento() throws NumberFormatException {
            this.documento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Documento"));
    }
    
    public long getDiasRestantes() {
        return expectativaDias;
    }

    public void setDiasRestantes(long diasRestantes) {
        this.expectativaDias = diasRestantes;
    }

    public long getDiavividos() {
        return diasvividos;
    }

    public void setDiavividos(long díavividos) {
        this.diasvividos = díavividos;
    }
    
    
}
