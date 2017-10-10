/*
 * Esta clase permite crear una poliza Temporal, 
 * El usuario paga una poliza por un periodo determinado de tiempo de n años/meses 
 * El asegurado accede a la poliza si muere en cualquier momento.
 */
package segurosservir.seguros;

import segurosservir.clientes.Clientes;
import tablasdereferencia.*;


public class PlanTranquilo implements SeguroVida {

    Clientes persona;
    double prima;
    static final int EXPECTATIVAVIDA = 78;
    int tiempoSeguro;
    
    /**
     * Valida los requisitos del asegurado, debe ser mayor o igual a 22 años
     * Debe ser n+1 años menor a la expectativa, siento n el tiempo futuro
     * @return Devuelve verdadero o falso
     */
    @Override
    public boolean validarViabilidad() {
           return (((EXPECTATIVAVIDA - persona.getEdad()) <(tiempoSeguro+1)) && (persona.getEdad() >= 22));
    }

    /**
     * Ejecuta la función Ax = Monto*((Mx - Mx+n)/Dx)
     * @param montoAsegurar Cantidad a asegurar
     * @param tiempoSeguro Tiempo futuro
     * @return Retorna el valor de la prima
     */
    @Override
    public double calculaCostoPrima(double montoAsegurar, int tiempoSeguro) {
        this.tiempoSeguro = tiempoSeguro;
        double mx = 0.0;
        double mxn = 0.0;
        double dx = 0.0;
        TablasDeReferencia.inicializarTabla();
        for(int i = 0; i < TablasDeReferencia.valores.size(); i++){
            if(persona.getEdad() == TablasDeReferencia.valores.get(i).getEdad()){
                mx = TablasDeReferencia.valores.get(i).getMx();
                mxn = TablasDeReferencia.valores.get(i+tiempoSeguro).getMx();
                dx = TablasDeReferencia.valores.get(i).getDx();
                i = TablasDeReferencia.valores.size();
            }
        }
        prima = montoAsegurar*((mx-mxn)/dx);
        return prima;
    }

    /**
     * Difiere la prima en cuotas mensuales dependiendo del tiempo del seguro
     * @param prima Recibe el valor neto de la prima
     * @return Retorna el valor a pagar mensual
     */
    @Override
    public double calcularMensual(double prima) {
        return (prima/(tiempoSeguro*12));
    }


}
