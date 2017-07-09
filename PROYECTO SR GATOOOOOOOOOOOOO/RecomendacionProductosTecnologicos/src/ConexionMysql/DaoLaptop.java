/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ConexionMysql;

import static ConexionMysql.ConexionMsql.CerrarMysql;
import static ConexionMysql.ConexionMsql.ConectarMysql;
import Entidad.Laptop;
import UtilJava.ClaseCargarImagen;

import static UtilJava.ClaseCargarImagen.ConvertirImagenByte;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeremy
 */
public class DaoLaptop {
//    (so, tamano, ram, serie, precio, marca, modelo, descripcion, preferencia, fotovuelta)
    

    public DaoLaptop() {
    }
    

    
    public  void DAO_RegistrarLaptop(Laptop usu){
        int columna=0;
        Connection conexion = ConectarMysql();
       
         String sql = "insert into laptop(serie,precio,marca,modelo,descripcion,preferencia,so,tamano,ram,foto) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement sq= conexion.prepareStatement(sql);
            //dni
            sq.setString(1,usu.getSerie());
            //nombre
            sq.setDouble(2,usu.getPrecio());
            //ap_paterno
            sq.setString(3,usu.getMarca());
            //ap_materno
            sq.setString(4,usu.getModelo());
            //celular
            sq.setString(5,usu.getDescripcion());
            //edad
            sq.setDouble(6,usu.getPreferencia());
            sq.setString(7,usu.getSO());
            sq.setString(8,usu.getTamano());
              //correo
            sq.setInt(9,usu.getRam());
            //usuario
            sq.setBlob(10,usu.getImageProduc(), usu.getLongitud());
            columna=sq.executeUpdate();
            ConexionMsql.CerrarMysql(conexion);
            sq.close();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No de pudo Guardar los datos en la B.D","Error",JOptionPane.ERROR_MESSAGE);
        }
            Icon  guardar2 = new ImageIcon("src/Imagenes/descargar.png");
            JOptionPane.showMessageDialog(null,"Los datos se Guardaron satisfactoriamente \n "
                  + " Numero de Filas Modificadas: "+columna,"Guardar",JOptionPane.WARNING_MESSAGE,guardar2);

    }
       //buscar los daots del alumno por dni 
    
    
    
    public  Laptop BusquedaLaptop_Serie(String serie){
        // obteniendo la conexion
        Laptop  laptop=null ;
        int ram;
        double precio,preferencia=0;
        String marca,modelo,descripcion,so,tamano,serie2; 
        Image  fotovuelta=null;
       
        Connection conexion = ConectarMysql();
        String sql="select * from laptop where serie = '"+serie+"'";
        try{
            PreparedStatement sq = conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            
            while (rql.next()){
                serie2=rql.getString("serie");
                precio=rql.getDouble("precio");
                marca=rql.getString("marca");
                modelo=rql.getString("modelo");
                descripcion = rql.getString("descripcion");
                preferencia =rql.getDouble("preferencia");
                so=rql.getString("so");
                tamano=rql.getString("tamano");
                ram=rql.getInt("ram");
                                                
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
//                    fotoCarnet= (FileInputStream) rql.getBlob("foto");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE);
                }
                laptop = new Laptop(so, tamano, ram, serie2, precio, marca, modelo, descripcion, preferencia, fotovuelta);
                
            }
            ConexionMsql.CerrarMysql(conexion);
            rql.close();
            sq.close();
     
        }catch(Exception e){
          
            JOptionPane.showMessageDialog(null,"El DNI ingresado no esta registrado \n"
                             + "   en la base de Datos BASE DE DATOS!!!!!","Error",JOptionPane.ERROR_MESSAGE);
        }      
        
        
        return laptop ;
    }
    
        
    public  Laptop PrecioLaptop(int precio){
        // obteniendo la conexion
        Laptop  laptop=null ;
        int ram;
        double precioReal=(double)precio;
         double preferencia=0;
        String marca,modelo,descripcion,so,tamano,serie2; 
        Image  fotovuelta=null;
       
        Connection conexion = ConectarMysql();
        String sql="select * from laptop where precio = "+precioReal;
        try{
            PreparedStatement sq = conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            
            while (rql.next()){
                serie2=rql.getString("serie");
               marca=rql.getString("marca");
                modelo=rql.getString("modelo");
                descripcion = rql.getString("descripcion");
                preferencia =rql.getDouble("preferencia");
                so=rql.getString("so");
                tamano=rql.getString("tamano");
                ram=rql.getInt("ram");
                                                
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
//                    fotoCarnet= (FileInputStream) rql.getBlob("foto");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE);
                }
                laptop = new Laptop(so, tamano, ram, serie2, precioReal, marca, modelo, descripcion, preferencia, fotovuelta);
                
            }
            ConexionMsql.CerrarMysql(conexion);
            rql.close();
            sq.close();
     
        }catch(Exception e){
          
            JOptionPane.showMessageDialog(null,"El DNI ingresado no esta registrado \n"
                             + "   en la base de Datos BASE DE DATOS!!!!!","Error",JOptionPane.ERROR_MESSAGE);
        }      
       
        return laptop ;
    }
    
    public  boolean EliminarLaptop(String serie) {
        boolean estado=false;

        Connection conexion=ConectarMysql();
        String sql= "delete from laptop where serie like '%"+serie+"%'";
        try{
        PreparedStatement sq = conexion.prepareStatement(sql);
            
           int i=sq.executeUpdate();
            if(i!=0){ 
            estado=true;
            JOptionPane.showMessageDialog(null,"Se elimino Correctamente \n"
                     + "    de la B.D!!!","Eliminar",JOptionPane.ERROR_MESSAGE);}

            ConexionMsql.CerrarMysql(conexion);
            sq.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No eliminar de la B.D!!","Error",JOptionPane.ERROR_MESSAGE);
        }
        return estado;
 }
  
    
    public boolean ModificarPreferencia(double pref,String serie,double dada){
        boolean estado = false;
        double prefer = pref+dada;
        
        Connection conexion = ConectarMysql();
        String sql="Update laptop SET preferencia ='"+prefer+"'WHERE serie ='"+serie+"'";
        try{
            try (PreparedStatement pst = conexion.prepareStatement(sql)) {
                int i=pst.executeUpdate();
                if(i!=0){
                    System.out.println("Modificado con exito");
                    estado=true;
                }
                ConexionMsql.CerrarMysql(conexion);
            }
            
            
        }catch(SQLException e){
            System.out.println("ModificarPreferencia = "+e);
        }
        
        return estado;
    }
 /*public void setDineroTotalVivanda(double newCantidad){
        try{
           String sq="UPDATE cuentas SET cantidad = " + newCantidad + "WHERE empresa = 'vivanda'";
           PreparedStatement sql= conexion.prepareStatement(sq);
           int n =sql.executeUpdate();
           conexion.close();
           sql.close();
           // stmt = conexion.createStatement(); 
            //int n = stmt.executeUpdate("UPDATE cuentas SET cantidad = " + newCantidad + "WHERE empresa = 'vivanda'");
            //stmt.close();
        }catch(Exception e){
        
    }
    }*/
/*  public PanelProductos [] ListarLaptopRecomendados(){
     ArrayList<Laptop> lsLista =  Dao.getDaoLaptop().ListarLaptop();
      PanelProductos a[] = new PanelProductos[100];
      
      Laptop laptop = null;
        for(int i=0;i<lsLista.size();i++){
           laptop  = lsLista.get(i);
              
          a[i]= new PanelProductos(laptop.getModelo(),laptop.getFotovuelta(),laptop.getDescripcion());
                 
     }
        return a;
       }*/
   
    public  ArrayList<Laptop> ListarLaptop(){
        ArrayList<Laptop> lsLaptopt=null;
         Laptop laptop=null ;
        int ram;
        double precio,preferencia=0;
        String marca,serie,modelo,descripcion,so,tamano,resolucion; 
        Image  fotovuelta=null;
     // obtenemos la conexxion con la base de datos Mysql
        Connection conexion= ConectarMysql();
        String sql="select * from laptop";
        
        try{ 
            PreparedStatement sq =  conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
             lsLaptopt= new ArrayList<Laptop>();
            while (rql.next()){
                serie=rql.getString("serie");
                precio=rql.getDouble("precio");
                marca=rql.getString("marca");
                modelo=rql.getString("modelo");
                descripcion = rql.getString("descripcion");
                preferencia =rql.getDouble("preferencia");
                so=rql.getString("so");
                tamano=rql.getString("tamano");
                ram=rql.getInt("ram");            
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE);
                }
                  laptop = new Laptop(so, tamano, ram, serie, precio, marca, modelo, descripcion, preferencia, fotovuelta);
                 lsLaptopt.add(laptop);
            }
             ConexionMsql.CerrarMysql(conexion);
             sq.close();
             rql.close();
         }catch(Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo cargar la Tabla!!","Error",JOptionPane.ERROR_MESSAGE);
         }
         return lsLaptopt;
      }
    
    public  ArrayList<Laptop> ListarmasRecomLaptop(){
        ArrayList<Laptop> lsLaptopt=null;
              
       
         Laptop laptop=null ;
        int ram;
        double precio,preferencia=0;
        String marca,serie,modelo,descripcion,so,tamano; 
        Image  fotovuelta=null;
     // obtenemos la conexxion con la base de datos Mysql
        Connection conexion= ConectarMysql();
        String sql="select * from laptop order by preferencia desc ";
        
        try{ 
           
            
            PreparedStatement sq =  conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
             lsLaptopt= new ArrayList<Laptop>();
             
            int cont=0;
            while (rql.next()){
                serie=rql.getString("serie");
                precio=rql.getDouble("precio");
                marca=rql.getString("marca");
                modelo=rql.getString("modelo");
                descripcion = rql.getString("descripcion");
                preferencia =rql.getDouble("preferencia");
                so=rql.getString("so");
                tamano=rql.getString("tamano");
                ram=rql.getInt("ram");
                                    
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE);
                }
                laptop = new Laptop(so, tamano, ram, serie, precio, marca, modelo, descripcion, preferencia, fotovuelta);
                lsLaptopt.add(laptop);
                cont++;
            }
                
             
             ConexionMsql.CerrarMysql(conexion);
             sq.close();
             rql.close();
             
         }catch(Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo cargar la Tabla!!","Error",JOptionPane.ERROR_MESSAGE);
         }
         return lsLaptopt;
      }
         public int ObtenerOrdenLaptop(String serie){
        int orden=0;
    Connection conexion = ConectarMysql();
    String sql = "select * from laptop  where serie='"+serie+"'";
    try{
      PreparedStatement sq = conexion.prepareStatement(sql);
      ResultSet s = sq.executeQuery();
       while(s.next()){
       orden = s.getInt("orden");
       }
          s.close();
          sq.close();
         ConexionMsql.CerrarMysql(conexion);
    
    }catch(Exception e ){
        JOptionPane.showMessageDialog(null,"Conexion Falla!!");
    }
    return orden;
    }
     
     public boolean ModificarLaptopConFoto(int orden, Laptop i){
        boolean modificado=false;
        Connection conexion = ConectarMysql();
    
    String sql = "update laptop set serie=?, precio=?,marca=?, modelo=? , descripcion= ? ,so=?, tamano=?, ram=?  foto=? where orden="+orden;
    try{
    PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,i.getSerie());
        ps.setDouble(2,i.getPrecio());
        ps.setString(3,i.getMarca());
        ps.setString(4,i.getModelo());
        ps.setString(5,i.getDescripcion());
        ps.setString(6,i.getSO());
        ps.setString(7,i.getTamano());
        ps.setInt(8,i.getRam());
        ps.setBlob(9,i.getImageProduc());
              
        int  ColumasModificadas = ps.executeUpdate();
        CerrarMysql(conexion);
         ps.close();
                  
        if (ColumasModificadas > 0) {
            modificado = true;
        } 
         
        } catch(Exception e){
                       JOptionPane.showMessageDialog(null,"No se pudo MOdifcar en la B.D");
        } 
     
    return modificado;
    }
     
      public boolean ModificarLaptopSinFoto(int orden, Laptop i){
        boolean modificado=false;
        Connection conexion = ConectarMysql();
    
    String sql = "update laptop set serie=?, precio=?,marca=?, modelo=? , descripcion= ? ,so=?, tamano=?, ram=?  where orden="+orden;
    try{
    PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,i.getSerie());
        ps.setDouble(2,i.getPrecio());
        ps.setString(3,i.getMarca());
        ps.setString(4,i.getModelo());
        ps.setString(5,i.getDescripcion());
        ps.setString(6,i.getSO());
        ps.setString(7,i.getTamano());
        ps.setInt(8,i.getRam());
              
        int  ColumasModificadas = ps.executeUpdate();
        CerrarMysql(conexion);
         ps.close();
                  
        if (ColumasModificadas > 0) {
            modificado = true;
        } 
         
        } catch(Exception e){
                       JOptionPane.showMessageDialog(null,"No se pudo MOdifcar en la B.D");
        } 
     
    return modificado;
    }
      
      
     
}
