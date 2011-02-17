public class Rabbit extends Creature{
    private int bombs;

    public Rabbit(){
        super("Rabbit", 10, 2, 44, 4);
        bombs = 3;
    }

    public int boomerang(){
        return attack()+13; 
    }

    public int sword(int enemyLife){
        return attack()+gen.nextInt(4 + (int)Math.ceil(Math.pow(enemyLife % 10, 2)));
    }

    public int lettuce(){
        life += gen.nextInt(charisma);
        return 1;
    }

    public int bomb() throws OutOfBombsException{
        if(bombs == 0)
            throw new OutOfBombsException("UNH! You're out of bombs!");
        bombs -= 1;
        return attack()+86;
    }
}
