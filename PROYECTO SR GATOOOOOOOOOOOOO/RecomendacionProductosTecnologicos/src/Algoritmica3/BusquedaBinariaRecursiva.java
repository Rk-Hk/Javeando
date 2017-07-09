/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmica3;

import Entidad.Laptop;
import Entidad.Pc;
import java.util.ArrayList;

/**
 *
 * @author sometimes
 */

public class BusquedaBinariaRecursiva {
   public static int BusquedaLaptop(ArrayList<Laptop> pc,int prim,int ult,String serie){
        
    int mitad,total;
    if (prim > ult) 
         return -1;
    else 
      mitad =(prim + ult)/2;
       
         if (pc.get(mitad).getSerie().trim().equalsIgnoreCase(serie) )
            return  mitad;
         else{
            if (pc.get(mitad).getSerie().trim().equalsIgnoreCase(serie)) 
                return BusquedaLaptop(pc, prim, mitad-1, serie);
            else
                return BusquedaLaptop(pc, mitad+1 , ult, serie);
            }
    }
    
    public static int TransfomarCodigo(String codigo){

            Character c;
            String resultado = "";
            int numero;
            for(int i = 0; i<codigo.length(); i++){
                c = codigo.charAt(i);
                if(Character.isDigit(c)){ 
                     resultado = resultado + c;
                     }
                  }
              numero = Integer.parseInt(resultado);
              return numero;
        
    }
}
