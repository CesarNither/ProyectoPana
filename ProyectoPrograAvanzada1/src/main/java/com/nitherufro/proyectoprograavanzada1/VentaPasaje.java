package com.nitherufro.proyectoprograavanzada1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VentaPasaje {

    private ArrayList<String> pasajes = new ArrayList<>();

    private ArrayList<Servicio> servicios;
    private String[] division;
    private ArrayList<Pasaje> registroVentas;
    static String comentario = "***************************************************";

    public VentaPasaje(ArrayList<Servicio> servicio) {
        registroVentas = new ArrayList<>();
        servicios = servicio;
    }

    public void menu() {
        System.out.println(comentario);
        int opcionUsuario = -404;
        do {
            try {
                opcionUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, "------MENU------\n"
                        + "1: Vender Pasaje\n"
                        + "2: Mostrar Los Horarios\n"
                        + "3: Mostrar Ventas\n"
                        + "0: Salir..."));
                switch (opcionUsuario) {
                    case 1:
                        venderPasaje();
                        break;
                    case 2:
                        verHorarios();
                        break;
                    case 3:
                        mostrarVentas();
                        String cont = leerTxt();
                        String[] separar = cont.split(",");
                        for (int i = 0; i < separar.length; i++) {
                            System.out.println(separar[i]);
                        }
                        break;
                    case 0:
                        salirPrograma(opcionUsuario);
                    default:
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
            Cliente c1 = new Cliente(ingresarPago(indiceServicio), ingresarRut(indiceServicio));
            mostrarAsientos(indiceServicio);

            int numeroAsiento = ingresarAsiento(indiceServicio);
            servicios.get(indiceServicio).getBus().getAsientos()[numeroAsiento - 1].setEstado(true);
            String contenido = leerTxt();

            division = contenido.split(",");
            for (int i = 0; i < division.length; i++) {
                String part = division[i];
                pasajes.add(division[i]);
            }
            int largo;
            Pasaje p1 = new Pasaje(division.length - 1, c1.getRut(), servicios.get(indiceServicio).getBus().getAsientos()[numeroAsiento - 1], servicios.get(indiceServicio));
            if (division.length == 0) {
                largo = division.length + 2;
            }
            registroVentas.add(p1);
            imprimirPasaje(p1, indiceServicio);
            bw.write(p1.getId() + "-" + "Asiento :" + p1.getAsiento() + "-" + "Hora :" + p1.getHoraImpresion() + "-" + "Rut: " + p1.getRutCliente() + p1.getServicio() + "," + "\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int ingresarDestino() {
        int destino = -1;
        int indiceServicio = 0;
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
                        break;
                }
            } catch (Exception NumberFormatException) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un caracter numerico", "Error", 0);
            }
        } while (destino < 0 || destino > 4);
        return indiceServicio;
    }

    public String ingresarRut(int indiceServicio) {
        boolean largoCorrectoRut = false;
        String rut;
        do {
            rut = JOptionPane.showInputDialog("Ingrese Rut del Cliente (12345678-9)\n" + "Ingrese 0 para salir del programa");
            salirPrograma(rut);
            if (rut.length() == 10) {
                break;
            }
            JOptionPane.showMessageDialog(null, "ingrese correctamente el rut : \"(12345678-9)\" sin puntos y con guion " + "\nSi es poseedor de un rut menor a 10.000.000-0 ingrese un 0 como primer digito", "Error", 0);
        } while (!largoCorrectoRut);
        return rut;
    }

    public int ingresarPago(int indiceServicio) {
        int numeroUsuario, pago = -1;
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

    public void salirPrograma(String numeroUsuario) {
        if (numeroUsuario.equals("0")) {
            JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro programa", "Gracias", 1);
            System.exit(0);
        };
    }

    public void salirPrograma(int numeroUsuario) {
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
            if (!servicios.get(indiceServicio).getBus().getAsientos()[i].isEstado()) {
                System.out.println(i + 1);
            }
        }
    }

    public int ingresarAsiento(int indiceServicio) {
        int numeroAsiento = 0;
        boolean validar = false;
        do {
            try {
                numeroAsiento = Integer.parseInt(JOptionPane.showInputDialog("Ingresar N° de Asiento \n"
                        + "Ingrese el numero 0 para salir del programa"));
                salirPrograma(numeroAsiento);
                if (numeroAsiento <= 0 || numeroAsiento >= servicios.get(indiceServicio).getBus().getCantidadAsientos()) {
                    validar = invalidarAsiento();
                } else if (servicios.get(indiceServicio).getBus().getAsientos()[numeroAsiento - 1].isEstado()) {
                    validar = invalidarAsiento();
                } else {
                    validar = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un caracter numerico", "Error", 0);
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Error: Ha ingresado un numero fuera del limite", "Error", 0);
            }
        } while (!validar);
        return numeroAsiento;
    }

    public void imprimirPasaje(Pasaje p1, int indiceServicio) {
        System.out.println(p1);
        System.out.println("Destino =         " + servicios.get(indiceServicio).getDestino());
        System.out.println("Hora salida =     " + servicios.get(indiceServicio).getHoraSalida());
    }

    public boolean invalidarAsiento() {
        JOptionPane.showMessageDialog(null, "ASIENTO NO DISPONIBLE " + "\nIngrese asiento nuevamente", "Error", 0);
        return false;
    }

    public int calcular(Servicio servicio, int pago) {
        if (servicio.getPrecioPasaje() <= pago) {
            JOptionPane.showMessageDialog(null, "VUELTO = " + (pago - servicio.getPrecioPasaje()), "Pago Recibido", -1);
            return (pago - servicio.getPrecioPasaje());
        }
        JOptionPane.showMessageDialog(null, "PAGO INSUFICIENTE" + "\nINGRESE OTRO MONTO", "Error", 0);
        return -1;
    }

    public void mostrarVentas() {
        System.out.println(comentario);
        System.out.println("  VENTAS  ");
        for (int i = 0; i < registroVentas.size(); i++) {
            if (i == 0) {
                System.out.println("ID   hora de impresion     pago");
            }
            System.out.println(registroVentas.get(i).getId() + "  | " + registroVentas.get(i).getHoraImpresion() + "      | " + registroVentas.get(i).getServicio().getPrecioPasaje());
            System.out.println("");
        }
    }

    public void verHorarios() {
        for (int i = 0; i < servicios.size(); i++) {
            System.out.println((i + 1) + ".- " + servicios.get(i).getDestino());
            System.out.println("Hora: " + servicios.get(i).getHoraSalida());
            System.out.println("Precio pasaje: " + servicios.get(i).getPrecioPasaje() + "\n");
        }
    }

    public int mostrarHorarios(String destino) {
        for (int i = 0; i < servicios.size(); i++) {
            if (servicios.get(i).getDestino().equalsIgnoreCase(destino)) {
                System.out.println((i + 1) + ".- " + servicios.get(i).getDestino());
                System.out.println("Hora: " + servicios.get(i).getHoraSalida());
                System.out.println("Precio pasaje: " + servicios.get(i).getPrecioPasaje() + "\n");
            }
        }
        int indiceServicio = 0;
        boolean flag = true;
        do {
            do {
                try {
                    indiceServicio = Integer.parseInt(JOptionPane.showInputDialog("Ingresar numero de Servicio\n"
                            + "Ingrese el numero 0 para salir del programa"));
                    salirPrograma(indiceServicio);
                    if (destino.equals("VILLARRICA")) {
                        if (indiceServicio > 0 && indiceServicio < 3) {
                            flag = false;
                        }
                    }
                    if (destino.equals("TEMUCO")) {
                        if (indiceServicio > 2 && indiceServicio < 5) {
                            flag = false;
                        }
                    }
                    if (destino.equals("SANTIAGO")) {
                        if (indiceServicio > 4 && indiceServicio < 7) {
                            flag = false;
                        }
                    }
                } catch (Exception NumberFormatException) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese un caracter numerico", "Error", 0);
                }
            } while (flag == true);
        } while (!servicios.get(indiceServicio - 1).getDestino().equalsIgnoreCase(destino));
        return indiceServicio - 1;
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
