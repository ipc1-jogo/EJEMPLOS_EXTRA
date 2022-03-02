package com.mycompany.tiendacomic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author joseg
 */

public class Inicio extends JFrame {

    private JPanel pnInicio; //Panel de inicio
    private JButton bttAbrirCargaMasiva; //Boton para abrir el formulario
    private JButton bttMostrarComics; //Boton para abrir el formulario
    private CargaMasiva formCarga; //Ventana creada a partir de la clase Formulario
    private TablaComics fmTabla; //

    public Inicio() {

       definirPropiedades();
       construirPanelInicio();
       construirBotonAbrir();
       construirBotonMostrar();

       //Creación de objeto formulario
       formCarga = new CargaMasiva(); 

    }
    
    private void definirPropiedades() {
       //Propiedades definidas internamente en el constructor de la clase Inicio para el Frame(Ventana de aplicación)
       setBounds(200, 200, 500, 350); 
       setTitle("Inicio");
       setLayout(null); 
       
    }

    private void construirPanelInicio() {
       //Creación y configuración de JPanel(Panel o lámina donde se puden colocar otros componentes)
       pnInicio = new JPanel();
       pnInicio.setLayout(null); 
       pnInicio.setBounds(0, 0, 500, 350);
       pnInicio.setBackground(Color.gray); 
       add(pnInicio);
    }

    private void construirBotonAbrir() {
       //Creación y configuración de JButton Abrir Carga masiva
       bttAbrirCargaMasiva = new JButton("Abrir Carga Masiva"); 
       bttAbrirCargaMasiva.setBounds(175, 75, 150, 30);
       bttAbrirCargaMasiva.addActionListener( new ActionListener(){ //Implementación alternativa de ActionListener
         @Override
         public void actionPerformed(ActionEvent e) { 
            formCarga.setVisible(true);  //Hace visible el formulario de carga.
         }
       });
       pnInicio.add(bttAbrirCargaMasiva); 
 
    }
   
    private void construirBotonMostrar() {
      //Creación y configuración de JButton
       bttMostrarComics = new JButton("Mostrar Comics"); 
       bttMostrarComics.setBounds(175, 175, 150, 30);
       bttMostrarComics.addActionListener( new ActionListener(){ //Implementación alternativa de ActionListener
         @Override
         public void actionPerformed(ActionEvent e) { 
            Tienda.mostrarComics(); //Imprime los comics en consola

            //Columnas y filas de la tabla
            String columnas[] = { "Autor", "Titulo", "Publicacion", "Descripcion", "Generos", "Copias", "Existencia"}; //Listado de columnas/encabezados
            String datos[][] = Tienda.obtenerDatos(); //Llamada al método estático obtener datos, de la clase Tienda. Recibe el arreglo de lecturas construido.

            fmTabla = new TablaComics(datos,columnas); //Creación de objeto tipo TablaLectura, pasando como parámetros los datos y las columnas recuperadas
            fmTabla.setVisible(true); //Se hace visible el Fram(TablaLecturas)
        }
       });
       pnInicio.add(bttMostrarComics); 
    }
}
