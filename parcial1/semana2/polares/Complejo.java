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

    public double getReal(){
        return this.magnitud * Math.cos(this.angulo);
    }

    public double getImag(){
        return this.magnitud * Math.sin(this.angulo);
    }

    public Complejo suma(Complejo otro){
        double nuevoReal = this.getReal()+otro.getReal();
        double nuevoImag = this.getImag()+otro.getImag();
        return Complejo.desdeRectangular(nuevoReal, nuevoImag);
    }

    public Complejo producto(Complejo otro){
        double nuevaMagnitud = this.magnitud * otro.magnitud;
        double nuevoAngulo   = this.angulo + otro.angulo;
        return new Complejo(nuevaMagnitud,  nuevoAngulo);
    }

    public static Complejo desdeRectangular(double real, double imag){
        double magnitud = Math.sqrt(Math.pow(real,2)+Math.pow(imag,2));
        double angulo   = Math.atan2(imag, real);
        return new Complejo(magnitud, angulo);
    }
} 
