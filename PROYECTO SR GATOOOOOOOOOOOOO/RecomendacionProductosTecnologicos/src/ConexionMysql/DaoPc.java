

package ConexionMysql;

import static ConexionMysql.ConexionMsql.CerrarMysql;
import static ConexionMysql.ConexionMsql.ConectarMysql;
import Entidad.Pc;
import Entidad.Usuario;
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
 * @author nelsoncuenta
 */
public class DaoPc {
    
    public void DAO_Producto(){
    }
    
    public  void DAO_RegistrarPc(Pc usu){
        int columna=0;
        Connection conexion = ConectarMysql();
        String sql = "insert into pc(serie,precio,marca,modelo,descripcion,so,ram,discoduro,foto,preferencias) values(?,?,?,?,?,?,?,?,?,?)";

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
            sq.setString(6,usu.getSO());
            //correo
            sq.setInt(7,usu.getRam());
            //usuario
            sq.setInt(8,usu.getDiscoDuro());
            //contraseña
            
            sq.setBlob(9,usu.getImageProduc(), usu.getLongitud());
            
            sq.setDouble(10,usu.getPreferencia());
            
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
       
    public  Pc BusquedaPc_Serie(String serie){
        // obteniendo la conexion
        Pc usu=null;
        int ram,discoduro;
        double precio,preferencia=0;
        String marca,modelo,descripcion,so;
        Image  fotovuelta=null;
       
        Connection conexion = ConectarMysql();
        String sql="select * from pc where serie like '%"+serie+"%'";
        try{
            PreparedStatement sq = conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            
            while (rql.next()){
                serie=rql.getString("serie");
                precio=rql.getDouble("precio");
                marca=rql.getString("marca");
                modelo=rql.getString("modelo");
                descripcion = rql.getString("descripcion");
                so =rql.getString("so");
                ram=rql.getInt("ram");
                discoduro=rql.getInt("discoduro");
                preferencia=rql.getDouble("preferencias");
                
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE);
                }
                
                usu = new Pc(so, ram, discoduro, serie, precio, marca, modelo, descripcion, preferencia, fotovuelta);
                 
            }
            
            ConexionMsql.CerrarMysql(conexion);
            rql.close();
            sq.close();
     
        }catch(Exception e){
          
            JOptionPane.showMessageDialog(null,"La serie ingresado no esta registrado \n"
                             + "   en la base de Datos BASE DE DATOS!!!!!","Error",JOptionPane.ERROR_MESSAGE);
        }      
        
        return usu;
    }
    
     public  Pc PrecioPc(int precio){
        // obteniendo la conexion
        Pc usu=null;
        int ram,discoduro;
        double precioReal=(double)precio;
        double preferencia=0;
        String marca,modelo,descripcion,so,serie;
        Image  fotovuelta=null;
       
        Connection conexion = ConectarMysql();
        String sql="select * from pc where precio="+precioReal;
        try{
            PreparedStatement sq = conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            
            while (rql.next()){
                serie=rql.getString("serie");
               marca=rql.getString("marca");
                modelo=rql.getString("modelo");
                descripcion = rql.getString("descripcion");
                so =rql.getString("so");
                ram=rql.getInt("ram");
                discoduro=rql.getInt("discoduro");
                preferencia=rql.getDouble("preferencias");
                
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE);
                }
                
                usu = new Pc(so, ram, discoduro, serie, precioReal, marca, modelo, descripcion, preferencia, fotovuelta);
                 
            }
            
            ConexionMsql.CerrarMysql(conexion);
            rql.close();
            sq.close();
     
        }catch(Exception e){
          
            JOptionPane.showMessageDialog(null,"La serie ingresado no esta registrado \n"
                             + "   en la base de Datos BASE DE DATOS!!!!!","Error",JOptionPane.ERROR_MESSAGE);
        }      
        
        return usu;
    }
    public  boolean EliminarPc(String serie) {
        boolean estado=false;
       

        Connection conexion=ConectarMysql();
        String sql= "delete from pc where serie like '%"+serie+"%'";
        try{
            PreparedStatement sq = conexion.prepareStatement(sql);
            int i=sq.executeUpdate();
            
            if(i!=0){
                estado=true;
                JOptionPane.showMessageDialog(null,"Se elimino Correctamente \n"
                         + "    de la B.D!!!","Eliminar",JOptionPane.ERROR_MESSAGE);
            }

            ConexionMsql.CerrarMysql(conexion);
            sq.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No eliminar de la B.D!!","Error",JOptionPane.ERROR_MESSAGE);
        }
        return estado;
    }

    public  ArrayList<Pc> ListarPc(){
        ArrayList<Pc> lsPc=null;
        
        int ram,discoduro;
        double precio,preferencia=0;
        String marca,modelo,descripcion,so,serie;
        Image  fotovuelta=null;
        
     // obtenemos la conexxion con la base de datos Mysql
        Connection conexion= ConectarMysql();
        String sql="select * from pc ";
        try{ 
            lsPc= new ArrayList<Pc>();
            
            PreparedStatement sq =  conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            while (rql.next()){
                serie=rql.getString("serie");
                precio=rql.getDouble("precio");
                marca=rql.getString("marca");
                modelo=rql.getString("modelo");
                descripcion = rql.getString("descripcion");
                so =rql.getString("so");
                ram=rql.getInt("ram");
                discoduro=rql.getInt("discoduro");
                preferencia=rql.getDouble("preferencias");
                
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                   //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Algunos Usuarios no Poseen Foto!!!","Alerta",JOptionPane.WARNING_MESSAGE);
                }
                Pc pc = new Pc(so, ram, discoduro, serie, precio, marca, modelo, descripcion, preferencia, fotovuelta);
                lsPc.add(pc);
             }
             ConexionMsql.CerrarMysql(conexion);
             sq.close();
             rql.close();
             
         }catch(Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo cargar la Tabla!!","Error",JOptionPane.ERROR_MESSAGE);
         }
         return lsPc;
      }
          
    public boolean ModificarPreferencia(double pref,String serie,double dada){
        boolean estado = false;
        double prefer = pref+dada;
        
        Connection conexion = ConectarMysql();
        String sql="Update pc SET preferencias ='"+prefer+"'WHERE serie ='"+serie+"'";
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
    
      public int ObtenerOrdenPc(String serie){
        int orden=0;
    Connection conexion = ConectarMysql();
    String sql = "select * from pc  where serie='"+serie+"'";
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
     
     public boolean ModificarPcConFoto(int orden, Pc i){
        boolean modificado=false;
        Connection conexion = ConectarMysql();
    
    String sql = "update pc set serie=?, precio=?,marca=?, modelo=? , descripcion= ? ,so=?, ram=?, discoduro=?,  foto=? where orden="+orden;
    try{
    PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,i.getSerie());
        ps.setDouble(2,i.getPrecio());
        ps.setString(3,i.getMarca());
        ps.setString(4,i.getModelo());
        ps.setString(5,i.getDescripcion());
        ps.setString(6,i.getSO());
        ps.setInt(7,i.getRam());
        ps.setInt(8, i.getDiscoDuro());
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
     
      public boolean ModificarPcSinFoto(int orden, Pc i){
        boolean modificado=false;
        Connection conexion = ConectarMysql();
    
    String sql = "update pc set serie=?, precio=?,marca=?, modelo=? , descripcion= ? ,so=?, ram=?, discoduro=?  where orden="+orden;
    try{
    PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,i.getSerie());
        ps.setDouble(2,i.getPrecio());
        ps.setString(3,i.getMarca());
        ps.setString(4,i.getModelo());
        ps.setString(5,i.getDescripcion());
        ps.setString(6,i.getSO());
        ps.setInt(7,i.getRam());
        ps.setInt(8, i.getDiscoDuro());
              
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
