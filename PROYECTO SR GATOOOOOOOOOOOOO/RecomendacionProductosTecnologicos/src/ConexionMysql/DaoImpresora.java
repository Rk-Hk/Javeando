/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ConexionMysql;

import static ConexionMysql.ConexionMsql.CerrarMysql;
import static ConexionMysql.ConexionMsql.ConectarMysql;
import Entidad.Impresora;
import Entidad.Pc;
import static UtilJava.ClaseCargarImagen.ConvertirImagenByte;
import static UtilJava.ClaseCargarImagen.clicFoto;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class DaoImpresora {
    public static Icon error = new ImageIcon("src/Imagenes/error.png");
    public static Icon  modificar = new ImageIcon("src/Imagenes/modificar.png");
    public static Icon  guardar = new ImageIcon("src/Imagenes/descargar.png");
    public static Icon alerta = new ImageIcon("src/Imagenes/alerta.png");
    public static Icon  eliminar = new ImageIcon("src/Imagenes/eliminar.png");
    
    
    
    
    
    public void DAO_Impresora(){
    
    }
    
    
    public  void DAO_RegistrarImpresora(Impresora usu){
        int columna=0;
        Connection conexion = ConectarMysql();
        
        //atributos de la tablaImpresora
        String sql = "insert into impresora( serie,tipo, precio, marca, modelo, descripcion, foto, preferencia) values(?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement sq= conexion.prepareStatement(sql);
            //dni
           
            //nombre
            sq.setString(1,usu.getSerie());
            //ap_paterno 
            sq.setString(2,usu.getTipo());
            sq.setDouble(3,usu.getPrecio());
            //ap_materno
            sq.setString(4,usu.getMarca());
            //celular
            sq.setString(5,usu.getModelo());
            //edad
            sq.setString(6,usu.getDescripcion());
            //correo
            sq.setBlob(7,usu.getImageProduc(), usu.getLongitud());
            sq.setDouble(8,usu.getPreferencia());
            //usuario
            
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
    
    
    
    
    
       //buscar los daots del alumno por dni 
       
    public  Impresora BusquedaImpresora_Serie(String serie){
        // obteniendo la conexion
        Impresora usu=null;
        double preferencia=0;
        Double precio;
        String marca,modelo,descripcion,tipo;
        Image  fotovuelta=null;
       
        Connection conexion = ConectarMysql();
        String sql="select * from impresora where serie = '"+serie+"'";
        try{
            PreparedStatement sq = conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            
            while (rql.next()){
                serie=rql.getString("serie");
                precio=rql.getDouble("precio");
                tipo=rql.getString("tipo");
                marca=rql.getString("marca");
                modelo = rql.getString("modelo");
                descripcion=rql.getString("descripcion");
                preferencia=rql.getDouble("preferencia");
                
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE,error);
                }
                
                usu = new Impresora(tipo, serie, precio, marca, modelo, descripcion, preferencia, fotovuelta);
                 
            }
            
            ConexionMsql.CerrarMysql(conexion);
            rql.close();
            sq.close();
     
        }catch(Exception e){
          
            JOptionPane.showMessageDialog(null,"Error laptop \n"
                             + "   en la base de Datos BASE DE DATOS!!!!!","Error",JOptionPane.ERROR_MESSAGE,error);
        }      
        
        return usu;
    }
    
     public  Impresora PrecioImpresora(int precio){
        // obteniendo la conexion
        Impresora usu=null;
        double PrecioReal = (double)precio;
        double preferencia=0;
       String marca,modelo,descripcion,tipo ,serie;
        Image  fotovuelta=null;
       
        Connection conexion = ConectarMysql();
        String sql="select * from impresora where precio = "+PrecioReal;
        try{
            PreparedStatement sq = conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            
            while (rql.next()){
                serie=rql.getString("serie");
                tipo=rql.getString("tipo");
                marca=rql.getString("marca");
                modelo = rql.getString("modelo");
                descripcion=rql.getString("descripcion");
                preferencia=rql.getDouble("preferencia");
                
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE,error);
                }
                
                usu = new Impresora(tipo, serie, PrecioReal, marca, modelo, descripcion, preferencia, fotovuelta);
                 
            }
            
            ConexionMsql.CerrarMysql(conexion);
            rql.close();
            sq.close();
     
        }catch(Exception e){
          
            JOptionPane.showMessageDialog(null,"Error laptop \n"
                             + "   en la base de Datos BASE DE DATOS!!!!!","Error",JOptionPane.ERROR_MESSAGE,error);
        }      
        
        return usu;
    }
    
    
    
    public boolean ModificarImpresoraConFoto(int orden, Impresora i){
        boolean modificado=false;
        Connection conexion = ConectarMysql();
    
    String sql = "update impresora set serie=?, tipo=?, precio=?,marca=?, modelo=? , descripcion= ? ,  foto=? where orden="+orden;
    try{
    PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,i.getSerie());
        ps.setString(2,i.getTipo());
        ps.setDouble(3,i.getPrecio());
        ps.setString(4,i.getMarca());
        ps.setString(5,i.getModelo());
        ps.setString(6,i.getDescripcion());
        ps.setBlob(7,i.getImageProduc());
              
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
    
    
    
    
    
    public boolean ModificarImpresoraSinFoto(int orden, Impresora i){
        boolean modificado=false;
        Connection conexion = ConectarMysql();
    
    String sql = "update impresora set serie=?, tipo=?, precio=?,marca=?, modelo=? , descripcion= ? where orden="+orden;
    try{
    PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,i.getSerie());
        ps.setString(2,i.getTipo());
        ps.setDouble(3,i.getPrecio());
        ps.setString(4,i.getMarca());
        ps.setString(5,i.getModelo());
        ps.setString(6,i.getDescripcion());
                     
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
    
    
    public int ObtenerOrdenImpresora(String serie){
        int orden=0;
    Connection conexion = ConectarMysql();
    String sql = "select * from impresora  where serie='"+serie+"'";
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
    
    
    
    
    public  boolean EliminarImpresora(String serie) {
        boolean estado=false;

        Connection conexion=ConectarMysql();
        String sql= "delete from Impresora where serie= '"+serie+"'";
        try{
            PreparedStatement sq = conexion.prepareStatement(sql);
            int i=sq.executeUpdate();
            
            if(i!=0){
                estado=true;
                JOptionPane.showMessageDialog(null,"Se elimino Correctamente \n"
                         + "    de la B.D!!!","Eliminar",JOptionPane.ERROR_MESSAGE,eliminar);
            }

            ConexionMsql.CerrarMysql(conexion);
            sq.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No eliminar de la B.D!!","Error",JOptionPane.ERROR_MESSAGE,error);
        }
        return estado;
    }

    
    
    
    public  ArrayList<Impresora> ListarImpresoras(){
        ArrayList<Impresora> lsImpresora=null;
        
        double preferencia=0;
        Double precio;
        String marca,modelo,descripcion,tipo,serie;
        Image  fotovuelta=null;
        
     // obtenemos la conexxion con la base de datos Mysql
        Connection conexion= ConectarMysql();
        String sql="select * from impresora ";
        try{ 
            lsImpresora= new ArrayList<Impresora>();
            
            PreparedStatement sq =  conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            while (rql.next()){
                serie=rql.getString("serie");
                precio=rql.getDouble("precio");
                tipo=rql.getString("tipo");
                marca=rql.getString("marca");
                modelo = rql.getString("modelo");
                descripcion=rql.getString("descripcion");
                preferencia=rql.getDouble("preferencia");
                
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                   //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Algunos Usuarios no Poseen Foto!!!","Alerta",JOptionPane.WARNING_MESSAGE,alerta);
                }
                Impresora imp =new Impresora(tipo, serie, precio, marca, modelo, descripcion, preferencia, fotovuelta);
                lsImpresora.add(imp);
             }
             ConexionMsql.CerrarMysql(conexion);
             sq.close();
             rql.close();
             
         }catch(Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo cargar la Tabla!!","Error",JOptionPane.ERROR_MESSAGE,error);
         }
         return lsImpresora;
      }
          
    public boolean ModificarPreferencia(double pref,String serie,double dada){
        boolean estado = false;
        double prefer = pref+dada;
        
        Connection conexion = ConectarMysql();
        String sql="Update impresora SET preferencia ='"+prefer+"'WHERE serie ='"+serie+"'";
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
