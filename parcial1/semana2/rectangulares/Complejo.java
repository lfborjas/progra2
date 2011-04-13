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

    public double getMagnitud(){
        return Math.sqrt(Math.pow(real,2)+Math.pow(imag,2));
    }

    public double getAngulo(){
        return Math.atan2(imag, real);
    }

    public static Complejo crearRectangular(double real, double imag){
        return new Complejo(real, imag);
    }

    public static Complejo crearPolar(double mag, double ang){
        double real = mag*Math.cos(ang);
        double imag = mag*Math.sin(ang);
        return new Complejo(real, imag);
    }
}
