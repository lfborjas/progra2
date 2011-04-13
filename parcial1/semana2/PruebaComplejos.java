import rectangulares.Complejo;

public class PruebaComplejos{
    
    public static void asegurar(boolean condicion, String mensajeError)
    {
        if(!condicion)
            System.out.println(mensajeError);
    }

    public static void main (String [] args)
    {
        Complejo a, b;
        a = Complejo.desdeRectangular(-3.5, 2);
        b = Complejo.desdeRectangular(1, 1);

        asegurar(a.getReal() == -3.5, "La parte real de a no coincide");
        asegurar(b.getReal() ==  1.0, "La parte real de b no coincide");
        asegurar(a.getImag() ==  2.0, "La parte imaginaria de a no coincide");
        asegurar(b.getImag() ==  1.0, "La parte imaginaria de b no coincide");

        asegurar(a.toString().equals("-3.5 + 2.0i"), "El toString de a está mal");
        asegurar(b.toString().equals("1.0 + 1.0i"), "El toString de b está mal");

        asegurar(a.suma(b).toString().equals("-2.5 + 3.0i"), "No sirve la suma");

        asegurar(a.producto(b).toString().equals("-5.5 + -1.5i"), "No sirve el producto");


    }
} 
