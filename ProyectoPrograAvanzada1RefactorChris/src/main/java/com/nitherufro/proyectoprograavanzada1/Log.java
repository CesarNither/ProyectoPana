package com.nitherufro.proyectoprograavanzada1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {

    private BufferedWriter buffered;
    private String ruta;
 
    public Log(String ruta) throws IOException {
        this.ruta = ruta;
        this.open(true);
    }
 
    public Log(String ruta, boolean reset) throws IOException {
        this.ruta = ruta;
        this.open(!reset);
    }
 
    private void open(boolean append) throws IOException {
        this.buffered = new BufferedWriter(new FileWriter(this.ruta, append));
    }
    
   public void addLine(String line) throws IOException {
    Logger logger = Logger.getLogger("MyLogger");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
    String formatoFecha = sdf.format(new Date());
    this.open(true);
    this.buffered.write("[" + formatoFecha + "] " + line + "\n");
    
    this.close();
}
    
    public String [] getLines() throws FileNotFoundException, IOException{
        ArrayList <String> linesFile = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(this.ruta));
        
        String line;
        
        while((line = br.readLine()) != null){
            linesFile.add(line);
        }
        
        br.close();
        
        String [] lines = new String [linesFile.size()];
        
        for (int i = 0; i < linesFile.size(); i++) {
            lines[i] = linesFile.get(i);
        }
        
        return lines;
            
        }
    
   public void resetLog() throws IOException{
    this.open(false);
    this.close();
}
    
    private void close() throws IOException{
        this.buffered.close();
    }
    }

