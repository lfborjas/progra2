public class Velociraptor extends Carnivoro{
    public Velociraptor(double p){
        super(p);
    }

    public void comer(SerVivo otro){
        this.peso *= otro.peso;
    }
}
