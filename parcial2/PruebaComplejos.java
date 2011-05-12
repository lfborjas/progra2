public class PruebaComplejos{
    public static void main (String [] args)
    {
        Complejo a = new ComplejoPolar(1.0,1.0);
        Complejo b = new ComplejoRectangular(1.0,1.0);
        Complejo c = a.producto(b);
        System.out.println(c);
    }
} 
