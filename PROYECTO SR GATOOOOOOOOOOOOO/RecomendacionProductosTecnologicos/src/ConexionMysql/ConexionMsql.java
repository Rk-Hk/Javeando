package ConexionMysql;


import java.sql.*;
import javax.swing.JOptionPane;
public class ConexionMsql {
  
      //private static  String ruta;
    
    public static Connection ConectarMysql(){
        Connection conectar=null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conectar=DriverManager.getConnection("jdbc:mysql://localhost:3306/huayna","root","mprintfricardo8");

            }catch(ClassNotFoundException e){
                JOptionPane.showMessageDialog(null,"No ha ingresado el Driver:JDBC");
            }catch (SQLException e ){
                JOptionPane.showMessageDialog(null,"No existe: Conexión");
            }
            return conectar;
        }
    
     public static void CerrarMysql(Connection conexion){
        try {
            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No existe: Conexión"); 
        }
     }
     
     public static void ComprobarConexion(){
           ConexionMsql conect= new ConexionMsql();
           Connection ConeccionPrueba = conect.ConectarMysql();
           if(ConeccionPrueba!=null)
                JOptionPane.showMessageDialog(null,"Conexion Establecida!!!");
           else {
                JOptionPane.showMessageDialog(null,"No se Pudo Establecer La conexion!!");
           }
           
     }
    
    
   
    public static void SeleccionarDatos(){
            /*Obtener conexion*/
        Connection conexion = ConectarMysql();
        
        /*Definir la sentencia*/
        String sql = "SELECT * FROM PERSONA";
        
        try {
            /*Preparar la sentencia*/
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            /*Ejecutamos la sentencia*/
            // selecciona todo!!!!
            ResultSet rs = ps.executeQuery();
            
            /*Navegamos por los resultados obtenidos*/
            while(rs.next() == true){
                /*Obtenemos los datos*/
                System.out.println("DNI: "+rs.getString("DNI"));
                System.out.println("Nombre: "+rs.getString("NOMBRE"));
                System.out.println("Apellido paterno: "+rs.getString("AP_PATERNO"));
                System.out.println("Apellido materno: "+rs.getString("AP_MATERNO"));
                System.out.println("Edad: "+rs.getInt("EDAD"));
                System.out.println("Estatura: "+rs.getDouble("ESTATURA"));
                System.out.println("Soltero: "+rs.getBoolean("SOLTERO"));
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        /*Cerrar la conexión*/
        CerrarMysql(conexion);

    }
    
}
