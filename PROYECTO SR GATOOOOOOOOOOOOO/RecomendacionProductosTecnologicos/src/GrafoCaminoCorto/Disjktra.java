/*
 * Autor: RICARDITO

*/

package GrafoCaminoCorto;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Disjktra {
    Grafo grafo;
    ListaNodoDisjktra listaNodosAdyacentes;
    ArrayList<Arista> aux = new ArrayList<Arista>();
    private int longi;
    private int peso=0;
    
    public Disjktra(Grafo grafo){
        this.grafo = grafo;
        listaNodosAdyacentes = new ListaNodoDisjktra();
        this.longi=0;
    }
    private void llenarConAdyacentes(Nodo nodo){
        if(nodo != null){
            ArrayList<Enlace> listaAux = nodo.getListaNodoAdyacente();
            if(listaAux != null){
                for(Enlace enlace:listaAux){
                    Nodo aux2 = enlace.getNodo();
                    if(!aux2.isMarca()){

                        if(listaNodosAdyacentes.isContenido(aux2)){
                            int longitud = nodo.getLongitudCamino() + enlace.getArista().getPeso();
                            longi = longitud;
                            if(aux2.getLongitudCamino() > longitud){
                                aux2.setLongitudCamino(longitud);
                                aux2.setNodoAntecesorDisjktra(nodo);
                            }
                        }else{
                            aux2.setLongitudCamino(nodo.getLongitudCamino() + enlace.getArista().getPeso());
                            aux2.setNodoAntecesorDisjktra(nodo);
                            listaNodosAdyacentes.add(aux2);
                        }

                    }
                }
            }
        }
    }
    
    public int getLong(){
        return longi;
    }
    
    
    public void ejecutar(Nodo nodoInicio){
        nodoInicio.setLongitudCamino(0);
        if(nodoInicio != null){
            listaNodosAdyacentes = new ListaNodoDisjktra();
            listaNodosAdyacentes.add(nodoInicio);
//            System.out.println("nodoini "+nodoInicio.getLongitudCamino());
            while(!listaNodosAdyacentes.isEmpty()){
                Nodo menor = listaNodosAdyacentes.buscarMenor();
                menor.setMarca(true);
                listaNodosAdyacentes.remove(menor);
                llenarConAdyacentes(menor);
            }
        }
    }
    
    public void rutaCorta(Nodo nodoFinal){
    aux.clear();
    Nodo nAux = nodoFinal;
    while(nAux.getNodoAntecesorDisjktra() != null){
        peso=peso+grafo.getArista(nAux,nAux.getNodoAntecesorDisjktra()).getPeso();
        aux.add(grafo.getArista(nAux,
                nAux.getNodoAntecesorDisjktra()));
        
        nAux = nAux.getNodoAntecesorDisjktra();
        
    }
    System.out.println("peso  "+getPeso());
}
    public int getPeso(){
        return peso;
    }
    public void setPeso(int peso){
        this.peso=peso;
    }
    
public void marcarRutaCorta(Nodo nodoFinal,Color color){
    if(nodoFinal != null){
        rutaCorta(nodoFinal);
//        System.out.println("peso  "+getPeso());
            for(int i = 0;i < aux.size();i++){
                if(!aux.isEmpty()){
                    aux.get(i).getLineaQuebrada().setColor(color);
                    aux.get(i).getLineaQuebrada().setGrosorLinea(4);
                }
            }
            setPeso(0);
    }
}

}
