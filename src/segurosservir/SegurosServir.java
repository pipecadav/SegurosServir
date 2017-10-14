/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segurosservir;

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
    
    public static void almacenarCliente(){
        String tipoPoliza;
        Clientes cliente = new Clientes();
        Poliza seguro = new Poliza();
        cliente.setNombre(JOptionPane.showInputDialog("Ingrese Nombre"));
        cliente.setDocumento(Integer.parseInt(JOptionPane.showInputDialog("Ingrese Documento")));
        seguro.setDocumento(cliente.getDocumento());
        cliente.setFechaNacimiento(JOptionPane.showInputDialog("Ingrese Fecha de Nacimiento"));
        cliente.calcularEdad();
        cliente.calcularDiasVividos();
        cliente.calcularExpectativa();
        asegurados.add(cliente);
        seguro.setMontoAsegurado(Double.parseDouble(JOptionPane.showInputDialog("Ingrese Monto a Asegurar")));
        seguro.setTiempoAsegurado(Integer.parseInt(JOptionPane.showInputDialog("A cuantos años desea el seguro?")));
        tipoPoliza = JOptionPane.showInputDialog("Escoja el tipo de poliza");
        switch(tipoPoliza){
            case "Plan Facil":
                PlanFacil facil = new PlanFacil();
                if(facil.validarViabilidad(cliente.getEdad()) == true){
                    seguro.setPrima(facil.calculaCostoPrima(seguro.getMontoAsegurado(), seguro.getTiempoAsegurado(), cliente.getEdad()));
                    seguro.setCuotaMensual(facil.calcularMensual(facil.getPrima()));
                    planes.add(seguro);
                }else{
                    JOptionPane.showMessageDialog(null, "Lo sentimos, no aplica para esta póliza");
                    asegurados.remove(cliente);
                }
            case "Plan Tranquilo":
                PlanTranquilo tranquilo = new PlanTranquilo();
                tranquilo.setTiempoSeguro(seguro.getTiempoAsegurado());
                if(tranquilo.validarViabilidad(cliente.getEdad()) == true){
                    seguro.setPrima(tranquilo.calculaCostoPrima(seguro.getMontoAsegurado(), seguro.getTiempoAsegurado(), cliente.getEdad()));
                    seguro.setCuotaMensual(tranquilo.calcularMensual(tranquilo.getPrima()));
                    planes.add(seguro);
                }else{
                    JOptionPane.showMessageDialog(null, "Lo sentimos, no aplica para esta póliza");
                    asegurados.remove(cliente);
                }
        }
    }
    
    public static void cancelarPoliza(){
        int documento;
        documento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento de la persona que desea cancelar"));
        for(Clientes buscarCliente: asegurados){
            if(buscarCliente.getDocumento() == documento){
                asegurados.remove(buscarCliente);
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
            }
        }
        
    }
    
    public static String buscarCliente(int documento){
        for(Clientes buscarCliente: asegurados){
            if(buscarCliente.getDocumento() == documento){
                return (buscarCliente.toString());
            }
        }
        return "Cliente no Encontrado";
    }
    
    public static String buscarPoliza(int documento){
        for(Poliza buscarPoliza: planes){
            if(buscarPoliza.getDocumento() == documento){
                return (buscarPoliza.toString());
            }
        }
        return "Poliza no Encontrada";
    }
    
    /**
     * Menú de opciones del usuario
     */
    public static void inicializarMenu(){
        String[] opciones = new String[] {"Comprar Poliza", "Cancelar Poliza", "Buscar Cliente", "Salir"};
        boolean correrMenu = true;
        while(correrMenu){
            int seleccion = JOptionPane.showOptionDialog(null, "Mensaje", "titulo", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
            switch(seleccion){
                case 0://Añadir un cliente nuevo y una poliza 
                        almacenarCliente();
                    break;
                case 1://Cancelar poliza 
                        cancelarPoliza();
                    break;

                case 2://Buscar cliente
                        int documento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento de la persona que desea cancelar"));
                        JOptionPane.showMessageDialog(null, buscarCliente(documento) + buscarPoliza(documento));
                    break;

                case 3:
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
