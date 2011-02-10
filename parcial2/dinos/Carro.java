public class Carro implements Pesable, Comparable{
    protected double masa;

    public Carro(double m){
        masa = m;
    }

    /**Método que la interfaz Pesable hace implementar*/
    public double getPeso(){
        /*Fuerza = Peso = masa * aceleración */
        return this.masa * Pesable.GRAVEDAD;
    }
    
    /**Método que la interfaz Comparable hace implementar
       cf: http://download.oracle.com/javase/6/docs/api/java/lang/Comparable.html */
    public int compareTo(Object otro){
        /*debe retornar:
         un número < 0 si el peso de éste es menor que el del otro
         0 si son iguales en peso
         > 0 si éste pesa más que el otro
         */
        Pesable o = (Pesable)otro;
        return (int)(this.getPeso() - o.getPeso());
    }
    @Override
    public String toString(){
        return String.format("Este %s pesa %.2f", this.getClass().getSimpleName(), getPeso());
    }
}
