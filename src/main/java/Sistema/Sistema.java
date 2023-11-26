/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;
import Usuario.Usuario;
import java.util.ArrayList;
import Vehiculo.*;
/**
 *
 * @author José Miguel
 */
public class Sistema {
  static ArrayList<Usuario> usuarios;
  static ArrayList<Servicio> servicios;
  static ArrayList<Vehiculo> vehiculos;

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public static ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        Sistema.usuarios = usuarios;
    }

    public static void setServicios(ArrayList<Servicio> servicios) {
        Sistema.servicios = servicios;
    }

    public static void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        Sistema.vehiculos = vehiculos;
    }

  
    public Sistema(ArrayList<Usuario> usuarios,ArrayList<Servicio> servicios,ArrayList<Vehiculo> vehiculos) {
        this.usuarios=usuarios;
        this.vehiculos=vehiculos;
        this.servicios=servicios;
    }
    
    static void validarAcceso(){
    
    }
    static void guardarDatosCliente(){
    
    }
    static void iniciarSesion(){
    
    }
    static void mostrarMenu(){
    
    }
}
