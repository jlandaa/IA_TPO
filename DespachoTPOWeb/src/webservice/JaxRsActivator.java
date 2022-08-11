package webservice;

import javax.ws.rs.ApplicationPath; 
import javax.ws.rs.core.Application; 

//Directorio en donde se encuentran definidos todos los servicios
//a los cuales, podra acceder el cliente remoto
@ApplicationPath("/services") 
public class JaxRsActivator extends Application {  
} 
