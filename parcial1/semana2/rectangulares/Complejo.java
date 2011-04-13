package rectangulares;

public class Complejo{
    private double real, imag;

    public Complejo(double r, double i){
        real = r;
        imag = i;
    }

    public String toString(){
        return String.format("%.1f + %.1fi", real, imag);
    }

    public Complejo suma(Complejo otro){
        return new Complejo(
                this.getReal()+otro.getReal(),
                this.getImag()+otro.getImag()
                            );
    }

    public Complejo producto(Complejo otro){
        double a,b,c,d;
        a = this.getReal();
        b = this.getImag();
        c = otro.getReal();
        d = otro.getImag();
        return new Complejo(a*c-b*d, a*d+b*c);
    }


    public double getReal(){
        return real;
    }

    public double getImag(){
        return imag;
    }

    public static Complejo desdeRectangular(double r, double im){
        return new Complejo(r, im);
    }
}
