public abstract class SerVivo implements Pesable, Comparable{
    protected double peso;
    SerVivo(double p){
        this.peso = p;
    }

    /**Método que la interfaz Pesable obliga a implementar*/
    public double getPeso(){
        return this.peso;
    }
    
    /**Método que Comparable obliga a implementar, nótese que hace lo mismo que 
      en carro, sólo que de una manera menos óptima*/
    public int compareTo(Object otro){
        //nótese que lo promovemos (cast) a Pesable, 
        //igual que una clase abstracta, una interfaz puede
        //perfectamente usarse como tipo, mas NO instanciarse
        Pesable o = (Pesable)otro;
        if(this.getPeso() < o.getPeso())
            return -1; //< 0 si son distintos en peso
        else if(this.getPeso() == o.getPeso())
            return 0; // = 0 si son iguales en peso
        else
            return 5; // > 0 si éste es mayor
         
    }

    /**Usamos reflexión para obtener el tipo
     en tiempo de ejecución; por polimorfismo el método getClass() obtendrá la clase adecuada*/
    @Override
    public String toString(){
        return String.format("Esto es un %s y  pesa %.2f", this.getClass().getSimpleName(), peso);
    }
}
