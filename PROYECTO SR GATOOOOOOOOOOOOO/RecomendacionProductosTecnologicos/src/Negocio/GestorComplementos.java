/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import ConexionMysql.Dao;
import Entidad.Complementos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RIKARDO
 */
public class GestorComplementos {
    public ArrayList<Complementos> lsComplementos(){
        return Dao.getDaoComple().ListarComplementos();
    }
    
     // Buscar Usuario
    public Complementos BuscarComplemento (String serie){
        return   Dao.getDaoComple().BusquedaComplementos(serie);
    }
    
    // Registrar Usuario!!!!
    public boolean RegistrarComplemento(Complementos usu){
        boolean estado =false;
        Complementos usuarioAux = null;
     
        usuarioAux = Dao.getDaoComple().BusquedaComplementos(usu.getSerie());
        System.out.println(usu.getSerie());
        if (usuarioAux !=null){
            JOptionPane.showMessageDialog(null,"El Laptop ya esta Registrado");

        }else 
        {  
            Dao.getDaoComple().DAO_RegistrarComplementos(usu);
            estado =true;
        }
            return estado ;
    }
    
    public boolean EliminarComplemento (String serie){
        return Dao.getDaoLaptop().EliminarLaptop(serie);
    }
    
    public boolean ExisteComplemento(String serie){
        Complementos usu =Dao.getDaoComple().BusquedaComplementos(serie);
        if(usu!=null)
            return true;
        else
            return false;
    }
    
    public boolean ModificarPref(double pref,String serie,double dada){
        return Dao.getDaoComple().ModificarPreferencia(pref, serie,dada);
    }
     public int OrdenComplemento(String serie){
        int orden = Dao.getDaoComple().ObtenerOrdenComplemento(serie);
            return orden;
    }
    
    
    public  boolean ModificarComplementoConFoto(Complementos i ,int orden){
    return Dao.getDaoComple().ModificarComplementoConFoto(orden, i);
        }
    
    public  boolean ModificarComplementoSinFoto(Complementos i ,int orden){
    return Dao.getDaoComple().ModificarComplementoSinFoto(orden, i);
    }
}
