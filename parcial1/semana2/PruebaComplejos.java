import polares.Complejo;

public class PruebaComplejos{
    
    public static void main (String [] args)
    {
        Complejo a, b, z, w;
        a = Complejo.desdeRectangular(-3.5, 2);
        b = Complejo.desdeRectangular(1, 1);

        System.out.println(a.toString());
        System.out.println(b); //el toString es llamado implícitamente por printf

        System.out.printf("Parte real de a: %.1f\n", a.getReal() );
        System.out.printf("Parte real de b: %.1f\n", b.getReal() );
        System.out.printf("Parte imaginaria de a: %.1f\n", a.getImag());
        System.out.printf("Parte imaginaria de b: %.1f\n", b.getImag() );

        z = a.suma(b);
        System.out.printf("Suma de a y b: %s\n", z.toString());
        
        w = a.producto(b);
        System.out.printf("Producto entre a y b: %s\n", w.toString());


    }
} 
