/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Usuario.Conductor;
import java.util.Date;
import utils.Archivo;
import utils.FormasPago;
import utils.TipoEncomiendas;
import utils.TipoServicio;

/**
 *
 * @author Luizzz
 */


public class Encomienda extends Servicio {
    
    private TipoEncomiendas tipoEncomienda;
    private int cantidadProductos;
    private double peso;
    
    public int dpe = 1;

    public Encomienda(TipoEncomiendas tipoEncomienda, int cantidadProductos, double peso, int id, String desde, String hasta, Date fecha, String hora, Conductor conductorAsignado, TipoServicio tipoServicio, FormasPago formaDePago) {
        super(id, desde, hasta, fecha, hora, conductorAsignado, tipoServicio, formaDePago);
        this.tipoEncomienda = tipoEncomienda;
        this.cantidadProductos = cantidadProductos;
        this.peso = peso;
    }
    
    
    
    @Override
    public double calcularCosto() {
        double valor = dpe * this.peso;
        
        valor += 4;
        
        System.out.println("Total a pagar: " + valor);
        
        super.setCosto(valor);
        
        return valor;
    }
    
    public void guardarEncomienda() {
        String ecomienda_data = String.valueOf(super.getId()) + "," + String.valueOf(this.tipoEncomienda) + "," + String.valueOf(this.cantidadProductos) + "," + String.valueOf(this.peso) + "," + String.valueOf(super.getCosto() + "\n");
    
        Archivo.EscribirArchivo(Archivo.MyPath + "Encomiendas.txt", ecomienda_data);
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
    
    @Override
    public String toString(){
        return "Tipo: Encomienda" + tipoEncomienda +" \n cantidadProductos=" + cantidadProductos +"\n peso= " + peso + super.toString();  
    }
}
