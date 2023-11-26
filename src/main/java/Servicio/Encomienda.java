/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Usuario.Conductor;
import java.util.Date;
import utils.FormasPago;
import utils.TipoEncomiendas;

/**
 *
 * @author Luizzz
 */


public class Encomienda extends Servicio {
    
    private TipoEncomiendas tipoEncomienda;
    private int cantidadProductos;
    private double peso;

    public Encomienda(TipoEncomiendas tipoEncomienda, int cantidadProductos, double peso, int id, String desde, String hasta, Date fecha, Conductor conductorAsignado, double costo, char tipoServicio, FormasPago formaDePago) {
        super(id, desde, hasta, fecha, conductorAsignado, costo, tipoServicio, formaDePago);
        this.tipoEncomienda = tipoEncomienda;
        this.cantidadProductos = cantidadProductos;
        this.peso = peso;
    }

    public TipoEncomiendas getTipoEncomienda() {
        return tipoEncomienda;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public double getPeso() {
        return peso;
    }

    public void setTipoEncomienda(TipoEncomiendas tipoEncomienda) {
        this.tipoEncomienda = tipoEncomienda;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    
}
