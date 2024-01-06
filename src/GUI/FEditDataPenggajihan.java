/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import GUI.FDataPenggajihan;
import java.sql.ResultSet;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;


/**
 *
 * @author Denny Hermawan
 */
public class FEditDataPenggajihan extends javax.swing.JFrame {
    private String idPenggajihan;
    private String idPegawai;
    private String nama;
    private String hariKerja;
    private String gajihPokok;
    private String tunjangan;
    private String totalGajih;
    

    public FEditDataPenggajihan(String idPenggajihan, String idPegawai, String nama, String hariKerja, String gajihPokok, String tunjangan, String totalGajih) {
        initComponents();

        // Inisialisasi nilai-nilai yang akan di-edit
        this.idPenggajihan = idPenggajihan;
        this.idPegawai = idPegawai;
        this.nama = nama;
        this.hariKerja = hariKerja;
        this.gajihPokok = gajihPokok;
        this.tunjangan = tunjangan;
        this.totalGajih = totalGajih;

        // Set nilai-nilai pada komponen-komponen di form FEditDataPenggajihan
        tfidpenggajihan.setText(idPenggajihan);
        tfidpegawai.setText(idPegawai);
        tfnama.setText(nama);
        tfharikerja.setText(hariKerja);
        tfgajihpokok.setText(gajihPokok);
        tftunjangan.setText(tunjangan);
        tftotalgajih.setText(totalGajih);
        
        // Memanggil metode updateNama() dan hitungTotalGaji() setelah nilai-nilai ditetapkan
        updateNama();
        hitungTotalGaji();
        centerFrame();
        
        // Refresh atau update tampilan
        revalidate();
        repaint();
        
    }
    
     
    /**
     * Creates new form FEditDataPenggajihan
     */
    public FEditDataPenggajihan() {
        
        initComponents();
        centerFrame();
        updateNama();
        hitungTotalGaji();
        
        // Menggunakan DocumentListener untuk memantau perubahan pada JTextField
        Document docIdPegawai = tfidpegawai.getDocument();
        docIdPegawai.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateNama();
                // Memanggil juga hitungTotalGaji() jika diperlukan
                hitungTotalGaji();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateNama();
                hitungTotalGaji();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Tidak digunakan untuk PlainDocument
            }
           
        
        });
        
        // Menggunakan DocumentListener untuk memantau perubahan pada JTextField tfharikerja
        Document docHariKerja = tfharikerja.getDocument();
        docHariKerja.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                hitungTotalGaji();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                hitungTotalGaji();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Tidak digunakan untuk PlainDocument
            }
        });

        // Menggunakan DocumentListener untuk memantau perubahan pada JTextField tfgajihpokok
        Document docGajihPokok = tfgajihpokok.getDocument();
        docGajihPokok.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                hitungTotalGaji();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                hitungTotalGaji();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Tidak digunakan untuk PlainDocument
            }
        });

        // Menggunakan DocumentListener untuk memantau perubahan pada JTextField tftunjangan
        Document docTunjangan = tftunjangan.getDocument();
        docTunjangan.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                hitungTotalGaji();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                hitungTotalGaji();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Tidak digunakan untuk PlainDocument
            }
        });
    }
        
        private void updateNama() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
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
                    JOptionPane.showMessageDialog(FEditDataPenggajihan.this, "Terjadi kesalahan SQL: " + ex.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void hitungTotalGaji() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    int hariKerja = Integer.parseInt(tfharikerja.getText());

                    // Menangani kesalahan jika tfgajihpokok dan tftunjangan kosong atau bukan angka
                    int gajihPokok = tfgajihpokok.getText().isEmpty() ? 0 : Integer.parseInt(tfgajihpokok.getText());
                    int tunjangan = tftunjangan.getText().isEmpty() ? 0 : Integer.parseInt(tftunjangan.getText());

                    // Set nilai gajih pokok sesuai dengan aturan
                    if (hariKerja < 30) {
                        gajihPokok = gajihPokok * hariKerja / 30;
                    }

                    // Melakukan perhitungan total gaji
                    int totalGaji = gajihPokok + tunjangan;

                    // Menetapkan nilai total gaji ke dalam tftotalgajih
                    tftotalgajih.setText(String.valueOf(totalGaji));
                } catch (NumberFormatException e) {
                    // Tangani jika terjadi kesalahan format angka
                    tftotalgajih.setText("");
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfidpenggajihan = new javax.swing.JTextField();
        tfidpegawai = new javax.swing.JTextField();
        tfnama = new javax.swing.JTextField();
        tfharikerja = new javax.swing.JTextField();
        tftunjangan = new javax.swing.JTextField();
        tftotalgajih = new javax.swing.JTextField();
        bsimpanperubahan = new javax.swing.JButton();
        bkembali = new javax.swing.JButton();
        tfgajihpokok = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("EDIT DATA PENGGAJIHAN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID PENGGAJIHAN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID PEGAWAI");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("NAMA");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("HARI KERJA");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("GAJIH POKOK");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("TUNJANGAN");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("TOTAL GAJIH");

        tfidpenggajihan.setBackground(new java.awt.Color(255, 255, 255));
        tfidpenggajihan.setForeground(new java.awt.Color(0, 0, 0));

        tfidpegawai.setBackground(new java.awt.Color(255, 255, 255));
        tfidpegawai.setForeground(new java.awt.Color(0, 0, 0));

        tfnama.setEditable(false);
        tfnama.setBackground(new java.awt.Color(255, 255, 255));
        tfnama.setForeground(new java.awt.Color(0, 0, 0));

        tfharikerja.setBackground(new java.awt.Color(255, 255, 255));
        tfharikerja.setForeground(new java.awt.Color(0, 0, 0));

        tftunjangan.setBackground(new java.awt.Color(255, 255, 255));
        tftunjangan.setForeground(new java.awt.Color(0, 0, 0));

        tftotalgajih.setEditable(false);
        tftotalgajih.setBackground(new java.awt.Color(255, 255, 255));
        tftotalgajih.setForeground(new java.awt.Color(0, 0, 0));

        bsimpanperubahan.setBackground(new java.awt.Color(0, 102, 204));
        bsimpanperubahan.setForeground(new java.awt.Color(255, 255, 255));
        bsimpanperubahan.setText("SIMPAN PERUBAHAN");
        bsimpanperubahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanperubahanActionPerformed(evt);
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

        tfgajihpokok.setBackground(new java.awt.Color(255, 255, 255));
        tfgajihpokok.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfidpegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfidpenggajihan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tftotalgajih, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tftunjangan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(bsimpanperubahan)
                                        .addGap(18, 18, 18)
                                        .addComponent(bkembali))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfharikerja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                        .addComponent(tfgajihpokok, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(tfnama, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(51, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(117, 117, 117))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfidpenggajihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfidpegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfharikerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfgajihpokok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tftunjangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tftotalgajih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpanperubahan)
                    .addComponent(bkembali))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        // TODO add your handling code here:
        // Menyembunyikan frame saat ini (frame saat ini adalah frame yang memiliki tombol BKembali)
        this.setVisible(false);

        // Menampilkan frame FDataPenggajihan
        FDataPenggajihan fDataPenggajihan = new FDataPenggajihan();
        fDataPenggajihan.setVisible(true);
    }//GEN-LAST:event_bkembaliActionPerformed

    private void bsimpanperubahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanperubahanActionPerformed
        // TODO add your handling code here:
        try {
        // Dapatkan nilai dari inputan
        String idPenggajihan = tfidpenggajihan.getText();
        String idPegawai = tfidpegawai.getText();
        String nama = tfnama.getText();
        String hariKerja = tfharikerja.getText();
        String gajihPokok = tfgajihpokok.getText();
        String tunjangan = tftunjangan.getText();
        String totalGajih = tftotalgajih.getText();

        // Query SQL untuk memperbarui data
        String sql = "UPDATE tb_penggajihan SET id_pegawai=?, nama=?, hari_kerja=?, gajih_pokok=?, tunjangan=?, total_gajih=? WHERE id_penggajihan=?";

        // Dapatkan koneksi ke database
        java.sql.Connection conn = koneksi.getConnection();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Set parameter PreparedStatement
            pstmt.setString(1, idPegawai);
            pstmt.setString(2, nama);
            pstmt.setString(3, hariKerja);
            pstmt.setString(4, gajihPokok);
            pstmt.setString(5, tunjangan);
            pstmt.setString(6, totalGajih);
            pstmt.setString(7, idPenggajihan);

            // Eksekusi query SQL
            pstmt.executeUpdate();
        }

        // Tambahkan logika tambahan jika diperlukan, seperti menutup frame atau memberikan pesan ke pengguna
        JOptionPane.showMessageDialog(this, "Perubahan berhasil disimpan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);

        // Menampilkan kembali frame FDataPenggajihan (sesuaikan dengan nama kelas yang digunakan)
        FDataPenggajihan frameDataPenggajihan = new FDataPenggajihan();
        frameDataPenggajihan.setVisible(true);
    } catch (Exception e) {
        // Tangani eksepsi jika terjadi kesalahan
        e.printStackTrace(); // Cetak trace eksepsi ke konsol (opsional)
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_bsimpanperubahanActionPerformed

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
            java.util.logging.Logger.getLogger(FEditDataPenggajihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FEditDataPenggajihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FEditDataPenggajihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FEditDataPenggajihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FEditDataPenggajihan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bkembali;
    private javax.swing.JButton bsimpanperubahan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfgajihpokok;
    private javax.swing.JTextField tfharikerja;
    private javax.swing.JTextField tfidpegawai;
    private javax.swing.JTextField tfidpenggajihan;
    private javax.swing.JTextField tfnama;
    private javax.swing.JTextField tftotalgajih;
    private javax.swing.JTextField tftunjangan;
    // End of variables declaration//GEN-END:variables
}
