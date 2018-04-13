/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author usuario
 */
public class Constantes {
    public static final int TERMINO_RAFAGA = 1;
    public static final int TERMINO_QUANTUM = 2;
    
    public static String describirPrioridad(int prioridad){
        switch(prioridad){
            case 0:
                return "Alta";
            case 1:
                return "Media";
            case 2:
                return "Baja";
            default:
                return "No definido";
        }
    }
}
