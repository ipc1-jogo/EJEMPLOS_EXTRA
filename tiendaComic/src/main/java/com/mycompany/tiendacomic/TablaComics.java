package com.mycompany.tiendacomic;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author joseg
 */
public class TablaComics extends JFrame {
   
   private String[] columnas; //Columnas de la tabla, referencia 
   private String[][] datos; //Datos presentados en la tabla

   private JPanel plTabla; //Panel de tabla
   private JTable tbLecturas; //Objeto tabla
   private JScrollPane scpScroll; //Este panel permite tener barras de desplazamiento vertical u horizontal

   public TablaComics(String[][] datos, String[] columnas) {
       this.columnas = columnas;
       this.datos = datos;
       
       definirPropiedades();
       iniciarComponentes(); 
   }    

   private void definirPropiedades() {
    //Configuración de la ventana
    setTitle("Tabla de Comics");
    setSize(800,400);
    setLayout(null);
    setLocationRelativeTo(this);
   }

   private void iniciarComponentes() {
    //Definición del panel
    plTabla = new JPanel();
    plTabla.setBounds(0, 0, 800, 400);
    plTabla.setBackground(Color.darkGray);
    plTabla.setLayout(null);
    add(plTabla);

    //Definicion de tabla
    tbLecturas = new JTable(datos,columnas); //Se pasan como parámetros la matriz de datos(registros o filas de la tabla) y las columnas(encabezados)

    //Definición del Scroll Panel(Con barras de desplazamiento vertical y horizontal)
    scpScroll = new JScrollPane(tbLecturas);
    scpScroll.setBounds(50, 25, 700, 300);
    plTabla.add(scpScroll);
  }
}
