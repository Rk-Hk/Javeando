
package ConexionMysql;

import static ConexionMysql.ConexionMsql.CerrarMysql;
import static ConexionMysql.ConexionMsql.ConectarMysql;
import Entidad.Complementos;
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
public class DaoComplementos {
    
    public  void DAO_RegistrarComplementos(Complementos usu){
        int columna=0;
        Connection conexion = ConectarMysql();
       
         String sql = "insert into complementos (serie,nombre,precio,marca,descripcion,preferencia,foto) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement sq= conexion.prepareStatement(sql);
            //dni
            sq.setString(1,usu.getSerie());
            //nombre
            sq.setString(2,usu.getNombre());
            //ap_paterno
            sq.setDouble(3,usu.getPrecio());
            //ap_materno
            sq.setString(4,usu.getMarca());
            //celular
            sq.setString(5,usu.getDescripcion());
            //edad
            sq.setDouble(6,usu.getPreferencia());
           
            sq.setBlob(7,usu.getImageProduc(), usu.getLongitud());
               columna=sq.executeUpdate();
            ConexionMsql.CerrarMysql(conexion);
            sq.close();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e+"No de pudo Guardar los datos en la B.D","Error",JOptionPane.ERROR_MESSAGE);
        }
            Icon  guardar2 = new ImageIcon("src/Imagenes/descargar.png");
            JOptionPane.showMessageDialog(null,"Los datos se Guardaron satisfactoriamente \n "
                  + " Numero de Filas Modificadas: "+columna,"Guardar",JOptionPane.WARNING_MESSAGE,guardar2);

    }
       //buscar los daots del alumno por dni 
       
    public  Complementos BusquedaComplementos(String Series){
        
        Complementos  complementos=null ;
        double preferencia=0;
        Double precio;
        String marca,descripcion,serie,nombre; 
        Image  fotovuelta=null;
       
        Connection conexion = ConectarMysql();
        String sql="select * from complementos where serie like '%"+Series+"%'";
        try{
            PreparedStatement sq = conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            while (rql.next()){
                serie=Series;
                nombre =rql.getString("nombre");
                precio=rql.getDouble("precio");
                marca=rql.getString("marca");
                descripcion = rql.getString("descripcion");
                preferencia =rql.getDouble("preferencia");        
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE);
                }
               complementos = new Complementos(nombre, serie, precio, marca, descripcion, preferencia, fotovuelta);
            }
            ConexionMsql.CerrarMysql(conexion);
            rql.close();
            sq.close();
     
        }catch(Exception e){
          
            JOptionPane.showMessageDialog(null,"Nose pudo Acceder a la \n"
                             + "   en la base de Datos BASE DE DATOS!!!!!","Error",JOptionPane.ERROR_MESSAGE);
        }      
        
        return complementos ;
    }
    
    public  Complementos PrecioComplementos(int precio){
        
      Complementos  complementos=null ;
        double preferencia=0;
        Double precioReal=(double)precio;
        String marca,descripcion,serie,nombre; 
        Image  fotovuelta=null;
       
        Connection conexion = ConectarMysql();
        String sql="select * from complementos where precio="+precioReal;
        try{
            PreparedStatement sq = conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            while (rql.next()){
                serie=rql.getString("serie");
                nombre =rql.getString("nombre");
                marca=rql.getString("marca");
                descripcion = rql.getString("descripcion");
                preferencia =rql.getDouble("preferencia");        
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE);
                }
               complementos = new Complementos(nombre, serie, precioReal, marca, descripcion, preferencia, fotovuelta);
            }
            ConexionMsql.CerrarMysql(conexion);
            rql.close();
            sq.close();
     
        }catch(Exception e){
          
            JOptionPane.showMessageDialog(null,"Nose pudo Acceder a la \n"
                             + "   en la base de Datos BASE DE DATOS!!!!!","Error",JOptionPane.ERROR_MESSAGE);
        }      
        
        return complementos ;
    }
    
    public  boolean EliminarComplementos(String serie) {
        boolean estado=false;

        Connection conexion=ConectarMysql();
        String sql= "delete from complementos where like '%"+serie+"%'";
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
 
 
    public  ArrayList<Complementos> ListarComplementos(){
        ArrayList<Complementos> lsComplementos=null;
        
       
         Complementos complementos=null ;
        double preferencia=0;
        Double precio;
        String marca,serie,modelo,descripcion,nombre; 
        Image  fotovuelta=null;
     // obtenemos la conexxion con la base de datos Mysql
        Connection conexion= ConectarMysql();
        String sql="select * from complementos ";
        try{ 
            lsComplementos= new ArrayList<Complementos>();
            
            PreparedStatement sq =  conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            while (rql.next()){
                serie=rql.getString("serie");
                nombre =rql.getString("nombre");
                precio=rql.getDouble("precio");
                marca=rql.getString("marca");
                descripcion = rql.getString("descripcion");
                preferencia =rql.getDouble("preferencia");
                                                                      
                try{
                    byte b[]=rql.getBytes("foto");
                    fotovuelta=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE);
                }
               complementos = new Complementos(nombre, serie, precio, marca, descripcion, preferencia, fotovuelta);
               lsComplementos.add(complementos);
            }             
                
             
             ConexionMsql.CerrarMysql(conexion);
             sq.close();
             rql.close();
             
         }catch(Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo cargar la Tabla!!","Error",JOptionPane.ERROR_MESSAGE);
         }
         return lsComplementos;
      }
    
    public boolean ModificarPreferencia(double pref,String serie,double dada){
        boolean estado = false;
        double prefer = pref+dada;
        
        Connection conexion = ConectarMysql();
        String sql="Update complementos SET preferencia ='"+prefer+"'WHERE serie ='"+serie+"'";
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
        public boolean ModificarComplementoConFoto(int orden, Complementos i){
        boolean modificado=false;
        Connection conexion = ConectarMysql();
    
    String sql = "update complementos set serie=?,nombre=?, precio=?,marca=?, modelo=? , descripcion= ? ,  foto=? where orden="+orden;
    try{
    PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,i.getSerie());
        ps.setString(2,i.getNombre());
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
    
    
    
    
    
    public boolean ModificarComplementoSinFoto(int orden, Complementos i){
        boolean modificado=false;
        Connection conexion = ConectarMysql();
    String sql = "update complementos set serie=?,nombre=?, precio=?,marca=?, modelo=? , descripcion= ?  where orden="+orden;

    try{
    PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,i.getSerie());
        ps.setString(2,i.getNombre());
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
    
    
    public int ObtenerOrdenComplemento(String serie){
        int orden=0;
    Connection conexion = ConectarMysql();
    String sql = "select * from complementos  where serie='"+serie+"'";
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
  

}
