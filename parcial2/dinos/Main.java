import java.util.ArrayList;
import java.util.Random;
import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import java.util.Scanner;
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

        ArrayList ecosistema = new ArrayList();
        llenarEcosistema(ecosistema);
        Scanner in = new Scanner(System.in);
        Object o; //estoy usando la super super clase...
        int opt;
        do{
            System.out.printf("El ecosistema es: %s\n", ecosistema);
            System.out.printf("Elija un elemento (-1 para dejar de simular)");
            opt = in.nextInt();
            if(opt == -1)
                break;
            o = ecosistema.get(opt);
            if(o instanceof Dinosaurio){
                Dinosaurio real = (Dinosaurio)o;
                System.out.printf("Encontramos un dinosaurio: %s \n", real);
                SerVivo comida =  real.conseguirAlimento(ecosistema);
                if(comida != null){
                    real.comer(comida);
                    System.out.printf("Ya comió el dinosaurio: %s \n", real);
                }else{
                    ecosistema.remove(o);
                    System.out.printf("Ya murió el dinosaurio: %s \n", real);
                }
            }else{
               System.out.printf("%s no es un dinosaurio\n", o);
            }
        }while(true);
 
    }
}
