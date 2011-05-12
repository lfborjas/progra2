import java.util.ArrayList;
import java.util.Collections;

public class PruebaMagnitud{
    public static void main (String [] args)
    {
      ArrayList<ConMagnitud> lista = new ArrayList<ConMagnitud>(); 
      lista.add(new ComplejoRectangular(1,1));
      lista.add(new Vector(1,2,3));
      lista.add(new Vector(2,3,4,5));
      lista.add(new ComplejoPolar(0.5, 0.41));

      for(ConMagnitud obj: lista)
          System.out.printf("La magnitud de %s es %s\n", obj.toString(), obj.getMagnitud());

      Collections.sort(lista);

      System.out.println("Después de ordenarla:");
      for(ConMagnitud obj: lista)
          System.out.printf("La magnitud de %s es %s\n", obj.toString(), obj.getMagnitud());
    }
} 
