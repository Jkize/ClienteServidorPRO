/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Jhoan Saavedra
 */
public class Caja implements Serializable{

    private String idCaja;
    private double montoActual;
    private String idSuperMercado;
    private int disponible;

    public Caja(String idCaja, double montoActual, String idSuperMercado, int disponible) {
        this.idCaja = idCaja;
        this.montoActual = montoActual;
        this.idSuperMercado = idSuperMercado;
        this.disponible=disponible;
    }

    public Caja() {
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }
    
    

    public String getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(String idCaja) {
        this.idCaja = idCaja;
    }

    public double getMontoActual() {
        return montoActual;
    }

    public void setMontoActual(double montoActual) {
        this.montoActual = montoActual;
    }

    public String getIdSuperMercado() {
        return idSuperMercado;
    }

    public void setIdSuperMercado(String idSuperMercado) {
        this.idSuperMercado = idSuperMercado;
    }

    
    
}
