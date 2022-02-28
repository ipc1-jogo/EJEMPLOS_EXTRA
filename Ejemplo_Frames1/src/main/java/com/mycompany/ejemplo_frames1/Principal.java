package com.mycompany.ejemplo_frames1;

import javax.swing.JFrame;

/**
 *
 * @author joseg
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Inicio fmInicio = new Inicio(); // Crear un objeto de tipo Inicio a partir de la Clase Inicio.
        fmInicio.setVisible(true); // Hacer visible la ventana
        fmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Comportamiento que indica que al cerrarse la ventana deje de consumir recursos
    }
    
}
