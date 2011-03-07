import java.util.ArrayList;
public abstract class Dinosaurio extends SerVivo{
    protected double peso; //en realidad sería "masa"...
    public Dinosaurio(double peso){
        super(peso);
    }
    
    public abstract SerVivo conseguirAlimento(ArrayList<SerVivo> ecosistema);
    public abstract void comer(SerVivo alimento);
}
