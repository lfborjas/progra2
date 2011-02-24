class Persona{
    String nombre;
    String paisResidencia;
    Direccion direccion;

    public class Direccion{
        String calle;
        String ciudad;
        public Direccion(String c, String city){
          calle= c; ciudad=city;
        }

        public String toString(){
            //uso de .this
            return Persona.this.nombre + "vive en " + paisResidencia + ciudad + calle;
        }
    }

    public Persona(String nombre, String pais){
        this.nombre = nombre;
        this.paisResidencia = pais;
    }

    public String toString(){
        return direccion.toString();
    }
}

public class ClaseInterna{
    public static void main (String [] args)
    {
        Persona p = new Persona("Luis ", " Honduras ");
        //uso de .new
        Persona.Direccion d = p.new Direccion(" calle algo ", " tegucigalpa ");
        p.direccion = d;
        System.out.println(p);
    }
}
