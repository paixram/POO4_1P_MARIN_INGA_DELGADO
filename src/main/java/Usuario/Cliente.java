/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Usuario;
import Servicio.*;
import java.util.Random;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import utils.*;
import utils.TipoVehiculo;
import Vehiculo.*;
import Sistema.Pago;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author José Marin
 */
public class Cliente extends Usuario{
    
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    
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
        
        String cedula = this.getNumCedula();
        
        // Extraer todas los servicios que tengan la cedula del cliente
        HashMap<String, ArrayList<Object>> where = Archivo.CreateQuery(new Object[]{"cedulaCliente", cedula});
        ArrayList<String> serv = Archivo.FindBy(Archivo.MyPath + "Servicios.txt", where);
        System.out.println("Coincidencias: " + serv);
        for(String s : serv) {
            // Splitear cada servicio
            String[] s_data = s.split(",");
            Integer numero_serv = Integer.parseInt(s_data[0]);
            TipoServicio t_serv = TipoServicio.valueOf(s_data[1]);
            String cedula_serv = s_data[2];
            String nombre_conductor = s_data[3];
            String desde_serv = s_data[4];
            String hasta_serv = s_data[5];
            
            SimpleDateFormat dateFormat_serv = new SimpleDateFormat("dd/MM/yyyy");    
            Date fecha_serv = null;
            try {             
                fecha_serv = dateFormat_serv.parse(s_data[6]);                    
            } catch (ParseException e) {             
                System.out.println("Formato de fecha inválido. Asegúrate de ingresar la fecha en formato dd/MM/yyyy.");         
            }
            
            String hora_serv = s_data[7];
            
            // Obtener usuario
            HashMap<String, ArrayList<Object>> clausule_user = Archivo.CreateQuery(new Object[]{"nombre", nombre_conductor});
            ArrayList<String> user_cred = Archivo.FindBy(Archivo.MyPath + "Usuarios.txt", clausule_user);

            String[] data_user = (user_cred.get(0)).split(",");
            
            String cedula_user = data_user[0];
            String nombre_user = data_user[1];
            String apellido_user = data_user[2];
            String user_user = data_user[3];
            String contraseña_user = data_user[4];
            String celular = data_user[5];
            TipoUsuario tu = TipoUsuario.valueOf(data_user[6]);
            
            // Obtener conductor
            HashMap<String, ArrayList<Object>> clausule_conductor = Archivo.CreateQuery(new Object[]{"cedula", cedula_user});
            ArrayList<String> conductor_cred = Archivo.FindBy(Archivo.MyPath + "Conductores.txt", clausule_conductor);
            
            String[] data_conductor = (conductor_cred.get(0)).split(",");
            
            String conductor_cedula = data_conductor[0];
            EstadoConductor ec = EstadoConductor.valueOf(data_conductor[1]);
            Integer codigo_vehiculo = Integer.parseInt(data_conductor[2]);
            
            // Obtener vehiculo
            HashMap<String, ArrayList<Object>> clausule_vehiculo = Archivo.CreateQuery(new Object[]{"codigoVehiculo", codigo_vehiculo});
            ArrayList<String> vehiculo_cred = Archivo.FindBy(Archivo.MyPath + "Vehiculos.txt", clausule_vehiculo);
            
            String[] data_vehiculo = (vehiculo_cred.get(0)).split(",");
            
            Integer codigo_vehi = Integer.parseInt(data_vehiculo[0]);
            String placa_vehi = data_vehiculo[1];
            String modelo_vehi = data_vehiculo[2];
            String marca_vehi = data_vehiculo[3];
            TipoVehiculo tv = TipoVehiculo.valueOf(data_vehiculo[4]);
            
            // obtener el pago
            HashMap<String, ArrayList<Object>> clausule_pago = Archivo.CreateQuery(new Object[]{"numeroServicio", numero_serv});
            ArrayList<String> pago_cred = Archivo.FindBy(Archivo.MyPath + "Pagos.txt", clausule_pago);
            System.out.println("El servisiosh: " + numero_serv);
            System.out.println("El pagosh: " + pago_cred);
            String[] data_pago = (pago_cred.get(0)).split(",");

            FormasPago forma_pago = FormasPago.valueOf(data_pago[3]);
            
            // crear el vehiculo, conductor, servicio
            Vehiculo vh = new Vehiculo(codigo_vehi, placa_vehi, modelo_vehi, marca_vehi, tv);
            Conductor c = new Conductor(conductor_cedula, ec, vh, cedula_user, nombre_user, apellido_user, user_user, contraseña_user, celular, tu);
            Servicio serv_n = new Servicio(numero_serv, desde_serv, hasta_serv, fecha_serv, hora_serv, c, t_serv, forma_pago);
            
            serv_n.setCosto(Double.parseDouble(data_pago[6]));
            serviciosSolicitados.add(serv_n);
        }
        
        int i = 1;
        for(Servicio servd : serviciosSolicitados) {
            
            System.out.println(servd);
            if(servd instanceof Taxi) {
               System.out.println("************************ Servicio " + i + " + TAXI ************************"); 
               Taxi t = (Taxi)servd;
               System.out.println(t);
            }else if(servd instanceof Encomienda){
                System.out.println("************************ Servicio " + i + " + ENCOMIENDA ************************");
                Encomienda e = (Encomienda)servd;
                System.out.println(e);
            }
            
            System.out.println("****************************************************************************");
            i++;
        }
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
        }catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Asegúrate de ingresar la fecha en formato dd/MM/yyyy.");
        }
        
        System.out.println("Ingrese la hora: ");
        String inputHora = sc.nextLine();
        
        //CONDUCTOR
        ArrayList<Conductor> conductores = Conductor.getConductores();
        boolean val = false;
        Conductor c_random = null;
        do{            
            int pos_aleatoria = random.nextInt(conductores.size());
            c_random = conductores.get(pos_aleatoria);
            if (c_random.getEstado() == EstadoConductor.D){
                Vehiculo v = c_random.getVehiculo();
                if (v.tipo == TipoVehiculo.A){
                    val = true;
                }                
            }            
        }while(val==false);
        
        System.out.println("Ingrese una forma de pago: ");
        String formaPago = sc.nextLine();
        FormasPago forma_Pago = FormasPago.valueOf(formaPago);
        
        System.out.println("Ingrese el numero de personas a transportar: ");
        int numeroPersonas = sc.nextInt();
        sc.nextLine();
        
        //id servicio
        //ArrayList<String> lineaServicios = Archivo.leer(Archivo.MyPath + "Servicios.txt");
        ArrayList<String> lineaServicios = Archivo.FindBy(Archivo.MyPath + "Servicios.txt", Archivo.ALLDATA);
        String[] datosUltLinea = lineaServicios.get(lineaServicios.size()-1).split(",");
        String id_in = datosUltLinea[0];        
        Integer identificador = Integer.valueOf(id_in);
        int clave_id = (int)identificador+1;
        
        Servicio s_taxi = new Taxi(numeroPersonas,clave_id,origenS,destinoS,date,inputHora,c_random,TipoServicio.T,forma_Pago);    
        Taxi sT = (Taxi)s_taxi;
        
        //id pago
        //ArrayList<String> linePago = Archivo.leer("Pagos.txt");
        ArrayList<String> linePago = Archivo.FindBy(Archivo.MyPath + "Pagos.txt", Archivo.ALLDATA);
        String[] datosUltLinea2 = linePago.get(linePago.size()-1).split(",");
        String id_in2 = datosUltLinea2[0];        
        Integer identificador2 = Integer.parseInt(id_in2);
        int clave_id_pago = (int)identificador2+1;
        
        //s_taxi.setCosto(sT.calcularCosto());
        
        if(forma_Pago == FormasPago.T) {
          s_taxi.setCosto(sT.calcularCosto(this.numTarjetaCredito));
        }else{
            s_taxi.setCosto(sT.calcularCosto());
        }
        
        //Confirmar servicio
        System.out.print("El valor a pagar es: "+sT.calcularCosto()+". \n Confirme su viaje (S/N): ");
        String confirmacion = sc.nextLine();
        if (confirmacion.equals("S")){
            Pago pago_confirmado = new Pago(clave_id_pago,date,s_taxi,this,s_taxi.getCosto());
            s_taxi.guardarServicio(this.getNumCedula());
            sT.guardarViaje(this.getNumCedula());
            pago_confirmado.guardarPago();
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
        }catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Asegúrate de ingresar la fecha en formato dd/MM/yyyy.");
        }
        
        System.out.println("Ingrese la hora: ");
        String inputHora = sc.nextLine();
        
        
        //CONDUCTOR]
        ArrayList<Conductor> conductores = Conductor.getConductores();
        boolean val = false;
        Conductor c_random = null;
        do{            
            int pos_aleatoria = random.nextInt(conductores.size());
            c_random = conductores.get(pos_aleatoria);
            if (c_random.getEstado() == EstadoConductor.D){
                Vehiculo v = c_random.getVehiculo();
                if (v.tipo == TipoVehiculo.A){
                    val = true;

                }
            }            
        }while(val==false);
        
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
        

        //ArrayList<String> lineaServicios = Archivo.leer(Archivo.MyPath + "Servicios.txt");
        ArrayList<String> lineaServicios = Archivo.FindBy(Archivo.MyPath + "Servicios.txt", Archivo.ALLDATA);
        String[] datosUltLinea = lineaServicios.get(lineaServicios.size()-1).split(",");
        String id_in = datosUltLinea[0];        
        Integer identificador = Integer.parseInt(id_in);
        int clave_id = (int)identificador;


        Servicio s_encomienda = new Encomienda(tipo_Encomienda,cantidadProductos,peso,clave_id,origenS,destinoS,fecha,inputHora,c_random,TipoServicio.E,forma_Pago);
        Encomienda sE = (Encomienda)s_encomienda;
        
        //id pago
        //ArrayList<String> linePago = Archivo.leer("Pagos.txt");
        ArrayList<String> linePago = Archivo.FindBy(Archivo.MyPath + "Pagos.txt", Archivo.ALLDATA);
        String[] datosUltLinea2 = linePago.get(linePago.size()-1).split(",");
        String id_in2 = datosUltLinea2[0];        
        Integer identificador2 = Integer.parseInt(id_in2);
        int clave_id_pago = (int)identificador2+1;
        
        //Confirmar servicio
        System.out.print("El valor a pagar es: "+sE.calcularCosto()+". Confirme su viaje: S/N");
        String confirmacion = sc.nextLine();
        if (confirmacion.equals("S")){
            Pago pago_confirmado = new Pago(clave_id_pago,fecha,s_encomienda,this,s_encomienda.getCosto());
            sE.guardarEncomienda();
            s_encomienda.guardarServicio(this.getNumCedula());
        }
        
    }
    
    public void pagarServicio(){
        this.consultarServicios();
        System.out.println("Determine el servicio a pagar con el id: ");
        Scanner sc = new Scanner(System.in);
        int id_service = sc.nextInt();
        HashMap<String, ArrayList<Object>> where = Archivo.CreateQuery(new Object[]{"numeroServicio",id_service});                
        ArrayList<String> coincidencia = Archivo.FindBy(Archivo.MyPath + "Servicios.txt", where);
        String[] partes = coincidencia.get(0).split(",");
        System.out.println("De qué forma desea pagar: T(Tarjeta de crédito)/E(Efectivo) ");
        String formaPago = sc.nextLine();
        FormasPago forma_pago = FormasPago.valueOf(formaPago);
        String t_d_s = partes[1];
        TipoServicio tDS = TipoServicio.valueOf(t_d_s);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");        
        Date fecha = null;
        try {
            fecha = dateFormat.parse(partes[6]);
            System.out.println("Fecha ingresada: " + fecha);
        }catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Asegúrate de ingresar la fecha en formato dd/MM/yyyy.");
        }
        //conductor
        Conductor c_asignado = null;
        ArrayList<Conductor> conductores = Conductor.getConductores();
        for (Conductor c: conductores){
            if (c.getNombres().equals(partes[3])){
                c_asignado = c;
            }
        }

        if (tDS == TipoServicio.T){
            HashMap<String, ArrayList<Object>> where2 = Archivo.CreateQuery(new Object[]{"numeroServicio",id_service});              
            ArrayList<String> datosViaje = Archivo.FindBy(Archivo.MyPath + "Viajes.txt", where2);
            String[] partesViaje = datosViaje.get(0).split(",");
            String numPasajeros = partesViaje[1];
            Integer cant = Integer.parseInt(numPasajeros);
            int cant_pasajeros = (int)cant;                
            if (forma_pago == FormasPago.T){
                Taxi s = new Taxi(cant_pasajeros, id_service, partes[4], partes[5], fecha, partes[7],
                        c_asignado, TipoServicio.T, FormasPago.T);
                s.calcularCosto(t_d_s);
            }else{
                Taxi s = new Taxi(cant_pasajeros, id_service, partes[4], partes[5], fecha, partes[7],
                        c_asignado, TipoServicio.T, FormasPago.E);
                s.calcularCosto();
            }
        }else{
            HashMap<String, ArrayList<Object>> where3 = Archivo.CreateQuery(new Object[]{"numeroServicio",id_service});              
            ArrayList<String> datosEncomienda = Archivo.FindBy(Archivo.MyPath + "Encomiendas.txt", where3);

            String[] partesEncomienda = datosEncomienda.get(0).split(",");
            TipoEncomiendas tE = TipoEncomiendas.valueOf(partesEncomienda[1]);
            String cantProd = partesEncomienda[2];
            Integer cant = Integer.parseInt(cantProd);
            int cant_prod = (int)cant;           
            double peso = sc.nextDouble();

            Encomienda e = new Encomienda(tE, cant_prod, peso, id_service, partes[4], partes[5],fecha, partes[7],
                      c_asignado,TipoServicio.E, FormasPago.T);
            e.calcularCosto();
        }


    }
    
    
}
