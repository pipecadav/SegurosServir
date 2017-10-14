/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segurosservir.clientes;

/**
 *
 * @author Felipe
 */
public class Poliza {
    
    private double prima;
    private int documento;
    private double cuotaMensual;
    private double montoAsegurado;
    private int tiempoAsegurado;

    public Poliza() {
    }

    /**
     * Devuelve los datos de este objeto como una cadena
     * @return Retorna una cadena
     */
    @Override
    public String toString(){
        return "Tiene un poliza con cedula: " + this.documento + ".\n"
               + "Debe pagar un cuota mensual de: $" + this.cuotaMensual +" y tiene un monto asegurado de: "+ this.montoAsegurado +"\n"
               + "Prima neta total: $"+ this.prima + ". Tiempo total: " + this.tiempoAsegurado + " años";
    }
    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public double getMontoAsegurado() {
        return montoAsegurado;
    }

    public void setMontoAsegurado(double montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public int getTiempoAsegurado() {
        return tiempoAsegurado;
    }

    public void setTiempoAsegurado(int tiempoAsegurado) {
        this.tiempoAsegurado = tiempoAsegurado;
    }
}
