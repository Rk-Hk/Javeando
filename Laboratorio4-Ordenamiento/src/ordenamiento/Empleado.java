
package ordenamiento;

/**
 *
 * @author Pregrado
 */
public class Empleado {
    
    
    private int codigoDelEmpleado;
    private String  nombreDelEmpleado;
    private float  sueldoDelEmpleado;

    public Empleado(int codigoDelEmpleado, String nombreDelEmpleado, float sueldoDelEmpleado) {
        this.codigoDelEmpleado = codigoDelEmpleado;
        this.nombreDelEmpleado = nombreDelEmpleado;
        this.sueldoDelEmpleado = sueldoDelEmpleado;
    }

    public int getCodigoDelEmpleado() {
        return codigoDelEmpleado;
    }

    public void setCodigoDelEmpleado(int codigoDelEmpleado) {
        this.codigoDelEmpleado = codigoDelEmpleado;
    }

    public String getNombreDelEmpleado() {
        return nombreDelEmpleado;
    }

    public void setNombreDelEmpleado(String nombreDelEmpleado) {
        this.nombreDelEmpleado = nombreDelEmpleado;
    }

    public float getSueldoDelEmpleado() {
        return sueldoDelEmpleado;
    }

    public void setSueldoDelEmpleado(float sueldoDelEmpleado) {
        this.sueldoDelEmpleado = sueldoDelEmpleado;
    }
    
    
    
}
