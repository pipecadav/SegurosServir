/*
 * Esta clase permite crear una poliza Total Mixta, donde el cliente 
 * asegurado recibe una prima neta única dentro de una cantidad de años n
 */
package segurosservir.seguros;

import segurosservir.clientes.Clientes;
import tablasdereferencia.*;

/**
 * 
 * @author Felipe Cadavid y Jeison Velasquez
 */
public class PlanFacil implements SeguroVida{
    
    Clientes persona;
    double prima;
    static final int EXPECTATIVAVIDA = 78;
    
    
    @Override
    public boolean validarViabilidad() {
           return (((EXPECTATIVAVIDA - persona.getEdad()) <5) && (persona.getEdad() > 22));
       }
  

    @Override
    public double calculaCostoPrima(double montoAsegurar, int tiempoSeguro) {
        double dxn = 0.0;
        double dxny = 0.0;
        TablasDeReferencia.inicializarTabla();
        for(int i = 0; i < TablasDeReferencia.valores.size(); i++){
            if(persona.getEdad() == TablasDeReferencia.valores.get(i).getEdad()){
                dxn = TablasDeReferencia.valores.get(i).getDx();
                dxny = TablasDeReferencia.valores.get(i+tiempoSeguro).getDx();
                i = TablasDeReferencia.valores.size();
            }
        }
        prima = montoAsegurar*(dxny/dxn);
        return prima;
    }

    @Override
    public double calcularMensual(double prima) {
        return (prima/60);
    }
    
}
