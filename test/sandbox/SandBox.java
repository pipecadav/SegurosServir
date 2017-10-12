/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import segurosservir.clientes.Clientes;

/**
 *
 * @author Felipe
 */
public class SandBox {
    
     public int edad(String fecha_nac) {     //fecha_nac debe tener el formato dd/MM/yyyy
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");//para que nos de la edad debe estar en este formato
        String hoy = formato.format(fechaActual);
        String[] dat1 = fecha_nac.split("/"); 
        String[] dat2 = hoy.split("/");
        int años = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
        int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
        if (mes < 0) {
          años = años - 1;
        } else if (mes == 0) {
          int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
          if (dia > 0) {
            años = años - 1;
          }
        }
        return años;
  }
     
     public static void main(String[] args) {
        
        Clientes persona = new Clientes();
        
        
        
        
    }
             
    
     
}
