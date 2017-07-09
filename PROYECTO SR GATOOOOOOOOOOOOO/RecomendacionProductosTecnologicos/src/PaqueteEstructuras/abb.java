package PaqueteEstructuras;


import Entidad.Producto;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SOPORTE
 */
public class abb {

 class Nodo
      {
        Producto info;
        Nodo izq, der;
      }
      Nodo raiz;
      
      ArrayList p;

      public abb() {
          
          raiz=null;
          p=new ArrayList();
      }
      
      public void insertar (Producto info)
      {
          Nodo nuevo;
          nuevo = new Nodo ();
          nuevo.info = info;
          nuevo.izq = null;
          nuevo.der = null;
          if (raiz == null)
              raiz = nuevo;
          else
          {
              Nodo anterior = null, reco;
              reco = raiz;
              while (reco != null)
              {
                  anterior = reco;
                  if (info.getPreferencia() < reco.info.getPreferencia())
                      
                      reco = reco.izq;
                  else
                      reco = reco.der;
              }
              if (info.getPreferencia() < anterior.info.getPreferencia())
                  anterior.izq = nuevo;
              else
                  anterior.der = nuevo;
          }
      }


      private void imprimirPre (Nodo reco)
      {
          if (reco != null)
          {
              System.out.print(reco.info + " ");
              imprimirPre (reco.izq);
              imprimirPre (reco.der);
          }
      }

      public void imprimirPre ()
      {
          imprimirPre (raiz);
          System.out.println();
      }

      private void imprimirEntre (Nodo reco)
      {
          if (reco != null)
          {    
              imprimirEntre (reco.izq);
              System.out.print(reco.info.getPreferencia()+"     ");
              
              imprimirEntre (reco.der);
          }
      }
      
      public void imprimirEntre ()
      {
          imprimirEntre (raiz);
          System.out.println();
      }
      private void imprimirDescend (Nodo reco)
      {
          if (reco != null)
          {    
              imprimirDescend (reco.der);
//              System.out.println(reco.info.getPreferencia()+"     "+reco.info);
              p.add(reco.info);
              imprimirDescend (reco.izq);
          }
      }
      
      public void imprimirDescend ()
      {
          imprimirDescend (raiz);
      }
      
      public ArrayList retornar(){
          return p;
      }

      private void imprimirPost (Nodo reco)
      {
          if (reco != null)
          {
              imprimirPost (reco.izq);
              imprimirPost (reco.der);
              System.out.print(reco.info + " ");
          }
      }


      public void imprimirPost ()
      {
          imprimirPost (raiz);
          System.out.println();
      }
      
}