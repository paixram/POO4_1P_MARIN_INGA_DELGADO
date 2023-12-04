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
 *
 * @author Luizzz
 */
public class Taxi extends Servicio {
    
    public int numeroPersonas;
    
    final public double cpk = 0.50;

    public Taxi(int numeroPersonas, int id, String desde, String hasta, Date fecha, String hora, Conductor conductorAsignado, TipoServicio tipoServicio, FormasPago formaDePago) {
        super(id, desde, hasta, fecha, hora, conductorAsignado, tipoServicio, formaDePago);
        this.numeroPersonas = numeroPersonas;
    }
    
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
    
    public double calcularCosto(String TC) {
        double subtotal = this.getCosto();
        double valorFinal = 0;
        
        valorFinal += subtotal + (subtotal * 0.10);
        valorFinal += valorFinal + (valorFinal * 0.15);
        
        //super.setCosto(subtotal);
        
        return valorFinal;
    }
    
    public void guardarViaje(String cedula) {
        
        String viaje_data = String.valueOf(super.getId()) + "," + String.valueOf(this.numeroPersonas) + "," + String.valueOf(super.getCosto() / this.cpk) + "," + String.valueOf(super.getCosto());
    
        Archivo.EscribirArchivo(Archivo.MyPath + "Viajes.txt", viaje_data);
        System.out.println("Viaje guardado correctamente!");
    }
    
    @Override
    public String toString(){
        return "Tipo: Viaje\nCantidad pasajeros: "+this.numeroPersonas+"\n"+super.toString();
    }
    
}
