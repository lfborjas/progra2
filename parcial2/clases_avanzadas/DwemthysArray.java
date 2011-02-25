//estas son **interfaces**
import java.util.List;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;
import java.util.Scanner;
import java.util.EmptyStackException;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
/**Ejemplo de clases internas, anónimas y bloques inicializadores*/
public class DwemthysArray{
    private static Random gen;
    private static void addMessage(String message){
        System.out.println(message);
    } 
    /*Este es un bloque inicializador de CLASE: cuando la clase se declara, se ejecuta*/
    static{
        gen = new Random();
    }

    /*Clase interna estática: independiente del padre*/
    static class Creature{

        /*Inner class madness!!*/
        static class DeadCreatureException extends Exception{
            DeadCreatureException(String obituary){super(obituary);}
        }

        static class ZombieException extends DeadCreatureException{
            ZombieException(String ghostmessage){super(ghostmessage);}
        }

        static class HeroDeadException extends DeadCreatureException{
            HeroDeadException(String lastwords){super(lastwords);}
        }

        //estos reciben 0 por defecto, aún cuando no se inicialicen explícitamente
        int life, strength, charisma, weapon;
        String name;
        public Creature(){}
        public Creature(String n){this.name = n;}
        public void hit(int damage) throws DeadCreatureException{
            int powerUp = gen.nextInt(charisma);
            //si tiene suerte, se gana un powerUp
            if(powerUp % 9 == 7){
               this.life += powerUp / 4; 
               addMessage(String.format("%s magick powers up %s !!", name, powerUp)); 
            }
            this.life -= damage;
            if(this.life <= 0)
                throw new DeadCreatureException(String.format("%s has died", name));
        }//fin de hit
        
        public void fight(Creature enemy, int weapon) throws DeadCreatureException{
            if(life <= 0 )
                throw new ZombieException(name +" is too dead to fight!");
            //attack the opponent
            int yourHit = gen.nextInt(this.strength + weapon);
            addMessage(String.format("You hit with %d points of damage!", yourHit));
            enemy.hit(yourHit);
            
            //sólo ejecutará lo siguiente si el enemigo sigue vivo
            int enemyHit = gen.nextInt(enemy.strength + enemy.weapon);
            addMessage(String.format("Your enemy hits with %s points of damage!", enemyHit));
            try{
             this.hit(enemyHit);
            }catch(DeadCreatureException dcex){
               //re-tirar la excepción: ¡el héroe ha muerto!
               addMessage(dcex.getMessage());
               throw new HeroDeadException("OH SNAP, THE HERO HAS DIED!!");
            }
        }//fin de fight
        
        public String toString(){
            return String.format("%s: life= %d, charisma= %d, strength= %d, weapon= %d", 
                    name,
                    life,
                    charisma,
                    strength,
                    weapon);
        }

    }//fin de la clase Creature


    static class Rabbit extends Creature{
        
        static class OutOfBombsException extends Exception{
            OutOfBombsException(String oopsMessage){super(oopsMessage);}
        }

        //bloque inicializador DE INSTANCIA: se ejecuta al instanciar un objeto
        private int bombs;
        {
            name = "Rabbit";
            life = 10;
            strength = 2;
            charisma = 44;
            weapon = 4;
            bombs = 3;
        }
        
        public void hurlBoomerang(Creature enemy) throws DeadCreatureException{
            addMessage(String.format("Hurl little boomerang to %s", enemy));
            fight(enemy, 13);
        }

        public void wieldSword(Creature enemy) throws DeadCreatureException{
            addMessage(String.format("Slash %s with sword", enemy));
            fight(enemy, gen.nextInt(4 + (int)Math.ceil(Math.pow(enemy.life % 10, 2))));
        }

        public void eatLettuce(Creature enemy) throws DeadCreatureException{
            int lettuce = gen.nextInt(charisma);
            addMessage(String.format("Healthy lettuce gives you %d life points!", lettuce));
            life += lettuce;
            fight(enemy, 1);
        }

        public void throwBomb(Creature enemy) throws DeadCreatureException, OutOfBombsException{
            if(bombs == 0)
                throw new OutOfBombsException("UHN!! You're out of bombs!");
            bombs -= 1;
            addMessage(String.format("Throw bomb to %s, you still have %d bombs", enemy, bombs));
            fight(enemy, 86);
        }
    }//fin de la clase Rabbit

    public static void main (String [] args)
    {
        Scanner in = new Scanner(System.in);
        //combinación de sub-clases anónimas, bloques inicializadores y reflexión
        HashMap<String, String> ataques = new HashMap(){{
            put("/", "wieldSword");
            put("^", "hurlBoomerang");
            put("%", "eatLettuce");
            put("*", "throwBomb");
        }};

        //diese ist ein stack: letze in, erste out
        Stack<Creature> dwary = new Stack(){{
            push (new Creature("Dragon"){{
                life = 1340; //tough scales
                strength = 451; //bristling veins
                charisma = 1020; //toothy smile
                weapon = 939; //fire breath
            }});
            
            push (new Creature("IntrepidDecomposedCyclist"){{
                life = 901;
                strength = 560;
                charisma = 422;
                weapon = 105; 
            }});
            
            push (new Creature("TeethDeer"){{
                life = 655;
                strength = 192;
                charisma = 19;
                weapon = 109; 
            }});
            
            push (new Creature("AssistantViceTentacleAndOmbudsman"){{
                life = 320;
                strength = 6;
                charisma = 144;
                weapon = 50; 
            }});
            
            push (new Creature("DwarvenAngel"){{
                life = 540;
                strength = 6;
                charisma = 144;
                weapon = 50; 
            }});
            
            push(new Creature("IndustrialRaverMonkey"){{
                life = 46;
                strength = 35;
                charisma = 91;
                weapon = 2;
            }});

            push(new Creature("ScubaArgentine"){{
                life = 46;
                strength = 35;
                charisma = 91;
                weapon = 2;
            }});

        }};

        Rabbit hero = new Rabbit();
        //resurrection counter
        Creature foe = dwary.pop();
        System.out.printf("Get ready, %s has emerged\n", foe.name);
        //goku siempre revivía un montón de veces en dragon ball...
        int goku = 0;
        while(true){
            try {
                System.out.printf("Choose your attack: %s\n> ", ataques.keySet());
                String attack = in.next();
                Method method = hero.getClass().getMethod(ataques.get(attack), Creature.class); 
                method.setAccessible(true);
                method.invoke(hero, foe);

            }catch(InvocationTargetException itex){
                Throwable cause = itex.getCause();
                if(cause instanceof Creature.HeroDeadException){
                    System.out.println(cause.getMessage());
                    hero = new Rabbit();
                    goku++;
                    System.out.printf("A new hero has entered. You've resurrected %d times so far\n", goku);
                }
                else if(cause instanceof Creature.DeadCreatureException){
                    System.out.println(cause.getMessage());
                    try{
                        foe = dwary.pop();
                        System.out.printf("Get ready, %s has emerged\n", foe.name);
                    }catch(EmptyStackException esex){
                        System.out.printf(
                                "Whoa. You decimated Dwemthy's Array. You only needed %d rabbits\n Bye and godspeed!\n",
                                goku);
                        break;
                    }
                }else{
                    System.out.println(cause.getMessage());
                }
            }catch(Exception e) {
                System.out.println("C'mon, that's not an attack!");
            }           
        }
    }//fin del main
}//you've reached the unfathomable depths of dwemthy's array
