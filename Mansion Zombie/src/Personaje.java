public class Personaje {

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
        if (vida == 0) {
            return false;
        } else {
            return true;
        }
    }

    //setters
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    //getters
    public int getAtaque() {
        return ataque;
    }

    public int getVida() {
        return vida;
    }



}
