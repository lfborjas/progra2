import java.util.List;import java.util.ArrayList;import java.util.Arrays;
interface Processor<T>{
    T apply(T x);
}
interface NamedProcessor<T> extends Processor<T>{
    String name();
}
interface Conditional <T> {
    boolean predicate(T x);
}

interface Accumulator<T>{
    T aggregate(T accumulator, T current);
}

class UpCaser implements NamedProcessor<String>, Conditional<String>{
    public String apply(String x){
        return x.toUpperCase();
    }

    public String name(){
        return getClass().getSimpleName();
    }

     public boolean predicate(String x){
        for(Character c: x.toCharArray()){
            if(!c.isUpperCase(c))
                return false;
        }
        return true;
    }
}

class Alphanumerical implements Processor<String>, Conditional<String>{
    public String apply(String x){
        return x.replaceAll("\\W", "");
    }

    public boolean predicate(String x){
        for(Character c: ((String)x).toCharArray()){
            if(!c.isLetter(c) && !c.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}

class Vowelizer implements Processor<String>, Conditional<String>, Accumulator<String>{
    /**Aquí estoy usando expresiones regulares (regular expressions or regexes) para
       llevar a cabo esta tarea, la expresión dice:
       reemplazar todo lo que NO esté en el conjunto (a,e,i,o,u,A,E,I,O,U) con espacios
     */
    public String apply(String x){
        return x.replaceAll("[^aeiouAEIOU]", "");
    }
    
    /**Aquí estoy usando expresiones regulares otra vez, esta vez la expresión dice:
       revisar si la cadena consiste en elementos del conjunto (a,e,i,o,u,A,E,I,O,U) repetidos una
       o más veces
     */
    public boolean predicate(String x){
        return x.matches("[aeiouAEIOU]+");
    }
    
    /**Sólo agrega las vocales del String*/
    public String aggregate(String accumulator, String current){
        System.out.println(apply(current));
        return accumulator + apply(current);
    }
}

class Even implements Conditional<Integer>{
    public boolean predicate(Integer x){
       return  x % 2 == 0;
    }
}

class Square implements Processor<Integer>, Conditional<Integer>{
    public Integer apply(Integer n){
        return n*n;
    }

    /**Revisa que el número sea un cuadrado perfecto*/
    public boolean predicate(Integer number){
        double root = Math.sqrt(number);
        return root == Math.floor(root);
    }
}

class Multiplier implements Accumulator<Integer>{
    public Integer aggregate(Integer accumulator, Integer current){
        return accumulator * current;
    }
}

/**Acá les regalo esta clase...*/
class IterUtils{
    public static <T> List<T> map(Processor<T> p, Iterable<T> l){
        if (p instanceof NamedProcessor)
            System.out.println("Usando"+((NamedProcessor)p).name());
        List res = new ArrayList<T>(); 
        for(T e: l)
            res.add(p.apply(e));
        return res;
    }

    public static <T> List<T> filter(Conditional<T> c, Iterable<T> l){
        List res = new ArrayList<T>();
        for(T e: l)
            if(c.predicate(e))
                res.add(e);
        return res;
    }
    
    /**Esto no lo habíamos visto, es un método genérico, más info acá: 
       http://download.oracle.com/javase/tutorial/extra/generics/methods.html
     */
    public static <T> T reduce(Accumulator<T> p, T initial, Iterable<T> l){
        T current = initial;
        for(T e: l){
            current = p.aggregate(current, e);
        }
        return current;
    }
    
}

/*Hablar de cómo la interfaz processor les podría servir en el proyecto*/
public class Functors{

    public static void main (String [] args)
    {
        List<String> listaDeStrings = new ArrayList(Arrays.asList(new String[]{"h$o#la734!", "MUNDO", "queue", "EAU", "au"}));
        System.out.println("Operaciones sobre strings alfanuméricas");
        System.out.println("Lista original: "+listaDeStrings);
        System.out.printf(
                        "Usando map: convertir todas a alfanúm: %s\n", 
                        IterUtils.map(new Alphanumerical(), listaDeStrings)
                        );

        System.out.printf(
                    "Usando filter: sacar las que sólo son alfanún %s\n", 
                    IterUtils.filter(new Alphanumerical(), listaDeStrings)
                    );

        System.out.println("Operaciones con vocales");
        System.out.printf(
                "Con map: dejar sólo las vocales de todas: %s\n",
                IterUtils.map(new Vowelizer(), listaDeStrings)
                );
        System.out.printf(
                "Con filter: sólo dejar las palabras que sean puras vocales %s\n", 
                IterUtils.filter(new Vowelizer(), listaDeStrings)
                );
        System.out.printf(
                "Con reduce: construir un string con sólo las vocales: %s\n",
                IterUtils.reduce(new Vowelizer(), "vocales: ", listaDeStrings)
                );

        
        List<Integer> listaDeEnteros= new ArrayList(Arrays.asList(new Integer[]{1,4,6,9,16,32}));
        System.out.println("Lista original: "+listaDeEnteros);
        System.out.printf(
                "Con filter: sacar los pares de una lista: %s\n", 
                IterUtils.filter(new Even(), listaDeEnteros)
                );

        System.out.printf(
                "Con map: sacar el cuadrado de todos los números en la lista: %s\n",
                IterUtils.map(new Square(), listaDeEnteros)
                );
        System.out.printf(
                "Con filter: sacar los que son cuadrados perfectos: %s\n", 
                IterUtils.filter(new Square(), listaDeEnteros)
                );
        

        System.out.printf(
                "Con reduce: sacar el producto de la lista: %s\n", 
                IterUtils.reduce(new Multiplier(),1,listaDeEnteros)
                );
    }
}
