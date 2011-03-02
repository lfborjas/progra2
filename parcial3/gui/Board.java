import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


class SwingConsole {
  public static void
  run(final JFrame f, final int width, final int height) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        f.setTitle(f.getClass().getSimpleName());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(width, height);
        f.setVisible(true);
      }
    });
  }
} 


class DrawBoard extends JPanel{
    private int step, side;
    public void setStep(int newStep){
        step = newStep;
        repaint();
    }

    public DrawBoard(){
        setStep(9);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        side = getWidth()/step;
        //podemos imaginarnos a g como un lapiz que va dibujando en el componente
        g.setColor(Color.BLACK);
        for(int i=0;i<step;i++){
            for(int j=0;j<step;j++){
               int dx = i * side;
               int dy = j * side;
               g.setColor(Color.BLACK);
               g.drawRect(dx, dy, side, side);
               g.setColor(new Color(205, 133, 63));
               g.fillRect(dx+1, dy+1, side-1, side-1);
            }
        }
    }
}

public class Board extends JFrame {
  private DrawBoard sines = new DrawBoard();
  private final JLabel info = new JLabel();
  public Board() {
    sines.setPreferredSize(new Dimension(300,300));
    add(BorderLayout.NORTH, sines);
    sines.addMouseListener(new MouseAdapter(){
        /*usamos MouseAdapter, que es una clase que implementa MouseListener
          pero deja todo vacío, para que sólo redefinamos los que necesitamos
          */
        public void mouseClicked(MouseEvent e){
            info.setText(String.format(" (%d, %d) | %s"
                                        , e.getX()
                                        , e.getY() //podemos obtener un Point con x,y de un solo con getPoint()
                                        , e.getLocationOnScreen()));
            Graphics2D g = (Graphics2D)((JPanel)e.getSource()).getGraphics();
            g.setPaint(
                new GradientPaint(e.getX(), e.getY(), Color.WHITE, e.getX()+20, e.getY()+20, Color.BLACK
                    )
                );
            g.fillOval(e.getX(), e.getY(), 20, 20);
        }
    });
    add(BorderLayout.SOUTH, info);
  }

  public static void main(String[] args) {
    SwingConsole.run(new Board(), 300, 500);
  }
} 
