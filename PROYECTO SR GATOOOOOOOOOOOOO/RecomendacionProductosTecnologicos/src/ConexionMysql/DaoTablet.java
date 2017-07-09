
package ConexionMysql;

import static ConexionMysql.ConexionMsql.CerrarMysql;
import static ConexionMysql.ConexionMsql.ConectarMysql;
import Entidad.Tablet;
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
public class DaoTablet {
    public static Icon error = new ImageIcon("src/Imagenes/error.png");
    public static Icon  modificar = new ImageIcon("src/Imagenes/modificar.png");
    public static Icon  guardar = new ImageIcon("src/Imagenes/descargar.png");
    public static Icon alerta = new ImageIcon("src/Imagenes/alerta.png");
    public static Icon  eliminar = new ImageIcon("src/Imagenes/eliminar.png");
    
    public void DAO_Producto(){
    }
    
    public  void DAO_RegistrarTablet(Tablet usu){
        int columna=0;
        Connection conexion = ConectarMysql();
       
         String sql = "insert into tablet(serie,precio,marca,modelo,descripcion,preferencia,so,tamano,ram,resolucion,foto) values(?,?,?,?,?,?,?,?,?,?,?)";
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
            sq.setString(10,usu.getResolucion());
            //contraseña
             sq.setBlob(11,usu.getImageProduc(), usu.getLongitud());
           
            columna=sq.executeUpdate();
            ConexionMsql.CerrarMysql(conexion);
            sq.close();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No de pudo Guardar los datos en la B.D","Error",JOptionPane.ERROR_MESSAGE,error);
        }
            Icon  guardar2 = new ImageIcon("src/Imagenes/descargar.png");
            JOptionPane.showMessageDialog(null,"Los datos se Guardaron satisfactoriamente \n "
                  + " Numero de Filas Modificadas: "+columna,"Guardar",JOptionPane.WARNING_MESSAGE,guardar2);

    }
    public boolean ModificarConFoto(int orden, Tablet i){
        boolean modificado=false;
        Connection conexion = ConectarMysql();
    
    String sql = "update tablet set serie=?, precio=?,marca=?, modelo=? , descripcion= ?,so=?,tamano=?,ram=?,resolucion=? ,foto=? where orden="+orden;
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
        ps.setString(9,i.getResolucion());
        ps.setBlob(10,i.getImageProduc(),i.getLongitud());
              
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
    
    
    
    
    
    public boolean ModificarSinFoto(int orden, Tablet i){
        boolean modificado=false;
        Connection conexion = ConectarMysql();
    
    String sql = "update tablet set serie=?, precio=?,marca=?, modelo=? , descripcion= ?,so=?,tamano=?,ram=?,resolucion=?  where orden="+orden;
    try{
    PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(2,i.getSerie());
        ps.setDouble(3,i.getPrecio());
       ps.setString(4,i.getMarca());
        ps.setString(5,i.getModelo());
        ps.setString(6,i.getDescripcion());
        ps.setString(8,i.getSO());
        ps.setString(9,i.getTamano());
        ps.setInt(10,i.getRam());
        ps.setString(11,i.getResolucion());
                     
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
       
    
    
      public int ObtenerOrdenTablet(String serie){
        int orden=0;
    Connection conexion = ConectarMysql();
    String sql = "select * from tablet  where serie='"+serie+"'";
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
    }   return orden;
    }
    
    
    
       //buscar los daots del alumno por dni 
       
    public  Tablet BusquedaTablet_Serie(String serie){
        // obteniendo la conexion
        Tablet tablet=null ;
        int ram;
        double precio,preferencia=0;
        String marca,modelo,descripcion,so,tamano,resolucion; 
        Image  fotovuelta=null;
       
        Connection conexion = ConectarMysql();
        String sql="select * from tablet where serie ='"+serie+"'";
        try{
            PreparedStatement sq = conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
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
                resolucion=rql.getString("resolucion");
                                
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE,error);
                }
                   tablet = new Tablet(so, tamano, ram, resolucion, serie, precio, marca, modelo, descripcion, preferencia, fotovuelta);
            }
            ConexionMsql.CerrarMysql(conexion);
            rql.close();
            sq.close();
     
        }catch(Exception e){
          
            JOptionPane.showMessageDialog(null,"La SERIE ingresado no esta registrado \n"
                             + "   en la base de Datos BASE DE DATOS!!!!!","Error",JOptionPane.ERROR_MESSAGE,error);
        }      
        
        return tablet ;
    }
    
     public  Tablet PrecioTablet(int precio){
        // obteniendo la conexion
        Tablet tablet=null ;
        int ram;
        double precioReal=(double)precio;
        double preferencia=0;
        String marca,modelo,descripcion,so,serie,tamano,resolucion; 
        Image  fotovuelta=null;
       
        Connection conexion = ConectarMysql();
        String sql="select * from tablet where precio ="+precioReal;
        try{
            PreparedStatement sq = conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            while (rql.next()){
                serie=rql.getString("serie");
               marca=rql.getString("marca");
                modelo=rql.getString("modelo");
                descripcion = rql.getString("descripcion");
                preferencia =rql.getDouble("preferencia");
                so=rql.getString("so");
                tamano=rql.getString("tamano");
                ram=rql.getInt("ram");
                resolucion=rql.getString("resolucion");
                                
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE,error);
                }
                   tablet = new Tablet(so, tamano, ram, resolucion, serie, precioReal, marca, modelo, descripcion, preferencia, fotovuelta);
            }
            ConexionMsql.CerrarMysql(conexion);
            rql.close();
            sq.close();
     
        }catch(Exception e){
          
            JOptionPane.showMessageDialog(null,"La SERIE ingresado no esta registrado \n"
                             + "   en la base de Datos BASE DE DATOS!!!!!","Error",JOptionPane.ERROR_MESSAGE,error);
        }      
        
        return tablet ;
    }
    
    public  boolean EliminarTablet(String serie) {
        boolean estado=false;

        Connection conexion=ConectarMysql();
        String sql= "delete from tablet where serie='"+serie+"'";
        try{
        PreparedStatement sq = conexion.prepareStatement(sql);
            int i=sq.executeUpdate();
            if(i!=0){
            estado=true;
            JOptionPane.showMessageDialog(null,"Se elimino Correctamente \n"
                     + "    de la B.D!!!","Eliminar",JOptionPane.ERROR_MESSAGE,eliminar);}

            ConexionMsql.CerrarMysql(conexion);
            sq.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No eliminar de la B.D!!","Error",JOptionPane.ERROR_MESSAGE,error);
        }
        return estado;
 }

 
    public  ArrayList<Tablet> ListarTablet(){
        ArrayList<Tablet> lsTablet=null;
        
       
         Tablet tablet=null ;
        int ram;
        double precio,preferencia=0;
        String marca,serie,modelo,descripcion,so,tamano,resolucion; 
        Image  fotovuelta=null;
     // obtenemos la conexxion con la base de datos Mysql
        Connection conexion= ConectarMysql();
        String sql="select * from tablet ";
        try{ 
            lsTablet= new ArrayList<Tablet>();
            
            PreparedStatement sq =  conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
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
                resolucion=rql.getString("resolucion");
                                
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE,error);
                }
                   tablet = new Tablet(so, tamano, ram, resolucion, serie, precio, marca, modelo, descripcion, preferencia, fotovuelta);
                lsTablet.add(tablet);   
                   
            }             
                
             
             ConexionMsql.CerrarMysql(conexion);
             sq.close();
             rql.close();
             
         }catch(Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo cargar la Tabla!!","Error",JOptionPane.ERROR_MESSAGE,error);
         }
         return lsTablet;
      }
    
    
    public  ArrayList<Tablet> ListarmasREcomenTablet(){
        ArrayList<Tablet> lsTablet=null;
        
       
         Tablet tablet=null ;
        int ram;
        double precio,preferencia=0;
        String marca,serie,modelo,descripcion,so,tamano,resolucion; 
        Image  fotovuelta=null;
     // obtenemos la conexxion con la base de datos Mysql
        Connection conexion= ConectarMysql();
        String sql="select * from tablet order by preferencia desc";
        
        
        try{ 
            
            
            PreparedStatement sq =  conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            lsTablet= new ArrayList<Tablet>();
            
            int cont=0;
            while (rql.next()&& cont<5){
                serie=rql.getString("serie");
                precio=rql.getDouble("precio");
                marca=rql.getString("marca");
                modelo=rql.getString("modelo");
                descripcion = rql.getString("descripcion");
                preferencia =rql.getDouble("preferencia");
                so=rql.getString("so");
                tamano=rql.getString("tamano");
                ram=rql.getInt("ram");
                resolucion=rql.getString("resolucion");
                                
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE,error);
                }
                tablet = new Tablet(so, tamano, ram, resolucion, serie, precio, marca, modelo, descripcion, preferencia, fotovuelta);
                cont++;
            }             
                lsTablet.add(tablet);
             
             ConexionMsql.CerrarMysql(conexion);
             sq.close();
             rql.close();
             
         }catch(Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo cargar la Tabla!!","Error",JOptionPane.ERROR_MESSAGE,error);
         }
         return lsTablet;
      }
    
    
    public boolean ModificarPreferencia(double pref,String serie,double dada){
        boolean estado = false;
        double prefer = pref+dada;
        
        Connection conexion = ConectarMysql();
        String sql="Update tablet SET preferencia ='"+prefer+"'WHERE serie ='"+serie+"'";
        try{
            PreparedStatement pst=conexion.prepareStatement(sql);
            int i=pst.executeUpdate();
            if(i!=0){
                System.out.println("Modificado con exito");
                estado=true;
            }
            ConexionMsql.CerrarMysql(conexion);
            pst.close();
            
            
        }catch(SQLException e){
            System.out.println("ModificarPreferencia = "+e);
        }
        
        return estado;
    }
   
}
