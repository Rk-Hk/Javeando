

package Entidad;

import java.awt.Image;
import java.io.FileInputStream;


public class Producto {
    
   private String serie;
   private double precio;
   private String marca;
   private String modelo;
   private String descripcion;
   private double preferencia;
   private FileInputStream imageProduc;
   
   
    private Image fotovuelta;
   private int longitud;

    

    public Producto(String serie, double precio, String marca, String modelo, String descripcion, double preferencia, Image fotovuelta) {
        this.serie = serie;
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.preferencia = preferencia;
        this.fotovuelta = fotovuelta;
    }

    // constructor para los Productos complementarios
    public Producto(String serie, double precio, String marca, String descripcion, double preferencia, Image fotovuelta) {
        this.serie = serie;
        this.precio = precio;
        this.marca = marca;
        this.descripcion = descripcion;
        this.preferencia = preferencia;
        this.fotovuelta = fotovuelta;
    }
     public Producto(){
     }
    

   
   

    public String getDescripcion() {
        return descripcion;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FileInputStream getImageProduc() {
        return imageProduc;
    }

    public void setImageProduc(FileInputStream imageProduc) {
        this.imageProduc = imageProduc;
    }

    

    public double getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(double preferencia) {
        this.preferencia = preferencia;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

   
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Image getFotovuelta() {
        return fotovuelta;
    }

    public void setFotovuelta(Image fotovuelta) {
        this.fotovuelta = fotovuelta;
    }
        
}
