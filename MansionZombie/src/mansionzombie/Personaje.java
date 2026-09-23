/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mansionzombie;

public abstract class Personaje {

    //Atributos
    private int vida;
    private int ataque;

    //Constructor
    public Personaje(int vida, int ataque) {
        this.vida = vida;
        this.ataque = ataque;
    }

    //dentro int
    void recibirDaño(int daño) {
        vida -= daño;
    }

    //Está vivo *si* o *no*
    boolean comprobarVivo() {
        if (vida <= 0) {
            return false;
        } else {
            return true;
        }
    }

    //Setters
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    //Getters
    public int getAtaque() {
        return ataque;
    }

    public int getVida() {
        return vida;
    }



}
