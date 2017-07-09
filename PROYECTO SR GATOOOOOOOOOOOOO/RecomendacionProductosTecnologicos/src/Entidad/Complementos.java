

package Entidad;

import java.awt.Image;

/**
 *
 * @author Jeremy
 */
public class Complementos extends Producto{
    private String nombre;

    public Complementos(String nombre, String serie, double precio, String marca, String descripcion, double preferencia, Image fotovuelta) {
        super(serie, precio, marca, descripcion, preferencia, fotovuelta);
        this.nombre = nombre;
    }

    public Complementos() {
    }
    
    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
          
    
}
