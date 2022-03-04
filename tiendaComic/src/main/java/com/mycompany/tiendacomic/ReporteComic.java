/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendacomic;

/**
 *
 * @author joseg
 */
public class ReporteComic {

    private String antesDeTabla =   "<!DOCTYPE html>\n" +
                                    "<html lang=\"en\">\n" +
                                    "<head>\n" +
                                    "	<title>Document</title>\n" + //Titulo de la página
                                    "</head>\n" +
                                    "<body>\n" +
                                    "	<table border=\"\">\n"; 
    
    private String despuesDeTabla = "	</table>\n" + 
                                    "</body>\n" +
                                    "</html>";

    private Comic[] datos;
    private String[] columnas;


    public ReporteComic (Comic[] datos, String[] columnas) {
        this.datos = datos;
        this.columnas = columnas;
    }




    public String obtenerReporteComics() { 

        //Construir la parte de los encabezados de la tabla, con cadenas (Strings) cocatenados
        String tablaColumnas= ""; //Inicialización de variable String para concatenar las etiquetas que contienen el valor de cada encabezado

        tablaColumnas += "		<tr>\n"; //Etiqueta de apertura <tr> de la primera fila (encabezado)

        for(int i = 0; i < columnas.length; i++) { //Bucle For para recorrer el arreglo de Strings de los encabezados/columnas y obtener cada uno de sus valores
            tablaColumnas += "			<th>" + columnas[i] + "</th>\n"; //Etiqueta <th>Valor columna 1<th> para cada columna recuperada del arreglo de columnas
        }

        tablaColumnas += "		</tr>\n"; //Etiqueta de cierre </tr> de la primera fila (encabezado)
   
        //Construir estructura para los datos de cada fila de la tabla
        String tablaDatos= ""; //Inicialización de variable String para concatenar las etiquetas que contienen el valor de cada columna de cada fila
        
        for(int i = 0; i < datos.length; i++) { //Bucle For para recorrer el arreglo de tipo Comic de las columnas y obtener cada uno de sus valores

            if(datos[i] != null) { //Verificar que la posición del arreglo sea diferente de null o que no este vacia

                tablaDatos += "		<tr>\n"; //Etiqueta de apertura <tr> de la fila actual u objeto recuperado (cada objeto del arreglo es un registro Comic diferente)

                tablaDatos += "			<td>" + datos[i].getAutor() + "</td>\n"; //Recuperar valor del objeto Comic de la forma <td>Atributo Autor<td>
                tablaDatos += "			<td>" + datos[i].getTitulo() + "</td>\n";
                tablaDatos += "			<td>" + datos[i].getPublicacion() + "</td>\n";
                tablaDatos += "			<td>" + datos[i].getDescripcion() + "</td>\n";
                tablaDatos += "			<td>" + datos[i].getGenerosConcatenados()+ "</td>\n";
                tablaDatos += "			<td>" + datos[i].getStrCopias() + "</td>\n";
                tablaDatos += "			<td>" + datos[i].getExistencia() + "</td>\n";

                tablaDatos += "		</tr>\n"; //Etiqueta de cierre </tr> de la fila actual

            } 

        }

        return antesDeTabla + tablaColumnas + tablaDatos + despuesDeTabla; //Concatenar el contenido antes de la tabla, los encabezados(columnas), las filas(registros Comic) y el contenido despues de la tabla

    }
}
