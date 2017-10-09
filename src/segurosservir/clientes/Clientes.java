/*
 * Clase que contiene las funciones de la clase persona
 */
package segurosservir.clientes;

import java.time.Instant;
import java.util.Date;

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
    
    public void calcularEdad(Date fechaNacimiento){
        Date.from(Instant.now());
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
