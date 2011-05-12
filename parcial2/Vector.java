import java.util.ArrayList;
import java.util.Arrays;
public class Vector extends ComparaMagnitud{
    ArrayList<Number> members;
    public Vector(Number... elems){
        members = new ArrayList<Number>();
        members.addAll(Arrays.asList(elems));
    }

    public double getMagnitud(){
        double res=0;
        for (Number n : members)
            res += n.doubleValue();
        return Math.sqrt(res);
    }

    public String toString(){
        return members.toString();
    }
} 
