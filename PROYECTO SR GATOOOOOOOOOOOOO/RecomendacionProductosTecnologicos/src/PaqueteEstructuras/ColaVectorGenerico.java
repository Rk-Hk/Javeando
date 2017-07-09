

package PaqueteEstructuras;




public class ColaVectorGenerico<T> { 
    private final T arreglo[];
    private int base,tope=0;
    private final int MAX_ELEM =50 ;
    
    public ColaVectorGenerico(){
        arreglo = (T[]) new Object[MAX_ELEM];
        this.base=0;
        this.tope=-1;
    }
    
    public void Encola(T dato){
        if(tope+1<MAX_ELEM){
            tope++;
            arreglo[base]=dato;
        }
    }
    
    public T Decolar(){
        return (arreglo[base]);
    }
    
    public T SacarDato(){
        T dato=null;
        if(!Vacio()){
            dato= Decolar();
            base++;
        }
        return dato;
    }
    
    public boolean Vacio(){
        return(tope+1==base);
    }
    
    public int size(){
        return tope;
    }
    
}
