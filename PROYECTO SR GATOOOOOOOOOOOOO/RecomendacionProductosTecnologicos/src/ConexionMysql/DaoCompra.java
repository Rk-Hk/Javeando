
package ConexionMysql;


import static ConexionMysql.ConexionMsql.ConectarMysql;
import static ConexionMysql.DaoImpresora.eliminar;
import static ConexionMysql.DaoImpresora.error;
import Entidad.Complementos;
import Entidad.Compra;
import Entidad.Impresora;
import Entidad.Laptop;
import Entidad.Pc;
import Entidad.Producto;
import Entidad.Tablet;
import Entidad.Usuario;
import PaqueteEstructuras.PilaListaGenerica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class DaoCompra {
     public  void DAO_RegistrarCompra(Compra com){
      int columna=0,contador=0;
        Usuario usu = null;
            Producto proAux= null;
                PilaListaGenerica<Producto>lsCargados = null;
         
        
      Connection conexion = ConectarMysql();
                       
        usu = com.getUsuario();
        lsCargados=com.getProductoCargado();
        
        //atributos de la tablaImpresora
       try {   
           while(!lsCargados.estaVacia()){
//        for(int i =0;i<lsCargados.size();i++){
             proAux = lsCargados.getDatoCima();
             lsCargados.sacarDato();
            String sql = "insert into compra(dnicomprador,nombrecom,apepater,apemater,nombreproduc,marcaproduc,modeloproduc,descriproduc,precio,fecha,hora) values(?,?,?,?,?,?,?,?,?,?,?)";
                                       
             PreparedStatement sq= conexion.prepareStatement(sql);
            //dni
          
            //dni
            sq.setInt(1,usu.getDni());
            sq.setString(2,usu.getNombre());
            sq.setString(3,usu.getApell_paterno());
            sq.setString(4,usu.getApell_materno());
            //nombreproducto
            if(proAux instanceof Laptop){
             sq.setString(5,"Laptop");
            }
             if(proAux instanceof Impresora){
             sq.setString(5,"Impresora");
            }
          if(proAux instanceof Pc){
             sq.setString(5,"PC");
            }
          if(proAux instanceof Tablet){
             sq.setString(5,"Tablet");
            }
           if(proAux instanceof Complementos){
             sq.setString(5,"Complementos");
            }
           
            sq.setString(6,proAux.getMarca());
            //ap_modelo
            sq.setString(7,proAux.getModelo());
            //descripcion
            sq.setString(8,proAux.getDescripcion());
            //edad
            sq.setDouble(9,proAux.getPrecio());
            //correo
            sq.setString(10,com.getFecha());
            sq.setString(11,com.getHora());
                                             
            columna=sq.executeUpdate();
            
            contador= contador+columna;
            
        }
            ConexionMsql.CerrarMysql(conexion);
            


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No de pudo Guardar los datos en la B.D","Error",JOptionPane.ERROR_MESSAGE,error);
        }
            Icon  guardar2 = new ImageIcon("src/Imagenes/descargar.png");
            JOptionPane.showMessageDialog(null,"Los datos se Guardaron satisfactoriamente \n "
                  + " Numero de Filas Modificadas: "+contador,"Guardar",JOptionPane.WARNING_MESSAGE,guardar2);
    }
        
       //buscar los daots del alumno por dni 
       
    public  boolean EliminarHistorialDeCompra(int dni) {
        boolean estado=false;

        Connection conexion=ConectarMysql();
        String sql= "delete from compra where serie= '"+dni+"'";
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
   
    public  ArrayList<Compra> ListarCompraUsuario(){
        ArrayList<Compra> lsCompra=null;
        
       int preferencia=0;
       Double precio;
       int dnicomprador;
       String nombrecom,apepater,apemater,nombreproduc,marcaproduc,modeloproduc,descriproduc,fecha,hora;
      
       
     // obtenemos la conexxion con la base de datos Mysql
        Connection conexion= ConectarMysql();
        String sql="select * from compra";
        try{ 
            lsCompra= new ArrayList<Compra>();
            PreparedStatement sq =  conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            while (rql.next()){
                 Producto pro = null;
                 Usuario usu = null;
                 
                dnicomprador=rql.getInt("dnicomprador");
                nombrecom = rql.getString("nombrecom");
                apepater=rql.getString("apepater");
                apemater=rql.getString("apemater");
                nombreproduc=rql.getString("nombreproduc");
                marcaproduc= rql.getString("marcaproduc");
                modeloproduc=rql.getString("modeloproduc");
                descriproduc=rql.getString("descripcion");
                fecha = rql.getString("fecha");
                precio = rql.getDouble("precio");
                hora= rql.getString("hora") ;
                
                Compra com = new Compra(dnicomprador, nombrecom, apepater, apemater, nombreproduc, marcaproduc, modeloproduc, descriproduc, precio, fecha, hora);
             
                      lsCompra.add(com);
             }
             ConexionMsql.CerrarMysql(conexion);
             sq.close();
             rql.close();
             
         }catch(Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo cargar la Tabla!!","Error",JOptionPane.ERROR_MESSAGE,error);
         }
         return lsCompra;
      }
    public  ArrayList<Compra> CuentaTotal(){
        ArrayList<Compra> lsCompra=null;
     
       Double precio;
       String nombreproduc;
      
       
     // obtenemos la conexxion con la base de datos Mysql
        Connection conexion= ConectarMysql();
        String sql="select nombreproduc , sum(precio)   from compra  group by nombreproduc;";
        try{ 
            lsCompra= new ArrayList<Compra>();
            PreparedStatement sq =  conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            while (rql.next()){
                                  
                nombreproduc=rql.getString("nombreproduc");
                precio = rql.getDouble("sum(precio)");
                
                     Compra com = new Compra(precio, nombreproduc);
             
                      lsCompra.add(com);
             }
             ConexionMsql.CerrarMysql(conexion);
             sq.close();
             rql.close();
             
         }catch(Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo cargar la Tabla!!","Error",JOptionPane.ERROR_MESSAGE,error);
         }
         return lsCompra;
      }
    
    
    
    public  ArrayList<Compra> ListarHistorialIndividual(int dni){
        ArrayList<Compra> lsCompra=null;
        
       int preferencia=0;
       Double precio;
       int dnicomprador;
       String nombrecom,apepater,apemater,nombreproduc,marcaproduc,modeloproduc,descriproduc,fecha,hora;
      
       
     // obtenemos la conexxion con la base de datos Mysql
        Connection conexion= ConectarMysql();
        String sql="select * from compra  where dnicomprador ="+dni;
        try{ 
            lsCompra= new ArrayList<Compra>();
            PreparedStatement sq =  conexion.prepareStatement(sql);
            ResultSet rql = sq.executeQuery();
            while (rql.next()){
                 Producto pro = null;
                 Usuario usu = null;
                 
                dnicomprador=rql.getInt("dnicomprador");
                nombrecom = rql.getString("nombrecom");
                apepater=rql.getString("apepater");
                apemater=rql.getString("apemater");
                nombreproduc=rql.getString("nombreproduc");
                marcaproduc= rql.getString("marcaproduc");
                modeloproduc=rql.getString("modeloproduc");
                descriproduc=rql.getString("descriproduc");
                fecha = rql.getString("fecha");
                precio = rql.getDouble("precio");
                hora= rql.getString("hora") ;
                
                Compra com = new Compra(dnicomprador, nombrecom, apepater, apemater, nombreproduc, marcaproduc, modeloproduc, descriproduc, precio, fecha, hora);
             
                      lsCompra.add(com);
             }
             ConexionMsql.CerrarMysql(conexion);
                          
         }catch(Exception e){
          JOptionPane.showMessageDialog(null,"No se pudo cargar la Tabla!!","Error",JOptionPane.ERROR_MESSAGE,error);
         }
         return lsCompra;
      }
          
}
    
          

