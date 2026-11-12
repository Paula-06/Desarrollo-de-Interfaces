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

    //Metodos compartidos por Zombie y Superviviente

    //Tirada de un dado de 1 a maximo. Static porque no depende de ningun objeto
    public static int tirarDado(int maximo) {
        return (int) (Math.random() * maximo) + 1;
    }

    //Ataque: dado con tantas caras como puntos de ataque
    public int atacar() {
        return tirarDado(ataque);
    }

    public void recibirDaño(int daño) {
        vida -= daño;
        if (vida < 0) {
            vida = 0;
        }
    }

    public boolean comprobarVivo() {
        return vida > 0;
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
