/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segurosservir;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import tablasdereferencia.*;
/**
 *
 * @author Felipe
 */
public class SegurosServir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       // TablasDeReferencia.inicializarTabla();
        System.out.println(Date.from(Instant.now()));
       SimpleDateFormat formatter = new SimpleDateFormat("dd.mm.yy");
      

    }
    
}
