package view;

import javax.swing.*;

import controller.Controller;
import model.Makanan;
import model.MenuResto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InputMakanan {
    private JFrame frame;
    private JTextField kodeField;
    private JTextField namaField;
    private JTextField hargaField;
    private JTextField porsiField;
    private JCheckBox vegetarianCheckBox;
    Controller con = Controller.getInstance();

    public InputMakanan() {
        frame = new JFrame("Input Makanan");
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

        JLabel porsiLabel = new JLabel("Porsi");
        porsiLabel.setBounds(20, 140, 100, 25);
        frame.add(porsiLabel);

        porsiField = new JTextField();
        porsiField.setBounds(120, 140, 150, 25);
        frame.add(porsiField);

        JLabel porsiUnitLabel = new JLabel("(orang)");
        porsiUnitLabel.setBounds(280, 140, 50, 25);
        frame.add(porsiUnitLabel);

        vegetarianCheckBox = new JCheckBox("Aman untuk vegetarian");
        vegetarianCheckBox.setBounds(120, 180, 200, 25);
        frame.add(vegetarianCheckBox);

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
                int porsi = Integer.parseInt(porsiField.getText());
                boolean vegetarian = vegetarianCheckBox.isSelected();

                ArrayList<MenuResto> listMenu = con.getAllMenuResto();
                MenuResto newMenu = new MenuResto(kode, nama, harga, listMenu.size() + 1);
                boolean cek = con.addNewMenuResto(newMenu);
                
                ArrayList<Makanan> listMakanan = con.getAllMakanan();
                Makanan newMakanan = new Makanan(kode, nama, harga, porsi, vegetarian, listMakanan.size() + 1);
                boolean cek2 = con.addNewMakanan(newMakanan);

                if (cek && cek2) {
                    JOptionPane.showMessageDialog(frame, "Makanan Berhasil Ditambah", "Success",
                            JOptionPane.WARNING_MESSAGE);
                    new MenuUtama();
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Makanan Gagal Ditambah", "Error",
                            JOptionPane.WARNING_MESSAGE);
                }
                
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // public static void main(String[] args) {
    //     new InputMakanan();
    // }
}
