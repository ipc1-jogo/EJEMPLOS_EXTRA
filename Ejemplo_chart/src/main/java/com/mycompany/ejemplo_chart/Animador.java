/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo_chart;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author joseg
 */
public class Animador {

    private Dato[] datos;
    private JPanel panel;
    private JFreeChart barras;
    private Random rand;


    public Animador(Dato[] datos, JPanel panel) {
        this.datos = datos;
        this.panel = panel;
        rand = new Random();
    }
    
    /*
        Genera valores aleatorios para cada uno de los elementos del arreglo.
        Llama a refrescar la gráfica (construir otra y reemplazar la anterior).
    */
    public void generarGraficaAleatoria() {
        for(Dato dato: datos) {
            dato.setValor(rand.nextInt(100));
        }
        refrechChart();
        generateImage("Imagen.png");
    }

    /*
        Crear una nueva gráfica y reemplazar la anterior
    */
    private void refrechChart() {
            ChartPanel chartPanel= getChartPanel(); //Obtener ChartPanel
            panel.removeAll(); //Remover los componentes, en este caso, el panel anterior
            panel.setLayout(new BorderLayout()); //Como se distribuyen los componentes dentro del panel
            panel.add(chartPanel); //Añadir charPanel al panel
            panel.validate();//Modificaciones en el diseño del panel no son apreciables hasta que sea validado
            System.out.println("Refrescar");
    }

    /*
        Generar nuevo charPanel y retornarlo.
    */
    public ChartPanel getChartPanel() {
        barras = ChartFactory.createBarChart("Gráfica","Categorias","valores",getDataset(),PlotOrientation.VERTICAL,true, true, false );
        ChartPanel chartPanel = new ChartPanel( barras ); //Añadir gráfica a un ChartPanel
        return chartPanel; //Retorno de chartPanel
    }

    /*
        Generar dataset.
        Recorrido del arreglo de datos.
    */
    private CategoryDataset getDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Dato dato: datos) {
            dataset.setValue(dato.getValor(), dato.getCategoria(),"Aleatorios"); //Colocar valor y categorìa de cada dato en el dataset. 
        }
        return dataset;
    }

    private void generateImage(String nombreGrafica) {
        try {
            final File file = new File(nombreGrafica); //Definición del archivo con nombre y extensión
            ChartUtils.saveChartAsPNG(file, barras, 800, 500); //Generar gráfica en formato PNG
        } catch(IOException e) {
            System.out.println("Imagen no generada.");
        }
    }
}
