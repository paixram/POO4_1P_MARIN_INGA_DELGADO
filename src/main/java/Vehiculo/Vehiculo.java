/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Vehiculo;

/**
 *
 * @author José Miguel
 */
import utils.TipoVehiculo;
import java.util.ArrayList;

public class Vehiculo{
    private int codigoVehiculo;
    private String placa;
    public String modelo;
    public String marca;
    public TipoVehiculo tipo;
    
<<<<<<< HEAD
    /*static ArrayList<Vehiculo> getVehiculos(){
        return ArrayList<Vehiculo> vehiculos;
=======
    static ArrayList<Vehiculo> getVehiculos(){
        //llamar a leer 
>>>>>>> 5c5445f9db31475c0d9694b0891045a41c30bc98
        return new ArrayList<>();

    }*/
    public int getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setCodigoVehiculo(int codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    public Vehiculo(int codigoVehiculo, String placa, String modelo, String marca, TipoVehiculo tipo) {
        this.codigoVehiculo = codigoVehiculo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo;
    }
    
    
    }

