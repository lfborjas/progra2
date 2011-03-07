//linkedList es otro tipo de lista, familia de ArrayList
import java.util.LinkedList;
import java.util.Random;
import java.lang.reflect.Constructor;
import java.util.Collections;
public class Ordenador{
    public static void llenarLista(LinkedList lista){
       Random gen = new Random();
       String[] pesables = {"TRex", "Brontosaurio", "Velociraptor", "Planta", "Carro"};
       try{
       /*En realidad una sentencia for es un atajo para un while. Acá les muestro cómo*/    
       int i = 0;//primera parte de un for
       while(i < gen.nextInt(10)){//segunda parte de un for
           Class clase = Class.forName(pesables[gen.nextInt(pesables.length)]);
           Constructor constructorConDouble = clase.getConstructors()[0];
           lista.add(constructorConDouble.newInstance(new Double(gen.nextDouble())));
           i++; //tercera parte de un for
       }
       }catch(Exception e){
        throw new RuntimeException(e); //mala práctica: esconder excepciones
       }
    }

    public static void main(String[] args){
        LinkedList l = new LinkedList();
        llenarLista(l);
        System.out.printf("La lista desordenada: %s\n", l);
        //Collections.sort espera que los elementos implementen Comparable
        Collections.sort(l);
        System.out.printf("La lista ordenada: %s\n", l);
        
    }
}
