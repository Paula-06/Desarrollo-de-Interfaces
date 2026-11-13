/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosdesarrollo.JAva;

import javax.swing.*;

public class Ejercicio1 {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Mi primera ventana");

        JLabel mensaje = new JLabel("¡Holiiiiiiiiiiii!");

        ventana.add(mensaje);

        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}