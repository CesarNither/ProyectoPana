
package com.nitherufro.proyectoprograavanzada1;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Utilidades {
    
    public static String nombreLogger;
    
    public static String getTimestamp(){
        return DateTimeFormatter.ofPattern("yyy-MM-dd HH-mm-ss-SSS").format(LocalDateTime.now());
        
    }
    
    public static FileHandler FileLogger() throws IOException {
        FileHandler fileLog = new FileHandler("./"+ nombreLogger + ".log", 10 * 1024 * 1024, 10);
        return fileLog;
    }

    public static Logger GenerarLog(String nombre,FileHandler fileLog) throws IOException {
        Logger logger = Logger.getLogger(nombreLogger);
        logger.addHandler(fileLog);
        SimpleFormatter formatter = new SimpleFormatter();
        fileLog.setFormatter(formatter);
        return logger;
    }
    
}
