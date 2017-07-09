/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Labo11;

import java.util.Scanner;

/**
 *
 * @author Pregrado
 */
public class NumeroE {
    
    
    
    public double NumeroE(){
        double e=1;
        double eanterior;
        int i =1;
        do{
            eanterior =e;
            e=e+(1/Factorial(i));
            i=i+1;
        }while(e!=eanterior);
        return e;
    }
    
    public double Factorial(int n){
        double fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        
        return fact;
    }
    
    public double redondear( double numero, int decimales ) {
        return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
    }
    
    public double exponencial(int x){
        double e = 1;
        double eant;
        int i=1;
        
        do{
            eant=e;
            e=e+Math.pow(x, i)/Factorial(i);
            i++;
        }while(e-eant>0);
        return e;
    }
    
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        NumeroE num = new NumeroE();
        double e =  num.NumeroE();
        
        System.out.println("VALOR DE e : "+num.redondear(e, 10));
        System.out.println("INGRESE UN NUMERO : ");
        int n= scan.nextInt();
        System.out.println("SOL : "+num.exponencial(n));;
    }
}
