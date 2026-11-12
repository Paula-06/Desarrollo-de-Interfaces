package mansionzombie;

public class Zombie extends Personaje {

    //Se generan aleatoriamente (ver Juego.crearZombie)
    public Zombie(int vida, int ataque) {
        super(vida, ataque);
    }

    //Los zombies no van armados: usa atacar() de Personaje tal cual
}
