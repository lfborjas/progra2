/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dwemthyemu;

/**
 *
 * @author UNITEC
 */
public class Heroe {
private double vida, fuerza, suerte;
private Ataque[] ataques;
private int posicion = 2;

    public Heroe(double vida, double suerte, double fuerza){
        this.vida = vida;
        this.suerte = suerte;
        this.fuerza = fuerza;
        ataques = new Ataque[9];
        ataques[0] = new Ataque("Sword",8,0);
        ataques[1] = new Ataque("Suicide bomb",80,-30);
        ataques[2] = null;
        ataques[3] = null;
        ataques[4] = null;
        ataques[5] = null;
        ataques[6] = null;
        ataques[7] = null;
        ataques[8] = null;
    }//constructor

    public String toString(){
        return "Thy name is Almagest!";
    }//tostring

    public Ataque[] getAtaques(){
        return ataques;
    }// getter de arreglo de ataques

    public double getSuerte(){
        return suerte;
    }//getter suerte

    public double getVida(){
        return vida;
    }

    public void recibirAtaque(double daño){
        vida -= daño;
        System.out.print("Hero HP: "+vida);
    }//recibir daño

    public void atacar(Enemigo enemigo, Ataque ataque){
        vida += ataque.getPowerUp()*suerte;
        System.out.println("Hero HP:" + vida);
        System.out.println("Damage dealt to enemy: "+(ataque.getFuerza()+fuerza)/suerte*enemigo.getSuerte());
        enemigo.recibirAtaque((ataque.getFuerza()+fuerza)/suerte*enemigo.getSuerte());
        System.out.println("");
    }//atacar

    public void agregarAtaque(Enemigo enemigo){
        ataques[posicion++] = enemigo.getAtaque();
    }//agregar ataque a repertorio

    public void resetSuerte(){
        suerte = Math.random();
    }

}//fin class
