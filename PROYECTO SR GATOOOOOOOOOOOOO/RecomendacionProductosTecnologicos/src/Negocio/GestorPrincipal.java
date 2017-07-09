
package Negocio;

/**
 *
 * @author nelsoncuenta
 */
public class GestorPrincipal {
    private static GestorCompra gestorCompra;
    private static GestorProducto gestorProducto;
    private static GestorUsuario gestorUsuario;
    private static GestorAdmin gestorAdmin;
    private static GestorLaptop gestorLaptop;
    private static GestorImpresora gestorImpresora;
    private static GestorPc gestorPc;
    private static GestorTablet gestorTablet;
    private static GestorComplementos gestorComple;
    
    
     static {
    gestorAdmin=new GestorAdmin();
    gestorCompra=new GestorCompra();
    gestorProducto=new GestorProducto();
    gestorUsuario=new GestorUsuario();
     gestorLaptop = new GestorLaptop();
    gestorImpresora = new GestorImpresora();
    gestorPc=new GestorPc();
    gestorTablet=new GestorTablet();
    gestorComple = new GestorComplementos();
    }
     
     public static GestorComplementos getGestorComple(){
         return gestorComple;
     }


    public static GestorImpresora getGestorImpresora() {
        return gestorImpresora;
    }

    public static GestorLaptop getGestorLaptop() {
        return gestorLaptop;
    }
     

    public static GestorCompra getGestorCompra() {
        return gestorCompra;
    }

    public static GestorProducto getGestorProducto() {
        return gestorProducto;
    }

    public static GestorUsuario getGestorUsuario() {
        return gestorUsuario;
    }

    public static GestorAdmin getGestorAdmin() {
        return gestorAdmin;
    }

    public static GestorPc getGestorPc() {
        return gestorPc;
    }

    public static GestorTablet getGestorTablet() {
        return gestorTablet;
    }
    
    
}
