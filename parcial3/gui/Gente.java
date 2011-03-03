import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;
public class Gente extends JPanel{

    static class Persona{
        String nombre;
        GregorianCalendar fechaNac;
        public Persona(String n, GregorianCalendar f){
            this.nombre   = n;
            this.fechaNac = f;
        }
        public String toString(){
            return this.nombre;
        }
    }
    
    protected JPanel info;
    protected JComboBox year, month, day;
    protected JTextField name;
    protected JButton benjamin;

    protected JPanel display;
    protected JList lista;
    protected JLabel salida;

    protected DefaultListModel datos;

    private static Object[] construirArreglo(final int inicio, final int fin){
       return new ArrayList(){{
            for (int i=inicio; i<=fin; i++ ) 
                add(new Integer(i));
       }}.toArray();
    }

    public Gente(){
        super(new BorderLayout());
        //le ponemos un tamaño inicial, con anchura y altura
        setPreferredSize(new Dimension(800, 100));
        //inicializar los componentes:
        year     = new JComboBox(construirArreglo(1970, 2032));
        year.setSelectedItem(new Integer((new GregorianCalendar()).get(Calendar.YEAR)));
        month    = new JComboBox(construirArreglo(01, 12));
        month.setSelectedItem(new Integer((new GregorianCalendar()).get(Calendar.MONTH)));
        day      = new JComboBox(construirArreglo(01,31));
        day.setSelectedItem(new Integer((new GregorianCalendar()).get(Calendar.DAY_OF_MONTH)));
        name     = new JTextField(20);
        benjamin = new JButton("Agregar");

        datos   = new DefaultListModel(); 
        display = new JPanel(new BorderLayout());
        lista   = new JList(datos);
        salida  = new JLabel("");
            
        //agregarlos a los paneles
        
        info   = new JPanel(new GridLayout(5,2)){{
            add(new JLabel("Año"));
            add(year);
            add(new JLabel("Mes"));
            add(month);
            add(new JLabel("Día"));
            add(day);
            add(new JLabel("Nombre"));
            add(name);
            add(benjamin);
        }};

        display.add(lista, BorderLayout.NORTH);
        display.add(salida, BorderLayout.SOUTH);

        //agregar los paneles a este:
        add(info, BorderLayout.WEST);
        add(display, BorderLayout.EAST);

        /*Programamos la funcionalidad del botón y la lista
         *en lugar de hacer que este panel implemente las interfaces
         *creamos clases anónimas que sólo se encargan de escuchar a un elemento
         */

        //el escuchador crea una nueva instancia de persona y la ESCRIBE en el modelo
        //de la lista

        benjamin.addActionListener(
                //clase anónima que implementa la interfaz ActionListener
                new ActionListener(){
                    //método que un ActionListener debe implementar
                    public void actionPerformed(ActionEvent e){
                        //ESCRIBIMOS una persona en el MODELO DE LA LISTA
                        datos.addElement(new Persona(name.getText(),
                         new GregorianCalendar(((Integer)year.getSelectedItem()).intValue(),
                                               ((Integer)month.getSelectedItem()).intValue(),
                                               ((Integer)day.getSelectedItem()).intValue())));

                    }
                }//fin de la clase anónima
        );//fin de AddActionListener
        

        //cuando cambie el valor seleccionado de una lista queremos mostrar ese objeto
        //en la salida, así que agregamos un escuchador para los cambios de selecciones
        //aquí LEEMOS del modelo de la lista
        lista.addListSelectionListener(
                /**Esta es una clase anónima que implementa la interfaz ListSelectionListener*/
                new ListSelectionListener(){
                    /**Este es el método que ListSelectionListener obliga a implementar*/
                    public void valueChanged(ListSelectionEvent evt){
                        //Obtenemos una persona del MODELO DE LA LISTA
                        Persona p = (Persona)datos.getElementAt(lista.getSelectedIndex());
                        //usamos la información de esa persona en el modelo
                        GregorianCalendar now = new GregorianCalendar();

                        salida.setText(String.format("%s tiene %d años", p.nombre,
                                                      now.get(Calendar.YEAR) - p.fechaNac.get(Calendar.YEAR)));
                    }
                }//fin de la clase anónima
        );//fin de addListSelectionListener
    }

    public static void mostrar(){
        JFrame marco = new JFrame();
        marco.setContentPane(new Gente());
        //para que se cierre y no esconda al darle a la equis
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.pack();
        marco.setVisible(true);
    }

    public static void main (String [] args)
    {
        mostrar();
    }
}
