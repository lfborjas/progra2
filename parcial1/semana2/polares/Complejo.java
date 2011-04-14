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

    /*Accesores: para poder ver el estado interno sin tocarlo directamente*/
    public double getReal(){
        return this.magnitud * Math.cos(this.angulo);
    }

    public double getImag(){
        return this.magnitud * Math.sin(this.angulo);
    }

    /*Mutador: permite cambiar el estado interno*/
    public void setReal(double nuevoReal){
       double imag = getImag();
       //cambiar la parte real cambia el vector, así que 
       //ahora tendrá una nueva magnitud y un nuevo ángulo
       this.magnitud = Math.sqrt(Math.pow(nuevoReal, 2)+Math.pow(imag, 2));
       this.angulo = Math.atan2(imag, nuevoReal);
    }

    /**Construye un número complejo polar a partir de coordenadas rectangulares*/
    public static Complejo desdeRectangular(double real, double imag){
        double magnitud = Math.sqrt(Math.pow(real,2)+Math.pow(imag,2));
        double angulo   = Math.atan2(imag, real);
        return new Complejo(magnitud, angulo);
    }

    //TAREA: hacer el mutador de la parte imaginaria

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

} 
