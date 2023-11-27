/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Usuario;
import Servicio.Servicio;


import utils.TipoUsuario;
import utils.EstadoConductor;

import Vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import utils.Archivo;
import utils.TipoServicio;
import utils.TipoVehiculo;
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
        String nombre = this.getNombres();
        
        // Extraer todas la chamba del conductor desde servicio
        HashMap<String, ArrayList<Object>> where = Archivo.CreateQuery(new Object[]{"nombreConductor", nombre});
        ArrayList<String> conductor_chamba = Archivo.FindBy("C:\\Users\\Luizzz\\Documents\\NetBeansProjects\\POO4_1P_MARIN_INGA_DELGADO\\src\\main\\java\\Database\\Servicios.txt", where, Servicio.class);
        
        
        for(String cc : conductor_chamba) {
            // splitear chamba
            String[] cc_data = cc.split(",");
            System.out.println("Tipo: " + TipoServicio.valueOf(cc_data[1]));
            
            HashMap<String, ArrayList<Object>> clausule_serv_viaje = Archivo.CreateQuery(new Object[]{"numeroServicio", cc_data[0]});
            ArrayList<String> conductor_viaje = Archivo.FindBy("C:\\Users\\Luizzz\\Documents\\NetBeansProjects\\POO4_1P_MARIN_INGA_DELGADO\\src\\main\\java\\Database\\Viajes.txt", clausule_serv_viaje, Servicio.class);
            
            String[] cv = (conductor_viaje.get(0)).split(",");
            
            Integer pasajeros_num = Integer.parseInt(cv[1]);
            
            if(TipoServicio.valueOf(cc_data[1]) == TipoServicio.T) {
                System.out.println("Cantidad pasajeros: " + pasajeros_num);
            }
            
            System.out.println("Fecha: " + cc_data[6]);
            System.out.println("Hora: " + cc_data[7]);
            System.out.println("Desde: " + cc_data[4]);
            System.out.println("Hasta: " + cc_data[5]);
        }
    }
    
    public static ArrayList<Conductor> getConductores(){
        ArrayList<Conductor> conductores = new ArrayList<>();
        
        Conductor c = null;
        ArrayList<String> lineasArc = Archivo.leer("conductores.txt");
        for (String lineas: lineasArc){            
            String[] datosConductor = lineas.split(",");
            String codVehiculo = datosConductor[2];
            EstadoConductor eC = EstadoConductor.valueOf(datosConductor[1]);
            ArrayList<String> lineasArc2 = Archivo.leer("vehículos.txt");
            Vehiculo v = null;
            for (String l: lineasArc2){
                String[] datosVehiculo = l.split(",");
                if (codVehiculo.equals(datosVehiculo[0])){
                    
                    String codigoVehiculo = datosVehiculo[0];        
                    Integer cVehiculo = Integer.parseInt(codigoVehiculo);
                    int id_code = (int)cVehiculo;                                    
                    TipoVehiculo tV = TipoVehiculo.valueOf(datosVehiculo[4]);
                    
                    v = new Vehiculo(id_code,datosVehiculo[1],datosVehiculo[2],datosVehiculo[3],tV);
                }
            }
            ArrayList<String> lineasArc3 = Archivo.leer("usuarios.txt");
            for (String l3: lineasArc3){
                String[] datosUsuario = l3.split(",");
                if (datosConductor[0].equals(datosUsuario[0])){
                    
                    TipoUsuario tU = TipoUsuario.valueOf(datosUsuario[datosUsuario.length-1]);
                    c = new Conductor(datosUsuario[0],eC,v,datosUsuario[0],datosUsuario[1],datosUsuario[2],datosUsuario[3],datosUsuario[4],datosUsuario[5],tU);
                   
                
            }
            conductores.add(c);
            }
        }
        return conductores;
            
            
    }
    
    
        
    public String verificarDatVehiculo(Conductor chofer){
        Vehiculo vPropiedad = chofer.getVehiculo();
        
        if (vPropiedad.tipo==TipoVehiculo.A){
            return "Carro";
        }else{
            return "Moto";
        }

    }
    
    
         
}   
            
            
    

