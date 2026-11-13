/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosdesarrollo.JAva;

import javax.swing.*;


public class Ejercicio3 {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Mi ventana");

        JButton boton = new JButton("Pulsa aquí");

        boton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Holiiiii");
        });

        ventana.add(boton);

        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}