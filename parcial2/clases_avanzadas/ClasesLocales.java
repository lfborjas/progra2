import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class ClubComedia{
    List<ClubComedia.Comediante> comediantes;
    int edadMaxima;

    {
        comediantes = new ArrayList<Comediante>();
    }


    ClubComedia(int maxAge){
        edadMaxima = maxAge;
    }

    public String toString(){
        return comediantes.toString();
    }

    abstract class Comediante{
        String nombre;
        int edad;
        Comediante(String n, int e){nombre = n; edad = e;}
        Comediante(){}
        public abstract String contarChiste();
        public String toString(){
            return contarChiste();
        }
    }

    public void suscribirComediante(final String algunNombre, final String chiste){
        final int edadAleatoria = (new Random()).nextInt(this.edadMaxima);
        //esta es una clase LOCAL: una clase interna que sólo existe dentro de este método
        //tiene acceso a variables de fuera, pero éstas TIENEN que ser final
        class LocalComedian extends Comediante{
            {
                nombre = algunNombre;
                edad = edadAleatoria;
            }
            public String contarChiste(){
                return this.nombre+"("+this.edad+"): "+chiste;
            }
        }
        
        this.comediantes.add(new LocalComedian());
    }

} 

class ClasesLocales{
    public static void main (String [] args)
    {
        ClubComedia club = new ClubComedia(18);
        club.suscribirComediante("Jerry Seinfeld", "Maybe the dingo ate your baby");
        club.suscribirComediante("Tina Fey", "It okay, don't be cry");
        System.out.println(club);        
    }
} 
