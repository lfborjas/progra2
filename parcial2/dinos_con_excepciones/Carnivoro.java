import java.util.ArrayList;
public abstract class Carnivoro extends Dinosaurio{
    public Carnivoro(double p){
        super(p);
    }
    
    /*Aquí hay un tipo de retorno covariante: el padre retornaba SerVivo, el hijo retorna Dinosaurio*/
    public final Dinosaurio conseguirAlimento(ArrayList<SerVivo> ecosistema) throws OutOfFoodException{
        for(SerVivo lo : ecosistema){
           //no se come a sí mismo!
           if(lo instanceof Dinosaurio && lo != this){
               ecosistema.remove(lo);
               return (Dinosaurio)lo;
           }
        }
        //return null;
        throw new OutOfFoodException("¡Ya no hay dinosaurios!");
    }
}
