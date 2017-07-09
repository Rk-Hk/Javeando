

package backtracking;

/**
 *
 * @author Pregrado
 */
public class PruebaBacktracking {
    
    
    
    public static void main(String[] args) {
          int[] valores={20,6,5,5,3,1,2};
          int suma =10;
          
          
        Backtraking sumaDda = new Backtraking(valores, suma);
        
        sumaDda.hallarSubconjunto();
        sumaDda.mostrarSolucion();
    }
}
