/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author Pregrado
 */
public class Empresa {
  private Empleado empleados[];
  private final int NUMERO_EMPLEADOS=20;
  private int intercambios=0;
  private int comparaciones=0;
  
  
  
  public Empresa(){
  
        int codigos[]={204,305,105,204,415,106,500,100,540,420,100,215,340,180,600,312,147,165,510,601};
        String nombre[]={"Juan","Ana","Rosa","Carlos","Raul","Pedro","Rosario","Martha","Saul","Karen","Rosa","Fracis","Ricardo","Luis","Damaris","Diana",
         "Pablo","Marcelo","Carolina","Ingrid"};
        float sueldos[]={1500,800,2000,550,1200,3500,1800,900,750,4000,750,1500,1200,3500,4000,1800,950,1400,600,5500};
        empleados = new Empleado[NUMERO_EMPLEADOS];
        for(int i=0; i<empleados.length ; i++){
        empleados[i]=new Empleado(codigos[i], nombre[i],sueldos[i]);

        }
  
   }
  
  
   public int  getCodigoDelEmpleado(int i){
  return empleados[i].getCodigoDelEmpleado();
  }
   
   public void setCodigoDelEmpleado(int codigo, int i){
   empleados[i].setCodigoDelEmpleado(codigo);
   }
   public String getNombreDelEmpleado(int i){
   return empleados[i].getNombreDelEmpleado();
   }
   
   public void setNombreDelEmpledo(String nombre,int i){
   empleados[i].setNombreDelEmpleado(nombre);
   }
   
   public float getSueldoDelEmpleado(int i){
   return empleados[i].getSueldoDelEmpleado();
   }
   
   public  void setSueldpDelEmpleado(float sueldo,int i){
   empleados[i].setSueldoDelEmpleado(sueldo);
   }
   
   public int getNumeroDeEmpleados(){
   return NUMERO_EMPLEADOS;
   }
  
   
   public  int getIntercambios(){
   return intercambios;
   }
   
   
   public  int getComparaciones(){
   return comparaciones;
   }
   
  public void OrdenBurbuja(){
  
     Empleado temp = new Empleado(0,"", 0);
     comparaciones =0;
     intercambios =0;
     
     for(int i=1; i<empleados.length; i++)
         for(int j=empleados.length-1; j>=i;j--){
         comparaciones++;
         if( empleados[j-1].getCodigoDelEmpleado()>empleados[j].getCodigoDelEmpleado()){
         
         temp.setCodigoDelEmpleado(empleados[j-1].getCodigoDelEmpleado());
         empleados[j-1].setCodigoDelEmpleado(empleados[j].getCodigoDelEmpleado());
         empleados[j].setCodigoDelEmpleado(temp.getCodigoDelEmpleado());
         temp.setNombreDelEmpleado(empleados[j-1].getNombreDelEmpleado());
         empleados[j-1].setNombreDelEmpleado(empleados[j].getNombreDelEmpleado());
         empleados[j].setNombreDelEmpleado(temp.getNombreDelEmpleado());
         
         temp.setSueldoDelEmpleado(empleados[j-1].getSueldoDelEmpleado());
         empleados[j-1].setSueldoDelEmpleado(empleados[j].getSueldoDelEmpleado());
         empleados[j].setSueldoDelEmpleado(temp.getSueldoDelEmpleado());
         intercambios++;
         }
         }  }
  
  
  public  void OrdenInsercionDirecta(){
  Empleado temp = new Empleado(0,"",0);
  comparaciones=0;
  intercambios=0;
   int k;
   
   for(int i=1;i<empleados.length;i++){
   comparaciones++;
    temp.setCodigoDelEmpleado(empleados[i].getCodigoDelEmpleado());
    temp.setNombreDelEmpleado(empleados[i].getNombreDelEmpleado());
    temp.setSueldoDelEmpleado(empleados[i].getSueldoDelEmpleado());
    
    k =i-1;
    
    while(k>=0 && temp.getCodigoDelEmpleado() < empleados[k].getCodigoDelEmpleado()){
    empleados[k+1].setCodigoDelEmpleado(empleados[k].getCodigoDelEmpleado());
    empleados[k+1].setNombreDelEmpleado(empleados[k].getNombreDelEmpleado());
    empleados[k+1].setSueldoDelEmpleado(empleados[k].getSueldoDelEmpleado());
    k--;
    
    intercambios ++;
    }

    empleados[k+1].setCodigoDelEmpleado(temp.getCodigoDelEmpleado());
    empleados[k+1].setNombreDelEmpleado(temp.getNombreDelEmpleado());
    empleados[k+1].setSueldoDelEmpleado(temp.getSueldoDelEmpleado());
    }
         }
  
    public void quicksort(int izq,int der) {
        Empleado temp = new Empleado(0, "",0);
        Empleado pivote=empleados[izq]; 
        int i=izq; 
        int j=der;
        Empleado aux;

        while(i<j){
            comparaciones++;
            while(empleados[i].getCodigoDelEmpleado() <=pivote.getCodigoDelEmpleado() && i<j) i++; 
            while(empleados[j].getCodigoDelEmpleado() >pivote.getCodigoDelEmpleado()) j--;        
            if (i<j) {                                          
                aux= empleados[i]; 
                empleados[i] =empleados[j];
                empleados[j]=aux;
                intercambios++;
            }
        }
        empleados[izq]=empleados[j]; 
        empleados[j]=pivote;
        if(izq<j-1)
            quicksort(izq,j-1);
        if(j+1 <der)
            quicksort(j+1,der);
    }
    
    
    public int busquedaBinaria( int dato){
        int n = empleados.length;
        int centro,inf=0,sup=n-1;
         while(inf<=sup){
            centro=(sup+inf)/2;
            if(dato == empleados[centro].getCodigoDelEmpleado()) 
                return centro;
            else if(dato < empleados[centro].getCodigoDelEmpleado() ){
                sup=centro-1;
            }
            else {
                inf=centro+1;
            }
        }
        return -1;
    }
   
}
