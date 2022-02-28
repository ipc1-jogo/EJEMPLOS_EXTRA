package com.mycompany.ejemplo_frames1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author joseg
 */
public class Formulario extends JFrame implements ActionListener {

   private Inicio ventanaAnterior; //Referencia a la ventana anterior, con este objeto (tipo Inicio) se puede manipular la ventana anterior.
   private JPanel pnFormulario; //Panel del formulario
   private JTextField txtEntrada; //Campo de texto par ingresar el mensaje a mostrar en Inicio
   private JButton bttMostrar; //Boton para mostrar el mensaje en Inicio
   private JButton bttCerrar; //Boton cerrar para hacer invisible el formulario y cambiar el color de la ventana Inicio
   private JLabel lbMensaje; //Etiqueta con mensaje


   public Formulario(Inicio ventanaAnterior, String nuevoTexto) {

      this.ventanaAnterior = ventanaAnterior; //Referencia a la ventana anterior(Inicio) pasada como parámetro

      //Propiedades definidas internamente en el constructor de la clase Formulario
      setBounds(700, 200, 400, 300); //Posición(700,200) - Tamaño 400 de ancho x 300 de alto
      setTitle(nuevoTexto); //Colocar titulo de la ventana: Formulario
      setLayout(null); //Posicionamiento absoluto, es decir, debemos especificar el lugar excacto donde se desea colocar el componente dentro del panel

      //Creación y configuración de JPanel(Panel o lámina donde se puden colocar otros componentes)
      pnFormulario = new JPanel(); //Crear objeto JPanel
      pnFormulario.setLayout(null); //Posicionamiento absoluto, es decir, debemos especificar el lugar excacto donde se desea colocar el componente dentro del panel
      pnFormulario.setBounds(0, 0, 400, 300); //Posición(0,0) - Tamaño 400 de ancho x 350 de alto
      pnFormulario.setBackground(Color.blue); //Colocar color de fondo azul
      add(pnFormulario); //Añadir el Panel(pnFormulario) al Frame(esta ventana Formulario)

      //Creación y configuración de JLabel
      lbMensaje = new JLabel("Mensaje: "); //Creando objeto Jlabel con texto "Mensaje: " utilizando el parámetro del constructor
      lbMensaje.setBounds(50, 50, 100, 30); //Posición(50,50) - Tamaño 100 de ancho x 30 de alto
      lbMensaje.setForeground(Color.white); //Colocar color de letra blanco
      pnFormulario.add(lbMensaje); //Añadir el botón cerrar(bttCerrar) al Panel(pnFormulario) 
     
      //Colocación de TextField o campo de texto para entrada del usuario
      txtEntrada = new JTextField(); //Crear objeto JTextField
      txtEntrada.setBounds(150, 50, 175, 30); //Posición(150,50) - Tamaño 175 de ancho x 30 de alto
      pnFormulario.add(txtEntrada); //Añadir el TextField(txtEntrada) al Panel(pnFormulario)
     
      //Creación y configuración de JButton
      bttMostrar = new JButton("Mostrar"); //Creando objeto JButton con nombre "Mostrar" utilizando el parámetro del constructor
      bttMostrar.setBounds(110, 150, 80, 30); //Posición(110,150) - Tamaño 80 de ancho x 30 de alto
      bttMostrar.addActionListener(this); //Se pone a la escucha al boton enviandole como parámetro este objeto con la palabra reservada this(haciendo referencia a este objeto en específico)
      pnFormulario.add(bttMostrar); //Añadir el botón mostrar(bttMostrar) al Panel(pnFormulario) 

      //Creación y configuración de JButton
      bttCerrar = new JButton("Cerrar"); //Creando objeto JButton con nombre "Cerrar" utilizando el parámetro del constructor
      bttCerrar.setBounds(210, 150, 80, 30); //Posición(210,150) - Tamaño 80 de ancho x 30 de alto
      bttCerrar.addActionListener(this); //Se pone a la escucha al boton enviandole como parámetro este objeto con la palabra reservada this(haciendo referencia a este objeto en específico)
      pnFormulario.add(bttCerrar); //Añadir el botón cerrar(bttCerrar) al Panel(pnFormulario) 

   }

    /*
     * Método abstracto de la clase ActionListener que escucha algún evento o acción del usuario
     * En este caso se debe diferenciar que botón es el que esta recibiendo el evento
     * Es necesario recuperar compoenentes privados del objeto de la clase Inicio con sus métodos getters
     * Al recuperar los componentes se almacenan en una variable del mismo tipo(Jlabel o JPanel en este caso)
    */ 

    @Override 
    public void actionPerformed(ActionEvent e) {

      if(e.getSource() == bttMostrar){ //Si el origen del evento es el botón mostrar
        JLabel lbInicioMensaje = ventanaAnterior.getLabelMensaje(); //Se recupera el componente de la clase Inicio lbMensaje(objeto privado) con el getter getLabelUsuario() y se almacen en lbInicioMensaje.
        String entradaUsuario = txtEntrada.getText(); //Se obtiene el texto introducido por el usuario en txtEntrada con el método getText().
        lbInicioMensaje.setText(entradaUsuario); //Se coloca el texto obtenido en el componente(lbMensaje) recuperado de Inicio
      }
      else if(e.getSource() == bttCerrar){ //Si el origen del evento es el botón cerrar
        setVisible(false); //Hacer invisible este formulario
        JPanel pnInicio = ventanaAnterior.getPanelInicio();//Se recupera el componente de la clase Inicio lbMensaje(objeto privado) con el getter getPanelInicio() y se almacena en pnInicio.
        pnInicio.setBackground(Color.gray); //Se coloca el panel recuperado de color gris
      }
       
    }
}
