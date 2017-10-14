/*
 * Esta clase permite crear una poliza Temporal, 
 * El usuario paga una poliza por un periodo determinado de tiempo de n años/meses 
 * El asegurado accede a la poliza si muere en cualquier momento.
 */
package segurosservir.seguros;

import tablasdereferencia.*;

/**
 * Clase Plan Tranquilo
 * @author Felipe Cadavid y Jeison Velasquez
 * @since 08-10-2017
 */
public class PlanTranquilo implements SeguroVida {

    private double prima;
    static final int EXPECTATIVAVIDA = 78;
    private int tiempoSeguro;
    
    /**
     * Valida los requisitos del asegurado, debe ser mayor o igual a 22 años
     * Debe ser n+1 años menor a la expectativa, siento n el tiempo futuro
     * @param edad Recibe la edad del cliente como parametro
     * @return Devuelve verdadero o falso
     */
    @Override
    public boolean validarViabilidad(int edad) {
           return (((EXPECTATIVAVIDA - edad) <(tiempoSeguro+1)) && (edad >= 22));
    }

    /**
     * Ejecuta la función Ax = Monto*((Mx - Mx+n)/Dx)
     * @param montoAsegurar Cantidad a asegurar
     * @param tiempoSeguro Tiempo futuro
     * @param edad Recibe la edad del cliente como parametro
     * @return Retorna el valor de la prima
     */
    
    @Override
    public double calculaCostoPrima(double montoAsegurar, int tiempoSeguro, int edad) {
        this.tiempoSeguro = tiempoSeguro;
        double mx = 0.0;
        double mxn = 0.0;
        double dx = 0.0;
        TablasDeReferencia.inicializarTabla();
        for(int i = 0; i < TablasDeReferencia.valores.size(); i++){
            if(edad == TablasDeReferencia.valores.get(i).getEdad()){
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

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public int getTiempoSeguro() {
        return tiempoSeguro;
    }

    public void setTiempoSeguro(int tiempoSeguro) {
        this.tiempoSeguro = tiempoSeguro;
    }

    
}
