/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosdesarrollo.JAva;

import javax.swing.*;

public class Ejercicio2 {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Ventana de 1000 x 800");

        ventana.setSize(1000, 800);

        // Impedir modificar el tamaño
        ventana.setResizable(false);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.setLocationRelativeTo(null);

        ventana.setVisible(true);
    }
}