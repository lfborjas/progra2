import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.JOptionPane;

public class Personas{
    static String[] nombres;
    static GregorianCalendar[] fechasNac;
    static int ultimaPersona = 0;
    /**Los nombres vienen de la forma PrimerApellido, PrimerNombre
       y las fechas, dia/mes/año
     */
    static void crearPersona(String nombre, String fechaNac){
        nombres[ultimaPersona] = nombre;
        String[] partes = fechaNac.split("/");
        fechasNac[ultimaPersona] = new GregorianCalendar(Integer.parseInt(partes[2]),
                                                         Integer.parseInt(partes[1]),
                                                         Integer.parseInt(partes[0]));
        ultimaPersona++;
    }

    static int mayor(int persona1, int persona2){
        GregorianCalendar fecha1 = fechasNac[persona1];
        GregorianCalendar fecha2 = fechasNac[persona2];

        if(fecha1.compareTo(fecha2) < 0) //si da menor que 0, 1 es antes que dos
            return persona1;
        else
            return persona2;
    }
    
    static String obtenerApellido(String nombre){
        return nombre.split(",")[0];
    }

    static boolean sonFamilia(int persona1, int persona2){
        return obtenerApellido(nombres[persona1]).equalsIgnoreCase(obtenerApellido(nombres[persona2]));
    }
    
    static void imprimirFamilias(){
        String familiaActual = obtenerApellido(nombres[0]);
        System.out.printf("Familia %s\n", familiaActual);
        for(String nombre : nombres){
            if(!obtenerApellido(nombre).equalsIgnoreCase(familiaActual))
                System.out.printf("Familia %s\n", familiaActual = obtenerApellido(nombre));
            System.out.printf("\t%s\n", nombre.split(", ")[1]);
        }
    }
    
    
    public static void main (String [] args)
    {
        int n = (new Random()).nextInt(3);
        nombres = new String[n];
        fechasNac = new GregorianCalendar[n];

        for(int i=0; i< n;i++){
            JOptionPane.showMessageDialog(null, String.format("Datos para la persona %d", i+1));
            String nombre = JOptionPane.showInputDialog(null, "Introduzca nombre");
            String fnac   = JOptionPane.showInputDialog(null, "Introduzca fecha de nacimiento");
            crearPersona(nombre, fnac);
        }

        imprimirFamilias();
    }
} 
