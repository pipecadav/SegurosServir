/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablasdereferencia;

import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class TablaMortalidad {
    
    
    
    public static ArrayList<Datos> valores = new ArrayList<Datos>();

    public static void initializeTable(){
        
        int numbero = 3;
        for(int i=0; i<15; i++){
            Datos tabla = new Datos();
            tabla.setEdad(22+i);
            tabla.setMx(4*numbero+i);
            valores.add(tabla);
            System.out.print(tabla.getMx()+", ");
        }
        
    }
    
}

    