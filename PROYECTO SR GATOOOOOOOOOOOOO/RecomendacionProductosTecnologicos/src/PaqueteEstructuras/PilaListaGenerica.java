
package PaqueteEstructuras;



public class PilaListaGenerica<T> {
    private Nodo<T> cima;
    
    private static class Nodo<T> {
        
        private final T dato;
        private Nodo<T> siguiente;
        
        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    //Constructor inicializa cima en null
    public PilaListaGenerica() {
        cima = null;
    }

    public T getDatoCima() {
        return cima.dato;
    }
    public boolean estaVacia() {
        return (cima == null);
    }
    public void insertarDato(T dato) {
        Nodo<T> nodo = new Nodo<>(dato);
        nodo.siguiente = cima;
        cima = nodo;
    }
    
    public void sacarDato() {
        if (!estaVacia()) 
            cima = cima.siguiente;
    }
}
