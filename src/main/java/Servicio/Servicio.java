/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import utils.FormasPago;
import java.util.Date;
import Usuario.Conductor;

/**
 *
 * @author Luizzz
 */
public class Servicio {
    private int id;
    private /*Ruta*/ String ruta;
    private /*Date*/ Date fecha;
    private Conductor conductorAsignado;
    private double costo;
    private char tipoServicio;
    private FormasPago formaDePago;

    public Servicio(int id, String ruta, Date fecha, Conductor conductorAsignado, double costo, char tipoServicio, FormasPago formaDePago) {
        this.id = id;
        this.ruta = ruta;
        this.fecha = fecha;
        this.conductorAsignado = conductorAsignado;
        this.costo = costo;
        this.tipoServicio = tipoServicio;
        this.formaDePago = formaDePago;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setConductorAsignado(Conductor conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setTipoServicio(char tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setFormaDePago(FormasPago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public int getId() {
        return id;
    }

    public String getRuta() {
        return ruta;
    }

    public Date getFecha() {
        return fecha;
    }

    public Conductor getConductorAsignado() {
        return conductorAsignado;
    }

    public double getCosto() {
        return costo;
    }

    public char getTipoServicio() {
        return tipoServicio;
    }

    public FormasPago getFormaDePago() {
        return formaDePago;
    }
    
    
}
