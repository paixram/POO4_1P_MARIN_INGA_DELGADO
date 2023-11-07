/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import utils.FormasPago;

/**
 *
 * @author Luizzz
 */
public class Taxi extends Servicio {
    
    public int numeroPersonas;

    public Taxi(int numeroPersonas, int id, String ruta, String fecha, String conductorAsignado, double costo, char tipoServicio, FormasPago formaDePago) {
        super(id, ruta, fecha, conductorAsignado, costo, tipoServicio, formaDePago);
        this.numeroPersonas = numeroPersonas;
    }
    
    
}
