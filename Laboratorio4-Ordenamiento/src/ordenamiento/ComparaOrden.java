
package ordenamiento;

/**
 *
 * @author Pregrado
 */
public class ComparaOrden {
    
    public static void main(String[] args) {
        Empresa miEmpresa1 = new Empresa();
        Empresa miEmpresa2 = new Empresa();
        Empresa miEmpresa3 = new Empresa();
        Empresa miEmpresa4 = new Empresa();
        Empresa miEmpresa5 = new Empresa();
        
        System.out.println("\n Metodo de QuickSort");
        System.out.println("-----------------------");
        
        miEmpresa3.quicksort(0, 19);
        for(int i=0; i<miEmpresa3.getNumeroDeEmpleados(); i++){
        
            System.out.printf("%10d%10s%10.2f \n",miEmpresa3.getCodigoDelEmpleado(i), miEmpresa3.getNombreDelEmpleado(i),
            miEmpresa3.getSueldoDelEmpleado(i));
            }
        
        System.out.println("\n Metodo de la Burbuja");
        System.out.println("-----------------------");
        
        miEmpresa1.OrdenBurbuja();
        
        for(int i=0; i<miEmpresa1.getNumeroDeEmpleados(); i++){
        
            System.out.printf("%10d%10s%10.2f \n",miEmpresa1.getCodigoDelEmpleado(i), miEmpresa1.getNombreDelEmpleado(i),
            miEmpresa1.getSueldoDelEmpleado(i));
            }
        
        System.out.printf("Numero de comparaciones: %d\n",miEmpresa1.getComparaciones());
        System.out.printf("Numero de Intercambios: %d\n",miEmpresa1.getIntercambios());
        
        System.out.println("\nMetodo Insercion directa");
        System.out.println("--------------------------");
        
        miEmpresa2.OrdenInsercionDirecta();
        
        System.out.println();
        
        for(int i=0 ; i<miEmpresa2.getNumeroDeEmpleados();i++){
            System.out.printf("%10d%10s%10.2f\n",        miEmpresa2.getCodigoDelEmpleado(i),
            miEmpresa2.getNombreDelEmpleado(i),
            miEmpresa2.getSueldoDelEmpleado(i));
            
        }
        System.out.printf("Numero de comparaciones: %d\n",miEmpresa2.getComparaciones());
        System.out.printf("Numero de Intercambios: %d\n",miEmpresa2.getIntercambios());
        
     
        System.out.println("\nMetodo busqueda binaria");
        System.out.println("--------------------------");
        
        miEmpresa5.OrdenBurbuja();
        System.out.println(miEmpresa5.busquedaBinaria(106));
        System.out.println(miEmpresa5.busquedaBinaria(1060));
    }
    
    
    
}
