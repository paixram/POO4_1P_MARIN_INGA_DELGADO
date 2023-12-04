/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Usuario.Conductor;
import java.util.Date;
import utils.FormasPago;
import java.util.Random;
import java.util.Scanner;
import utils.Archivo;
import utils.TipoServicio;

/**
 * La clase Taxi representa un servicio de taxi.
 * Extiende la clase abstracta Servicio.
 * 
 * @author Luizzz
 */
public class Taxi extends Servicio {
    
    public int numeroPersonas;
    
    final public double cpk = 0.50;
     /**
     * Constructor de la clase Taxi.
     *
     * @param numeroPersonas     Número de personas en el taxi.
     * @param id                 Identificador del servicio.
     * @param desde              Lugar de origen del servicio.
     * @param hasta              Lugar de destino del servicio.
     * @param fecha              Fecha del servicio.
     * @param hora               Hora del servicio.
     * @param conductorAsignado  Conductor asignado al servicio.
     * @param tipoServicio       Tipo de servicio.
     * @param formaDePago        Forma de pago del servicio.
     */
    public Taxi(int numeroPersonas, int id, String desde, String hasta, Date fecha, String hora, Conductor conductorAsignado, TipoServicio tipoServicio, FormasPago formaDePago) {
        super(id, desde, hasta, fecha, hora, conductorAsignado, tipoServicio, formaDePago);
        this.numeroPersonas = numeroPersonas;
    }
     /**
     * Calcula el costo del servicio de taxi.
     *
     * @return El costo del servicio.
     */
    @Override
    public double calcularCosto() {
        System.out.println("***************************** Calculando costo *****************************");
        double valorPagar = 0.0;
        
        // gen random km
        Random rn = new Random();
        
        int kms = rn.nextInt(45);
        
        // subtotal
        valorPagar += cpk * kms;
        System.out.println("Subtotal: " + valorPagar);
        
        super.setCosto(valorPagar);
        
        return valorPagar;
    }
    /**
     * Calcula el costo final del servicio de taxi con tarifa especial.
     *
     * @param TC Tarjeta de crédito utilizada.
     * @return El costo final del servicio.
     */
    public double calcularCosto(String TC) {
        double subtotal = this.getCosto();
        double valorFinal = 0;
        
        valorFinal += subtotal + (subtotal * 0.10);
        valorFinal += valorFinal + (valorFinal * 0.15);
        
        //super.setCosto(subtotal);
        
        return valorFinal;
    }
      /**
     * Guarda los detalles del viaje en un archivo.
     *
     * @param cedula Cédula del usuario asociado al viaje.
     */
    public void guardarViaje(String cedula) {
        
        String viaje_data = String.valueOf(super.getId()) + "," + String.valueOf(this.numeroPersonas) + "," + String.valueOf(super.getCosto() / this.cpk) + "," + String.valueOf(super.getCosto());
    
        Archivo.EscribirArchivo(Archivo.MyPath + "Viajes.txt", viaje_data);
        System.out.println("Viaje guardado correctamente!");
    }
    /**
     * Representación en cadena del servicio de taxi.
     *
     * @return Cadena que representa los detalles del servicio de taxi.
     */
    @Override
    public String toString(){
        return "Tipo: Viaje\nCantidad pasajeros: "+this.numeroPersonas+"\n"+super.toString();
    }
    
}
