import java.util.HashMap;

public class MathUtils{
    //guardar computaciones previas de factorial
    //¿qué hace un HashMap?
    //http://download.oracle.com/javase/6/docs/api/java/util/HashMap.html
    private static HashMap<Integer, Integer> previousFactorials;

    static{
        previousFactorials = new HashMap<Integer, Integer>(); 
        //guardemos factoriales conocidos
        previousFactorials.put(1, 1);
        previousFactorials.put(2, 2);
        previousFactorials.put(3, 6);
    }
    
    /**Calcula el factorial de n
       
       Esto de usar computaciones previas en vez de volverlas a hacer
       se conoce como "programación dinamica"
     */
    public static int factorial(int n){
        //si ya está en la tabla de computaciones previas, devolverlo
        if(previousFactorials.containsKey(n)){
            System.out.printf("Ya tenía guardado el factorial de %d :)\n", n);
            return previousFactorials.get(n);
        }else if(n == 1){
            return 1;
        }else{
            int f = n * factorial(n-1);
            previousFactorials.put(n, f);
            return f;
        }
    }

    
    public static void main (String [] args)
    {
        for(int i=1;i<10;i++){
            System.out.printf("Factorial de %d: %d\n", i, factorial(i));
        }
    }

    /*aquí podría haber más métodos matemáticos
      ...
      */
} 
