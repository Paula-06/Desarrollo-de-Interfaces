package mansionzombie;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private static final String LINEA = "----------------------------------------------------------------------------------------";
    private final Scanner sc = new Scanner(System.in);

    //Pantalla de bienvenida y eleccion de dificultad
    public Dificultad elegirDificultad() {
        System.out.println(LINEA);
        System.out.println("BIENVENIDO A LA MANSIÓN ZOMBIE. ELIGE DIFICULTAD:");
        System.out.println("1. FÁCIL (5 HABITACIONES)");
        System.out.println("2. DIFÍCIL (10 HABITACIONES)");
        System.out.println(LINEA);

        ArrayList<Integer> validas = new ArrayList<>();
        validas.add(1);
        validas.add(2);

        if (leerOpcion(validas) == 1) {
            return Dificultad.FACIL;
        }
        return Dificultad.DIFICIL;
    }

    //Muestra el estado y solo las acciones disponibles. Devuelve la elegida
    public int pedirAccion(Superviviente s, int habitacion, int maxHabitaciones, int zombies, int intentos) {
        ArrayList<Integer> validas = new ArrayList<>();

        System.out.println(LINEA);
        System.out.println("** PV: " + s.getVida() + " #MAX(" + s.getVidaMaxima() + "); ARMAS: "
                + s.getArmas() + "; PROTECCIÓN: " + s.getProtecciones());
        System.out.println("** LA HABITACIÓN " + habitacion + " CONTIENE: " + zombies + " ZOMBIES.");
        System.out.println("* ELIGE UNA DE LAS SIGUIENTES ACCIONES:");

        if (zombies > 0) {
            System.out.println("1. COMBATIR CONTRA UN ZOMBI.");
            validas.add(1);
        } else {
            if (intentos > 0) {
                System.out.println("2. BUSCAR POR LA HABITACIÓN (" + intentos + " INTENTOS).");
                validas.add(2);
            }
            if (habitacion == maxHabitaciones) {
                System.out.println("3. SALIR DE LA MANSIÓN.");
            } else {
                System.out.println("3. AVANZAR A OTRA HABITACIÓN.");
            }
            validas.add(3);
            if (s.isTieneBotiquin()) {
                System.out.println("4. CURARSE.");
                validas.add(4);
            }
        }
        System.out.println(LINEA);
        return leerOpcion(validas);
    }

    //Lee un numero controlando que sea entero y que este entre las opciones validas
    private int leerOpcion(ArrayList<Integer> validas) {
        while (true) {
            System.out.println("> OPCIÓN:");
            String texto = sc.nextLine().trim();
            try {
                int opcion = Integer.parseInt(texto);
                if (validas.contains(opcion)) {
                    return opcion;
                }
                System.out.println("Opción no disponible. Elige una de las mostradas: " + validas);
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número, no \"" + texto + "\".");
            }
        }
    }
}
