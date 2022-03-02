package com.mycompany.tiendacomic;

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
        Inicio fmInicio = new Inicio();
        fmInicio.setVisible(true);
        fmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Tienda.mostrarComics();
    }
    
}
