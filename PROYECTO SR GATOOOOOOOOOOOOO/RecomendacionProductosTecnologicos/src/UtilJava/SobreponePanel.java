/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UtilJava;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author RIKARDO
 */
public class SobreponePanel {
    public static void SobrePonerPAnel(JPanel padre , JPanel hijo){
        padre.removeAll(); // limpiamos el contnido del panel principal
        padre.add(hijo);   // Agregar el hijo dentro del padre (paneles)
        padre.updateUI();  // Actualizamos en pantalla el contenid del padre
    }
    
    public static JPanel ObtenerPadre(JPanel hijo){
        return (JPanel) hijo.getParent();  //devuelve el padre del Panel instanciado o null en el caso de que no exista padre
    }
    
    public static void quitarPanel(JPanel hijo){
        JPanel padre = ObtenerPadre(hijo);
        padre.removeAll();
        padre.updateUI();
    }
    

}
