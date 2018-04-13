/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Utilidades {
    /**
     * Muestra un mensaje con el titulo y cuerpo especificado con MessageDialog
     * @param titulo titulo del recuadro
     * @param mensaje cuerpo del mensaje
     */
    public static void mostrarMensaje(String titulo, String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
