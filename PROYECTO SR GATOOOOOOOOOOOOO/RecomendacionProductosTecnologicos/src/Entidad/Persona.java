
package Entidad;

//import PaqueteEstructuras.VectorGenerico;
//import java.util.ArrayList;


public class Persona {
    private String password;
    private String user;

    public Persona(String password, String user) {
        this.password = password;
        this.user = user;
    }
    public Persona(){
    }

    // private ArrayList<Producto> Prod_Comprado;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
   
   
    
}
