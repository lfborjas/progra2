public class ComplejoRectangular implements Complejo{
    private double real, imag;

    public ComplejoRectangular(double r, double i){
        real = r;
        imag = i;
    }

    public String toString(){
        return String.format("%.1f + %.1fi", real, imag);
    }

    public Complejo suma(Complejo otro){
        return new ComplejoRectangular(
                this.getReal()+otro.getReal(),
                this.getImag()+otro.getImag()
                            );
    }

    public Complejo producto(Complejo otro){
        return new ComplejoPolar(this.getMagnitud()*otro.getMagnitud()
                                ,this.getAngulo()+otro.getAngulo());
    }

    public double getReal(){
        return real;
    }

    public double getImag(){
        return imag;
    }

    public double getMagnitud(){
        return Math.sqrt(
                    Math.pow(this.real,2)+
                    Math.pow(this.imag,2)
                );
    }

    public double getAngulo(){
        return Math.atan2(this.imag, this.real);
    }
}
