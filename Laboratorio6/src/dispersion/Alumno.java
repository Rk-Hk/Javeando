/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dispersion;

/**
 *
 * @author Pregrado
 */
public class Alumno {
    private String codigoDelAlumno;
    private String nombreDelAlumno;
    private float pensionDelAlumno;

    public Alumno(String codigoDelAlumno, String nombreDelAlumno, float pensionDelAlumno) {
        this.codigoDelAlumno = codigoDelAlumno;
        this.nombreDelAlumno = nombreDelAlumno;
        this.pensionDelAlumno = pensionDelAlumno;
    }

    public String getCodigoDelAlumno() {
        return codigoDelAlumno;
    }

    public void setCodigoDelAlumno(String codigoDelAlumno) {
        this.codigoDelAlumno = codigoDelAlumno;
    }

    public String getNombreDelAlumno() {
        return nombreDelAlumno;
    }

    public void setNombreDelAlumno(String nombreDelAlumno) {
        this.nombreDelAlumno = nombreDelAlumno;
    }

    public float getPensionDelAlumno() {
        return pensionDelAlumno;
    }

    public void setPensionDelAlumno(float pensionDelAlumno) {
        this.pensionDelAlumno = pensionDelAlumno;
    }
    
    
}
