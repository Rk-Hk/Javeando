
package PaqueteEstructuras;



public class VectorGenerico<T> {
    private T arreglo[];
    private int indice;
    private int MaxElem;
    
    public VectorGenerico(){
        this.MaxElem=30;
        this.arreglo = (T[]) new Object[MaxElem];
        this.indice=-1;
    }
    
    public int size(){
        return indice;
    }
    
    public T getDato(int indice){
        return arreglo[indice];
    }
    
    public void Mostrar(){
        if(indice>0){
            for(int i=0;i<indice;i++){
                System.out.println(i+1+" : "+ getDato(i));
            }
        }else
            System.out.println("EL vector esta vacio!!");
    }
    
    public void Insertar(T dato){
        if(indice<MaxElem){
            indice++;
            arreglo[indice]=dato;
        }else
            System.out.println("El vector esta lleno !!");
    }
    
    public void EliminarPosi(int posi){
        if(posi>0 && posi<indice){
            while(posi<indice){
                arreglo[posi]=arreglo[posi+1];
                posi++;
            }
            indice=indice-1;
        }else
            System.out.println("la posicion esta fuera del rango!!");
    }
    
    public void InsertarPosi(int posi,T Dato){
        int indi=indice;
        indi=indi+1;
        if(indi<MaxElem && posi<indice){
            indice=indice+1;
            while(posi<indice){
                arreglo[indi]=arreglo[indi-1];
                indi--;
            }
            arreglo[posi]=Dato;
        }else
            System.out.println("ERROR !!, posicion fuera de rango");
    }
    
    
    
}
