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
public enum Signos {
    PUNTO("." ),
    COMA(","),
    PUNTOCOMA(";"),
    DOSPUNTOS(":");
    private String signo;
    private Signos (String signo){
        this.signo=signo;
    }
    public String getSigno(){ 
        return this.signo;
    } 
}
