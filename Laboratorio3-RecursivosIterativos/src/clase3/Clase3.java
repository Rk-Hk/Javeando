

package clase3;

import java.util.Scanner;


public class Clase3 {
    
    /********************** METODOS RECURCIVOS ******************/
    
    public int factorial_Recurcivo(int n){
        int f=0;
        if(n>=0){
            if(n==0||n==1){
               f=1;
            }
            else{
                f=n*factorial_Recurcivo(n-1);
            }    
        }
        return f;   
    }
    
    public int mcd_Recurcivo(int n,int m){
        int max=-1;
        if(m==n){
            max=n;
        }
        else{if(n>m)
            max=mcd_Recurcivo(n-m,m);
            else{max=mcd_Recurcivo(n,m-n);
            
            }
        }
        
      return max;  
    }
    
    public int fibonacci_Recurcivo(int n){
        int fibon=-1;
        if(n>=0){
            if(n<=1){
                fibon=n;   
            }
            else{fibon=fibonacci_Recurcivo(n-1)+fibonacci_Recurcivo(n-2);
                
            }
        }
       return fibon; 
    }
    
    
    public void bBinaria_Recurcivo(int[] a,int prim,int u,int valor){
        int ind=-1;
        if(prim>u){
            System.out.println("no se ha encontrado");
        }
        else{
            ind=(prim+u)/2;
            if(valor==a[ind]){
                System.out.println("encontrado en el indice : " +ind); 
            }
            else{
                if(valor<a[ind]){
                    bBinaria_Recurcivo(a,prim,ind -1, valor);
                }
                else{
                    bBinaria_Recurcivo(a, ind +1, u, valor);
                }
            }
        }
        
    }
    
    /*******************   METODOS ITERATIVOS *********************/
    
    public int factorial_Iterativo(int num){
        int fact=1;
        for(int i=1;i<=num;i++){
            fact=fact*i;
        }
        return fact;
    }
    
    public int fibonaci_Iterativo(int num){
        int fibo=-1;
        int prim=-1;
        int seg=1;
        System.out.print("Secuencia Fibonacci : ");
        if(num>1){
            for(int i=0;i<num;i++){
                fibo=prim+seg;
                System.out.print(fibo+", ");
                prim=seg;
                seg=fibo;
            }
        }
        return fibo;
    }
    
    public int MCD_Iterativo(int n1,int n2){
        int num=-1;
        if(n1==n2){
            num=n1;
        }else{
            if(n1<n2){
                for(int i=1;i<=n1;i++){
                    if(n1%i==0&&n2%i==0){
                    num=i;
                    }
                }   
            }
            else{
                for(int j=1;j<=n2;j++){
                    if(n1%j==0&&n2%j==0){
                        num=j;
                        
                    }
                }
            }
        }
       return num; 
    }
    
    public int bbinario_Iterativo(int  vector[], int dato){
        int n = vector.length;
        int centro,inf=0,sup=n-1;
        while(inf<=sup){
            centro=(sup+inf)/2;
            if(vector[centro]==dato) 
                return centro;
            else {
                if(dato < vector [centro] )
                    sup=centro-1;
            
                else 
                  inf=centro+1;
            }
        }
        return -1;
   }
    
    
    public void menu1(){
        long ti,tf;
        Clase3 c=new Clase3();
        Scanner scan = new Scanner(System.in);
        int[] a={2,5,7,11,15,18}; 
        int op=0,dato,dato2;
        
        do{ System.out.println("\n\n\n**************************");
            System.out.println("***  MENU  RECURCIVO  ****");
            System.out.println("**************************\n");
            System.out.println("1. Factorial de un numero");
            System.out.println("2. Maximo Comun Divisor");
            System.out.println("3. Fibonacci");
            System.out.println("4. Busqueda Binaria");
            System.out.println("5. salir");
            System.out.println("**************************\n");
                System.out.print("Seleccione una opcion : ");
                op=scan.nextInt();
                
                ti=0;tf=0;
                
                
        switch(op){
            case 1: 
                    do{
                        System.out.print("Ingrese un numero >=0 :");
                        dato=scan.nextInt();
                    }while(dato<0);
                    System.out.println("--------------------------------");
                    ti=System.currentTimeMillis();
                    System.out.println("-> El Factorial de "+dato+" es: "+c.factorial_Recurcivo(dato));
                    tf=System.currentTimeMillis()-ti;
                    System.out.println("Tiempo de compilacion : "+tf);
                    System.out.println("--------------------------------");break;
            case 2: 
                    do{
                        System.out.print("Ingrese 1° numero>0 :");
                        dato=scan.nextInt();
                    }while(dato<0);
                    
                    do{
                        System.out.print("Ingrese 2° numero>0 :");
                        dato2=scan.nextInt();
                    }while(dato2<0);
                    System.out.println("-----------------------------------------");
                    ti=System.currentTimeMillis();
                    System.out.println("El MCD de "+dato+" y "+dato2+" es : "+c.mcd_Recurcivo(dato,dato2));
                    tf=System.currentTimeMillis()-ti;
                    System.out.println("Tiempo de compilacion : "+tf);
                    System.out.println("-----------------------------------------");break;
            case 3: 
                    do{
                        System.out.print("Ingrese un numero>0 :");
                        dato=scan.nextInt();
                    }while(dato<0);
                    System.out.println("----------------------------------------------");
                    ti=System.currentTimeMillis();
                    System.out.println("El fibonacci de posision "+dato+" es : "+c.fibonacci_Recurcivo(dato));
                    tf=System.currentTimeMillis()-ti;
                    System.out.println("Tiempo de compilacion : "+tf);
                    System.out.println("\n--------------------------------------------");
                    break;
            case 4: System.out.print("Ingrese un numero :");
                    dato=scan.nextInt();
                    System.out.println("----------------------------------------------");
                    ti=System.currentTimeMillis();
                    if(c.bbinario_Iterativo(a, dato)==-1)
                        System.out.println("No se ah encontrado el numero");
                    else
                        c.bBinaria_Recurcivo(a,0,8, dato);
                    tf=System.currentTimeMillis()-ti;
                    System.out.println("Tiempo de compilacion : "+tf);
                    System.out.println("\n--------------------------------------------");
                    
                    break;
            case 5:System.out.println("Gracias Por su Preferencia !!!");break;
        }
        
        }while(op!=5);
    }
    
    public void menu2(){
        
        long ti,tf;
        Clase3 c=new Clase3();
        Scanner scan = new Scanner(System.in);
        int[] a={2,5,7,11,15,18}; 
        int op=0,dato,dato2;
        
        do{ System.out.println("\n\n\n**************************");
            System.out.println("***  MENU  ITERATIVO  ****");
            System.out.println("**************************\n");
            System.out.println("1. Factorial de un numero");
            System.out.println("2. Maximo Comun Divisor");
            System.out.println("3. Fibonacci");
            System.out.println("4. Busqueda Binaria");
            System.out.println("5. salir");
            System.out.println("**************************\n");
                System.out.print("Seleccione una opcion : ");
                op=scan.nextInt();
                
                ti=0;tf=0;
                
        switch(op){
            case 1: 
                    do{
                        System.out.print("Ingrese un numero >=0 :");
                        dato=scan.nextInt();
                    }while(dato<0);
                    System.out.println("--------------------------------");
                    ti=System.currentTimeMillis();
                    System.out.println("-> El Factorial de "+dato+" es: "+c.factorial_Iterativo(dato));
                    tf=System.currentTimeMillis()-ti;
                    System.out.println("Tiempo de compilacion : "+tf);
                    System.out.println("--------------------------------");break;
            case 2: 
                    do{
                        System.out.print("Ingrese 1° numero>0 :");
                        dato=scan.nextInt();
                    }while(dato<0);
                    
                    do{
                        System.out.print("Ingrese 2° numero>0 :");
                        dato2=scan.nextInt();
                    }while(dato2<0);
                    System.out.println("-----------------------------------------");
                    ti=System.currentTimeMillis();
                    System.out.println("El MCD de "+dato+" y "+dato2+" es : "+c.MCD_Iterativo(dato,dato2));
                    tf=System.currentTimeMillis()-ti;
                    System.out.println("Tiempo de compilacion : "+tf);
                    System.out.println("-----------------------------------------");break;
            case 3: 
                    do{
                        System.out.print("Ingrese un numero>0 :");
                        dato=scan.nextInt();
                    }while(dato<0);
                    System.out.println("----------------------------------------------");
                    ti=System.currentTimeMillis();
                    c.fibonaci_Iterativo(dato);
                    tf=System.currentTimeMillis()-ti;
                    System.out.println("Tiempo de compilacion : "+tf);
                    System.out.println("\n--------------------------------------------");
                    break;
            case 4: System.out.print("Ingrese un numero :");
                    dato=scan.nextInt();
                    System.out.println("----------------------------------------------");
                    ti=System.currentTimeMillis();
                    if(c.bbinario_Iterativo(a, dato)==-1)
                        System.out.println("No se ah encontrado el numero");
                    else
                        System.out.println("Se encontro en el indice : "+c.bbinario_Iterativo(a, dato));
                    tf=System.currentTimeMillis()-ti;
                    System.out.println("Tiempo de compilacion : "+tf);
                    System.out.println("\n--------------------------------------------");
                    
                    break;
            case 5:System.out.println("Gracias Por su Preferencia !!!");break;
        }
        
        }while(op!=5);
    }
    
    public static void main(String[] args) {
        
        Clase3 c=new Clase3()  ;
        Scanner scan = new Scanner(System.in);
        int op1=0;
        
        do{
            System.out.println("****************************");
            System.out.println("***   TIPO DE OPERACION  ***");
            System.out.println("****************************");
            System.out.println("1. RECURSIVO");
            System.out.println("2. ITERATIVO");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion : ");
            op1=scan.nextInt();
            switch(op1){
                case 1:c.menu1();break;
                case 2:c.menu2();break;
                case 3:System.out.println("Gracias por su preferencia !!");break;
            }
        }while(op1!=3);
    }

}
