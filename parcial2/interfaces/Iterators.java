import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
class StringBag implements Iterable<String>, Iterator<String>{
    private ArrayList<String> bag;
    private int current;
    public StringBag(String... elements){
        bag = new ArrayList<String>(Arrays.asList(elements));
        current = 0;
    }

    public boolean hasNext(){
        return current <= bag.size()-1;
    }

    public String next() throws NoSuchElementException{
        if(current <= bag.size()-1){
            return bag.get(current++);
        }else{
            throw new NoSuchElementException();
        }
    }

    public Iterator<String> iterator(){
        return this;
    }

    public void remove(){throw new UnsupportedOperationException("Me doy pereza programarlo");}
}

public class Iterators{
    public static void main (String [] args)
    {
        StringBag b = new StringBag("hola", "mundo");
        for(String s : b)
            System.out.println(s);
    }
}
