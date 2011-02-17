import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
public class Main{
    public static void fight(String attack, 
                             Creature you, Creature enemy, 
                             int yourHit, int enemyHit)
                             throws DeadCreatureException, HeroDeadException, OutOfBombsException{
        int powerUp=-1;
        System.out.printf("%s %s \n", you, attack);
        //you hit
        System.out.printf("You hit with %d points of damage!\n", yourHit);
        if((powerUp = enemy.getHit(yourHit)) != -1){
            System.out.printf("Your magick powers up %d !\n", powerUp );
        }
        //retaliation!
        System.out.printf("%s attacks back\n", enemy);
        System.out.println(String.format("Your enemy hits with %s points of damage!", enemyHit));
        if((powerUp = you.getHit(enemyHit)) != -1){
            System.out.printf("Your enemy's magick powers up %d\n", powerUp );
        }
        
    }

    public static void main (String [] args)
    {
        //las cosas básicas
        Rabbit hero = new Rabbit();
        ArrayList<Creature> dwemthysArray = new ArrayList<Creature>();
        Scanner in = new Scanner(System.in);

        //llenar el arreglo:
        dwemthysArray.add(new Creature("IndustrialRaverMonkey", 46, 35, 91, 2));        
        dwemthysArray.add(new Creature("DwarvenAngel", 540, 6, 144, 50));        
        dwemthysArray.add(new Creature("AssistantViceTentacleAndOmbudsman", 320, 6, 144, 50));        
        dwemthysArray.add(new Creature("TeethDeer", 655, 192, 19, 109));        
        dwemthysArray.add(new Creature("IntrepidDecomposedCyclist",901, 560, 422, 105));        
        dwemthysArray.add(new Creature("Dragon", 1340, 451, 1020, 939 ));        

        //las opciones:
        ArrayList<String> ataques = new ArrayList<String>();
        ataques.add("*"); //bombas
        ataques.add("^"); //boomerang
        ataques.add("/"); //espada
        ataques.add("%"); //lechuga

        //comenzar el juego
        Creature foe = dwemthysArray.get(0);
        int retries = 0; //cuantas veces revive el héroe
        int hit = 0; //lo que vale cada golpe
        String attack = ""; //mejor declarar una vez que en cada iteración
        System.out.printf("Get ready, %s has emerged\n", foe.name);
        while(true){ 
           System.out.printf("Choose your attack: %s\n> ", ataques);
           attack = in.next();
           try {
               switch(ataques.indexOf(attack)){
                   case 0:
                       fight("throws bomb", hero, foe, hero.bomb(), foe.attack());
                       break;
                   case 1:
                       fight("hurls boomerang", hero, foe, hero.boomerang(), foe.attack());
                       break;
                   case 2:
                       fight("slashes with sword", hero, foe, hero.sword(foe.getLife()), foe.attack());
                       break;
                   case 3:
                       fight("eats lettuce", hero, foe, hero.lettuce(), foe.attack());
                       break;
                   default:
                       System.out.println("C'mon, that's not an attack!");
               }
           } catch(HeroDeadException hdex){ 
               System.out.println(hdex.getMessage());
               hero = new Rabbit();
               retries ++;
               System.out.printf("A new hero has entered. You've retried %d times so far\n", retries);
           }catch(OutOfBombsException oubex){
               System.out.println(oubex.getMessage());
           }catch(DeadCreatureException dcex){
               System.out.println(dcex.getMessage());
               dwemthysArray.remove(foe);
               if(dwemthysArray.isEmpty()){
                   System.out.printf("Whoa. You decimated Dwemthy's Array (and it only took %d rabbits)\n", retries+1);
                   break;
               }else{
                   foe = dwemthysArray.get(0);
                   System.out.printf("Get ready, %s has emerged\n", foe.name);
               }
           } catch(Exception e) {
               System.out.println("Call the java cops, something unexpected happened"+ e.getMessage());
           }
        }
        

    }//fin del main
}
