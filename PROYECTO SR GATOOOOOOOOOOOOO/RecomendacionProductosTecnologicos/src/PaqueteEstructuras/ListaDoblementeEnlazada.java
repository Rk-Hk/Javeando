
package PaqueteEstructuras;


public class ListaDoblementeEnlazada<T> {
    
    private Nodo cab;
    
    class Nodo<T> {
        private T info;
        private Nodo ant;
        private Nodo sig;
        
        public Nodo(){
            this.ant=null;
            this.sig=null;
        }
    }
    
    public ListaDoblementeEnlazada () {
        cab=null;
    }
    
    public int cantidad ()    //Metodo que retorna el tamaño de la lista.
    {
        int cant = 0;
        Nodo reco = cab;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }
    
    public void ingresar (T dato){
        Nodo nuevo = new Nodo();
        nuevo.info=dato;
        
        if(vacia()){
            cab=nuevo;
        }else{
            Nodo q = cab;
            while (q.sig!=null){
                q=q.sig;
            }
            q.sig=nuevo;
            nuevo.ant=q;
        }
        
    }
      
    public void insertar (int pos, T dato)
    {
        
        if (pos <= cantidad() + 1)    {
            Nodo nuevo = new Nodo ();
            nuevo.info = dato;
            if (pos == 1){        // si posicion es el primero
                nuevo.sig = cab;
                if (cab!=null)
                    cab.ant=nuevo;
                cab = nuevo;
            } else
                if (pos == cantidad() + 1){   // si la posicion es ultimo
                    Nodo q = cab;
                    while (q.sig != null){
                        q = q.sig;
                    }
                    q.sig = nuevo;
                    nuevo.ant=q;
                    nuevo.sig = null;
                } else {
                    Nodo p = cab;
                    for (int f = 1 ; f <= pos - 2 ; f++)
                        p = p.sig;
                    Nodo siguiente = p.sig;
                    p.sig = nuevo;
                    nuevo.ant=p;
                    nuevo.sig = siguiente;
                    siguiente.ant=nuevo;
                }
        }
    }

    public T extraer (int pos) throws IllegalArgumentException{
        if (pos <= cantidad ())    {
            T informacion;
            if (pos == 1) {
                informacion = (T) cab.info;
                cab = cab.sig;
                if (cab!=null)
                    cab.ant=null;
            } else {
                Nodo reco;
                reco = cab;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                Nodo prox = reco.sig;
                reco.sig = prox.sig;
                Nodo siguiente=prox.sig;
                if (siguiente!=null)
                    siguiente.ant=reco;
                informacion = (T) prox.info;
            }
            return informacion;
        }
        else
            throw new IllegalArgumentException("La posision exede al numero de nodos");
    }

    public void borrar (int pos)
    {
        if (pos <= cantidad ())    {
            if (pos == 1) {
                cab = cab.sig;
                if (cab!=null)
                    cab.ant=null;
            } else {
                Nodo reco;
                reco = cab;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                Nodo prox = reco.sig;
                prox=prox.sig;
                reco.sig = prox;
                if (prox!=null)
                    prox.ant=reco;
            }
        }
    }
    
    public void intercambiar (int pos1, int pos2) {
        if (pos1 <= cantidad () && pos2 <= cantidad ())    {
            Nodo reco1 = cab;
            for (int f = 1 ; f < pos1 ; f++)
                reco1 = reco1.sig;
            Nodo reco2 = cab;
            for (int f = 1 ; f < pos2 ; f++)
                reco2 = reco2.sig;
            T aux = (T) reco1.info;
            reco1.info = reco2.info;
            reco2.info = aux;
        }
    }
    
    
    public boolean existe(T x) {
        Nodo reco=cab;
        while (reco!=null) {
            if (reco.info==x)
                return true;
            reco=reco.sig;
        }
        return false;
    }
    
    public boolean vacia ()
    {
        return(cab==null);
    }
    
    public void imprimir ()
    {
        Nodo reco = cab;
        while (reco != null) {
            System.out.print (reco.info + "-");
            reco = reco.sig;
        }
        System.out.println();
    }
     /*   
    public static void main(String[] ar) {
        ListaDoblementeEnlazada lg=new ListaDoblementeEnlazada();
        lg.ingresar(34);
        lg.insertar (5, 10);
        lg.insertar (3, 20);
        lg.insertar (2, 30);
        lg.insertar (2, 15);
        lg.insertar (1, 115);
        lg.imprimir ();
        System.out.println ("Luego de Borrar el primero");
        lg.borrar (1);
        lg.imprimir ();
        System.out.println ("Luego de Extraer el segundo");
        lg.extraer (2);
        lg.imprimir ();
        System.out.println ("Luego de Intercambiar el primero con el tercero");
        lg.intercambiar (1, 3);
        lg.imprimir ();
        if (lg.existe(10)) 
            System.out.println("Se encuentra el 20 en la lista");
        else
            System.out.println("No se encuentra el 20 en la lista");
                
    }*/
}