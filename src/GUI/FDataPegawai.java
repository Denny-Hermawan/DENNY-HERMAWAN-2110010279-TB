/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package GUI;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Denny Hermawan
 */
public class FDataPegawai extends javax.swing.JFrame {
    // Mendeklarasikan DefaultTableModel untuk data tabel datapegawai dan SQL untuk query database
    private DefaultTableModel DftJTDataPegawai;
    private String SQL;

    // Metode untuk menampilkan data pada tabel datapegawai
    private void TampilkanData() {
        // Override metode isCellEditable untuk membuat sel di tabel tidak dapat di-edit
        DefaultTableModel DftJTDataPegawai = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Semua sel tidak dapat di-edit
                return false;
            }
        };

        // Inisialisasi objek DefaultTableModel
        DftJTDataPegawai = new DefaultTableModel();

        // Menambahkan kolom-kolom ke dalam tabel
        DftJTDataPegawai.addColumn("ID PEGAWAI");
        DftJTDataPegawai.addColumn("NIP");
        DftJTDataPegawai.addColumn("NAMA");
        DftJTDataPegawai.addColumn("ALAMAT");
        DftJTDataPegawai.addColumn("JENIS KELAMIN");
        DftJTDataPegawai.addColumn("JABATAN");
        DftJTDataPegawai.addColumn("NO HP");

        // Mengatur model tabel dengan objek DefaultTableModel yang sudah diinisialisasi
        tdatapegawai.setModel(DftJTDataPegawai);

        // Mendapatkan koneksi ke database
        Connection conn = koneksi.getConnection();

        try {
            // Membuat statement SQL
            java.sql.Statement stmt = conn.createStatement();

            // Menjalankan query untuk mengambil data dari tabel tb_datapegawai
            SQL = "SELECT * FROM tb_datapegawai";
            java.sql.ResultSet res = stmt.executeQuery(SQL);

            // Menambahkan data dari hasil query ke dalam model tabel
            while (res.next()) { 
                DftJTDataPegawai.addRow(new Object[] {
                    res.getString("id_pegawai"),
                    res.getString("NIP"),
                    res.getString("nama"),
                    res.getString("alamat"),
                    res.getString("jenis_kelamin"),
                    res.getString("jabatan"),
                    res.getString("no_hp")
                });
            }
        } catch (SQLException e) {
            // Menangani eksepsi jika terjadi kesalahan SQL
            System.out.println(e.getMessage());
        }
    }

    // Metode untuk mendapatkan nilai dari kolom "ID PEGAWAI" pada baris yang dipilih
    public String getSelectedIdPegawai() {
        int selectedRow = tdatapegawai.getSelectedRow();
        if (selectedRow == -1) {
            return null; // atau throw sebuah exception, tergantung pada kebutuhan
        }
        return tdatapegawai.getValueAt(selectedRow, 0).toString();
    }

    // Metode untuk mendapatkan nilai dari kolom "NIP" pada baris yang dipilih
    public String getSelectedNIP() {
        int selectedRow = tdatapegawai.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        return tdatapegawai.getValueAt(selectedRow, 1).toString();
    }

    // Metode untuk mendapatkan nilai dari kolom "NAMA" pada baris yang dipilih
    public String getSelectedNama() {
        int selectedRow = tdatapegawai.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        return tdatapegawai.getValueAt(selectedRow, 2).toString();
    }

    // Metode untuk mendapatkan nilai dari kolom "ALAMAT" pada baris yang dipilih
    public String getSelectedAlamat() {
        int selectedRow = tdatapegawai.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        return tdatapegawai.getValueAt(selectedRow, 3).toString();
    }

    // Metode untuk mendapatkan nilai dari kolom "JENIS KELAMIN" pada baris yang dipilih
    public String getSelectedJenisKelamin() {
        int selectedRow = tdatapegawai.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        return tdatapegawai.getValueAt(selectedRow, 4).toString();
    }

    // Metode untuk mendapatkan nilai dari kolom "JABATAN" pada baris yang dipilih
    public String getSelectedJabatan() {
        int selectedRow = tdatapegawai.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        return tdatapegawai.getValueAt(selectedRow, 5).toString();
    }

    // Metode untuk mendapatkan nilai dari kolom "NO HP" pada baris yang dipilih
    public String getSelectedNoHP() {
        int selectedRow = tdatapegawai.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        return tdatapegawai.getValueAt(selectedRow, 6).toString();
    }

    /** Creates new form FDataPegawai */
    public FDataPegawai() {
        initComponents();
        centerFrame();
        DftJTDataPegawai = new DefaultTableModel();
        tdatapegawai.setModel(DftJTDataPegawai);
        TampilkanData();
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
        btambah = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdatapegawai = new javax.swing.JTable();
        bkembali = new javax.swing.JButton();
        tfcari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DATA PEGAWAI");

        btambah.setBackground(new java.awt.Color(0, 102, 255));
        btambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btambah.setForeground(new java.awt.Color(255, 255, 255));
        btambah.setText("TAMBAH DATA");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        bedit.setBackground(new java.awt.Color(255, 102, 0));
        bedit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bedit.setForeground(new java.awt.Color(255, 255, 255));
        bedit.setText("EDIT DATA");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });

        bhapus.setBackground(new java.awt.Color(255, 0, 0));
        bhapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bhapus.setForeground(new java.awt.Color(255, 255, 255));
        bhapus.setText("HAPUS DATA");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        tdatapegawai.setBackground(new java.awt.Color(0, 0, 0));
        tdatapegawai.setForeground(new java.awt.Color(255, 255, 255));
        tdatapegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID PEGAWAI", "NIP", "NAMA", "ALAMAT", "JENIS KELAMIN", "JABATAN", "NO HP"
            }
        ));
        jScrollPane1.setViewportView(tdatapegawai);

        bkembali.setBackground(new java.awt.Color(0, 0, 0));
        bkembali.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bkembali.setForeground(new java.awt.Color(255, 255, 255));
        bkembali.setText("KEMBALI");
        bkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkembaliActionPerformed(evt);
            }
        });

        tfcari.setBackground(new java.awt.Color(255, 255, 255));
        tfcari.setForeground(new java.awt.Color(0, 0, 0));
        tfcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfcariActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CARI:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfcari, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btambah)
                                .addComponent(bkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(34, 34, 34)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tfcari, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btambah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(bkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        // Mendapatkan indeks baris yang dipilih
        int selectedRow = tdatapegawai.getSelectedRow();

        // Memeriksa apakah ada baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih pegawai yang ingin diedit.");
            return;
        }

        // Mendapatkan nilai-nilai dari baris yang dipilih
        String idPegawai = tdatapegawai.getValueAt(selectedRow, 0).toString();
        String nip = tdatapegawai.getValueAt(selectedRow, 1).toString();
        String nama = tdatapegawai.getValueAt(selectedRow, 2).toString();
        String alamat = tdatapegawai.getValueAt(selectedRow, 3).toString();
        String jenisKelamin = tdatapegawai.getValueAt(selectedRow, 4).toString();
        String jabatan = tdatapegawai.getValueAt(selectedRow, 5).toString();
        String noHP = tdatapegawai.getValueAt(selectedRow, 6).toString();

        // Menyembunyikan frame saat ini (frame saat ini adalah frame yang memiliki tombol BKembali)
        this.setVisible(false);

        // Membuka frame FEditDataPegawai untuk pengeditan dengan parameter yang sesuai
        FEditDataPegawai fEditDataPegawai = new FEditDataPegawai(idPegawai, nip, nama, alamat, jenisKelamin, jabatan, noHP);
        fEditDataPegawai.setVisible(true);
        
    }//GEN-LAST:event_beditActionPerformed

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        // TODO add your handling code here:
        // Menyembunyikan frame saat ini (frame saat ini adalah frame yang memiliki tombol BKembali)
        this.setVisible(false);

        // Menampilkan kembali frame FMainMenuAdmin
        FMainMenuAdmin fMainMenuAdmin = new FMainMenuAdmin();
        fMainMenuAdmin.setVisible(true);
    }//GEN-LAST:event_bkembaliActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        // Menyembunyikan frame saat ini (frame saat ini adalah frame yang memiliki tombol BKembali)
        this.setVisible(false);

        // Menampilkan frame FTambahDataPegawai
        FTambahDataPegawai fTambahDataPegawai = new FTambahDataPegawai();
        fTambahDataPegawai.setVisible(true);
        
    }//GEN-LAST:event_btambahActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        try {
            // Mendapatkan indeks baris yang dipilih
            int selectedRow = tdatapegawai.getSelectedRow();

            // Memeriksa apakah ada baris yang dipilih
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih pegawai yang ingin dihapus.");
                return;
            }

            // Konfirmasi pengguna sebelum menghapus
            int confirmResult = JOptionPane.showConfirmDialog(
                this,
                "Anda yakin ingin menghapus data pegawai ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

            // Jika pengguna memilih "Ya" (YES_OPTION), lanjutkan dengan penghapusan
            if (confirmResult == JOptionPane.YES_OPTION) {
                // Mendapatkan nilai ID Pegawai dari baris yang dipilih
                String idPegawai = tdatapegawai.getValueAt(selectedRow, 0).toString();

                // Query SQL untuk menghapus data berdasarkan ID Pegawai
                String sql = "DELETE FROM tb_datapegawai WHERE id_pegawai=?";

                // Dapatkan koneksi ke database
                Connection conn = koneksi.getConnection();

                // Gunakan PreparedStatement untuk mencegah SQL Injection
                try (java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    // Set parameter pada PreparedStatement
                    pstmt.setString(1, idPegawai);

                    // Eksekusi query SQL
                    pstmt.executeUpdate();
                }

                // Hapus baris dari model tabel
                DefaultTableModel model = (DefaultTableModel) tdatapegawai.getModel();
                model.removeRow(selectedRow);

                // Tambahkan logika tambahan jika diperlukan, seperti memberikan pesan ke pengguna
                JOptionPane.showMessageDialog(this, "Data pegawai berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            // Tangani eksepsi jika terjadi kesalahan SQL
            e.printStackTrace(); // Cetak trace eksepsi ke konsol (opsional)
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan SQL: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Tangani eksepsi jika terjadi kesalahan lainnya
            e.printStackTrace(); // Cetak trace eksepsi ke konsol (opsional)
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_bhapusActionPerformed

    private void tfcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfcariActionPerformed
        // TODO add your handling code here:
        // Mendapatkan teks yang dimasukkan oleh pengguna untuk digunakan sebagai kriteria pencarian
        String keyword = tfcari.getText().trim();

        // Melakukan koneksi ke database (sesuaikan dengan metode koneksi Anda)
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbkepegawaian", "root", "")) {
            // Membuat pernyataan SQL untuk melakukan pencarian
            String sql = "SELECT * FROM tb_datapegawai WHERE nama LIKE ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // Menetapkan parameter untuk pencarian (menggunakan LIKE untuk pencarian yang mirip)
                pstmt.setString(1, "%" + keyword + "%");

                // Mengeksekusi query dan mendapatkan hasil
                try (ResultSet rs = pstmt.executeQuery()) {
                    // Membersihkan data di tabel (misalnya jTable) sebelum menampilkan hasil pencarian
                    // Sesuaikan dengan komponen dan model tabel yang Anda gunakan
                    DefaultTableModel model = (DefaultTableModel) tdatapegawai.getModel();
                    model.setRowCount(0);

                    // Menampilkan hasil pencarian ke dalam tabel
                    while (rs.next()) {
                        Object[] rowData = {
                            rs.getInt("id_pegawai"),
                            rs.getString("NIP"),
                            rs.getString("nama"),
                            rs.getString("alamat"),
                            rs.getString("jenis_kelamin"),
                            rs.getString("jabatan"),
                            rs.getString("no_hp")
                        };
                        model.addRow(rowData);
                    }

                    // Menampilkan pesan jika tidak ada hasil pencarian
                    if (model.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(this, "Tidak ada data ditemukan untuk kriteria pencarian tersebut.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tfcariActionPerformed

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
            java.util.logging.Logger.getLogger(FDataPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FDataPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FDataPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FDataPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FDataPegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bedit;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkembali;
    private javax.swing.JButton btambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tdatapegawai;
    private javax.swing.JTextField tfcari;
    // End of variables declaration//GEN-END:variables

}
