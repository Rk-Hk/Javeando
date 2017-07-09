
package Entidad;

import PaqueteEstructuras.VectorGenerico;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;


public class Usuario extends Persona{
    private String nombre;
    private String apell_paterno;
    private String apell_materno;
    private int edad;
    private int celular;
    private int dni;
    private int longitudFoto;
    private String correo;
    private FileInputStream fotoCarnet;
    private Image fotoVuelta;
    private VectorGenerico<Producto> CarritoCompra; 
    private  double gastoTotal;

    // constructor para cargar datos !!!!
    public Usuario(String nombre, String apell_paterno, String apell_materno, int edad, int celular, int dni, int longitudFoto, String correo, FileInputStream fotoCarnet, String password, String user) {
        super(password, user);
        this.nombre = nombre;
        this.apell_paterno = apell_paterno;
        this.apell_materno = apell_materno;
        this.edad = edad;
        this.celular = celular;
        this.dni = dni;
        this.longitudFoto = longitudFoto;
        this.correo = correo;
        this.fotoCarnet = fotoCarnet;
    }

       //constructor para SELECCIONAR datos de la B.D(Mysql)
    public Usuario(int dni,String nombre, String apell_paterno, String apell_materno, int edad, int celular, String correo, String password, String user,Image fotoVuelta) {
        super(password, user);
        this.nombre = nombre;
        this.apell_paterno = apell_paterno;
        this.apell_materno = apell_materno;
        this.edad = edad;
        this.celular = celular;
        this.dni = dni;
        this.fotoVuelta = fotoVuelta;
        this.correo = correo;
    }
   
    
    public Usuario() {
      
    }

    public Image getFotoVuelta() {
        return fotoVuelta;
    }

    public void setFotoVuelta(Image fotoVuelta) {
        this.fotoVuelta = fotoVuelta;
    }

    
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
   

    public int getLongitudFoto() {
        return longitudFoto;
    }

    public void setLongitudFoto(int longitudFoto) {
        this.longitudFoto = longitudFoto;
    }
     
   public void Persona(){
   this.gastoTotal=0.0;
    
     } 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApell_paterno() {
        return apell_paterno;
    }

    public void setApell_paterno(String apell_paterno) {
        this.apell_paterno = apell_paterno;
    }

    public String getApell_materno() {
        return apell_materno;
    }

    public void setApell_materno(String apell_materno) {
        this.apell_materno = apell_materno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public FileInputStream getFotoCarnet() {
        return fotoCarnet;
    }

    public void setFotoCarnet(FileInputStream fotoCarnet) {
        this.fotoCarnet = fotoCarnet;
    }

       public double getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(double gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public VectorGenerico<Producto> getCarritoCompra() {
        return CarritoCompra;
    }

    public void setCarritoCompra(VectorGenerico<Producto> CarritoCompra) {
        this.CarritoCompra = CarritoCompra;
    }

   
     
    
}
