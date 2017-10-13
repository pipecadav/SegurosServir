/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segurosservir;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import segurosservir.clientes.*;
import tablasdereferencia.*;
/**
 *
 * @author Felipe Cadavid y Jeison Velasquez
 */
public class SegurosServir {
    
    public static ArrayList <Clientes> asegurados = new ArrayList<>();
    public static ArrayList <Poliza> planes = new ArrayList<>();
    
    
    /**
     * Menú de opciones del usuario
     * @param opcion de tipo entero
     */
    public static void menuOpciones(){
        String opcion;
        opcion = JOptionPane.showInputDialog(null, "Escoja una de las opciones siguientes", "ingrese", 0);
        switch(opcion){
            case "Añadir Cliente"://Añadir un cliente nuevo 
                    Clientes cliente = new Clientes();
                    cliente.setNombre(JOptionPane.showInputDialog("Ingrese Nombre"));
                    cliente.setDocumento(Integer.parseInt(JOptionPane.showInputDialog("Ingrese Nombre")));
                    cliente.setFechaNacimiento(JOptionPane.showInputDialog("Ingrese Fecha de Nacimiento"));
                    cliente.calcularEdad();
                    cliente.calcularDiasVividos();
                    cliente.calcularExpectativa();
                break;
            case "Cancelar Poliza"://Cancelar poliza 

                break;

            case "Buscar Cliente"://Buscar cliente

                break;

            case "Salir":

                break;

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
    
    }

    
}
