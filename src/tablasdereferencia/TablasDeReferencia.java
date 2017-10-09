/*
 * Esta Clase contiene la función que crea la tabla de valores 
 * que se usaran para calcular las primas de las polizas
 */
package tablasdereferencia;

import java.util.ArrayList;

/**
 * Clase Tablas de Referencia
 * @author Felipe Cadavid y Jeison Velasquez
 * @since 08-10-2017
 */
public class TablasDeReferencia {
    
    public static final double TASA = 0.03;
    public static final double REFERENCIAPROB = 10000.00;
    public static final double TASADIV = Math.pow((1+TASA),0.5);
    
    public static ArrayList<DatosOperaciones> valores = new ArrayList<DatosOperaciones>();

    /**
     * Esta función inicializa la tabla de referencia para calcular las pólizas
     */
    public static void inicializarTabla(){
        int i;
        double acumularCx = 0.0;
        double decremento = 0.0;
        
        for(i=20; i<90; i++){
            DatosOperaciones tabla = new DatosOperaciones();
            tabla.setEdad(i);
            tabla.setIx((REFERENCIAPROB*(1/(1+(0.234*i))))/100);
            tabla.setCx((Math.pow((1/(1+TASA)),i+1))*(TASADIV)*(tabla.getIx()));
            tabla.setDx((Math.pow((1/(1+TASA)),i)));
            acumularCx = acumularCx + tabla.getCx();
            valores.add(tabla);
        }

        i = 0;
        while(i < valores.size()){
            if((valores.size()) - i == valores.size()){
                valores.get(i).setMx(acumularCx);
            }else{
                decremento = decremento + valores.get(i-1).getCx();
                valores.get(i).setMx(acumularCx - decremento);
            }
            i++;
            
        }
        
    }
    
}

    