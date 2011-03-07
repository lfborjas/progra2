import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**En esta clase estamos generalizando el comportamiento de dibujo de los frames
 para sólo tener que llamar a FrameDisplayer.run() en lugar de repetirnos a nosotros mismos*/
class FrameDisplayer{
    public static void run(final JFrame frame, final int width, final int height){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
             frame.setLayout(new FlowLayout());
             frame.setTitle(frame.getClass().getSimpleName());
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setSize(width, height);
             frame.setVisible(true);
            }
        });
    }
}

public class Basic extends JFrame{
    protected final JLabel nombre, resultado;
    protected final JTextField entrada;
    protected JButton procesar;
    
    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(Basic.this, String.format("%s dice %s"
                        , ((JButton)e.getSource()).getText()
                        , e.getActionCommand()
                        ));
        }
    }

    public Basic(){
        nombre = new JLabel("Escribí tu nombre");
        add(nombre);
        
        entrada = new JTextField(20);
        add(entrada);
        
        procesar = new JButton("Eco...");
        add(procesar);

        resultado = new JLabel();
        add(resultado);

        procesar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                resultado.setText(entrada.getText());               
            }
        });

        add(new JButton("Botón A"){{
            addActionListener(new ButtonListener());
            setActionCommand("Ábrete sésamo");
        }});

        add(new JButton("Botón B"){{
            addActionListener(new ButtonListener());
            setActionCommand("Abracadabra");
        }});
        
    }

    public static void main (String [] args)
    {
       FrameDisplayer.run(new Basic(), 300, 300);
    }
}
