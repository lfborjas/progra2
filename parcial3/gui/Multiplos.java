import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;
public class Multiplos extends JFrame{
   protected JSlider selector;
   protected JPanel  mostrador;

   public Multiplos(){
    //hay un panel implícito
    getContentPane().setLayout(new GridLayout(2,1));
    setPreferredSize(new Dimension(600, 900));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //recibe: orientación, min, max, inicial
    selector  = new JSlider(JSlider.HORIZONTAL, 0, 50, 0){{
        setMajorTickSpacing(5);
        setMinorTickSpacing(1);
        setPaintLabels(true);
        setPaintTicks(true);
    }};
    mostrador = new JPanel();
    
    add(selector);
    add(mostrador);

    selector.addChangeListener(new ChangeListener(){
        public void stateChanged(ChangeEvent e){
                final int valor = selector.getValue();
                int total = mostrador.getComponentCount()/3;
                for(int i=total; i <= valor ; i++){
                    final JTextField t = new JTextField();
                    final JLabel     l = new JLabel();
                    l.setOpaque(true);
                    mostrador.add(t);
                    final int temp = i+1;
                    mostrador.add(new JButton(String.format("Es divisor de %d ?", temp)){{
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
                    mostrador.add(l);

                }
                mostrador.setLayout(new GridLayout(total, 3));
                mostrador.validate();
                mostrador.repaint();
        }
    });
    pack();
   }
    
   public static void main (String [] args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Multiplos().setVisible(true);
            }
        });
    }
}
