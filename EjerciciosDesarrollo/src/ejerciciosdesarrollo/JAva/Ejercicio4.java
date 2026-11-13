/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosdesarrollo.JAva;

import javax.swing.*;

public class Ejercicio4 {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Finalizar programa");

        JButton boton = new JButton("Salir del programa");

        boton.addActionListener(e -> {

            System.exit(0);

        });

        ventana.add(boton);

        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}