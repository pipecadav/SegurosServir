/*
 * Esta clase permite crear una poliza Total Mixta, donde el cliente 
 * asegurado paga una prima neta única para un tiempo futuro en años n
 * El asegurado recibe la poliza despues de n años 
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
    
    /**
     * Valida los requisitos del asegurado, debe ser mayor o igual a 22 años
     * Debe ser como mínimo 10 años menor que la expectativa de vida
     * @return Devuelve verdadero o falso
     */
    @Override
    public boolean validarViabilidad() {
           return (((EXPECTATIVAVIDA - persona.getEdad()) <10) && (persona.getEdad() >= 22));
       }
  

    /**
     * Ejecuta la función Ax = Monto*(Dxn/Dx)
     * @param montoAsegurar Cantidad a asegurar
     * @param tiempoSeguro Tiempo futuro
     * @return Retorna el valor de la prima
     */
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

    /**
     * Difiere la prima en cuotas de 60 meses independiente del tiempo futuro
     * @param prima Recibe el valor neto de la prima
     * @return Retorna el valor a pagar mensual
     */
    @Override
    public double calcularMensual(double prima) {
        return (prima/60);
    }
    
}
