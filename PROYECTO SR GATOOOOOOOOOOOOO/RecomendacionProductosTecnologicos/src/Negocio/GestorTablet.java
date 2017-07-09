
package Negocio;

import ConexionMysql.Dao;
import Entidad.Tablet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class GestorTablet {
       //listar pc
    public ArrayList<Tablet> lsTablet(){
        return Dao.getDaoTablet().ListarTablet();
    }
    
     // Buscar pc
    public Tablet BuscarTablet (String serie){
        return   Dao.getDaoTablet().BusquedaTablet_Serie(serie);
    }
    
    // Registrar Laptop!!!!
    public boolean RegistrarTablet(Tablet tablet){
        boolean estado =false;
        Tablet tabletAux = null;
     
    tabletAux = Dao.getDaoTablet().BusquedaTablet_Serie(tablet.getSerie());
    if (tabletAux !=null){
        JOptionPane.showMessageDialog(null,"El usuario ya esta Registrado");
    
    }else 
    {  
      Dao.getDaoTablet().DAO_RegistrarTablet(tablet);
      estado =true;
    }
        return estado ;
    }
    
    
    public boolean EliminarTablet (String serie){
        return Dao.getDaoTablet().EliminarTablet(serie);
    }
    
     public  boolean ModificarTabletConFoto(Tablet i ,int orden){
    return Dao.getDaoTablet().ModificarConFoto(orden, i);
        }
    
    public  boolean ModificarTabletSinFoto(Tablet i ,int orden){
    return Dao.getDaoTablet().ModificarSinFoto(orden,i);
    
    }
    
    public int  OrdenTabler(String serie){
        int orden = Dao.getDaoTablet().ObtenerOrdenTablet(serie);
        return orden ;
    }
    
    public boolean ModificarPref(double pref,String serie,double dada){
        return Dao.getDaoTablet().ModificarPreferencia(pref, serie,dada);
    }
}
