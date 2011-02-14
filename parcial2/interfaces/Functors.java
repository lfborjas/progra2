import java.util.List;import java.util.ArrayList;import java.util.Arrays;
interface Processor<T>{
    T apply(T x);
}
interface NamedProcessor extends Processor{
    String name();
}
interface Conditional {
    boolean predicate(Object x);
}

interface Accumulator{
    Object aggregate(Object accumulator, Object current);
}

class UpCaser implements NamedProcessor, Conditional{
    public String apply(Object x){
        return ((String)x).toUpperCase();
    }

    public String name(){
        return getClass().getSimpleName();
    }

     public boolean predicate(Object x){
        for(Character c: ((String)x).toCharArray()){
            if(!c.isUpperCase(c))
                return false;
        }
        return true;
    }
}

class Alphanumerical implements Processor<String>, Conditional{
    public String apply(String x){
        return x.replaceAll("\\W", "");
    }

    public boolean predicate(Object x){
        for(Character c: ((String)x).toCharArray()){
            if(!c.isLetter(c) && !c.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}

class Even implements Conditional{
    public boolean predicate(Object x){
       return  ((Integer)x) % 2 == 0;
    }
}


class IntegerMultiplier implements Accumulator{
    public Integer aggregate(Object accumulator, Object current){
        return ((Integer)accumulator) * ((Integer)current);
    }
}


/*Hablar de cómo la interfaz processor les podría servir en el proyecto*/
public class Functors{
    public static List map(Processor p, List l){
        if (p instanceof NamedProcessor)
            System.out.println("Usando"+((NamedProcessor)p).name());
        List res = new ArrayList(); 
        for(Object e: l)
            res.add(p.apply(e));
        return res;
    }

    public static List filter(Conditional c, List l){
        List res = new ArrayList();
        for(Object e: l)
            if(c.predicate(e))
                res.add(e);
        return res;
    }

    public static Object reduce(Accumulator p, Object initial, List l){
        Object current = initial;
        for(Object e: l)
            p.aggregate(current, e);
        return current;
    }

    public static void main (String [] args)
    {
        System.out.printf("Usando map: %s\n", 
                          map(new Alphanumerical(), new ArrayList(Arrays.asList(new String[]{"hola734!", "MUNDO"}))));
        System.out.println(map(new Processor<Integer>(){
            public Integer apply(Integer x){return x*x;}
        }, new ArrayList(Arrays.asList(new Integer[]{1,2,3,4,5}))));
    }
}
