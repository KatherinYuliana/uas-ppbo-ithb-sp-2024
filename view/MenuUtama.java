package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUtama {
    private JFrame frame;
    public MenuUtama() {
        frame = new JFrame("Menu Utama");
        frame.setSize(320, 220);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        // Create buttons
        JButton inputMakananButton = new JButton("Input Makanan");
        JButton daftarMakananButton = new JButton("Daftar Makanan");
        JButton inputMinumanButton = new JButton("Input Minuman");
        JButton daftarMinumanButton = new JButton("Daftar Minuman");

        inputMakananButton.setBounds(20, 40, 120, 20);
        daftarMakananButton.setBounds(150, 40, 130, 20);
        inputMinumanButton.setBounds(20, 80, 120, 20);
        daftarMinumanButton.setBounds(150, 80, 130, 20);

        // Add buttons to the frame
        frame.add(inputMakananButton);
        frame.add(daftarMakananButton);
        frame.add(inputMinumanButton);
        frame.add(daftarMinumanButton);

        // Add action listeners to the buttons
        inputMakananButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InputMakanan();
                frame.dispose();
            }
        });

        daftarMakananButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        inputMinumanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InputMinuman();
                frame.dispose();
            }
        });

        daftarMinumanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // public static void main(String[] args) {
    //     new MenuUtama();
    // }
}
