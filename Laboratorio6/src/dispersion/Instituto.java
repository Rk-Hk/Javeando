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
public class Instituto {
    private Alumno alumno[];
    private final int TAM_TABLA=20;

    public Instituto() {
        alumno = new Alumno[TAM_TABLA];
        for(int i=0;i<TAM_TABLA;i++){
            alumno[i]= new Alumno("", "", 0);
        }
    }

    public void setCodigoDelAlumno(String codigo,int i){
        alumno[i].setCodigoDelAlumno(codigo);
    }
    
    public String getCogigoDelAlumno(int i){
        return alumno[i].getCodigoDelAlumno();
    }
    
    public void setNombreDelAlumno(String nombre ,int i){
        alumno[i].setNombreDelAlumno(nombre);
    }
    
    public String getNombreDelalumno(int i){
        return alumno[i].getNombreDelAlumno();
    }
    
    public void setPensionDelAlumno(float pension ,int i){
        alumno[i].setPensionDelAlumno(pension);
    }
    
    public float getPencionDelAlumno(int i){
        return alumno[i].getPensionDelAlumno();
    }
    
    public int getNumeroDeAlumnos(){
        return TAM_TABLA;
    }
    
    public int hash(String clave){
        int pos=0;
        for(int i=0;i<clave.length();i++){
            pos=pos+ Character.valueOf(clave.charAt(i));
        }
        return pos%19;
    }
    
    public boolean Insertar(String codigo,String nombre,float pension){
        int pos,pos_sig;
        pos=hash(codigo);
        
        if(getCogigoDelAlumno(pos).equalsIgnoreCase("")){
            setCodigoDelAlumno(codigo, pos);
            setNombreDelAlumno(nombre, pos);
            setPensionDelAlumno(pension, pos);
            return true;
        }else{
            pos_sig=pos+1;
            while(pos_sig<getNumeroDeAlumnos()&& !getCogigoDelAlumno(pos_sig).equalsIgnoreCase("") &&pos_sig!=pos){
                pos_sig++;
                if(pos_sig==getNumeroDeAlumnos())
                    pos_sig=0;
            }
            if(getCogigoDelAlumno(pos_sig).equalsIgnoreCase("")){
                setCodigoDelAlumno(codigo, pos_sig);
                setNombreDelAlumno(nombre, pos_sig);
                setPensionDelAlumno(pension, pos_sig);
                return true;
            }else
                return false;
        }
    }
    
    public int Buscar(String codigo){
        int pos,pos_sig;
        pos=hash(codigo);
        if(getCogigoDelAlumno(pos).equalsIgnoreCase(codigo))
            return pos;
        else{
            pos_sig=pos+1;
            while(pos_sig<getNumeroDeAlumnos() && !getCogigoDelAlumno(pos_sig).equalsIgnoreCase("") && pos_sig!=pos && !getCogigoDelAlumno(pos).equalsIgnoreCase(codigo)){
                pos_sig++;
                if(pos_sig==getNumeroDeAlumnos())
                    pos_sig=0;
            }
            if(getCogigoDelAlumno(pos_sig).equalsIgnoreCase("") || pos_sig==pos)
                return -1;
            else
                return pos_sig;
        }
    }
}
