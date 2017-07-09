/*
 * Autor: RICARDITO
 */
package GrafoCaminoCorto;

import java.util.ArrayList;

public class ListaNodoDisjktra extends ArrayList<Nodo>{

    public ListaNodoDisjktra(){
        super();
    }
    public Nodo buscarMenor(){
        Nodo aux = new Nodo();
        aux.setLongitudCamino(9999999);

        for(Nodo nodo:this){
            if(nodo.getLongitudCamino() < aux.getLongitudCamino()){
                aux = nodo;                
            }
        }

        return aux;
    }
    public boolean isContenido(Nodo nodo){
        boolean retornado = false;
        for(Nodo n:this){
            if(n == nodo){
                retornado = true;
            }
        }
        return retornado;
    }
}