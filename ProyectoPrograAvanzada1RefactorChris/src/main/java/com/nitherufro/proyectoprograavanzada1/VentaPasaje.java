package com.nitherufro.proyectoprograavanzada1;

import static com.nitherufro.proyectoprograavanzada1.Utilidades.FileLogger;
import static com.nitherufro.proyectoprograavanzada1.Utilidades.GenerarLog;
import static com.nitherufro.proyectoprograavanzada1.Utilidades.nombreLogger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JOptionPane;

public class VentaPasaje {

    private ArrayList<String> pasajes = new ArrayList<>();
    private static ArrayList<Servicio> servicios;
    private String[] division;
    private ArrayList<Pasaje> registroVentas;
    static String comentario = "***************************************************";
    static String fecha;
    static Logger registro;
    private BufferedWriter buffered;

    public VentaPasaje(ArrayList<Servicio> servicio) {
        registroVentas = new ArrayList<>();
        servicios = servicio;
    }

    public VentaPasaje() {
    }

    public static Logger crearLog(FileHandler fileLog) {
        try {
            registro = GenerarLog(nombreLogger, fileLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return registro;
    }

    public static FileHandler log() throws IOException {
        fecha = Utilidades.getTimestamp();
        FileHandler fileLog = FileLogger();
        registro = crearLog(fileLog);
        return fileLog;
    }

    public void menu() throws IOException {
        nombreLogger = "menu";
        FileHandler fileLog = log();
        System.out.println(comentario);
        int opcionUsuario = -1;
        do {
            try {
                opcionUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, "------MENU------\n"
                        + "1: Vender Pasaje\n"
                        + "2: Mostrar Los Horarios\n"
                        + "3: Mostrar Ventas\n"
                        + "0: Salir..."));
                switch (opcionUsuario) {
                    case 1:
                        registro.info("Menu, Opcion vender pasaje seleccionada");
                        fileLog.close();
                        venderPasaje();
                        break;
                    case 2:
                        registro.info("Menu, Opcion vender pasaje seleccionada");
                        fileLog.close();
                        verHorarios();
                        break;
                    case 3:
                        registro.info("Menu, Opcion vender pasaje seleccionada");
                        fileLog.close();
                        mostrarVentas();
                        String cont = leerTxt();
                        String[] separar = cont.split(",");
                        for (int i = 0; i < separar.length; i++) {
                            System.out.println(separar[i]);
                        }
                        break;
                    case 0:
                        registro.info("Usuario se ha retirado de la aplicacion");
                        fileLog.close();
                        salirPrograma(opcionUsuario);
                    default:
                        registro.warning("Metodo menu, Opcion invalida seleccionada");
                        fileLog.close();
                        JOptionPane.showMessageDialog(null, "¡Opcion no valida ingrese de nuevo!", "Error", 0);
                        break;
                }
            } catch (Exception NumberFormatException) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un caracter numerico", "Error", 0);
            }
        } while (opcionUsuario >= -1 || opcionUsuario <= 4);
    }

    public void venderPasaje() throws IOException {
        try {
            String ruta = "C:/Users/Public/Documents/pasajes.txt";
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (file.length() == 0) {
                bw.write(",");
            }

            int indiceServicio = ingresarDestino();
            nombreLogger = "ingresarRut";
            String rut = ingresarRut();
            Cliente c1 = new Cliente(ingresarPago(indiceServicio), rut);
            mostrarAsientos(indiceServicio);

            int numeroAsiento = ingresarAsiento(indiceServicio);
            servicios.get(indiceServicio).getBus().setAsiento(numeroAsiento - 1, true);
            String contenido = leerTxt();

            division = contenido.split(",");
            for (int i = 0; i < division.length; i++) {
                String part = division[i];
                pasajes.add(division[i]);
            }
            int largo;
            Pasaje p1 = new Pasaje(division.length - 1, c1.getRut(), numeroAsiento, servicios.get(indiceServicio));
            if (division.length == 0) {
                largo = division.length + 2;
            }
            registroVentas.add(p1);
            imprimirPasaje(p1);
            bw.write(p1.getId() + "-" + "Asiento :N°" + p1.getAsiento() + "-" + "Hora :" + p1.getHoraImpresion() + "-" + "Rut: " + " " + p1.getRutCliente() + p1.getServicio() + "," + "\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int ingresarDestino() throws IOException {
        int destino = -1;
        int indiceServicio = 0;
        nombreLogger = "ingresarDestino";
        do {
            try {

                destino = Integer.parseInt(JOptionPane.showInputDialog(null, "------Ingrese un Destino------\n"
                        + "1: Villarrica\n"
                        + "2: Temuco\n"
                        + "3: Santiago\n"
                        + "0: Salir..."));
                switch (destino) {
                    case 1:
                        indiceServicio = mostrarHorarios("VILLARRICA");
                        break;
                    case 2:
                        indiceServicio = mostrarHorarios("TEMUCO");
                        break;
                    case 3:
                        indiceServicio = mostrarHorarios("SANTIAGO");
                        break;
                    case 0:
                        salirPrograma(destino);
                    default:
                        JOptionPane.showMessageDialog(null, "Error: ingrese un destino valido", "Error", 0);
                        FileHandler fileLog = log();
                        registro.warning("Metodo ingresarDestino  \n Metodo recibio un valor no autorizado '" + destino + "'");
                        fileLog.close();
                        break;
                }
            } catch (Exception NumberFormatException) {
                FileHandler fileLog = log();
                registro.severe("Metodo ingresarDestino ERROR NumberFormatException \n Metodo recibio un valor no autorizado causando una excepcion");
                fileLog.close();
                JOptionPane.showMessageDialog(null, "Error: Ingrese un caracter numerico", "Error", 0);
            }
        } while (destino < 0 || destino > 3);
        return indiceServicio;
    }

    public static String ingresarRut() throws IOException {
        String rut;
        FileHandler fileLog = log();
        do {
            JOptionPane.showMessageDialog(null, "ingrese correctamente el rut : \"(12345678-9)\" sin puntos y con guion " + "\nSi es poseedor de un rut menor a 10.000.000-0 ingrese un 0 como primer digito", "Formato", -1);
            rut = JOptionPane.showInputDialog("Ingrese Rut del Cliente (12345678-9)\n" + "Ingrese 0 para salir del programa");
            salirPrograma(rut);
            if (rut.length() != 10) {
                registro.warning("Metodo ingresarRut, usuario ingreso un rut no valido, rut del cliente: '" + rut + "'");
                fileLog.close();
            }
        } while (rut.length() != 10);
        registro.info("Metodo ingresarRut, cumplido satisfactoriamente, rut del cliente: '" + rut + "'");
        fileLog.close();
        return rut;
    }

    public int ingresarPago(int indiceServicio) {
        int numeroUsuario, pago = 0;
        do {
            try {
                numeroUsuario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto con el que pagara\n" + "Ingrese 0 para salir del programa"));
                salirPrograma(numeroUsuario);
                pago = calcular(servicios.get(indiceServicio), numeroUsuario);
            } catch (Exception NumberFormatException) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un caracter numerico", "Error", 0);
            }
        } while (pago == -1);
        return pago;
    }

    public static void salirPrograma(String numeroUsuario) {
        if (numeroUsuario.equals("0")) {
            JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro programa", "Gracias", 1);
            System.exit(0);
        };
    }

    public static void salirPrograma(int numeroUsuario) {
        if (numeroUsuario == 0) {
            JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro programa", "Gracias", 1);
            System.exit(0);
        };
    }

    public void mostrarAsientos(int indiceServicio) {
        System.out.println(comentario);
        System.out.println("ASIENTOS DISPONIBLES");
        System.out.println("");
        for (int i = 0; i < servicios.get(indiceServicio).getBus().getAsientos().length; i++) {
            if (!servicios.get(indiceServicio).getBus().getAsientos()[i]) {
                System.out.println(i + 1);
            }
        }
    }

    public int ingresarAsiento(int indiceServicio) {
        int numeroAsiento = 0;
        boolean validar = false;
        do {
            try {
                numeroAsiento = Integer.parseInt(JOptionPane.showInputDialog("Ingresar N° de Asiento \n" + "Ingrese el numero 0 para salir del programa"));
                salirPrograma(numeroAsiento);
                if (validarAsiento(numeroAsiento, indiceServicio)) {
                    validar = true;
                } else {
                    validar = invalidarAsiento();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un caracter numerico", "Error", 0);
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Error: Ha ingresado un numero fuera del limite", "Error", 0);
            }
        } while (!validar);
        return numeroAsiento;
    }

    public boolean validarAsiento(int asiento, int indice) {
        return !servicios.get(indice).getBus().getAsiento(asiento - 1);
    }

    /*
    public boolean existeAsiento(int asiento){
        
        return asiento<=0;
    }
    
    public boolean isAsientoCorrecto(int asiento,int cantidadAsientos){
        
        return !(asiento>cantidadAsientos);
        
    }
     */
    public void imprimirPasaje(Pasaje p1) {
        System.out.println(p1);
        System.out.println("Destino =         " + p1.getServicio().getDestino());
        System.out.println("Hora salida =     " + p1.getServicio().getHoraSalida());
    }

    public boolean invalidarAsiento() {
        JOptionPane.showMessageDialog(null, "ASIENTO NO DISPONIBLE " + "\nIngrese asiento nuevamente", "Error", 0);
        return false;
    }

    // version pruebas cesar
    public static int calcular(Servicio servicio, int pago) {
        if (servicio.getPrecioPasaje() <= pago) {
             try {
                Log myLog = new Log("./log.txt");
            JOptionPane.showMessageDialog(null, "VUELTO = " + (pago - servicio.getPrecioPasaje()), "Pago Recibido", -1);
             myLog.addLine("Se ha generado un vuelto del pago de un pasaje correctamente");

                String[] lines = myLog.getLines();

                for (int i = 0; i < lines.length; i++) {
                    System.out.println(lines[i]);
                }

                myLog.resetLog();

            return (pago - servicio.getPrecioPasaje());
            
           
            } catch (IOException ex) {
                Logger.getLogger(VentaPasaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            
                Log myLog = new Log("./log.txt");
                   myLog.addLine("Se ha generado un vuelto del pago de un pasaje INCORRECTAMENTE");
                 String[] lines = myLog.getLines();

                for (int i = 0; i < lines.length; i++) {
                    System.out.println(lines[i]);
                }

                myLog.resetLog();
        
     
        } catch (IOException ex) {
                Logger.getLogger(VentaPasaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        JOptionPane.showMessageDialog(null, "PAGO INSUFICIENTE" + "\nINGRESE OTRO MONTO", "Error", 0);
        return -1;
    }

    /*
    Version alternativa, pruebas de giovanni
    public int calcular(Servicio servicio, int pago) {
        if (isVuelto(servicio.getPrecioPasaje(), pago)) {
            int vuelto=vuelto(servicio.getPrecioPasaje(), pago);
            JOptionPane.showMessageDialog(null, "VUELTO = " + (vuelto), "Pago Recibido", -1);
            return (vuelto);
            
        }
        JOptionPane.showMessageDialog(null, "PAGO INSUFICIENTE" + "\nINGRESE OTRO MONTO", "Error", 0);
        return -1;
        
    }
    
    public boolean isVuelto(int precioPasaje, int pago){
        
        return precioPasaje <= pago;
    }
    
    public int vuelto(int precioPasaje, int pago){
        
        return pago-precioPasaje;
        
    }
     */
    public void mostrarVentas() {
        System.out.println(comentario);
        System.out.println("  VENTAS  .");
        for (int i = 0; i < registroVentas.size(); i++) {
            if (i == 0) {
                System.out.println("ID   hora de impresion     pago");
            }
            System.out.println(registroVentas.get(i).getId() + "  | " + registroVentas.get(i).getHoraImpresion() + "      | " + registroVentas.get(i).getServicio().getPrecioPasaje());
            System.out.println("");
        }
    }

    public static void verHorarios() {

        for (int i = 0; i < servicios.size(); i++) {
            System.out.println((i + 1) + ".- " + servicios.get(i).getDestino() + "\n" + "Hora: " + servicios.get(i).getHoraSalida() + "\n" + "Precio pasaje: " + servicios.get(i).getPrecioPasaje());
        }

    }

    public void verHorarios(String destino) {

        System.out.println(destino);

        for (int i = 0; i < servicios.size(); i++) {
            if (servicios.get(i).getDestino().equalsIgnoreCase(destino)) {
                System.out.println((i + 1) + ".- " + servicios.get(i).getDestino() + "\n" + "Hora: " + servicios.get(i).getHoraSalida() + "\n" + "Precio pasaje: " + servicios.get(i).getPrecioPasaje());

            }
        }
    }

    public int mostrarHorarios(String destino) {
        verHorarios(destino);
        int indiceServicio;
        boolean ciclo;
        do {
            try {
                try {
                    Log myLog = new Log("./log.txt");
                indiceServicio = Integer.parseInt(JOptionPane.showInputDialog("Ingresar numero de Servicio\n" + "Ingrese el numero 0 para salir del programa"));
                salirPrograma(indiceServicio);
                if (destino.equals("VILLARRICA") && indiceServicio > 0 && indiceServicio < 3) {
                     myLog.addLine("Se ha ingresado un numero de servicio correctamente");
                      return indiceServicio - 1;
                }
                if (destino.equals("TEMUCO") && indiceServicio > 2 && indiceServicio < 5) {
                     myLog.addLine("Se ha ingresado un numero de servicio correctamente");
                    return indiceServicio - 1;
                }
                if (destino.equals("SANTIAGO") && indiceServicio > 4 && indiceServicio < 7) {
                     myLog.addLine("Se ha ingresado un numero de servicio correctamente");
                    return indiceServicio - 1;
                }
                myLog.addLine("Se ha ingresado un numero de servicio incorrecto");
                    String[] lines = myLog.getLines();

                    for (int i = 0; i < lines.length; i++) {
                        System.out.println(lines[i]);
                    }

                    myLog.resetLog();

                } catch (IOException ex) {
                    Logger.getLogger(VentaPasaje.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Error: Ingrese un destino valido", "Error", 0);
            } catch (Exception NumberFormatException) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un caracter numerico", "Error", 0);
            }
        } while (ciclo = true);
        return 0;
}

    public String leerTxt() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/Public/Documents/pasajes.txt"));
            StringBuilder texto = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                texto.append(line);
            }
            br.close();
            String contenido = texto.toString();
            return contenido;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
