package polares;

public class Complejo{
    double magnitud, angulo;

    public Complejo(double mag, double ang){
        magnitud = mag;
        angulo = ang;
    }

    public String toString(){
        return String.format("%.1f + %.1fi", getReal(), getImag());
    }

    public Complejo suma(Complejo otro){
        double r,s,a,b;
        r = this.magnitud;
        s = otro.magnitud;

        a = this.angulo;
        b = otro.angulo;

        double mag = Math.sqrt(r*r + s*s + 2*r*s*Math.cos(a-b));
        double ang = Math.atan2(r*Math.sin(a)+s*Math.sin(b),
                                r*Math.cos(a)+s*Math.cos(b));
        return new Complejo(mag, ang);
    }

    public Complejo producto(Complejo otro){
        return new Complejo(this.magnitud*otro.magnitud, this.angulo+otro.angulo);
    }

    public double getReal(){
        return this.magnitud * Math.cos(this.angulo);
    }

    public double getImag(){
        return this.magnitud * Math.sin(this.angulo);
    }

    public double getMagnitud(){
        return magnitud;
    }

    public double getAngulo(){
        return angulo;
    }

    public static Complejo crearRectangular(double real, double imag){
        return new Complejo(Math.sqrt(Math.pow(real,2)+Math.pow(imag,2)),
                Math.atan2(imag,real)
                );
    }

    public static Complejo crearPolar(double mag, double ang){
        return new Complejo(mag, ang);
    }
} 
