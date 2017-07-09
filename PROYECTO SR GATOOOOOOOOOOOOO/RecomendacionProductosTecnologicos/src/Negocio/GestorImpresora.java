/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import ConexionMysql.Dao;
import Entidad.Impresora;
import Entidad.Laptop;
import Entidad.Usuario;
import PaqueteEstructuras.VectorGenerico;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nelsoncuenta
 */
public class GestorImpresora {
    public ArrayList<Impresora> lsImpresoras(){
        return Dao.getDaoImpresora().ListarImpresoras();
    }
    
     // Buscar Usuario
    public Impresora BuscarLaptop (String serie){
        return   Dao.getDaoImpresora().BusquedaImpresora_Serie(serie);
    }
    
    // Registrar Usuario!!!!
    public boolean RegistrarImpresora(Impresora usu){
        boolean estado =false;
        Impresora  impreAux = null;
     
        impreAux = Dao.getDaoImpresora().BusquedaImpresora_Serie(usu.getSerie());
        if (impreAux !=null){
            JOptionPane.showMessageDialog(null,"La Impresora  ya esta Registrado");

        }else 
        {  
            Dao.getDaoImpresora().DAO_RegistrarImpresora(usu);
            estado =true;
        }
            return estado ;
    }
    
    public boolean Eliminar (String serie){
        return Dao.getDaoImpresora().EliminarImpresora(serie);
    }
    
    public boolean ExisteImpresora(String serie){
        Impresora usu =Dao.getDaoImpresora().BusquedaImpresora_Serie(serie);
        if(usu!=null)
            return true;
        else
            return false;
    }
    public int OrdenImpresora(String serie){
        int orden = Dao.getDaoImpresora().ObtenerOrdenImpresora(serie);
            return orden;
    }
    
    
    public  boolean ModificarImpresoraConFoto(Impresora i ,int orden){
    return Dao.getDaoImpresora().ModificarImpresoraConFoto(orden, i);
        }
    
    public  boolean ModificarImpresoraSinFoto(Impresora i ,int orden){
    return Dao.getDaoImpresora().ModificarImpresoraSinFoto(orden, i);
    
    }
    
    public boolean ModificarPref(double pref,String serie,double dada){
        return Dao.getDaoImpresora().ModificarPreferencia(pref, serie,dada);
    }
    
}
