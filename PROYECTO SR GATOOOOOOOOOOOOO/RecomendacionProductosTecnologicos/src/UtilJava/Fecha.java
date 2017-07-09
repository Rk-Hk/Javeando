
package UtilJava;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nelsoncuenta
 */
public class Fecha {
    
   
public static String fechaActual(){ 
    Date fecha=new Date(); 
    SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY");
    return formatoFecha.format(fecha);
}

public static String horaActual(){

    Date hora = new Date();
    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    return formatoHora.format(hora);
}

   
    
}
