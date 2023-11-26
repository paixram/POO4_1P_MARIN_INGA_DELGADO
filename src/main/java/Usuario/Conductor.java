/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Usuario;
import Servicio.Servicio;


import utils.TipoUsuario;
import utils.EstadoConductor;
import Servicio.Servicio;

import Vehiculo.Vehiculo;

import java.util.ArrayList;
/**
 *
 * @author José Marin
 */
public class Conductor extends Usuario {
    
    private String numLicencia;
    private EstadoConductor estado;
    private Vehiculo vehiculo;

    public Conductor(String numLicencia, EstadoConductor estado, Vehiculo vehiculo, String numCedula, String nombres, String apellidos, String user, String contrasenia, String numCelular, TipoUsuario tipoDeUsuario) {
        super(numCedula, nombres, apellidos, user, contrasenia, numCelular, tipoDeUsuario);
        this.numLicencia = numLicencia;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    //getters
    public String getNumLicencia() {
        return numLicencia;
    }

    public EstadoConductor getEstado() {
        return estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    //setters
    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    public void setEstado(EstadoConductor estado) {
        this.estado = estado;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    @Override
    public void consultarServicios(){
        
    }
    
}
