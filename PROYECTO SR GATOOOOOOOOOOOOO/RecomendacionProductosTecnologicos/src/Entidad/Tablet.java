

package Entidad;

import java.awt.Image;
import java.io.FileInputStream;

/**
 *
 * @author nelsoncuenta
 */
public class Tablet extends Producto{
    private String SO;
    private String tamano;
    private int ram;
    private String resolucion ;

    public Tablet(String SO, String tamano, int ram, String resolucion, String serie, double precio, String marca, String modelo, String descripcion, double preferencia, Image fotovuelta) {
        super(serie, precio, marca, modelo, descripcion, preferencia, fotovuelta);
        this.SO = SO;
        this.tamano = tamano;
        this.ram = ram;
        this.resolucion = resolucion;
    }

    public Tablet() {
    }


    public String getSO() {
        return SO;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }
    
    
   
    
}
