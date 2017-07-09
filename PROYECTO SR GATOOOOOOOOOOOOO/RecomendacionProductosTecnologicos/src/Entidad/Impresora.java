/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

import java.awt.Image;
import java.io.FileInputStream;

/**
 *
 * @author nelsoncuenta
 */
public class Impresora extends Producto{
   private String tipo;

    public Impresora(String tipo, String serie, double precio, String marca, String modelo, String descripcion, double preferencia, Image fotovuelta) {
        super(serie, precio, marca, modelo, descripcion, preferencia, fotovuelta);
        this.tipo = tipo;
    }
    
    public Impresora() {
      
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
   
    
}
