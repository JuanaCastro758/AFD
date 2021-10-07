/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VerificarAFD;

import Enums.Letra;
import Enums.Numero;
import Enums.Operadores;
import Enums.SignoAgrupacion;
import Enums.Signos;

/**
 *
 * @author Chiko malo
 */
public class Tokens {

    public Tokens() {
    }
    
    public boolean numero(String palabra){
        Numero[] numero=Numero.values();
        boolean valido=false;
        int cantidad=0;
        for(int j=0;j<palabra.length();j++){
            String num=""+palabra.charAt(j);
           System.out.println(num);
            for(int i=0; i<10;i++){
                System.out.println("--"+numero[i].getNumero());
                if(num.equals(numero[i].getNumero())){
                    System.out.println(" "+cantidad);
                    cantidad++;
                    i=10;
                }
            }
        }
        if(palabra.length()==cantidad){
            valido=true;
        }
        return valido;
    }
    
    public boolean decimal(String palabra){
        Numero[] numero=Numero.values();
        boolean valido=false;
        int cantidad=0;
        int punto=0;
        int pos=0;
        for(int j=0;j<palabra.length();j++){
            String num=""+palabra.charAt(j);
            for(int i=0; i<10;i++){
                System.out.println("--"+numero[i].getNumero());
                if(num.equals(numero[i].getNumero())){
                    System.out.println(" "+cantidad);
                    cantidad++;
                    i=10;
                }else if(num.equals(".")){
                    punto++;
                    i=10;
                    pos=j;
                }
            }
        }
        if(palabra.length()==(cantidad+punto) && punto==1 && pos!=0 && pos!=(palabra.length()-1)){
            valido=true;
        }
        return valido;
    }
    
    public boolean letra(String palabra){
        boolean valido=false;
        Letra[] letra=Letra.values();
        int cantidad=0;
        for(int j=0;j<palabra.length();j++){
            String num=""+palabra.charAt(j);
           System.out.println(num);
            for(int i=0; i<26;i++){
                System.out.println("--"+letra[i]);
                if(num.equalsIgnoreCase(letra[i].toString())){
                    System.out.println(" "+cantidad);
                    cantidad++;
                    i=26;
                }
            }
        }
        if(palabra.length()==cantidad){
            valido=true;
        }
        return valido;
    }
    
    public boolean signo(String signo){
        Signos[] sig=Signos.values();
        boolean valido=false;
        int cantidad=0;
        for(int j=0;j<signo.length();j++){
            String num=""+signo.charAt(j);
           System.out.println(num);
            for(int i=0; i<4;i++){
                System.out.println("--"+sig[i].getSigno());
                if(num.equals(sig[i].getSigno())){
                    System.out.println(" "+cantidad);
                    cantidad++;
                    i=4;
                }
            }
        }
        if(signo.length()==cantidad){
            valido=true;
        }
        return valido;
    }
    
    public boolean operador(String operador){
        Operadores[] sig=Operadores.values();
        boolean valido=false;
        int cantidad=0;
        for(int j=0;j<operador.length();j++){
            String num=""+operador.charAt(j);
           System.out.println(num);
            for(int i=0; i<5;i++){
                System.out.println("--"+sig[i].getOperador());
                if(num.equals(sig[i].getOperador())){
                    System.out.println(" "+cantidad);
                    cantidad++;
                    i=5;
                }
            }
        }
        if(operador.length()==cantidad){
            valido=true;
        }
        return valido;
    }
    
    public boolean signoAgrupacion(String signo){
        SignoAgrupacion[] sig=SignoAgrupacion.values();
        boolean valido=false;
        int cantidad=0;
        for(int j=0;j<signo.length();j++){
            String num=""+signo.charAt(j);
           System.out.println(num);
            for(int i=0; i<6;i++){
                System.out.println("--"+sig[i].getSignoAgrupacion());
                if(num.equals(sig[i].getSignoAgrupacion())){
                    System.out.println(" "+cantidad);
                    cantidad++;
                    i=6;
                }
            }
        }
        if(signo.length()==cantidad){
            valido=true;
        }
        return valido;
    }
}
