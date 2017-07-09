

package Entidad;

import java.awt.Image;

public class Laptop extends Producto{
   private String SO;
    private String tamano;
    private int ram; 

  
    public Laptop(String SO, String tamano, int ram, String serie, double precio, String marca, String modelo, String descripcion, double preferencia, Image fotovuelta) {
        super(serie, precio, marca, modelo, descripcion, preferencia, fotovuelta);
        this.SO = SO;
        this.tamano = tamano;
        this.ram = ram;
    }
public Laptop(){
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
    
   
    
}
