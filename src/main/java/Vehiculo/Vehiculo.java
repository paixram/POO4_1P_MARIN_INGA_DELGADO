/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Vehiculo;

/**
 * La clase `Vehiculo` representa un vehículo en el sistema. Contiene información sobre el código
 * del vehículo, placa, modelo, marca y tipo de vehículo.
 * 
 * @author José Miguel
 */
import utils.TipoVehiculo;
import java.util.ArrayList;
import utils.Archivo;
import utils.TipoVehiculo;

public class Vehiculo{
    private int codigoVehiculo;
    private String placa;
    public String modelo;
    public String marca;
    public TipoVehiculo tipo;
    /**
     * Método estático que obtiene una lista de todos los vehículos almacenados en el sistema.
     * 
     * @return Lista de objetos `Vehiculo`.
     */
    static ArrayList<Vehiculo> getVehiculos(){
         ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        
        Vehiculo v1 = null;
        //ArrayList<String> lineasArc = Archivo.leer(Archivo.MyPath + "Vehiculos.txt");
        ArrayList<String> lineasArc = Archivo.FindBy(Archivo.MyPath + "Vehiculos.txt", Archivo.ALLDATA);
        for (String lineas: lineasArc){            
            String[] datosVehiculos = lineas.split(",");
            String codigoVehiculo = datosVehiculos[0];
            Integer cVehiculo = Integer.parseInt(codigoVehiculo);
            int id_code = (int)cVehiculo;
            TipoVehiculo tV = TipoVehiculo.valueOf(datosVehiculos[4]);
            v1 = new Vehiculo(id_code,datosVehiculos[1],datosVehiculos[2],datosVehiculos[3],tV);
                }
        return vehiculos;
    }
    //metodos de acceso
    //getters
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
    //setters
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
    /**
     * Constructor de la clase `Vehiculo`.
     * 
     * @param codigoVehiculo Código único que identifica al vehículo.
     * @param placa Placa del vehículo.
     * @param modelo Modelo del vehículo.
     * @param marca Marca del vehículo.
     * @param tipo Tipo de vehículo (automóvil, moto, etc.).
     */
    public Vehiculo(int codigoVehiculo, String placa, String modelo, String marca, TipoVehiculo tipo) {
        this.codigoVehiculo = codigoVehiculo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo;
    }
    
    
    }

