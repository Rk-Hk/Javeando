/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import ConexionMysql.Dao;
import Entidad.Usuario;
import PaqueteEstructuras.VectorGenerico;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author nelsoncuenta
 */
public class GestorUsuario {
    
    // ListarUsuario
    
    public VectorGenerico<Usuario> lsUsuario(){
        return Dao.getDaoUsuario().ListarUsuarios();
    }
    
     // Buscar Usuario
    public Usuario BuscarUsuario (int dni){
        return   Dao.getDaoUsuario().BusquedaUsuario_Dni(dni);
    }
    
    // Registrar Usuario!!!!
    public boolean RegistrarUsuario(Usuario usu){
        boolean estado =false;
        Usuario usuarioAux = null;
     
        usuarioAux = Dao.getDaoUsuario().BusquedaUsuario_Dni(usu.getDni());
        if (usuarioAux !=null){
            JOptionPane.showMessageDialog(null,"El usuario ya esta Registrado","REGISTRO",JOptionPane.ERROR_MESSAGE);

        }else 
        {  
            Dao.getDaoUsuario().RegistrarUsuario(usu);
            estado =true;
        }
            return estado ;
    }
    
    public boolean Eliminar (int dni){
        return Dao.getDaoUsuario().EliminarUsuario(dni);
    }
    
    public boolean ExisteUsuario(int dni){
        Usuario usu =BuscarUsuario(dni);
        if(usu!=null)
            return true;
        else
            return false;
    }
}
