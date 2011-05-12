public class PruebaMagnitud{
    public static void main (String [] args)
    {
      ConMagnitud[] lista = new ConMagnitud[4]; 
      lista[0] = new ComplejoRectangular(1,1);
      lista[1] = new Vector(1,2,3);
      lista[2] = new Vector(2,3,4,5);
      lista[3] = new ComplejoPolar(0.5, 0.41);

      for(ConMagnitud obj: lista)
          System.out.println(obj.getMagnitud());
    }
} 
