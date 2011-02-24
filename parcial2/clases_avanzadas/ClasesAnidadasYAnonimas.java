import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
class Juego{
    static class Criatura{
        String nombre;
        int fuerza, carisma, vida;
        Criatura(String n){nombre = n;}
        public String toString(){
            return String.format("Se llama %s\n\tfuerza: %d\n\tcarisma: %d\n\tvida: %d", nombre, fuerza, carisma, vida);
        }
    }
}

public class ClasesAnidadasYAnonimas{
    public static void main (String [] args)
    {

        System.out.println(new Juego.Criatura("Doctor muelas"){{
            fuerza = 666;
            carisma = 2;
            vida = 10;
        }}.toString());

        List lista = new ArrayList<Juego.Criatura>(){{
            add(new Juego.Criatura("Zombie Jogger"){{
                fuerza = 92;
                carisma = 1000;
                vida = 200;
            }});

            add(new Juego.Criatura("Acid Python"){{
                fuerza = 2;
                carisma = 5000;
                vida = 20;
            }});
            
            add(new Juego.Criatura("Dragon"){{
                vida = 1340;    //tough scales
                fuerza = 451;   //bristling veins
                carisma = 1020; //toothy smile
            }
            public String toString(){
                return "I am the mighty dragon, thou shalt not inspect me!";
            }
            });
        }};

        System.out.println(lista);

        Collections.sort(lista, new Comparator<Juego.Criatura>(){
            public int compare(Juego.Criatura t, Juego.Criatura o){
                return (t.vida + t.fuerza) - (o.vida+o.fuerza);
            }

            public boolean equals(Object o){
                return false;
            }
        });

        System.out.println(lista);
    }
} 
