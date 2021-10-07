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
public enum Numero{
    Cero("0"),
    UNO("1"),
    DOS("2"),
    TRES("3"),
    CUATRO("4"),
    CINCO("5"),
    SEIS("6"),
    SIETE("7"),
    OCHO("8"),
    NUEVE("9");
    
    private String numero;
    private Numero (String numero){
        this.numero=numero;
    }
    public String getNumero(){ 
        return this.numero;
    } 
}
