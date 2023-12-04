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
 * La clase Encomienda representa un servicio de entrega de encomiendas.
 * Extiende la clase abstracta Servicio.
 *
 * @author Luizzz
 */


public class Encomienda extends Servicio {
    
    private TipoEncomiendas tipoEncomienda;
    private int cantidadProductos;
    private double peso;
    
    public int dpe = 1;
     /**
     * Constructor de la clase Encomienda.
     *
     * @param tipoEncomienda    Tipo de encomienda.
     * @param cantidadProductos Cantidad de productos en la encomienda.
     * @param peso              Peso total de la encomienda.
     * @param id                Identificador del servicio.
     * @param desde             Lugar de origen del servicio.
     * @param hasta             Lugar de destino del servicio.
     * @param fecha             Fecha del servicio.
     * @param hora              Hora del servicio.
     * @param conductorAsignado Conductor asignado al servicio.
     * @param tipoServicio      Tipo de servicio.
     * @param formaDePago       Forma de pago del servicio.
     */
    public Encomienda(TipoEncomiendas tipoEncomienda, int cantidadProductos, double peso, int id, String desde, String hasta, Date fecha, String hora, Conductor conductorAsignado, TipoServicio tipoServicio, FormasPago formaDePago) {
        super(id, desde, hasta, fecha, hora, conductorAsignado, tipoServicio, formaDePago);
        this.tipoEncomienda = tipoEncomienda;
        this.cantidadProductos = cantidadProductos;
        this.peso = peso;
    }
    
    
    /**
     * Calcula el costo total del servicio de encomienda.
     *
     * @return El costo total del servicio.
     */
    @Override
    public double calcularCosto() {
        double valor = dpe * this.peso;
        
        valor += 4;
        
        System.out.println("Total a pagar: " + valor);
        
        super.setCosto(valor);
        
        return valor;
    }
    /**
     * Guarda los detalles de la encomienda en un archivo.
     */
    public void guardarEncomienda() {
        String ecomienda_data = String.valueOf(super.getId()) + "," + String.valueOf(this.tipoEncomienda) + "," + String.valueOf(this.cantidadProductos) + "," + String.valueOf(this.peso) + "," + String.valueOf(super.getCosto());
    
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
    /**
     * Representación en cadena de la encomienda.
     *
     * @return Cadena que representa la encomienda y sus detalles.
     */
    @Override
    public String toString(){
        return "Tipo: Encomienda " + tipoEncomienda +"\nCantidad de productos = " + cantidadProductos +"\nPeso = " + peso +"\n"+ super.toString();  
    }
}
