/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mansionzombie;

import java.util.Scanner;

public class Juego {
    //Atributos
    private Superviviente superviviente;
    private int habitacionActual;
    private int numMaxHabitaciones;
    private int NumzombieHabitacion;

    Scanner sc = new Scanner(System.in);
    
    //Metodos
    void inciarPartida() {
        int facil = 1;
        int difcil = 2;
        
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("BIENVENIDO A LA MANSIÓN ZOMBIE. ELIGE DIFICULTAD:");
        System.out.println("1. FÁCIL (5 HABITACIONES)");
        System.out.println("2. DIFÍCIL (10 HABITACIONES)");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.print("> OPCIÓN: ");
        
        
        
        
    }

    void mostrarMenu() {

    }

    boolean combatir() {
        return false;
    }

    boolean buscar() {
        return false;
    }

    Zombie pasarHabitacion() { 
        
        return null;
        
    }

    boolean crearZombie() {
        return false;
    }

    boolean comprobarVictoria() {
        return false;
    }

    void comprobarDerrota() {

    }

    int elegirDificultad(int f, int d) {
       // int opc = -1;
        
        
    }
    
    
    
}
