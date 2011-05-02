/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dwemthyemu;

/**
 *
 * @author UNITEC
 */
public class Enemigo {
private String nombre;
private double vida, suerte, fuerza;
private Ataque ataque;

    public Enemigo(String nombre, double vida, double suerte, double fuerza, Ataque ataque ){
        this.nombre = nombre;
        this.vida = vida;
        this.suerte = suerte;
        this.fuerza = fuerza;
        this.ataque = ataque;
    }//constructor

    public String toString(){
        return nombre+" is waiting!";
    }//tostring

    public double getSuerte(){
        return suerte;
    }

    public double getVida(){
        return vida;
    }

    public void recibirAtaque(double daño){
        vida -= daño;
        System.out.print("Enemy HP: "+vida);
    }//recibir daño

    public void atacar(Heroe heroe){
        System.out.println("Damage received: "+ fuerza/suerte*heroe.getSuerte());
        heroe.recibirAtaque( fuerza/suerte*heroe.getSuerte());
        System.out.println("");
    }//atacar

    public void resetSuerte(){
        suerte = Math.random();
    }

    public Ataque getAtaque(){
        return ataque;
    }

}//fin class
