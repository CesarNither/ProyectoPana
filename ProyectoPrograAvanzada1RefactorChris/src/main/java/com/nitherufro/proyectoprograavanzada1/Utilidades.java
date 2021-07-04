/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitherufro.proyectoprograavanzada1;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author chris
 */
public class Utilidades {
    
    public static String getTimestamp(){
        String fecha;
        return fecha = DateTimeFormatter.ofPattern("yyyMMddHHmm").format(LocalDateTime.now());
        
    }
    
    public static Logger GenerarLog(String nombre, String time) throws IOException {
      
        Logger logger = Logger.getLogger(nombre);
        FileHandler fileLog = new FileHandler("./"+time+" "+nombre+".log",true);
        logger.addHandler(fileLog);
        SimpleFormatter formatter = new SimpleFormatter();
        fileLog.setFormatter(formatter);
        return logger;
        
    }   
    
}
