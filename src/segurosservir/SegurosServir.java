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
    public static void menuOpciones(int opcion){
        switch(opcion){
            case 1://Añadir un cliente nuevo 

                break;
            case 2://Cancelar poliza 

                break;

            case 3://Buscar cliente

                break;

            case 4:

                break;

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
    }

    
}
