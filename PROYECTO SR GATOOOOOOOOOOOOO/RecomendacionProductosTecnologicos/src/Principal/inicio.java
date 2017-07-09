

package Principal;
//import Vista.Admin.JframePrincipalAdmin;
//import Vista.Admin.JframeRegistoLaptops;
//import Vista.Inicio;
//import Vista.Usuario.JframeRegistroUsuario;
import VistaCargando.Splash;

public class inicio {
    
    public static void main(String[] args) {
      try{
         
        new Thread(new Splash()).start();
      }catch(Exception e){
      
      }
        
          
         
    }
}
