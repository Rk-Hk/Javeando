/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmica3;

import Entidad.Producto;
import java.util.ArrayList;

/**
 *
 * @author Rikardo
 */
     
     /* Class AVLTree */
    public class ArbolAvl{
        class Nodo{    
            Nodo izq, der;
            Producto data;
            int altura;

            public Nodo(){
                izq = null;
                der = null;
                data = null;
                altura = 0;
            }

            public Nodo(Producto n){
                izq = null;
                der = null;
                data = n;
                altura = 0;
            }     
        }

        private ArrayList<Producto> p;
        private Nodo raiz;     
         
        
        public ArrayList retornar(){
            return p;
        }
         public ArbolAvl(){
             p = new ArrayList<>();
             raiz = null;
         }

         public boolean esVacio(){
             return raiz == null;
         }

         public void IniciarVacio(){
             raiz = null;
         }

         public void insertar(Producto data){
             raiz = Insertar(data, raiz);
         }

         private int altura(Nodo t ){
             return t == null ? -1 : t.altura;
         }

         private int max(int lhs, int rhs){ // maximo de nodos a derecha o izquierda
             return lhs > rhs ? lhs : rhs;
         }

        private Nodo Insertar(Producto x, Nodo t){// Insertar datos recursivmente
            if (t == null)
                 t = new Nodo(x);
            else 
                if (x.getPreferencia() < t.data.getPreferencia()){
                    t.izq = Insertar(x, t.izq );
                    if( altura(t.izq ) - altura(t.der ) == 2 )
                        if( x.getPreferencia() < t.izq.data.getPreferencia() )
                            t = RotarIzquierda( t );
                        else
                            t = DobleRotacionIzq( t );
                }
            else 
                if( x.getPreferencia() > t.data.getPreferencia() ){
                 t.der = Insertar(x, t.der );
                 if( altura(t.der ) - altura(t.izq ) == 2 )
                     if( x.getPreferencia() > t.der.data.getPreferencia())
                         t = RotarDerecha( t );
                     else
                         t = DobleRotacionDer( t );

             }
             else
               ;  // Duplicate; do nothing
             t.altura = max( altura(t.izq ), altura(t.der ) ) + 1;
             return t;
         }

         /* Rotate binary tree node with left child */     

         private Nodo RotarIzquierda(Nodo k2){
             Nodo k1 = k2.izq;
             k2.izq = k1.der;
             k1.der = k2;
             k2.altura = max( altura(k2.izq ), altura(k2.der ) ) + 1;
             k1.altura = max( altura(k1.izq ), k2.altura ) + 1;
             return k1;
         }
         
         /* Rotate binary tree node with right child */
         private Nodo RotarDerecha(Nodo k1){
             Nodo k2 = k1.der;
             k1.der = k2.izq;
             k2.izq = k1;
             k1.altura = max( altura(k1.izq ), altura(k1.der ) ) + 1;
             k2.altura = max( altura(k2.der ), k1.altura ) + 1;
             return k2;
         }

         /**

          * Double rotate binary tree node: first left child

          * with its right child; then node k3 with new left child */

         private Nodo DobleRotacionIzq(Nodo k3){
             k3.izq = RotarDerecha(k3.izq );
             return RotarIzquierda( k3 );
         }

         /**

          * Double rotate binary tree node: first right child

          * with its left child; then node k1 with new right child */      

         private Nodo DobleRotacionDer(Nodo k1){
             k1.der = RotarIzquierda(k1.der );
             return RotarDerecha( k1 );
         }    

         /* Functions to count number of nodes */

         public int ContarNodos(){
             return ContarNodos(raiz);
         }
         
         private int ContarNodos(Nodo r){
             if (r == null)
                 return 0;
             else
             {
                 int l = 1;
                 l += ContarNodos(r.izq);
                 l += ContarNodos(r.der);
                 return l;
             }
         }

         /* Functions to search for an element */

         public boolean BuscarProducto(Producto val){
             return BuscarProducto(raiz, val);
         }

         private boolean BuscarProducto(Nodo r, Producto val){
             boolean found = false;
             while ((r != null) && !found)
             {
                 Producto rval = r.data;
                 if (val.getPreferencia() < rval.getPreferencia())
                     r = r.izq;
                 else if (val.getPreferencia() > rval.getPreferencia())
                     r = r.der;
                 else
                 {
                     found = true;
                     break;
                 }
                 found = BuscarProducto(r, val);
             }
             return found;
         }

         /* Function for inorder traversal */

         public void inorden(){
             inorden(raiz);
         }
         private void inorden(Nodo r){
             if (r != null)
             {
                 inorden(r.izq);
                 System.out.print(r.data +" ");
                 inorden(r.der);
             }
         }

         /* Function for preorder traversal */

         public void preorden(){
             preorden(raiz);
         }

         private void preorden(Nodo r){
             if (r != null)
             {
                 System.out.print(r.data +" ");
                 preorden(r.izq);             
                 preorden(r.der);
             }
         }
         
         public void invertOrden(Nodo reco){
             if (reco != null)
          {    
              invertOrden(reco.der);
              System.out.println(reco.data.getPreferencia()+"     "+reco.data);
              p.add(reco.data);
              invertOrden(reco.izq);
          }
         }
         
         public void invertOrden (){
            invertOrden(raiz);
        }

         /* Function for postorder traversal */

         public void postorden(){
             postorden(raiz);
         }

         private void postorden(Nodo r)
         {
             if (r != null)
             {
                 postorden(r.izq);             
                 postorden(r.der);
                 System.out.print(r.data +" ");
             }
         }   
     }
