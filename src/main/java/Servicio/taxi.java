/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Usuario.Conductor;
import java.util.Date;
import utils.FormasPago;
import java.util.Random;

/**
 *
 * @author Luizzz
 */
public class Taxi extends Servicio {
    
    public int numeroPersonas;
    
    final public double cpk = 0.50;

    public Taxi(int numeroPersonas, int id, String desde, String hasta, Date fecha, Conductor conductorAsignado, double costo, char tipoServicio, FormasPago formaDePago) {
        super(id, desde, hasta, fecha, conductorAsignado, costo, tipoServicio, formaDePago);
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
        
        if(super.getFormaDePago() == FormasPago.TARJETA) {
            valorPagar += valorPagar + (valorPagar * 0.15);
        }
        
        System.out.println("Valor final: " + valorPagar);
        
        return valorPagar;
    }
    
    
}
