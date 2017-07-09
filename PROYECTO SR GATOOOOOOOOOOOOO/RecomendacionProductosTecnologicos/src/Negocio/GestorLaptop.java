/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import ConexionMysql.Dao;
import Entidad.Laptop;
import UtilJava.ClaseCargarImagen;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nelsoncuenta
 */
public class GestorLaptop {
    

    public GestorLaptop() {
    }
    

    public ArrayList<Laptop> lsLaptop(){
        return Dao.getDaoLaptop().ListarLaptop();
    }
    
     // Buscar Usuario
    public Laptop BuscarLaptop (String serie){
        return   Dao.getDaoLaptop().BusquedaLaptop_Serie(serie);
    }
    
    // Registrar Usuario!!!!
    public boolean RegistrarLaptop(Laptop usu){
        boolean estado =false;
        Laptop usuarioAux = null;
     
        usuarioAux = Dao.getDaoLaptop().BusquedaLaptop_Serie(usu.getSerie());
        if (usuarioAux !=null){
            JOptionPane.showMessageDialog(null,"El Laptop ya esta Registrado");

        }else 
        {  
            Dao.getDaoLaptop().DAO_RegistrarLaptop(usu);
            estado =true;
        }
            return estado ;
    }
    
    public boolean Eliminar (String serie){
        return Dao.getDaoLaptop().EliminarLaptop(serie);
    }
    
    public boolean ExisteLaptop(String serie){
        Laptop usu =Dao.getDaoLaptop().BusquedaLaptop_Serie(serie);
        if(usu!=null)
            return true;
        else
            return false;
    }
    
    
    
    
    public boolean ModificarPref(double pref,String serie,double dada){
        return Dao.getDaoLaptop().ModificarPreferencia(pref, serie,dada);
    }
     public int OrdenLaptop(String serie){
        int orden = Dao.getDaoLaptop().ObtenerOrdenLaptop(serie);
            return orden;
    }
     
     public  boolean ModificarLaptopConFoto(Laptop i ,int orden){
    return Dao.getDaoLaptop().ModificarLaptopConFoto(orden, i);
        }
     
      public  boolean ModificarLaptopSinFoto(Laptop i ,int orden){
    return Dao.getDaoLaptop().ModificarLaptopSinFoto(orden, i);
        }
}

