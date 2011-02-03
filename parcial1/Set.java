import java.util.HashMap;
import java.util.Arrays;

public class Set<E> {
    /*E es una "variable de tipo", donde sea que necesitemos un tipo genérico dentro de la clase,
      podemos usar E
      */

    /*vamos a simular la función indicatriz del conjunto con un HashMap
     el dominio es el tipo genérico de esta instancia, el rango siempre es
     Boolean (para indicar pertenencia)
     La ventaja de HashMap es que se encarga por nosotros de los duplicados 
     */

    private HashMap<E, Boolean> indicator;

    /*Este es un bloque inicializador DE INSTANCIA: el código
      se ejecuta al llamar CUALQUIER constructor
     */
    {
        indicator = new HashMap<E, Boolean>();
    }

    //puede recibir varios argumentos O un arreglo
    public Set(Object... elements){
        for(Object element : elements)
            this.indicator.put((E)element, true);
    }

    public void add(E elem){
        this.indicator.put(elem, true);
    }

    public boolean contains(E elem){
        return this.indicator.get(elem) != null;
    }

    public E remove(E elem){
        if(this.indicator.remove(elem))
            return elem;
        else
            return null;
    }

    public String toString(){
       return Arrays.toString(this.indicator.keySet().toArray());
    }

    public Set<E> union(Set<E> otro){
        Set<E> resultado = new Set<E>(this.indicator.keySet().toArray());
        resultado.indicator.putAll(otro.indicator);
        return resultado;
    }

    public Set<E> intersection(Set<E> otro){
        Set <E> resultado = new Set<E>();
        for(E a : this.indicator.keySet())
            if(otro.contains(a))
                resultado.add(a);
        return resultado;
    }

    public Set<E> difference(Set<E> otro){
        Set<E> resultado = new Set<E>(this.indicator.keySet().toArray());
        for(E a: this.intersection(otro).indicator.keySet())
            resultado.remove(a);
        return resultado;
    }

    public boolean isSubset(Set<E> otro){
        if(otro == null)
            return false;
        /*if(! (otro instanceof E.class))
            return false;*/
        if(otro == this)
            return true;
        for(E a : this.indicator.keySet())
            if(!otro.contains(a))
                return false;
        return true;
    }

    public boolean equals(Set<E> otro){
        return this.isSubset(otro) && otro.isSubset(this);
    }

    public static void main (String [] args)
    {
        Set<Integer> x = new Set(1,2,3,4);
        Set<Integer> y = new Set(4,5,1);
        Set<String> z = new Set("hola", "mundo");

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        x.add(6);
        System.out.println(x);
        y.remove(4);
        System.out.println(y);

        System.out.printf("%s Unión %s = %s\n", x,y, x.union(y));
        System.out.printf("%s Intersección %s = %s\n", x,y, x.intersection(y));
        System.out.printf("%s Diferencia %s = %s\n", x,y, x.difference(y));
        System.out.printf("%s es subconjunto de %s ? %s\n", x,y, x.isSubset(y));
        y.remove(5);
        y.add(4);
        System.out.printf("%s subconjunto de %s ? %s\n", y,x, y.isSubset(x));
        System.out.printf("%s es igual a %s? %s\n", x,y, x.equals(y));
        x.remove(2);
        x.remove(3);
        x.remove(6);
        System.out.printf("%s es igual a %s? %s\n", y,x, x.equals(y));

    }
}
