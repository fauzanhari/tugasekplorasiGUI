
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorFrame extends JFrame implements ActionListener {

    // Deklarasi komponen GUI
    private JTextField txtAngka1;
    private JTextField txtAngka2;

    private JButton btnTambah;
    private JButton btnKurang;
    private JButton btnKali;
    private JButton btnBagi;

    private JLabel lblHasil;

    // Constructor
    public CalculatorFrame() {

        // Pengaturan JFrame
        setTitle("Simple Calculator by Fauzan Hari");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        // Mengatur konfirmasi ketika jendela ditutup
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                int pilihan = JOptionPane.showConfirmDialog(
                    CalculatorFrame.this,
                    "Apakah Anda yakin ingin keluar?",
                    "Konfirmasi Keluar",
                    JOptionPane.YES_NO_OPTION
                );

                if (pilihan == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        // Panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Panel input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 10, 10));

        inputPanel.add(new JLabel("Angka Pertama:"));

        txtAngka1 = new JTextField();
        inputPanel.add(txtAngka1);

        inputPanel.add(new JLabel("Angka Kedua:"));

        txtAngka2 = new JTextField();
        inputPanel.add(txtAngka2);

        // Panel tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(
            new FlowLayout(FlowLayout.CENTER, 10, 10)
        );

        btnTambah = new JButton("+");
        btnKurang = new JButton("-");
        btnKali = new JButton("*");
        btnBagi = new JButton("/");

        buttonPanel.add(btnTambah);
        buttonPanel.add(btnKurang);
        buttonPanel.add(btnKali);
        buttonPanel.add(btnBagi);

        // Label hasil
        lblHasil = new JLabel("Hasil: -", JLabel.CENTER);

        // Menggabungkan komponen ke panel utama
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(lblHasil, BorderLayout.SOUTH);

        // Memasukkan panel utama ke JFrame
        add(mainPanel);

        // Event Listener untuk tombol
        btnTambah.addActionListener(this);
        btnKurang.addActionListener(this);
        btnKali.addActionListener(this);
        btnBagi.addActionListener(this);
    }

    // Override method actionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            // Mengambil input angka
            double angka1 = Double.parseDouble(
                txtAngka1.getText().trim()
            );

            double angka2 = Double.parseDouble(
                txtAngka2.getText().trim()
            );

            double hasil = 0;

            // Operasi penjumlahan
            if (e.getSource() == btnTambah) {

                hasil = angka1 + angka2;

            }

            // Operasi pengurangan
            else if (e.getSource() == btnKurang) {

                hasil = angka1 - angka2;

            }

            // Operasi perkalian
            else if (e.getSource() == btnKali) {

                hasil = angka1 * angka2;

            }

            // Operasi pembagian
            else if (e.getSource() == btnBagi) {

                if (angka2 == 0) {

                    JOptionPane.showMessageDialog(
                        this,
                        "Tidak dapat membagi angka dengan nol!",
                        "Peringatan",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                hasil = angka1 / angka2;
            }

            // Menampilkan hasil pada GUI
            lblHasil.setText("Hasil: " + hasil);

        }

        // Menangani input yang tidak valid
        catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Mohon masukkan angka yang valid!",
                "Input Tidak Valid",
                JOptionPane.ERROR_MESSAGE
            );

        }
    }
}
