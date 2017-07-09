
package Entidad;

import PaqueteEstructuras.PilaListaGenerica;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Compra {
   private Usuario usuario;
   private PilaListaGenerica<Producto> productoCargado;
  // tributos para las graficas
   private double total;
   private  String nombreProducto;
  
   ////
   private int dni;
   private String nombre;
   private String  apepater;
   private String  apemater;
   private String nombreproduc;
   private String  marcaproduc;
   private String modeloproduc;
   private String descriproduc;
   private double precio;
   private String fecha;
   private  String  Hora;

    public Compra(int dni, String nombre, String apepater, String apemater, String nombreproduc, String marcaproduc, String modeloproduc, String descriproduc, double precio, String fecha, String Hora) {
        this.dni = dni;
        this.nombre = nombre;
        this.apepater = apepater;
        this.apemater = apemater;
        this.nombreproduc = nombreproduc;
        this.marcaproduc = marcaproduc;
        this.modeloproduc = modeloproduc;
        this.descriproduc = descriproduc;
        this.precio = precio;
        this.fecha = fecha;
        this.Hora = Hora;
    }

   
   
   public Compra (){
    productoCargado = new PilaListaGenerica<>();
   }

   
    public Compra(Usuario usuario, PilaListaGenerica<Producto> productoCargado, String fecha, String Hora) {
        this.usuario = usuario;
        this.productoCargado = productoCargado;
        this.fecha = fecha;
        this.Hora = Hora;
    }

    public Compra(double total, String nombreProducto) {
        this.total = total;
        this.nombreProducto = nombreProducto;
    }

    
    
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    
    //  para sacar el array  de manera completa

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApepater() {
        return apepater;
    }

    public void setApepater(String apepater) {
        this.apepater = apepater;
    }

    public String getApemater() {
        return apemater;
    }

    public void setApemater(String apemater) {
        this.apemater = apemater;
    }

    public String getNombreproduc() {
        return nombreproduc;
    }

    public void setNombreproduc(String nombreproduc) {
        this.nombreproduc = nombreproduc;
    }

    public String getMarcaproduc() {
        return marcaproduc;
    }

    public void setMarcaproduc(String marcaproduc) {
        this.marcaproduc = marcaproduc;
    }

    public String getModeloproduc() {
        return modeloproduc;
    }

    public void setModeloproduc(String modeloproduc) {
        this.modeloproduc = modeloproduc;
    }

    public String getDescriproduc() {
        return descriproduc;
    }

    public void setDescriproduc(String descriproduc) {
        this.descriproduc = descriproduc;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
       public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }
   

   
      public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PilaListaGenerica<Producto> getProductoCargado() {
        return productoCargado;
    }

    public void setProductoCargado(PilaListaGenerica<Producto> productoCargado) {
        this.productoCargado = productoCargado;
    }

   
   
    
}
