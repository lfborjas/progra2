import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Contacto{
    String nombre;
    Long[] numeros;
    public Contacto(String n, Long[] m){nombre = n; numeros = m;}
    public String toString(){
        return String.format("Nombre: %s, Números: %s", nombre, Arrays.toString(numeros));
    }
}

abstract class Agenda{
    HashMap<Character, ArrayList<Contacto> > contactos;
    String nombre;

    {
        contactos = new HashMap<Character, ArrayList<Contacto>>();
        for(Character c = 'A'; c <= 'Z'; c++){
            contactos.put(c, new ArrayList<Contacto>());
        }
    }


    public Agenda(String nombre){
        this.nombre = nombre;
    }

    public void agregarContacto(Character pagina, Contacto c){
        contactos.get(pagina).add(c);
    }

    public void agregarContacto(Contacto c){
        contactos.get(c.nombre.charAt(0)).add(c);
    }

    public abstract ArrayList<Contacto> contactosImportantes();

    public String toString(){
        return contactos.toString();
    }
}

class MiAgenda extends Agenda {
    public MiAgenda(String n){
        super(n);
    } 
    public ArrayList<Contacto> contactosImportantes(){
        return contactos.get('L');
    }
}

public class AgendaAvanzada{
    public static void main (String [] args)
    {
        Agenda miAgendaConNombreLargo = new MiAgenda("Agenda de Luis Felipe");

        Long[] nlf = {(long)99010606};
        Long[] nta = {(long)45673000};

        Agenda laDeTitus = new Agenda("Agenda de Titus"){

            {
                Long[] nta = {(long)45673000};
                agregarContacto('A', new Contacto("Titus Andronicus", nta));
            }

            public ArrayList<Contacto> contactosImportantes(){
                return contactos.get('A');
            }
        };

        ArrayList<String> lista = new ArrayList(){
            {
            add("hola");
            add("mundo");
            }
        };

        ArrayList<String> lista2 = new ArrayList<String>();
        lista2.add("hola");
        lista2.add("mundo");


        miAgendaConNombreLargo.agregarContacto(new Contacto("Luis Felipe", nlf));
        miAgendaConNombreLargo.agregarContacto('A', new Contacto("Titus Andronicus", nta));
        System.out.printf("Mi agenda:%s\n", miAgendaConNombreLargo);

        System.out.printf("Mi agenda:%s\n", laDeTitus);
        System.out.printf("Mis contactos importantes :%s\n", miAgendaConNombreLargo.contactosImportantes());
        
        System.out.printf("Mis contactos importantes :%s\n", laDeTitus.contactosImportantes());
    }

}
