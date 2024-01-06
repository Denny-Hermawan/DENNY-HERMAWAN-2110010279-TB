/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 *
 * @author Denny Hermawan
 */
public class FAbsensiPulang extends javax.swing.JFrame {

    /**
     * Creates new form FAbsensiPulang
     */
    public FAbsensiPulang() {
        initComponents();
        centerFrame();
        
        // Menggunakan DocumentListener untuk memantau perubahan pada JTextField
        Document docIdPegawai = tfidpegawai.getDocument();
        docIdPegawai.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateNama();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateNama();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Tidak digunakan untuk PlainDocument
            }

            private void updateNama() {
                try {
                    // Membuat query SQL untuk mengambil data nama dari tb_datapegawai berdasarkan id_pegawai
                    String query = "SELECT nama FROM tb_datapegawai WHERE id_pegawai = ?";

                    // Mendapatkan koneksi ke database
                    Connection conn = koneksi.getConnection();

                    // Membuat objek PreparedStatement untuk menjalankan query SQL
                    try (PreparedStatement pstNama = conn.prepareStatement(query)) {
                        // Mengambil nilai dari tfidpegawai
                        String idPegawai = tfidpegawai.getText();

                        // Menetapkan nilai idPegawai sebagai parameter query
                        pstNama.setString(1, idPegawai);

                        // Menjalankan query untuk mengambil data nama
                        try (ResultSet rs = pstNama.executeQuery()) {
                            // Mengisi otomatis tfnama jika data ditemukan
                            if (rs.next()) {
                                tfnama.setText(rs.getString("nama"));
                            } else {
                                tfnama.setText("");
                                // Tambahkan logika tambahan jika diperlukan, seperti memberikan pesan ke pengguna
                            }
                        }
                    }
                } catch (SQLException ex) {
                    // Menangani eksepsi jika terjadi kesalahan SQL
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FAbsensiPulang.this, "Terjadi kesalahan SQL: " + ex.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void centerFrame() {
        // Mendapatkan ukuran layar
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Mendapatkan ukuran form
        Dimension frameSize = this.getSize();

        // Menghitung posisi x dan y untuk membuat form berada di tengah layar
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;

        // Menetapkan lokasi form
        this.setLocation(x, y);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfidabsen = new javax.swing.JTextField();
        tfidpegawai = new javax.swing.JTextField();
        tfnama = new javax.swing.JTextField();
        tfjampulang = new javax.swing.JTextField();
        binput = new javax.swing.JButton();
        bkembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ABSENSI PULANG");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID ABSEN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID PEGAWAI");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("NAMA");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("JAM PULANG");

        tfidabsen.setBackground(new java.awt.Color(255, 255, 255));
        tfidabsen.setForeground(new java.awt.Color(0, 0, 0));

        tfidpegawai.setBackground(new java.awt.Color(255, 255, 255));
        tfidpegawai.setForeground(new java.awt.Color(0, 0, 0));

        tfnama.setBackground(new java.awt.Color(255, 255, 255));
        tfnama.setForeground(new java.awt.Color(0, 0, 0));

        tfjampulang.setBackground(new java.awt.Color(255, 255, 255));
        tfjampulang.setForeground(new java.awt.Color(0, 0, 0));

        binput.setBackground(new java.awt.Color(0, 102, 204));
        binput.setForeground(new java.awt.Color(255, 255, 255));
        binput.setText("INPUT");
        binput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binputActionPerformed(evt);
            }
        });

        bkembali.setBackground(new java.awt.Color(0, 0, 0));
        bkembali.setForeground(new java.awt.Color(255, 255, 255));
        bkembali.setText("KEMBALI");
        bkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(108, 108, 108))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(binput)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bkembali))
                    .addComponent(tfnama, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfjampulang, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfidpegawai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addComponent(tfidabsen, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfidabsen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfidpegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfjampulang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(binput)
                    .addComponent(bkembali))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        // TODO add your handling code here:
        // Menyembunyikan frame saat ini (frame saat ini adalah frame yang memiliki tombol BKembali)
        this.setVisible(false);

        // Menampilkan kembali frame FMainMenuPegawai
        FMainMenuPegawai fMainMenuPegawai = new FMainMenuPegawai();
        fMainMenuPegawai.setVisible(true);
    }//GEN-LAST:event_bkembaliActionPerformed

    private void binputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binputActionPerformed
        // TODO add your handling code here:
        try {
            // Dapatkan nilai dari inputan
            String idAbsen = tfidabsen.getText();
            String idPegawai = tfidpegawai.getText();
            String nama = tfnama.getText();
            String jamPulang = tfjampulang.getText();

            // Query SQL untuk memasukkan data
            String sql = "INSERT INTO tb_absenpulang (id_absen, id_pegawai, nama, jam_pulang) VALUES (?, ?, ?, ?)";

            // Dapatkan koneksi ke database
            Connection conn = koneksi.getConnection();

            // Gunakan PreparedStatement untuk mencegah SQL Injection
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // Set parameter pada PreparedStatement
                pstmt.setString(1, idAbsen);
                pstmt.setString(2, idPegawai);
                pstmt.setString(3, nama);
                pstmt.setString(4, jamPulang);

                // Eksekusi query SQL
                pstmt.executeUpdate();
            }

            // Tambahkan logika tambahan jika diperlukan, seperti memberikan pesan ke pengguna
            JOptionPane.showMessageDialog(this, "Data absensi pulang berhasil disimpan", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // Bersihkan inputan setelah berhasil disimpan
            tfidabsen.setText("");
            tfidpegawai.setText("");
            tfnama.setText("");
            tfjampulang.setText("");

        } catch (SQLException e) {
            // Tangani eksepsi jika terjadi kesalahan SQL
            e.printStackTrace(); // Cetak trace eksepsi ke konsol (opsional)
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan SQL: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Tangani eksepsi jika terjadi kesalahan lainnya
            e.printStackTrace(); // Cetak trace eksepsi ke konsol (opsional)
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_binputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FAbsensiPulang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FAbsensiPulang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FAbsensiPulang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FAbsensiPulang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAbsensiPulang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton binput;
    private javax.swing.JButton bkembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfidabsen;
    private javax.swing.JTextField tfidpegawai;
    private javax.swing.JTextField tfjampulang;
    private javax.swing.JTextField tfnama;
    // End of variables declaration//GEN-END:variables
}
