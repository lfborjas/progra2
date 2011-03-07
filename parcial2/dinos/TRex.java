/*Cuando una clase se declara como final, NO puede tener hijos*/
public final class TRex extends Carnivoro{
    public TRex(double p){
        super(p);
    }

    public void comer(SerVivo otro){
        this.peso += otro.peso;
    }
}
