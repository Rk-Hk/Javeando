/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author Rikardo
 */
public class ArbolBinario{
    class Nodo
      {
        int info;
        Nodo izq;
        Nodo der;
      }
    
      Nodo raiz;
      String men1="";
      String men2="";
      String men3="";

      public ArbolBinario() {
          raiz=null;
      }
      
      public void LlenadoporDefecto(){
          int[] vector = {20,15,25,13,16,23,28};
          for(int i =0 ;i<vector.length;i++){
              LlenarArbol(vector[i]);
          }
      }
      
      public void LlenarArbol (int dato)
      {
          Nodo nuevo=new Nodo ();
          nuevo.info = dato;
          nuevo.izq = null;
          nuevo.der = null;
          if (raiz == null)
              raiz = nuevo;
          else
          {
              Nodo anterior = null, aux;
              aux = raiz;
              while (aux != null)
              {
                  anterior = aux;
                  if (dato < aux.info)
                      aux = aux.izq;
                  else
                      aux = aux.der;
              }
              if (dato < anterior.info)
                  anterior.izq = nuevo;
              else
                  anterior.der = nuevo;
          }
      }


      public void PreOrden (Nodo aux)
      {
          if (aux != null)
          {
              men1= men1+aux.info + ", ";
              PreOrden (aux.izq);
              PreOrden (aux.der);
          }
      }

      public void InOrden (Nodo aux)
      {
          if (aux != null)
          {    
              InOrden (aux.izq);
              men2= men2+aux.info + ", ";
              InOrden (aux.der);
          }
      }

      public void PosOrden (Nodo aux)
      {
          if (aux != null)
          {
              PosOrden (aux.izq);
              PosOrden (aux.der);
              men3= men3+aux.info + ", ";
          }
      } 

    public String getMen1() {
        return men1;
    }

    public String getMen2() {
        return men2;
    }

    public String getMen3() {
        return men3;
    }
      
}