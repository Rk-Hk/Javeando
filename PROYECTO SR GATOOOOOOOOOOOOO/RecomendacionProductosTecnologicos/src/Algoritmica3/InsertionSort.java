/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmica3;

import Entidad.Impresora;
import Entidad.Laptop;
import Entidad.Pc;
import Entidad.Producto;
import Entidad.Tablet;
import java.util.ArrayList;

/**
 *
 * @author Rikardo
 */
public class InsertionSort {
    
    
    public static  void InsercionDirecta(ArrayList<Producto> A){
        //n=la cantidad de elementos en A
        int n = A.size();
        for (int i = 1; i < n; i++)
        {
            //guardamos el valor del elemento i
            Producto v =  A.get(i);
            //empezamos a compararlo con el anterior
            int j = i - 1;
            //y seguimos mientras no hayamos llegado
            //al principio del array y los elementos
            //que encontremos sean mayores que el que
            //analizamos
            while (j >= 0 && A.get(j).getPreferencia() > v.getPreferencia())
            {
                   //desplazamos el elemento un
                   //lugar a la derecha
                   A.set(j+1, A.get(j));
                   //y pasamos al anterior
                   j--;
               }
            //Al terminar el bucle, j indica el
            //lugar inmediatamente anterior a donde
            //debemos encajar v
            A.set(j+1, v);
        }
    }
    
    
     public static  void InsercionDirectaPc(ArrayList<Pc> A){
        //n=la cantidad de elementos en A
        int n = A.size();
        for (int i = 1; i < n; i++)
        {
            Pc v =  A.get(i);
            int j = i - 1;
            while (j >= 0 && A.get(j).getPreferencia() > v.getPreferencia())
            {
                   A.set(j+1, A.get(j));
                   j--;
               }
            A.set(j+1,v);
        }
       
    }
      
        public static  void InsercionDirectalaptop(ArrayList<Laptop> A){
        //n=la cantidad de elementos en A
        int n = A.size();
        for (int i = 1; i < n; i++)
        {
            Laptop v =  A.get(i);
            int j = i - 1;
            while (j >= 0 && A.get(j).getPreferencia() > v.getPreferencia())
            {
                   A.set(j+1, A.get(j));
                   j--;
               }
            A.set(j+1, v);
        }
       
    }
        
          public static  void InsercionDirectaTablet(ArrayList<Tablet> A){
        //n=la cantidad de elementos en A
        int n = A.size();
        for (int i = 1; i < n; i++)
        {
            Tablet v =  A.get(i);
            int j = i - 1;
            while (j >= 0 && A.get(j).getPreferencia() > v.getPreferencia())
            {
                   A.set(j+1, A.get(j));
                   j--;
               }
            A.set(j+1, v);
        }
       
    }
          
            public static  void InsercionDirectaImpresoras(ArrayList<Impresora> A){
        //n=la cantidad de elementos en A
        int n = A.size();
        for (int i = 1; i < n; i++)
        {
            Impresora v =  A.get(i);
            int j = i - 1;
            while (j >= 0 && A.get(j).getPreferencia() > v.getPreferencia())
            {
                   A.set(j+1, A.get(j));
                   j--;
               }
            A.set(j+1, v);
        }
       
    }
}
