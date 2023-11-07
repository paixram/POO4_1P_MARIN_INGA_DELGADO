/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package usuarios;

/**
 *
 * @author José Miguel
 */
import utils.TipoVehiculo;
public class Vehiculo{
    private int codigoVehiculo;
    private String placa;
    private String modelo;
    private String marca;
    private TipoVehiculo tipo;
    public Vehiculo(String modelo, String marca, TipoVehiculo tipo){
        this.modelo=modelo;
        this.marca=marca;
        this.tipo=tipo;
    }

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
    
    }

