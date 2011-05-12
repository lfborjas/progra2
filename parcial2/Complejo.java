public interface Complejo{
    double getReal();
    double getImag();
    double getMagnitud();
    double getAngulo();
    Complejo suma(Complejo o);
    Complejo producto(Complejo o);
}
