import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

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

public class Dinamico extends JFrame{
   protected final JTextField txtEntrada;
   protected JButton btnProcesar;
   protected final JPanel  pnlResultados;

   public Dinamico(){
    setLayout(new GridLayout(2,2));
    
    txtEntrada = new JTextField(2);    
    add(txtEntrada);

    btnProcesar = new JButton("Actualizar");
    add(btnProcesar);

    pnlResultados= new JPanel();
    //preferredSize es diferente a setSize en que fuerza al tamaño aunque no haya componentes
    //mientras que setSize no tiene efecto si el panel está vacío
    pnlResultados.setPreferredSize(new Dimension(500, 200));
    add(pnlResultados);


    btnProcesar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
                final int valor;
                try{
                    valor = Integer.parseInt(txtEntrada.getText()); 
                }catch(NumberFormatException nex){
                    return;
                }

                //para sólo agregar nuevas filas
                int filasExistentes = pnlResultados.getComponentCount()/3;
                //sólo se pueden agregar filas:
                if(valor < filasExistentes){
                    JOptionPane.showMessageDialog(Dinamico.this, "Sólo se pueden agregar filas");
                    return;
                }



                //aquí agregamos dinámicamente filas
                for(int i=filasExistentes; i <= valor ; i++){
                    final JTextField t = new JTextField();
                    pnlResultados.add(t);
                    final JLabel l = new JLabel();
                    final int temp = i+1;
                    //agregamos un botón cuyo comportamiento dependa de la fila en la que estemos
                    //usamos una sub-clase anónima con un bloque inicializador
                    pnlResultados.add(new JButton(String.format("¿Es múltiplo de %d ?", temp)){{
                        //aquí, en el contexto de esta instancia de JButton, creamos el comportamiento
                        addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                try{
                                    int v = Integer.parseInt(t.getText());
                                    if((v % temp) == 0){
                                       l.setBackground(Color.GREEN);
                                    }else{
                                       l.setBackground(Color.RED);
                                    }
                                }catch(NumberFormatException nfex){}
                            }
                        });
                    }});

                    l.setOpaque(true);
                    pnlResultados.add(l);
                }

                //los labels son transparentes por defecto
                //cuando agreguemos nuevos elementos a un panel SIEMPRE tenemos que obligarlo a 
                //re-dibujarse. 
                //actualizamos la disposición de este panel para que acomode las filas en una tabla
                //de n x 3
                pnlResultados.setLayout(new GridLayout(pnlResultados.getComponentCount()/3, 3));
                pnlResultados.validate();
                pnlResultados.repaint();
        }
    });
   }
    
   public static void main (String [] args)
    {
        FrameDisplayer.run(new Dinamico(), 500, 300);
    }
}
