public class ComplejoPolar extends ComparaMagnitud implements Complejo{
    double magnitud, angulo;

    public ComplejoPolar(double mag, double ang){
        magnitud = mag;
        angulo = ang;
    }

    public String toString(){
        return String.format("%.1f + %.1fi", getReal(), getImag());
    }

    /*Accesores: para poder ver el estado interno sin tocarlo directamente*/
    public double getReal(){
        return this.magnitud * Math.cos(this.angulo);
    }

    public double getImag(){
        return this.magnitud * Math.sin(this.angulo);
    }

    public double getMagnitud(){
        return this.magnitud;
    }

    public double getAngulo(){
        return this.angulo;
    }

    public Complejo suma(Complejo otro){
        double nuevoReal = this.getReal()+otro.getReal();
        double nuevoImag = this.getImag()+otro.getImag();
        return new ComplejoRectangular(nuevoReal, nuevoImag);
    }

    public Complejo producto(Complejo otro){
        double nuevaMagnitud = this.getMagnitud() * otro.getMagnitud();
        double nuevoAngulo   = this.getAngulo() + otro.getAngulo();
        return new ComplejoPolar(nuevaMagnitud,  nuevoAngulo);
    }
} 
