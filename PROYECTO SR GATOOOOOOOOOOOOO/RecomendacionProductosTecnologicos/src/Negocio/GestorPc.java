

package Negocio;

import ConexionMysql.Dao;
import Entidad.Pc;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class GestorPc {
     //listar pc
    public ArrayList<Pc> lsPc(){
        return Dao.getDaoPc().ListarPc();
    }
    
     // Buscar pc
    public Pc BuscarPc (String serie){
        return   Dao.getDaoPc().BusquedaPc_Serie(serie);
    }
    
    // Registrar Laptop!!!!
    public boolean RegistrarPc(Pc pc){
        boolean estado =false;
        Pc pcpAux = null;
     
    pcpAux = Dao.getDaoPc().BusquedaPc_Serie(pc.getSerie());
    if (pcpAux !=null){
        JOptionPane.showMessageDialog(null,"El usuario ya esta Registrado");
    
    }else 
    {  
      Dao.getDaoPc().DAO_RegistrarPc(pc);
      estado =true;
    }
        return estado ;
    }
    
    public boolean EliminarPc (String serie){
        return Dao.getDaoPc().EliminarPc(serie);
    }
    
    public boolean ModificarPref(double pref,String serie,double dada){
        return Dao.getDaoPc().ModificarPreferencia(pref, serie,dada);
    }
     public int OrdenPc(String serie){
        int orden = Dao.getDaoPc().ObtenerOrdenPc(serie);
            return orden;
    }
     
     public  boolean ModificarPcConFoto(Pc i ,int orden){
    return Dao.getDaoPc().ModificarPcConFoto(orden, i);
        }
     
      public  boolean ModificarPcSinFoto(Pc i ,int orden){
    return Dao.getDaoPc().ModificarPcSinFoto(orden, i);
        }
}
