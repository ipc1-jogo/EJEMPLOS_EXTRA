package com.mycompany.tiendacomic;

/**
 *
 * @author joseg
 */
package com.mycompany.pizzeria;

/**
 *
 * @author joseg
 */

public class Comic {
    
    private String autor; //Autor del Comic
    private String titulo; //Título del Comic
    private String publicacion; //Publicación del Comic
    private String descripcion; //Descripción del Comic
    private String[] generos; //Géneros del Comic 
    private int copias; //Copias del comic de tipo entero
    private int existencia; //Existencia del comic de tipo entero

    private String generosConcatenados; //Presentación concatenada de los géneros, separados por coma
    private String strCopias; //Presentación de tipo String del atributo copias
    private String strExistencia; //Presentación de tipo String del atributo existencia

   /*
     * Constructor sobrecargado para Comic, recibe un parámetros string provenientes de entrada de  usuario
     * Realiza un split para separar los géneros
     * Utiliza el método replace de Strings para reemplazar el carácter "%" por el carácter ","
    */
    public Comic(
                 String autor, 
                 String titulo, 
                 String publicacion, 
                 String descripcion, 
                 String generos,
                 String copias,
                 String existencia
                ) {

      this.autor = autor;
      this.titulo = titulo;
      this.publicacion = publicacion;
      this.descripcion = descripcion;
      this.generos = generos.split("%");
      this.copias = Integer.parseInt(copias);
      this.existencia = Integer.parseInt(existencia);
     
      this.generosConcatenados = generos.replace('%', ','); //Reemplazar un carácter en una cadena con otro carácter especifico replace(caracter_a_reemplazar,caracter_de_reemplazo)
      this.strCopias = copias;
      this.strExistencia = existencia;
    }


    /*
     * Método que imprime los géneros del objeto creado
     * Recorrido del arreglo mediante ciclo For Each
    */
    public void mostrarGeneros() {
      for(String genero: getGeneros()) { //Ciclo For Each (Para cada género (tipo String) en arreglo (tipo String) de generos)
         System.out.println(genero); //Imprimir género
      }
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the publicacion
     */
    public String getPublicacion() {
        return publicacion;
    }

    /**
     * @param publicacion the publicacion to set
     */
    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the generos
     */
    public String[] getGeneros() {
        return generos;
    }

    /**
     * @param generos the generos to set
     */
    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    /**
     * @return the copias
     */
    public int getCopias() {
        return copias;
    }

    /**
     * @param copias the copias to set
     */
    public void setCopias(int copias) {
        this.copias = copias;
    }

    /**
     * @return the existencia
     */
    public int getExistencia() {
        return existencia;
    }

    /**
     * @param existencia the existencia to set
     */
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    /**
     * @return the generosConcatenados
     */
    public String getGenerosConcatenados() {
        return generosConcatenados;
    }

    /**
     * @param generosConcatenados the generosConcatenados to set
     */
    public void setGenerosConcatenados(String generosConcatenados) {
        this.generosConcatenados = generosConcatenados;
    }

    /**
     * @return the strCopias
     */
    public String getStrCopias() {
        return strCopias;
    }

    /**
     * @param strCopias the strCopias to set
     */
    public void setStrCopias(String strCopias) {
        this.strCopias = strCopias;
    }

    /**
     * @return the strExistencia
     */
    public String getStrExistencia() {
        return strExistencia;
    }

    /**
     * @param strExistencia the strExistencia to set
     */
    public void setStrExistencia(String strExistencia) {
        this.strExistencia = strExistencia;
    }



}
