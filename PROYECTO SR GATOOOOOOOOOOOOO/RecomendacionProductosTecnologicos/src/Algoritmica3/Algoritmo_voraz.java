/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmica3;

/**
 *
 * @author Pregrado
 */
public class Algoritmo_voraz {
    
    public void Voraz(int s[], double v[], double cambio){
        double x;
        int i = 0;
        while (!Solucion(s , v, cambio) && i < s.length){
            x= v[i];
            if (Factible(s, v, cambio, x))
                s[i]++;
            else
                i++;
        }
    }
    public boolean Solucion (int s[], double v[], double cambio){
        double suma = 0.0;
        for (int i = 0; i< s.length; i++){
            suma += s[i]*v[i];
        }
        suma = Math.rint(suma*100)/100;
        if (suma==cambio)
            return true;
        else
            return false;
    }
    
    public boolean Factible (int s[], double v[], double cambio, double x){
        double suma = 0.0;
        for (int i = 0; i< s.length; i++){
            suma += s[i]*v[i];
        }
        suma = suma + x;
        suma = Math.rint(suma*100)/100;
        if (suma<=cambio)
            return true;
        else
            return false;
    }
}
