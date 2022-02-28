package com.mycompany.ejemplo_frames1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author joseg
 */


/*

   * En Swing se le llama componente, en palabras simples, a los elementos que colocamos en una GUI(Interfaz Gráfica de Usuario)-

   * ActionListener permite poner a la escucha algún componente por eventos ocurridos. Existen muchas formas de utilizar esta clase,
     en este caso se implementará en la clase inicio(implements ActionListener) para definir las acciones dentro de esta clase

   * JFrame es una clase que genera Ventanas, en este caso se extiende(hereda) para que la clase Inicio sea un JFrame(Ventana). A esta se le agregarán 
     otras propiedades, componentes, atributos y métodos. Extender de la Clase JFrame, como se ha implementado acá, es una ventaja para poder manipular 
     los componentes internos de forma sencilla, definiendo variables a utilizar y comportamientos específicos para el formulario generado.

   * extends es la palabra reservada de Java para decir que una clase hereda de otra. Este caso decimos que Inicio extiende o hereda de JFrame, por lo cual,
     Inicio ahora será una Ventana.

   * implements es una forma de utilizar interfaces(diferentes al concepto de GUI, estas interfaces hacen referencia a otro concepto). Java no permite herencia múltiple,
     es decir, heredar de varias clases. Por lo que implements es una alternativa para asignarle otras porpiedades a las clases.

   * JPanel es una clase que genera Paneles, los paneles se asemejan a láminas que se pueden colocar en una Venana. En estos se pueden agregar
     otros componentes como si fuera un JFrame(Ventana). Generalmente se colocan siempre los componentes dentro de un panel y no en una ventana directamente.

   * JLabel es una clase que genera Etiquetas, estas son textos que no son modificables a nivel de la interfás grafica y son usados para colocar texto
     visible para el usuario pero que este no puede modificar.

   * JButton es una clase que genera Botones, estos son botones que al hacer click en ellos pueden realizar diferentes acciones(sí se les ha definido
     alguna acción)

   * setBounds(X, Y, ancho, alto) configura posición y tamaño. Posición X, Y en los primeros 2 parámetros y tamaño ancho, alto en los últimos 2.
     Es importante mencionar que la posición Y o vertical se cuenta desde arriba hacia abajo

   * setText(texto) coloca el texto en algún componente que lo permita, es decir, si el componente contiene algún texto puede modificarse con este metodo

   * setBackground(Color) coloca color a algún componente que lo permite y un objeto tipo Color. Existen colores predefinidos como constantes estáticas en la clase Color.
     Por ejemplo, si se quiere colocar color rojo, se agrega: Color.red. Aunque es posible hacer mezclas de colores utilizando RGB.

   * add(Componente) permite agregar componentes dentro de otro componente. 

   * La palabra reservada "this" hace referencia al objeto generado a partir de la clase donde se esta utilizando. Cuando accedemos a métodos y atributos de un objeto lo hacemos con 
     objeto.atrituto u objeto.metodo(). En este caso podemos realizar this.atrituto o this.metodo() para referirnos al objeto internamente.
 */

public class Inicio extends JFrame implements ActionListener{

    private JPanel pnInicio; //Panel de inicio
    private JLabel lbMensaje; //Label para mostrar el mensaje proveniente de Formulario
    private JButton bttAbrirFormulario; //Boton para abrir el formulario
    private Formulario form; //Ventana creada a partir de la clase Formulario

    public Inicio() {
       //Propiedades definidas internamente en el constructor de la clase Inicio para el Frame(Ventana de aplicación)
       setBounds(200, 200, 500, 350); //Posición(200,200) - Tamaño 500 de ancho x 350 de alto
       setTitle("Inicio");
       setLayout(null); //Posicionamiento absoluto, es decir, debemos especificar el lugar exacto donde se desea colocar el componente dentro del panel
       
       //Creación y configuración de JPanel(Panel o lámina donde se puden colocar otros componentes)
       pnInicio = new JPanel(); //Crear objeto JPanel
       pnInicio.setLayout(null); //Posicionamiento absoluto, es decir, debemos especificar el lugar exacto donde se desea colocar el componente dentro del panel
       pnInicio.setBounds(0, 0, 500, 350); //Posición(0,0) - Tamaño 500 de ancho x 350 de alto
       pnInicio.setBackground(Color.gray); //Colocar color de fondo gris
       add(pnInicio);//Añadir el Panel(pnInicio) al Frame(esta ventana Inicio) 
       
       //Creación de JLabel para colocar nombre y apellido del usuario
       lbMensaje = new JLabel();
       lbMensaje.setBounds(150, 50, 200, 100); //Posición(175,50) - Tamaño 200 de ancho x 100 de alto
       lbMensaje.setText("Aún sin entrada."); //Colocar texto mostrado al inicio
       lbMensaje.setForeground(Color.white); //Colocar color de letra blanco
       pnInicio.add(lbMensaje); //Añadir la etiqueta(lbMensaje) al Panel(pnInicio) 

       //Creación y configuración de JButton
       bttAbrirFormulario = new JButton("Abrir Formulario"); //Creando objeto formulario
       bttAbrirFormulario.setBounds(175, 150, 150, 50); //Posición(175,150) - Tamaño 150 de ancho x 50 de alto
       bttAbrirFormulario.addActionListener(this); ///Se pone a la escucha al boton enviandole como parámetro este objeto con la palabra reservada this(haciendo referencia a este objeto en específico)
       pnInicio.add(bttAbrirFormulario); //Añadir el botón abrir formulario(bttAbrirFormulario) al Panel(pnInicio) 

       //Creación de objeto formulario
       this.form = new Formulario(this, "Hola"); //El objeto se crea con el constructor que recibe un objeto tipo Inicio generado a partir de esta clase

    }

    /*
      * Cuando implementamos una clase abstracta, es necesario implementar sus métodos abstractos. Al igual que el concepto de interfaz la clase abstracta
        nos permite colocar comportamientos específicos a una clase. 

      * En este caso sobreescribo el método actionPerformed para que este a la escucha de un evento.

      * Definimos dentro de este método lo que se necesita realizar cuado hacemos click
    */
 
    //Getter para obtener el JLabel privado lbMensaje
    public JLabel getLabelMensaje() {
       return lbMensaje;
    }

    //Getter para obtener el JPanel privado pnInicio
    public JPanel getPanelInicio() {
       return pnInicio;
    }

    /*
     * Método abstracto de la clase ActionListener que escucha algún evento o acción del usuario
     * En este caso solo se quiere detectar un click del usuario al único botón.
    */ 
    @Override 
    public void actionPerformed(ActionEvent e) {
      pnInicio.setBackground(Color.red); //Se coloca el Pnel(pnInicio) color rojo
      form.setVisible(true); //Se hace visible la nueva ventana creada(form) a partir de la clase Formulario
    }
}
