package com.mycompany.tiendacomic;

/**
 *
 * @author joseg
 */

/*
 * Esta clase implementa métodos y atributos estáticos
 * Pueden invocarse desde cualquier lado, al no tener encapsulamiento
 * Pueden invocarse sin necesidad de crear una instancia/objeto (Tienda tienda = new Tienda())
*/

public class Tienda {
 
  private static Comic[] almacenComics = new Comic[100]; //Arreglo de objetos tipo Comic
  private static int cantidadComics = 0; //Definir la cantidad de comics, para contruir tabla a la medida(implementación opcional)

  /*
   * Coloca un objeto tipo Comic en un lugar nulo o que aún no tiene una referencia a un objeto
  */
  public static void colocarComic(Comic nuevoComic) { 
    for(int i = 0; i < getAlmacenComics().length; i++) {
        if( getAlmacenComics()[i] == null) {
          almacenComics[i] = nuevoComic;
          cantidadComics++; //Incrementar la cantidad de comics con cada Comic agregado
          return;
        }
    }
  }

  /*
   * Mostrar Comics en consola
  */
  public static void mostrarComics() {
    for(Comic comic: getAlmacenComics()) { //Recorrido For Each, para cada objeto Comic en el arreglo de objetos Comic(almacenComis)
       if(comic != null) { //Evaluar si no es nulo o que de verdad exista un objeto tipo Comic en esta posición

          //Imprimier en consola los atributos del objeto Comic con encapsulamiento
          System.out.println(    
                                "Autor: " + comic.getAutor() +
                                " - Titulo: " + comic.getTitulo() + 
                                " - Publicación: " + comic.getPublicacion() +
                                " - Descripción: " + comic.getDescripcion() +
                                " - Generos: " + comic.getGenerosConcatenados() +
                                " - Copias: " + comic.getStrCopias() +
                                " - Existencia: " + comic.getStrExistencia() 
                            );
       }
    }
  }

  /* 
   * obtenerDatos, retorna un arreglo de dos dimensiones(matriz) con los datos de los Comics
  */
  public static String [][] obtenerDatos() {

    String [][] datos = new String [cantidadComics][7]; //Crear nueva matriz de cantidadComics filas x 7 columnas. Será retornada al final.

    int posicion = 0; //Contador de posiciones para recorr arreglo de datos y colocar en cada posición un Comic. Inicia en 0. 

    for (Comic comic : getAlmacenComics()) //Recorrido del arreglo de Comics, para cada comic en almacenComics
    {
        if(comic != null) { //Si el objeto Comic no es nulo

          //Crear nuevo arreglo de tipo String, con los atributos del objeto. 
          String [] fila = { 
                                comic.getAutor(), 
                                comic.getTitulo(),  
                                comic.getPublicacion(), 
                                comic.getDescripcion(), 
                                comic.getGenerosConcatenados(), 
                                comic.getStrCopias(), 
                                comic.getStrExistencia()
                            };
          datos[posicion] = fila; //Almacenar la fila en la posición actual del arreglo datos
          posicion++; //Correr una posición 
        }
    }
    
    return datos; //Retornar el nuevo arreglo de datos recolectados del arreglo de comics

  }

    /**
     * @return the almacenComics
     */
    public static Comic[] getAlmacenComics() {
        return almacenComics;
    }

}
