/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dwemthyemu;
import java.util.Scanner;
/**
 *
 * @author UNITEC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String command = "";
        int currentEnemy = 0;
        Scanner in = new Scanner(System.in);
        Heroe heroe = new Heroe(100,Math.random(),15);
        Ataque[] ataques = heroe.getAtaques();
        Enemigo[] enemigos = new Enemigo[7];
        enemigos[0] = new Enemigo("Infectious rat",35,Math.random(),5,new Ataque("Whip",15,0));
        enemigos[1] = new Enemigo("Vampire bat",45,Math.random(),8,new Ataque("Stale bread",-5,-10));
        enemigos[2] = new Enemigo("Bloody zombie",50,Math.random(),14,new Ataque("Gladius",20,0));
        enemigos[3] = new Enemigo("Blue rose",100,Math.random(),9,new Ataque("Roast beef",-5,100));
        enemigos[4] = new Enemigo("Venom stinger",60,Math.random(),14,new Ataque("Ashes",25,0));
        enemigos[5] = new Enemigo("Destroyer",70,Math.random(),20,new Ataque("Cross",40,25));
        enemigos[6] = new Enemigo("Finisher",351,Math.random(),30,new Ataque("Glory",0,0));
        System.out.println("Your epic adventure has begun!");
        int number = 1;
        for (Ataque arma: ataques){
            if(arma != null)
                System.out.println(number++ +". "+ arma);
        }//impresion de armas
        System.out.println(enemigos[currentEnemy]);
        System.out.println("Enter 'Inventory' to visualize your weapons and the enemy's name, or the number of an attack to use it.");
        do{
            System.out.print("Command?: ");
            command = in.next();
            if(command.equals("Inventory") || command.equals("inventory")){
                number = 1;
                for (Ataque arma: ataques){
                    if(arma != null)
                        System.out.println(number++ +". "+ arma);
                }//fin impresion de armas
                System.out.println(enemigos[currentEnemy]);
            }//fin if
            if(Character.isDigit(command.charAt(0)) && command.length() < 2){
                if (Integer.parseInt(command) <= (currentEnemy+2)){
                    heroe.atacar(enemigos[currentEnemy], ataques[Integer.parseInt(command) - 1]);
                    heroe.resetSuerte();
                    if (heroe.getVida() <= 0 || enemigos[currentEnemy].getVida() <= 0){
                        if(heroe.getVida() <= 0){
                            currentEnemy = 7;
                            System.out.println("Game Over.");
                        }//if hero dies
                        else{
                            heroe.agregarAtaque(enemigos[currentEnemy]);
                            currentEnemy++;
                            System.out.println("You have defeated the enemy!");
                            if (currentEnemy <= 6)
                                    System.out.println("\n\n"
                                    +"\nYou obtained "+enemigos[currentEnemy - 1].getAtaque() + "."
                                    +"\n"+enemigos[currentEnemy]+"\n");
                            else
                                System.out.println("\n\nYou obtained "+enemigos[currentEnemy - 1].getAtaque() + "."
                                        +"\nCongratulations! You beat the game!"
                                        +"\n"+heroe);
                        }//if enemy dies
                    }//if a character dies
                    else{
                        enemigos[currentEnemy].atacar(heroe);
                        enemigos[currentEnemy].resetSuerte();
                        if(heroe.getVida() <= 0){
                            currentEnemy = 7;
                            System.out.println("Game Over.");
                        }
                    }//if no one died after the hero attacked
                }
            }//verificacion de numeros
        }while(currentEnemy < 7);
    }//fin main

}//fin class
