
package Algoritmica3;
import ConexionMysql.Dao;
import Entidad.Complementos;
import Entidad.Impresora;
import Entidad.Laptop;
import Entidad.Pc;
import Entidad.Producto;
import Entidad.Tablet;
import PaqueteEstructuras.abb;
import java.util.ArrayList;
import javax.swing.JOptionPane;

 public  class Backtraking {
    
     private int s[];
     private  int v[];
    private int tact;
    private int  p;
    private  int sol[][];
    private Producto sol2[][];
     private int w;
     private int solucion=0;

    public int[] getS() {
        return s;
    }

    public void setS(int[] s) {
        this.s = s;
    }

    public int  getV(int i) {
        return v[i];
    }
  public int[]  getV() {
        return v;
    }
    public void setV(int[] v) {
        this.v = v;
    }

    public int getTact() {
        return tact;
    }

    public void setTact(int tact) {
        this.tact = tact;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

      public int getSolucion() {
        return solucion;
    }

    public void setSolucion(int solucion) {
        this.solucion = solucion;
    }

    public int[][] getSol() {
        return sol;
    }
    
    
    

    public Backtraking(ArrayList<Producto> valores,int suma) {
        Producto producto;
        v= new int[valores.size()];
        s= new int[valores.size()];
        sol= new int[valores.size()][valores.size()];
        sol2= new Producto[valores.size()][valores.size()];
        for(int i=0; i<valores.size();i++){
             producto = valores.get(i);
           v[i]= (int)producto.getPrecio();
        }
        
        tact =0;
        p=suma;
        w=0;
    }
    
    public void hallarSubconjunto(){
        int nivel=0;
        boolean fin = false;
//        
        for(int i=0;i<s.length;i++){
            s[i]=-1;}
        
        do{
                    generar(nivel);
                    if(solucion(nivel,p)){
                        solucion++;
                        Almacenar(s);
                    }
                    if(criterio(nivel,p))
                        nivel++;
                                    else{

                                        while(!masHermanos(nivel) && nivel>0)
                                          {
                                            nivel=retroceder(nivel);
                                           }
                                       }

        }while(nivel>0);
    }
    
    public void generar(int nivel){
        s[nivel]=s[nivel]+1;
        if(s[nivel]==1)
            tact=tact+v[nivel];
    }
    
    public boolean solucion(int nivel ,int p){
        int n=s.length;
        return (nivel==n-1 && tact==p);
    }
    
    public  boolean criterio(int nivel,int p){
        int n =s.length;
        return (nivel<n-1 && tact<=p);
    }
    
    public boolean masHermanos(int nivel){
        return (s[nivel]<1);
    }
    
    public int retroceder(int nivel){
        tact-=v[nivel]*s[nivel];
        s[nivel]=-1;
        nivel--;
        return nivel;
    }
    
   
    
    
    
    public  void Almacenar(int[] ps){
            for(int j=0;j<ps.length;j++){
                sol[w][j]=ps[j];
            }
            w++;
    }    

    public int getSol(int i, int j) {
        return sol[i][j];
    }

    
     public static  ArrayList<Producto> LlenandoArbol2(){
         abb ab = new abb();
         ArrayList<Producto> Lista=new ArrayList<>();
         ArrayList<Laptop> lsLap = Dao.getDaoLaptop().ListarLaptop();
         ArrayList<Impresora> lsImpresora = Dao.getDaoImpresora().ListarImpresoras();
         ArrayList<Tablet> lsTap = Dao.getDaoTablet().ListarTablet();
         ArrayList<Pc> lsPc = Dao.getDaoPc().ListarPc();
         ArrayList<Complementos> lsComplementos = Dao.getDaoComple().ListarComplementos();
         
         
        if(lsLap!=null && lsTap !=null && lsPc!=null && lsComplementos!= null && lsImpresora!=null){
        int i=0,j=0;
        while(i<lsLap.size()){
            ab.insertar(lsLap.get(i));
            i++;
        }
        while(j<lsTap.size()){
            ab.insertar(lsTap.get(j));
            j++;
        }
        j=0;
        while(j<lsPc.size()){
            ab.insertar(lsPc.get(j));
            j++;
        }
        j=0;
        while(j<lsComplementos.size()){
            ab.insertar(lsComplementos.get(j));
            j++;
        }
        j=0;
        while(j<lsImpresora.size()){
            ab.insertar(lsImpresora.get(j));
            j++;
        }
        ab.imprimirDescend();
        //obtiene el arraylist creao anteriormente
        Lista=ab.retornar();
      
    }
         
        return Lista;
        
    }
     
     
        
    public  void mostrarSolucion(){
        System.out.println("solucion = "+solucion);
        String mensaje = "";
        mensaje = "Valores: \n {";
            for(int i=0;i<v.length; i++){
                mensaje+=v[i];
                if(i<v.length -1)
                    mensaje+=",";
                else 
                    mensaje +="}";

            }
        mensaje += "\n\n Solucion de bactracking:\n{";
        
        for(int i=0;i<solucion;i++){
            for(int j=0;j<s.length;j++){
                mensaje +=sol[i][j];
                if(i<s.length-1)
                    mensaje +=",";
                else
                    mensaje +="}";
            }
            mensaje+="\n";
        }
         if(solucion==0){
             mensaje="no solucion";
         }else{
          mensaje +="\n\n Sub conjunto cuya suma es "+p+ ":\n {"; 
         
           for(int i=0; i<solucion;i++){
               for(int j=0;j<s.length;j++)
                    if(sol[i][j]==1){   
                        mensaje+=v[j];
                        if(i<s.length-1)
                            mensaje+=",";
                        else
                            mensaje+="}\n";
                   
                    }
               mensaje+="\n";
            }
               
        }
           JOptionPane.showMessageDialog(null, mensaje,"Algoritmos  de retroceso(Backtracking)",JOptionPane.INFORMATION_MESSAGE);
             
    }
    
    
    
}
