

package ConexionMysql;

import static ConexionMysql.ConexionMsql.CerrarMysql;
import static ConexionMysql.ConexionMsql.ConectarMysql;
import static UtilJava.ClaseCargarImagen.ConvertirImagenByte;
import Entidad.Impresora;
import Entidad.Usuario;
import PaqueteEstructuras.VectorGenerico;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author nelsoncuenta
 */
public class DaoUsuario {

    public void DAO_Usuario(){
    }
    
    public  void RegistrarUsuario(Usuario usu){
       
        int columna=0;
        Connection conexion = ConectarMysql();
        String sql = "insert into comprador(dni,nombre,apepater,apemater,celular,edad,correo,user,contrasena,foto) values(?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement sq= conexion.prepareStatement(sql);
            //dni
            sq.setInt(1,usu.getDni());
            //nombre
            sq.setString(2,usu.getNombre());
            //ap_paterno
            sq.setString(3,usu.getApell_paterno());
            //ap_materno
            sq.setString(4,usu.getApell_materno());
            //celular
            sq.setInt(5,usu.getCelular());
            //edad
            sq.setInt(6,usu.getEdad());
            //correo
            sq.setString(7,usu.getCorreo());
            //usuario
            sq.setString(8,usu.getUser());
            //contraseña
            sq.setString(9,usu.getPassword());
            sq.setBlob(10,usu.getFotoCarnet(), usu.getLongitudFoto());
            
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
       
    public  Usuario BusquedaUsuario_Dni(int dni){
        // obteniendo la conexion
        Usuario usu=null;
        int edad,celular=0;
        String nombre,apepater,apemater,correo,user,password;
        Image  VueltafotoCarnet=null;
       
        Connection conexion = ConectarMysql();
        String sql="select * from comprador where dni = "+dni;
        try{
            PreparedStatement sq = conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            while (rql.next()){
                edad=rql.getInt("edad");
                nombre=rql.getString("nombre");
                apepater=rql.getString("apepater");
                apemater=rql.getString("apemater");
                correo = rql.getString("correo");
                user =rql.getString("user");
                password=rql.getString("contrasena");
                celular=rql.getInt("celular");
                try{
                    byte b[]=rql.getBytes("foto");
                    VueltafotoCarnet=ConvertirImagenByte(b);
                    //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"no se pudo cargar La foto!!","Error",JOptionPane.ERROR_MESSAGE);
                }
                 
                usu = new Usuario(dni, nombre, apepater, apemater, edad, celular, correo, password, user, VueltafotoCarnet);              
            }
            ConexionMsql.CerrarMysql(conexion);
            rql.close();
            sq.close();
     
        }catch(Exception e){
          
            JOptionPane.showMessageDialog(null,"El DNI ingresado no esta registrado \n"
                             + "   en la base de Datos BASE DE DATOS!!!!!","Error",JOptionPane.ERROR_MESSAGE);
        }      
        
        return usu;
    }
    
    public  boolean EliminarUsuario(int dni) {
        boolean estado=false;

        Connection conexion=ConectarMysql();
        String sql= "delete from comprador where dni="+dni;
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
    
    
    public  VectorGenerico<Usuario> ListarUsuarios(){
        VectorGenerico<Usuario> vrUsuario=null;
        int dni,edad,celular=0;
       
        String nombre,apepater,apemater,correo,user,password;
        Image  VueltafotoCarnet=null;
     // obtenemos la conexxion con la base de datos Mysql
        Connection conexion= ConectarMysql();
        String sql="select * from comprador ";
        try{ 
            vrUsuario= new VectorGenerico<Usuario>();
            
            PreparedStatement sq =  conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            while (rql.next()){
                dni= rql.getInt("dni");
                edad=rql.getInt("edad");
                nombre=rql.getString("nombre");
                apepater=rql.getString("apepater");
                apemater=rql.getString("apemater");
                correo = rql.getString("correo");
                user =rql.getString("user");
                password=rql.getString("contrasena");
                celular=rql.getInt("celular");
                try{
                    byte b[]=rql.getBytes("foto");
                    VueltafotoCarnet=ConvertirImagenByte(b);
                   //fotoCarnet= (FileInputStream) rql.getBlob("foto")
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Algunos Usuarios no Poseen Foto!!!","Alerta",JOptionPane.WARNING_MESSAGE);
                }
                Usuario usu = new Usuario(dni, nombre, apepater, apemater, edad, celular, correo, password, user, VueltafotoCarnet);              
                vrUsuario.Insertar(usu);
             }
             ConexionMsql.CerrarMysql(conexion);
             sq.close();
             rql.close();
             
         }catch(Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo cargar la Tabla!!","Error",JOptionPane.ERROR_MESSAGE);
         }
         return vrUsuario;
      }
          
    public int ObtenerOrdenUsuario(int dni){
        int orden=0;
    Connection conexion = ConectarMysql();
    String sql = "select * from comprador  where dni="+dni;
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
    
    
   public boolean ModificarUsuarioSinFoto(int orden, Usuario usu){
        boolean modificado=false;
        Connection conexion = ConectarMysql();
    
    String sql = "update comprador set dni=?, nombre=?, apepater=?,apemater=?, celular=? , edad= ?, correo=?,user=?,contrasena=?where orden="+orden;
    try{
    PreparedStatement sq = conexion.prepareStatement(sql);
           sq.setInt(1,usu.getDni());
            //nombre
            sq.setString(2,usu.getNombre());
            //ap_paterno
            sq.setString(3,usu.getApell_paterno());
            //ap_materno
            sq.setString(4,usu.getApell_materno());
            //celular
            sq.setInt(5,usu.getCelular());
            //edad
            sq.setInt(6,usu.getEdad());
            //correo
            sq.setString(7,usu.getCorreo());
            //usuario
            sq.setString(8,usu.getUser());
            //contraseña
            sq.setString(9,usu.getPassword());
                     
        int  ColumasModificadas = sq.executeUpdate();
        CerrarMysql(conexion);
         sq.close();
                  
        if (ColumasModificadas > 0) {
            modificado = true;
        } 
         
        } catch(Exception e){
                       JOptionPane.showMessageDialog(null,"No se pudo MOdifcar en la B.D");
        } 
     
    return modificado;
    }
     
    
       
    
}
