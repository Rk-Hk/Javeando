/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

import java.awt.Image;
//import java.io.FileInputStream;

/**
 *
 * @author RIKARDO
 */
public class Pc extends Producto{
    private String SO;
     private int ram;
    private int discoDuro;

    public Pc(String SO, int ram, int discoDuro, String serie, double precio, String marca, String modelo, String descripcion, double preferencia, Image fotovuelta) {
        super(serie, precio, marca, modelo, descripcion, preferencia, fotovuelta);
        this.SO = SO;
        this.ram = ram;
        this.discoDuro = discoDuro;
    }

    public Pc() {
    }

   
    
    
    public String getSO() {
        return SO;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(int discoDuro) {
        this.discoDuro = discoDuro;
    }
    
    
}
