/*
 * Clase que contiene las funciones de la clase persona
 */
package segurosservir.clientes;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import segurosservir.*;

/**
 * Clase Persona
 * @author Felipe Cadavid y Jeison Velasquez
 * @since 08-10-2017
 */
public class Clientes {
    
    private String nombre;
    private String apellido;
    private int edad;
    private Date fechaNacimiento;
    private String documento;

    public Clientes() {
    }
    //caclcular edad metodo 1
    public void calcularEdad(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse("15/08/1993", fmt);
        LocalDate ahora = LocalDate.now();
        
        Period periodo = Period.between(fechaNac, ahora);
        System.out.printf("Tu edad es: %s años, %s meses y %s días",
        periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }
    //edad metodo 2
    public int edad(String fecha_nac) {     //fecha_nac debe tener el formato dd/MM/yyyy
        Date fechaActual = new Date();
        SegurosServir formato = new SegurosServir("dd/MM/yyyy");//para que nos de la edad debe estar en este formato
        String hoy = formato.format(fechaActual);
        String[] dat1 = fecha_nac.split("/"); 
        String[] dat2 = hoy.split("/");
        int anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
        int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
        if (mes < 0) {
          anos = anos - 1;
        } else if (mes == 0) {
          int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
          if (dia > 0) {
            anos = anos - 1;
          }
        }
        return anos;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    
    
    
}
