
package PaqueteEstructuras;





public class ColaListaGenerica<T> {
    private Nodo cima;
    private Nodo ult;
    private int cont;
    public class Nodo<T>{
        
        private T dato;
        private Nodo sgte;
        
        public Nodo(T dato){
            this.dato =dato;
            this.sgte=null;
        }
    }
    
    //Constructor que inicializa en null la cima y el ult
    public ColaListaGenerica(){
        this.cima=null;
        this.ult= null;
        cont=0;
    }

    public int size(){
        return cont;
    }
    
    public boolean Vacio(){
        return (cima==null);
    }
    
    //Accion crea la lista por el final
    public void Insertar(T dato){
        Nodo q = new Nodo(dato);
        q.sgte =null;
        if(Vacio()){
            cima=q;
            ult=q;
            cont++;
        }else{
            ult.sgte =q;
            ult=q;
            cont++;
        }
    }
    
    public T getDato(){
        return (T) cima.dato;
    }
    
    public void SacarDato(){
        if(!Vacio()){
            cima=cima.sgte;
            cont--;
        }
        else
            System.out.println("Cola Vacia");
    }
}
