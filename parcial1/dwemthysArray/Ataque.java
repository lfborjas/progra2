/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dwemthyemu;

/**
 *
 * @author UNITEC
 */
public class Ataque {
private String nombre;
private double fuerza,powerUp;

    public Ataque(String nombre, double fuerza, double powerUp){
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.powerUp = powerUp;
    }//constructor

    public String toString(){
        return this.nombre;
    }//toString

    public double getFuerza(){
        return fuerza;
    }

    public double getPowerUp(){
        return powerUp;
    }
}//fin class
