/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;
import java.util.ArrayList;

/**
 *
 * @author José Marin
 */
public class Cliente extends Usuario{
    
    private int edad;
    private String numTarjetaCredito;
    private ArrayList<Servicio> servicios;
    
    public Cliente(int edad, String numTarjetaCredito, Servicio s){
        servicios = new ArrayList<>();
        this.edad = edad;
        this.numTarjetaCredito = numTarjetaCredito;
        servicios.add(s);
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
