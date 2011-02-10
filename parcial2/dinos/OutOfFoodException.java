/**Al heredar de Exception, esta clase se vuelve una excepción comprobada: tiene que ser manejada o propagada*/
public class OutOfFoodException extends Exception{
    public OutOfFoodException(String message){
        super(message);
    }
}
