import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Basic extends JFrame{

    /*declaramos estas variables como `final` porque serán usadas 
      dentro de una clase anónima, y a ésta le debemos asegurar
      que los valores de los que depende no van a cambiar
      */
    protected final JLabel lblPrompt, lblResultado;
    protected final JTextField txtEntrada;
    protected JButton btnProcesar;
    
    /*Esta es una clase interna que implementa la interfaz que se encarga de los clicks*/
    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(Basic.this, String.format("%s dice %s"
                        , ((JButton)e.getSource()).getText()
                        /*el action command es un string opcional que podemos
                          asociar al evento en caso de que queramos distinguir entre varios botones
                          que comparten un solo listener, como se puede ver más adelante
                          */
                        , e.getActionCommand() //el actionCommand es un string opcional que podemmos
                        ));
        }
    }

    public Basic(){
        /*Le decimos al frame cómo ordenará sus elementos,
          el ordenamiento por defecto es BorderLayout, pero 
          ese es inútil porque monta los elementos unos sobre otros,
          FlowLayout en cambio los pone contiguos siguiendo un flujo 
          de izquierda a derecha y de arriba abajo
          */
        setLayout(new FlowLayout());
        lblPrompt = new JLabel("Escribí algo");
        add(lblPrompt);
        
        txtEntrada = new JTextField(20);
        add(txtEntrada);
        
        btnProcesar = new JButton("Eco...");
        add(btnProcesar);
        
        /*Este es el botón principal, el que copia lo escrito en el textfield al label de lblResultado
         Como la acción es única a este botón, no nos molestamos en hacer una clase que sepa cómo
         escucharlo, sino que creamos una clase anónima que implemente la interfaz ActionListener
         */
        btnProcesar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                lblResultado.setText(txtEntrada.getText());               
            }
        });

        lblResultado = new JLabel();
        add(lblResultado);

        /*Aquí agregamos dos botones que no hacen demasiado, pero que comparten
         un solo actionListener. Les establecemos un actionCommand para poder
         distinguir uno de otro en el listener: el actionCommand es como la
         "identidad" o el "grito distintivo" de un botón.

         Como la acción de estos dos botones es similar, hicimos arriba una
         clase (ButtonListener) que sabe cómo escucharlos.

         Como nadie más en la clase necesita saber que estos dos botones existen
         (porque no hacen mucho), NO los declaramos como miembros de instancia, 
         sino como variables locales al constructor.
         */

        //declaramos esta variable como `final` porque será referida en una clase anónima local
        final ActionListener escuchaBotones = new ButtonListener();

        JButton botonA = new JButton("Botón A");
        botonA.addActionListener(escuchaBotones);
        botonA.setActionCommand("Ábrete sésamo");
        add(botonA);
        
        /*Este otro botón es muy parecido al anterior, pero usamos la sintaxis de clases
         anónimas y bloques inicializadores de instancia para hacer el código más corto.
        */
        add(new JButton("Botón B"){{
            addActionListener(escuchaBotones);
            setActionCommand("Abracadabra");
        }});


        
    }

    public static void main (String [] args)
    {
        JFrame frame = new Basic();
        frame.setTitle("Mi primer GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
