/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Usuario;
import Servicio.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import utils.*;
import utils.TipoVehiculo;
import Vehiculo.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author José Marin
 */
public class Cliente extends Usuario{
    
    Scanner sc = new Scanner(System.in);
    
    private int edad;
    private String numTarjetaCredito;
    
    public Cliente(int edad, String numTarjetaCredito, String numCedula, String nombres, String apellidos, String user, String contrasenia, String numCelular, TipoUsuario tipoDeUsuario) {
        super(numCedula, nombres, apellidos, user, contrasenia, numCelular, tipoDeUsuario);
        this.edad = edad;
        this.numTarjetaCredito = numTarjetaCredito;
    }
    
    //getters
    public int getEdad(){
        return edad;
    }
    public String getNumTarjetaCredito(){
        return numTarjetaCredito;
    }
    
    //setters
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setNumTarjetaCredito(String numTarjetaCredito){
        this.numTarjetaCredito = numTarjetaCredito;
    }

    @Override
    public void consultarServicios(){
        ArrayList<Servicio> serviciosSolicitados = new ArrayList<>();
        
      
        
    }
    
    
    
    
    
    public void solicitarServicioTaxi(){
        System.out.println("Ingrese el origen: ");
        String origenS = sc.nextLine();
        System.out.println("Ingrese el destino: ");
        String destinoS = sc.nextLine();
        
        Date date = null;
        System.out.println("Ingrese la fecha (formato dd/MM/yyyy): ");
        String inputDate = sc.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = dateFormat.parse(inputDate);
            System.out.println("Fecha ingresada: " + date);
        }catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Asegúrate de ingresar la fecha en formato dd/MM/yyyy.");
        }
        
        System.out.println("Ingrese la hora: ");
        String inputHora = sc.nextLine();
        
        //CONDUCTOR
        Conductor c = null;
        ArrayList<String> lineasArc = Archivo.leer("conductores.txt");
        for (String lineas: lineasArc){
            String[] datosConductor = lineas.split(",");
            if (datosConductor[1].equals("D")){
                ArrayList<String> lineasArc2 = Archivo.leer("vehículos.txt");
                for (String l: lineasArc2){
                    String[] datosVehiculo = l.split(",");
                    if (datosVehiculo[0].equals(datosConductor[2])){
                        if (datosVehiculo[4].equals("M")){
                            ArrayList<String> lineasArc3 = Archivo.leer("usuarios.txt");
                            for (String l3: lineasArc3){
                                String[] datosUsuario = l3.split(",");
                                if (datosUsuario[0].equals(datosConductor[0]));
                                    TipoUsuario tU = TipoUsuario.valueOf(datosUsuario[datosUsuario.length-1]);
                                    EstadoConductor eC = EstadoConductor.valueOf(datosConductor[1]);
                                    
                                    String codigoVehiculo = datosConductor[2];        
                                    Integer cVehiculo = Integer.parseInt(codigoVehiculo);
                                    int id_code = (int)cVehiculo;
                                    
                                    TipoVehiculo tV = TipoVehiculo.valueOf(datosVehiculo[4]);
                                    Vehiculo v = new Vehiculo(id_code,datosVehiculo[1],datosVehiculo[2],datosVehiculo[3],tV);
                                    
                                    c = new Conductor(datosUsuario[0],eC,v,datosUsuario[0],datosUsuario[1],datosUsuario[2],datosUsuario[3],datosUsuario[4],datosUsuario[5],tU);
                                
                            }
                        }
                    }
                }
                
            }
        }
                        
        System.out.println("Ingrese un tipo de servicio");
        String tipoServicio = sc.nextLine();
        TipoServicio tipo_Servicio= TipoServicio.valueOf(tipoServicio);
        
        System.out.println("Ingrese una forma de pago: ");
        String formaPago = sc.nextLine();
        FormasPago forma_Pago = FormasPago.valueOf(formaPago);
        
        System.out.println("Ingrese el numero de personas a transportar: ");
        int numeroPersonas = sc.nextInt();
        sc.nextLine();
        
        ArrayList<String> lineaServicios = Archivo.leer("servicios.txt");
        String[] datosUltLinea = lineaServicios.get(lineaServicios.size()-1).split(",");
        String id_in = datosUltLinea[0];        
        Integer identificador = Integer.parseInt(id_in);
        int clave_id = (int)identificador;
        Servicio s_taxi = new Taxi(numeroPersonas,clave_id,origenS,destinoS,date,inputHora,c,tipo_Servicio,forma_Pago);    
        Taxi sT = (Taxi)s_taxi;
        //Confirmar servicio
        System.out.print("El valor a pagar es: "+sT.calcularCosto()+". Confirme su viaje: S/N");
        String confirmacion = sc.nextLine();
        if (confirmacion.equals("S")){
            
        }
        
        
        
        
    }
    
    public void solicitarServicioEncomienda(){
        System.out.println("Ingrese el origen: ");
        String origenS = sc.nextLine();
        System.out.println("Ingrese el destino: ");
        String destinoS = sc.nextLine();
        
        System.out.println("Ingrese la fecha (formato dd/MM/yyyy): ");
        String inputDate = sc.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        Date fecha = null;
        try {
            fecha = dateFormat.parse(inputDate);
            System.out.println("Fecha ingresada: " + fecha);
        }catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Asegúrate de ingresar la fecha en formato dd/MM/yyyy.");
        }
        
        System.out.println("Ingrese la hora: ");
        String inputHora = sc.nextLine();
        
        
        //CONDUCTOR]
        Conductor c = null;
        ArrayList<String> lineasArc = Archivo.leer("conductores.txt");
        for (String lineas: lineasArc){
            String[] datosConductor = lineas.split(",");
            if (datosConductor[1].equals("D")){
                ArrayList<String> lineasArc2 = Archivo.leer("vehículos.txt");
                for (String l: lineasArc2){
                    String[] datosVehiculo = l.split(",");
                    if (datosVehiculo[0].equals(datosConductor[2])){
                        if (datosVehiculo[4].equals("M")){
                            ArrayList<String> lineasArc3 = Archivo.leer("usuarios.txt");
                            for (String l3: lineasArc3){
                                String[] datosUsuario = l3.split(",");
                                if (datosUsuario[0].equals(datosConductor[0]));
                                    TipoUsuario tU = TipoUsuario.valueOf(datosUsuario[datosUsuario.length-1]);
                                    EstadoConductor eC = EstadoConductor.valueOf(datosConductor[1]);
                                    
                                    String codigoVehiculo = datosConductor[2];        
                                    Integer cVehiculo = Integer.parseInt(codigoVehiculo);
                                    int id_code = (int)cVehiculo;
                                    
                                    TipoVehiculo tV = TipoVehiculo.valueOf(datosVehiculo[4]);
                                    Vehiculo v = new Vehiculo(id_code,datosVehiculo[1],datosVehiculo[2],datosVehiculo[3],tV);
                                    
                                    c = new Conductor(datosUsuario[0],eC,v,datosUsuario[0],datosUsuario[1],datosUsuario[2],datosUsuario[3],datosUsuario[4],datosUsuario[5],tU);

                                    c = new Conductor(datosUsuario[0],eC,v,datosUsuario[0],datosUsuario[1],datosUsuario[2],datosUsuario[3],datosUsuario[4],datosUsuario[5],tU);
                                
                            }
                        }
                    }
                }
                
            }
        }
                        
        System.out.println("Ingrese un tipo de servicio");
        String tipoServicio = sc.nextLine();
        TipoServicio tipo_Servicio= TipoServicio.valueOf(tipoServicio);
        
        System.out.println("Ingrese una forma de pago: ");
        String formaPago = sc.nextLine();
        FormasPago forma_Pago = FormasPago.valueOf(formaPago);
        
        System.out.println("Ingrese el tipo de encomienda: ");
        String tipoEncomienda = sc.nextLine();
        TipoEncomiendas tipo_Encomienda = TipoEncomiendas.valueOf(tipoEncomienda);
        
        System.out.println("Ingrese la cantidad de productos: ");
        int cantidadProductos = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese el peso de la encomienda: ");
        double peso = sc.nextDouble();
        sc.nextLine();
        
        ArrayList<String> lineaServicios = Archivo.leer("servicios.txt");
        String[] datosUltLinea = lineaServicios.get(lineaServicios.size()-1).split(",");
        String id_in = datosUltLinea[0];        
        Integer identificador = Integer.parseInt(id_in);
        int clave_id = (int)identificador;
        Servicio s_encomienda = new Encomienda(tipo_Encomienda,cantidadProductos,peso,clave_id,origenS,destinoS,fecha,inputHora,c,tipo_Servicio,forma_Pago);

 
        //Servicio s_encomienda = new Taxi(tipo_Encomienda,cantidadProductos,peso,clave_id,origenS,destinoS,date,ident_conductor,tipo_Servicio,forma_Pago);

        //Servicio s_encomienda = new Encomienda(tipo_Encomienda,cantidadProductos,peso,clave_id,origenS,destinoS,date,c,tipo_Servicio,forma_Pago);
        
    }
    
    public void pagarServicio(){
    
    }
    
    
}
