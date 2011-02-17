import java.util.ArrayList;
import java.util.Random;
import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
/*Using reflection: cf: http://download.oracle.com/javase/1.5.0/docs/guide/language/autoboxing.html
http://download.oracle.com/javase/1.5.0/docs/guide/language/varargs.html*/
public class Main{
    public static void llenarEcosistema(ArrayList ecosistema) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException{
        Random gen = new Random();
        String[] dinos = {"TRex", "Brontosaurio", "Velociraptor", "Planta"};
        for(int i=0;i<gen.nextInt(10); i++){
            ecosistema.add((Class.forName(dinos[gen.nextInt(dinos.length)])).getConstructors()[0].newInstance(new Double(gen.nextDouble())));
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException{
        ArrayList<SerVivo> ecosistema = new ArrayList();
        llenarEcosistema(ecosistema);
        Object o=null;
        int opt;
        do{
            JOptionPane.showMessageDialog(null, String.format("El ecosistema es: %s", ecosistema));
            do{
                try{
                    opt = Integer.parseInt(
                            JOptionPane.showInputDialog(
                                String.format("Elija un ser para simular (entre 0 y %d)", ecosistema.size()))); 
                    if(opt == -1) break;
                    o = ecosistema.get(opt);
                    break; //no llegará acá a menos que no haya excepciones
                }catch(IndexOutOfBoundsException iobex){
                    JOptionPane.showMessageDialog(null, String.format("El número debe estar entre 0 y %d", ecosistema.size()));
                }catch(NumberFormatException nfex){
                    JOptionPane.showMessageDialog(null,
                            String.format("Debe ingresar un número en el rango [0, %d], no una letra\n", ecosistema.size()));
                }
            }while(true);
            if(opt == -1)
                break;
            if(o instanceof Dinosaurio){
                Dinosaurio real = (Dinosaurio)o;
                JOptionPane.showMessageDialog(null,"Encontramos un dinosaurio"+real);
                SerVivo comida; 
                try{
                    comida = real.conseguirAlimento(ecosistema);
                    real.comer(comida);
                    JOptionPane.showMessageDialog(null, "Ya comió"+real);
                }catch(OutOfFoodException ouex){
                    ecosistema.remove(o);
                    JOptionPane.showMessageDialog(null, "Murió "+real+" porque "+ouex.getMessage());
                }finally{
                    JOptionPane.showMessageDialog(null, "Terminada iteración");
                }
            }else{
                JOptionPane.showMessageDialog(null, o+": no un dinosaurio");
            }
        }while(true);
        
    }
}
