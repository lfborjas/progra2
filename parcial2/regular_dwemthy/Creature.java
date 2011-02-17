import java.util.Random;
public class Creature{
    protected String name;
    protected int life, strength, charisma, weapon;
    protected static Random gen = new Random();
    public Creature(String name, int life, int strength, int charisma, int weapon){
        this.name = name;
        this.life=life;
        this.strength=strength;
        this.charisma=charisma;
        this.weapon=weapon;
    }

    public int attack(){
        if(life <= 0)
            throw new ZombieCreatureException(this.name+" is too dead to fight!");
        return gen.nextInt(strength+weapon);
    }

    public String toString(){
            return String.format("<%s: life= %d, charisma= %d, strength= %d, weapon= %d>", 
                    name,
                    life,
                    charisma,
                    strength,
                    weapon);
    }

    public int getHit(int damage) throws DeadCreatureException{
        int powerUp = gen.nextInt(charisma);
        //si tiene suerte, se gana un powerUp
        if(powerUp % 9 == 7){
           this.life += powerUp / 4; 
           return powerUp;
        }
        this.life -= damage;
        if(this.life <= 0){
            if(this instanceof Rabbit)
                throw new HeroDeadException("The hero has died!!");
            else
                throw new DeadCreatureException(String.format("%s has died", name));
        }
        return -1;
    }

    public int getLife(){
        return life;
    }
}
