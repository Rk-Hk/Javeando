package PaquetePuntoCorte;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pregrado
 */
public class Linea {
    private Punto PO;
    private Punto PF;

    public Linea(Punto PO, Punto PF) {
        this.PO = PO;
        this.PF = PF;
    }
    
    

    public Punto getPO() {
        return PO;
    }

    public void setPO(Punto PO) {
        this.PO = PO;
    }

    public Punto getPF() {
        return PF;
    }

    public void setPF(Punto PF) {
        this.PF = PF;
    }
    
    public double longitudSegmento(){
        return Math.sqrt(Math.pow(getPF().getX()-getPO().getX(), 2)+Math.pow(getPF().getY()-getPO().getY(), 2));
    }
    
    public boolean existeInserccion(Linea s){
        double m1 =(PF.getY()-PO.getY())/(PF.getX()-PO.getX());
        double a =m1;
        double b=-1;
        double c=m1*PO.getX()-PO.getY();
        
        double m2 = (s.getPF().getY()-s.getPO().getY())/(s.getPF().getX()-s.getPO().getX());
        
        double d=m2;
        double e = -1;
        double f=m2*s.getPO().getX()-s.getPO().getY();
        double det =a*e-b*d;
        
        if(det!=0){
            return true;
        }
        else
            return false;
        
    }
    
    public Punto puntoInterseccion(Linea s){
        Punto pcorte = new Punto();
        double m1 =(PF.getY()-PO.getY())/(PF.getX()-PO.getX());
        
        double a=m1;
        double b=-1;
        double c =m1*PO.getX()-PO.getY();
        
        double m2 =(s.getPF().getY()-s.getPO().getY())/(s.getPF().getX()-s.getPO().getX());
        
        double d = m2;
        double e =-1;
        double f =m2*s.getPO().getX()-s.getPO().getY();
        double det=a*e-b*d;
        
        if(det!=0){
            pcorte.setX((c*e-b*f)/det);
            pcorte.setY((a*f-c*d)/det);
        }
        return pcorte;
    }
    
}
