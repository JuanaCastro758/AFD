/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author Chiko malo
 */
public enum Operadores {
    SUMA("+"),
    RESTA("-"),
    MULTIPLICACION("*"),
    Division("/"),
    MODULO("%");
    
    private String operador;
    private Operadores (String operador){
        this.operador=operador;
    }
    public String getOperador(){ 
        return this.operador;
    } 
}
