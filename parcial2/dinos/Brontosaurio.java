public final class Brontosaurio extends Herbivoro{
    public Brontosaurio(double p){
        super(p);
    }

    public void comer(SerVivo algo){
       peso = Math.pow(peso, algo.peso); 
    }
}
