import java.util.ArrayList;
public abstract class Herbivoro extends Dinosaurio{
    public Herbivoro(double p){
        super(p); 
    }
    /*Usamos final para que los hijos NO puedan redefinir este método*/
    public final Planta conseguirAlimento(ArrayList<SerVivo> ecosistema) throws OutOfFoodException{
        for(SerVivo lo : ecosistema){
           if(lo instanceof Planta){
            ecosistema.remove(lo);
            return (Planta)lo;
           } 
        }
        //return null;
        /*Si no hay comida, levantemos una excepción*/
        throw new OutOfFoodException("¡Ya no hay plantas!");
    }
}
