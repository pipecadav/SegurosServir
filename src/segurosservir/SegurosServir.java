/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segurosservir;

import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import segurosservir.clientes.*;
import segurosservir.seguros.*;
import tablasdereferencia.*;
/**
 *
 * @author Felipe Cadavid y Jeison Velasquez
 */
public class SegurosServir {
    
    public static ArrayList <Clientes> asegurados = new ArrayList<>();
    public static ArrayList <Poliza> planes = new ArrayList<>();
    
    /**
     * Almacena a un cliete nuevo y la poliza que haya escogido
     */
    public static void almacenarCliente(){
        try {
            String tipoPoliza;
            Clientes cliente = new Clientes();
            Poliza seguro = new Poliza();
            cliente.setNombre(JOptionPane.showInputDialog("Ingrese Nombre"));
            cliente.setDocumento();
            seguro.setDocumento(cliente.getDocumento());
            cliente.setFechaNacimiento(JOptionPane.showInputDialog("Ingrese Fecha de Nacimiento")) ;
            cliente.calcularEdad();
            cliente.calcularDiasVividos();
            cliente.calcularExpectativa();
            asegurados.add(cliente);
            seguro.setMontoAsegurado(Double.parseDouble(JOptionPane.showInputDialog("Ingrese Monto a Asegurar")));
            seguro.setTiempoAsegurado(Integer.parseInt(JOptionPane.showInputDialog("A cuantos años desea el seguro?")));
            String[] opciones = new String[] {"Plan Facil", "Plan Tranquilo"};
            tipoPoliza = (String) JOptionPane.showInputDialog(null, "Escoja el tipo de poliza", "Seleccion Poliza", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            switch(tipoPoliza){
                case "Plan Facil":
                    PlanFacil facil = new PlanFacil();
                    if(facil.validarViabilidad(cliente.getEdad()) == true){
                        seguro.setPrima(facil.calculaCostoPrima(seguro.getMontoAsegurado(), seguro.getTiempoAsegurado(), cliente.getEdad()));
                        seguro.setCuotaMensual(facil.calcularMensual(facil.getPrima()));
                        planes.add(seguro);
                        JOptionPane.showMessageDialog(null, "Cliente Almacenado! \n" 
                                + cliente.toString() + seguro.toString());
                    }else{
                        JOptionPane.showMessageDialog(null, "Lo sentimos, no aplica para esta póliza");
                        asegurados.remove(cliente);
                    }
                    break;
                case "Plan Tranquilo":
                    PlanTranquilo tranquilo = new PlanTranquilo();
                    tranquilo.setTiempoSeguro(seguro.getTiempoAsegurado());
                    if(tranquilo.validarViabilidad(cliente.getEdad()) == true){
                        seguro.setPrima(tranquilo.calculaCostoPrima(seguro.getMontoAsegurado(), seguro.getTiempoAsegurado(), cliente.getEdad()));
                        seguro.setCuotaMensual(tranquilo.calcularMensual(tranquilo.getPrima()));
                        planes.add(seguro);
                        JOptionPane.showMessageDialog(null, "Cliente Almacenado! \n" 
                                + cliente.toString() + seguro.toString());
                    }else{
                        JOptionPane.showMessageDialog(null, "Lo sentimos, no aplica para esta póliza");
                        asegurados.remove(cliente);
                    }
                    break;
            }
        }catch(HeadlessException | NumberFormatException | DateTimeParseException e){
            inicializarMenu();
            System.exit(0);
        }    
            
    }
    
    /**
     * Cancelar Cliente
     * @param documento Recibe documento como parametro
     * @return Devuelve una respuesta 
     */
    public static String cancelarCliente(int documento){
        for(Clientes cancelarCliente: asegurados){
            if(cancelarCliente.getDocumento() == documento){
                asegurados.remove(cancelarCliente);
                return "Cliente Eliminado";
            }
        }
        return "Cliente no encontrado";
    }
    
    
    /**
     * Cancelar Poliza
     * @param documento Recibe documento como parametro
     * @return Devuelve una respuesta 
     */
    public static String cancelarPoliza(int documento){
        for(Poliza cancelarPoliza: planes){
            if(cancelarPoliza.getDocumento() == documento){
                planes.remove(cancelarPoliza);
                return "Poliza Eliminada";
            }
        }
        return "Cliente no encontrado";
    }
    
    
    /**
     * Buscar al cliente
     * @param documento Recibe documento como parametro
     * @return Devuelve una respuesta 
     */
    public static String buscarCliente(int documento){
        for(Clientes buscarCliente: asegurados){
            if(buscarCliente.getDocumento() == documento){
                return (buscarCliente.toString());
            }
        }
        return "Cliente no encontrado";
    }
    
    /**
     * Buscar la poliza
     * @param documento Recibe documento como parametro
     * @return Devuelve una respuesta 
     */
    public static String buscarPoliza(int documento){
        for(Poliza buscarPoliza: planes){
            if(buscarPoliza.getDocumento() == documento){
                return (buscarPoliza.toString());
            }
        }
        return "Poliza no encontrada";
    }
    
    /**
     * Menú de opciones del usuario
     */
    public static void inicializarMenu(){
        int documento;
        String[] opciones = new String[] {"Comprar Poliza", "Cancelar Poliza", "Buscar Cliente", "Salir"};
        boolean correrMenu = true;
        while(correrMenu){
            int seleccion = JOptionPane.showOptionDialog(null, "Para empezar escoja una de las opciones siguientes", "Seguros Servir", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
            switch(seleccion){
                case 0://Añadir un cliente nuevo y una poliza 
                        almacenarCliente();
                    break;
                case 1://Cancelar poliza 
                        documento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento de la persona a cancelar"));
                        JOptionPane.showMessageDialog(null, cancelarCliente(documento) + ". " + cancelarPoliza(documento));
                    break;

                case 2://Buscar cliente
                        documento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento de la persona a buscar"));
                        JOptionPane.showMessageDialog(null, buscarCliente(documento) + ". " + buscarPoliza(documento));
                    break;

                case 3://Salir
                        JOptionPane.showMessageDialog(null, "Feliz Día");
                        correrMenu = false;
                    break;

            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        inicializarMenu();
    }

    
}
