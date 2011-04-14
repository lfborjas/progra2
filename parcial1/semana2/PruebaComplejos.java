/**Muestra de encapsulamiento: acá podríamos tener 
   import polares.Complejo;
   o
   import rectangulares.Complejo;
   Y debería funcionar igual en ambos casos:
   si sólo usamos MÉTODOS para comunicarnos con 
   objetos, la representación interna ya no nos importa
   y la podríamos cambiar completamente
 */
import rectangulares.Complejo;
//import polares.Complejo;

public class PruebaComplejos{
    public static void main (String [] args)
    {
        Complejo a, b, z, w;
        a = Complejo.desdeRectangular(-3.5, 2);
        b = Complejo.desdeRectangular(1, 1);

        System.out.println(a.toString());
        System.out.println(b); //el toString es llamado implícitamente por printf

        /*no podemos poner a.real o a.imag porque esos miembros son privados
        además, estaríamos asumiendo que TIENEN esa parte, y podría no ser, 
        si decidimos usar la representación polar
        */
        System.out.printf("Parte real de a: %.1f\n", a.getReal()); 
        System.out.printf("Parte real de b: %.1f\n", b.getReal() );
        System.out.printf("Parte imaginaria de a: %.1f\n", a.getImag());
        System.out.printf("Parte imaginaria de b: %.1f\n", b.getImag() );
        

        z = a.suma(b);
        System.out.printf("Suma de a y b: %s\n", z.toString());
        
        w = a.producto(b);
        System.out.printf("Producto entre a y b: %s\n", w.toString());

        /*¿Y si quisiéramos cambiar la parte real de alguno de los números?
          Podríamos usar a.real = 5, pero como la propiedad es privada
          usamos el mutador setReal
          */
        a.setReal(5);
        System.out.printf("a después de que mutáramos su parte real: %s\n", a.toString());
    }
} 
