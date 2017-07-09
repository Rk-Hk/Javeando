/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UtilJava;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author RIKARDO
 */
public class Validaciones {
    
    public static void SoloLetras(JTextField jt){
        jt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c= e.getKeyChar();
                if(Character.isDigit(c))
                    e.consume();
            }
        }
        );
    }
    
    public static void SoloNumeros(JTextField jt){
        jt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c= e.getKeyChar();
                if(!Character.isDigit(c))
                    e.consume();
            }
        }
        );
    }
}