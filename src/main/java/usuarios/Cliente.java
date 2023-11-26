/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;
import Servicio.Servicio;
import java.util.ArrayList;

/**
 *
 * @author José Marin
 */
public class Cliente extends Usuario{
    
    private int edad;
    private String numTarjetaCredito;
    private ArrayList<Servicio> servicios;
    
    public Cliente(int edad, String numTarjetaCredito, ArrayList<Servicio> servicios, String numCedula, String nombres, String apellidos, String user, String contrasenia, String numCelular, char tipoUsuario) {
        super(numCedula, nombres, apellidos, user, contrasenia, numCelular, tipoUsuario);
        this.edad = edad;
        this.numTarjetaCredito = numTarjetaCredito;
        this.servicios = servicios;
    }
    
    //getters
    public int getEdad(){
        return edad;
    }
    public String getNumTarjetaCredito(){
        return numTarjetaCredito;
    }
    public ArrayList<Servicio> getServicios(){
        return servicios;
    }
    
    //setters
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setNumTarjetaCredito(String numTarjetaCredito){
        this.numTarjetaCredito = numTarjetaCredito;
    }
    public void setServicios(Servicio s){
        servicios.add(s);
    }
    
}
