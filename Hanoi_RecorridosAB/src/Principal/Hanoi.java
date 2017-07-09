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
    public class Hanoi {
        String cad ="" ;
        public void TorresHanoi(int numdis, int origen,  int auxiliar, int destino){
            
            if(numdis==1){
                cad = cad+"Mover disco de   "+ origen + "  a  " + destino+"\n";
            }else{
               TorresHanoi(numdis-1, origen, destino, auxiliar);
               cad = cad+"Mover disco de   "+ origen + "  a  " + destino+"\n";
               TorresHanoi(numdis-1, auxiliar, origen, destino);
            }
        }
        
        public String getCadena(){
            return cad ;
        }
        
        public long numMov(int n){
            long mov=1;
            for(int i=0;i<n;i++)
                mov=mov*2;
            mov=mov-1;
            return mov;
        }
    }
