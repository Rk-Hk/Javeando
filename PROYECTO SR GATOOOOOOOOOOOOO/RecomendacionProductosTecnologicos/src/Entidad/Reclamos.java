/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

import java.io.Serializable;


public class Reclamos implements Serializable{
    private String razon;
    private String fecha;
    private String sujerencia;
    private int dni;

    public Reclamos() {
    }

    public Reclamos(int dni,String razon, String fecha, String sujerencia) {
        this.dni=dni;
        this.razon = razon;
        this.fecha = fecha;
        this.sujerencia = sujerencia;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSujerencia() {
        return sujerencia;
    }

    public void setSujerencia(String sujerencia) {
        this.sujerencia = sujerencia;
    }
    
    
    
}
