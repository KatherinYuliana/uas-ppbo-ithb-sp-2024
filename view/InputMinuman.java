package view;

import javax.swing.*;

import controller.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputMinuman {
    private JFrame frame;
    private JTextField kodeField;
    private JTextField namaField;
    private JTextField hargaField;
    private JRadioButton panasButton, dinginButton;
    Controller con = Controller.getInstance();

    public InputMinuman() {
        frame = new JFrame("Input Minuman");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel kodeLabel = new JLabel("Kode");
        kodeLabel.setBounds(20, 20, 100, 25);
        frame.add(kodeLabel);

        kodeField = new JTextField();
        kodeField.setBounds(120, 20, 150, 25);
        frame.add(kodeField);

        JLabel namaLabel = new JLabel("Nama");
        namaLabel.setBounds(20, 60, 100, 25);
        frame.add(namaLabel);

        namaField = new JTextField();
        namaField.setBounds(120, 60, 150, 25);
        frame.add(namaField);

        JLabel hargaLabel = new JLabel("Harga");
        hargaLabel.setBounds(20, 100, 100, 25);
        frame.add(hargaLabel);

        hargaField = new JTextField();
        hargaField.setBounds(120, 100, 150, 25);
        frame.add(hargaField);

        // Jenis minuman
        JLabel jenisLabel = new JLabel("Jenis");
        jenisLabel.setBounds(20, 140, 100, 25);
        frame.add(jenisLabel);

        panasButton = new JRadioButton("Panas");
        panasButton.setBounds(120, 140, 80, 25);
        frame.add(panasButton);
        dinginButton = new JRadioButton("Dingin");
        dinginButton.setBounds(200, 140, 150, 25);
        frame.add(dinginButton);

        ButtonGroup jenisGroup = new ButtonGroup();
        jenisGroup.add(panasButton);
        jenisGroup.add(dinginButton);

        JButton simpanButton = new JButton("Simpan");
        simpanButton.setBounds(150, 230, 80, 20);
        frame.add(simpanButton);

        // Add action listener to the save button
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kode = kodeField.getText();
                String nama = namaField.getText();
                int harga = Integer.parseInt(hargaField.getText());
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // public static void main(String[] args) {
    //     new InputMinuman();
    // }
}
