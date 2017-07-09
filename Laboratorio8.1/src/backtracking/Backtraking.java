/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backtracking;

import javax.swing.JOptionPane;

/**
 *
 * @author Pregrado
 */
public class Backtraking {
    private int s[];
    private int v[];
    private int tact;
    private int p;
    private int sol[][];
    private int w;
    private int solucion=0;
    

    public Backtraking(int valores[],int suma) {
        v= new int[valores.length];
        s= new int[valores.length];
        sol= new int[valores.length][valores.length];
        v=valores;
        tact =0;
        p=suma;
        w=0;
    }
    
    public void hallarSubconjunto(){
        int nivel=0;
        boolean fin = false;
//        
        for(int i=0;i<s.length;i++)
            s[i]=-1;
        
        do{
            generar(nivel);
            if(solucion(nivel,p)){
                solucion++;
                Almacenar(s);
            }
            if(criterio(nivel,p))
                nivel++;
            else{
                while(!masHermanos(nivel) && nivel>0){
                    nivel=retroceder(nivel);}}

        }while(nivel>0);
    }
    
    public void generar(int nivel){
        s[nivel]=s[nivel]+1;
        if(s[nivel]==1)
            tact=tact+v[nivel];
    }
    
    public boolean solucion(int nivel ,int p){
        int n=s.length;
        return (nivel==n-1 && tact==p);
    }
    
    public  boolean criterio(int nivel,int p){
        int n =s.length;
        return (nivel<n-1 && tact<=p);
    }
    
    public boolean masHermanos(int nivel){
        return (s[nivel]<1);
    }
    
    public int retroceder(int nivel){
        tact-=v[nivel]*s[nivel];
        s[nivel]=-1;
        nivel--;
        return nivel;
    }
    
    public  void mostrarSolucion(){
        System.out.println("solucion = "+solucion);
        String mensaje = "";
        mensaje = "Valores: \n {";
            for(int i=0;i<v.length; i++){
                mensaje+=v[i];
                if(i<v.length -1)
                    mensaje+=",";
                else 
                    mensaje +="}";

            }
        mensaje += "\n\n Solucion de bactracking:\n{";
        
        for(int i=0;i<solucion;i++){
            for(int j=0;j<s.length;j++){
                mensaje +=sol[i][j];
                if(i<s.length-1)
                    mensaje +=",";
                else
                    mensaje +="}";
            }
            mensaje+="\n";
        }
         if(solucion==0){
             mensaje="no solucion";
         }else{
          mensaje +="\n\n Sub conjunto cuya suma es "+p+ ":\n {"; 
         
           for(int i=0; i<solucion;i++){
               for(int j=0;j<s.length;j++)
                    if(sol[i][j]==1){   
                        mensaje+=v[j];
                        if(i<s.length-1)
                            mensaje+=",";
                        else
                            mensaje+="}\n";
                   
                    }
               mensaje+="\n";
            }
               
        }
           JOptionPane.showMessageDialog(null, mensaje,"Algoritmos  de retroceso(Backtracking)",JOptionPane.INFORMATION_MESSAGE);
           
       
    }
    
    
    public void Almacenar(int[] ps){
            for(int j=0;j<ps.length;j++){
                sol[w][j]=ps[j];
            }
            w++;
    }    

    public int[][] getSol() {
        return sol;
    }
    
    
    
    
    
}
