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
public enum SignoAgrupacion {
    PARENTESISIZQUIERDO("("),
    PARENTESISDERECHO(")"),
    CORCHETEIZQUIERO("["),
    CORCHETEDERECHO("]"),
    LLAVEIZQUIERDA("{"),
    LLAVEDERECHA("}");
    
    private String signo;
    private SignoAgrupacion (String signo){
        this.signo=signo;
    }
    public String getSignoAgrupacion(){ 
        return this.signo;
    }
}
