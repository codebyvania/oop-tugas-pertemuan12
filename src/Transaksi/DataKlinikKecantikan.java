/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Transaksi;

import static Transaksi.PasienKecantikanEntity_.id;
import Transaksi.UpdateTreatment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class DataKlinikKecantikan extends javax.swing.JFrame {

    private static final Logger logger = Logger.getLogger(DataKlinikKecantikan.class.getName());

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt = null;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/PBO_P12";
    String user = "postgres";
    String password = "karina";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    public DataKlinikKecantikan() {
        initComponents();
        showTable();
        showTableTreatment();
    }

    public void tampilkanData() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            stmt = conn.createStatement();

            String sql = "SELECT * FROM data_pasien_kecantikan ORDER BY id";
            ResultSet rs = stmt.executeQuery(sql);

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Pasien");
            model.addColumn("Nama");
            model.addColumn("Alamat");
            model.addColumn("Nomor Hp");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("no_hp"),});
            }

            this.jTable1.setModel(model);

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void tampilkanDataTreatment() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Treatment");
        model.addColumn("ID Pasien");
        model.addColumn("Treatment");
        model.addColumn("Dokter");
        model.addColumn("Harga");
        model.addColumn("Tanggal");

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("PBO_P12PU");
            em = emf.createEntityManager();

            List<DataTreatmentEntity> list = em.createQuery(
                    "SELECT d FROM DataTreatmentEntity d", DataTreatmentEntity.class)
                    .getResultList();

            for (DataTreatmentEntity d : list) {
                model.addRow(new Object[]{
                    d.getIdTreatment(),
                    d.getPasien() != null ? d.getPasien().getId() : "-",
                    d.getNamaTreatment(),
                    d.getDokter(),
                    d.getHarga(),
                    d.getTanggal()
                });
            }

            jTable2.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data treatment: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        CetakPasienbt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        DeleteTreatmentbt = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jButton6.setText("jButton6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(245, 240, 230));

        jLabel1.setBackground(new java.awt.Color(181, 111, 122));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(181, 111, 122));
        jLabel1.setText("data pasien");

        jTable1.setBackground(new java.awt.Color(181, 111, 122));
        jTable1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(206, 150, 147));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(206, 150, 147));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(206, 150, 147));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(206, 150, 147));
        jButton4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton4.setText("Upload");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        CetakPasienbt.setBackground(new java.awt.Color(242, 238, 231));
        CetakPasienbt.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        CetakPasienbt.setText("Cetak");
        CetakPasienbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CetakPasienbtActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Transaksi/1.png"))); // NOI18N

        jLabel5.setBackground(new java.awt.Color(181, 111, 122));
        jLabel5.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(181, 111, 122));
        jLabel5.setText("V`beaute");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(CetakPasienbt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CetakPasienbt)
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("Data Pasien", jPanel1);

        jPanel2.setBackground(new java.awt.Color(181, 111, 122));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("data treatment");

        jTable2.setBackground(new java.awt.Color(242, 238, 231));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton7.setBackground(new java.awt.Color(206, 150, 147));
        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton7.setText("Insert");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(206, 150, 147));
        jButton8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton8.setText("Update");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(242, 238, 231));
        jButton9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton9.setText("Cetak");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        DeleteTreatmentbt.setBackground(new java.awt.Color(206, 150, 147));
        DeleteTreatmentbt.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        DeleteTreatmentbt.setText("Delete");
        DeleteTreatmentbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteTreatmentbtActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(206, 150, 147));
        jButton11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton11.setText("Upload");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("V`beaute");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Transaksi/2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(DeleteTreatmentbt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(DeleteTreatmentbt)
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Data Treatmen", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int baris = jTable1.getSelectedRow();
        if (baris >= 0) {
            // ambil ID Nasabah dari kolom pertama tabel
            String id = jTable1.getValueAt(baris, 0).toString();

            // panggil JDialog, kirim ID Nasabah
            DeletePasien dialog = new DeletePasien(this, true, id);
            dialog.setParentFrame(this); // kirim referensi parent
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data Pasien dulu!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InsertPasien dialog = new InsertPasien(this, true);
        dialog.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        InsertTreatment insertDialog = new InsertTreatment(this, true);
        insertDialog.setParentFrame(this); // 👉 kirim referensi ke parent frame
        insertDialog.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void DeleteTreatmentbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteTreatmentbtActionPerformed
        int row = jTable2.getSelectedRow();
        if (row >= 0) {
            String idTreatment = jTable2.getValueAt(row, 0).toString();

            DeleteTreatment dialog = new DeleteTreatment(this, true, idTreatment);
            dialog.setParentFrame(this); // 👉 wajib, biar bisa refresh tabel
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
        }
    }//GEN-LAST:event_DeleteTreatmentbtActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int baris = jTable1.getSelectedRow();
        if (baris >= 0) {
            String id = jTable1.getValueAt(baris, 0).toString();
            String nama = jTable1.getValueAt(baris, 1).toString();
            String alamat = jTable1.getValueAt(baris, 2).toString();
            String NoHp = jTable1.getValueAt(baris, 3).toString();

            UpdatePasien dialog = new UpdatePasien(this, true, this, id, nama, alamat, NoHp);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow >= 0) {
            String idTreatment = jTable2.getValueAt(selectedRow, 0).toString();
            String idPasien = jTable2.getValueAt(selectedRow, 1).toString();
            String dokter = jTable2.getValueAt(selectedRow, 2).toString();
            String namaTreatment = jTable2.getValueAt(selectedRow, 3).toString();
            String harga = jTable2.getValueAt(selectedRow, 4).toString();
            String tanggal = jTable2.getValueAt(selectedRow, 5).toString();

            UpdateTreatment updateDialog = new UpdateTreatment(this, true);

            updateDialog.setDataTreatment(idTreatment, idPasien, namaTreatment, harga, tanggal, dokter);

            updateDialog.setLocationRelativeTo(this);
            updateDialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih row yang ingin diupdate!");
        }
        
        showTableTreatment();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void CetakPasienbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CetakPasienbtActionPerformed
        JasperReport reports;

        String path = ".\\\\src\\\\Transaksi\\\\DataPasienReport.jasper";
        try {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(koneksi, user, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, ex);
            }

            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reports, null, conn);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CetakPasienbtActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        JasperReport reports;

        String path = ".\\\\src\\\\Transaksi\\\\DataTreatmentReport.jasper";
        try {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(koneksi, user, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, ex);
            }

            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reports, null, conn);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();
            System.out.println("yang dipilih : " + filePilihan.getAbsolutePath());

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PBO_P12PU");
            EntityManager em = emf.createEntityManager();

            try (BufferedReader br = new BufferedReader(new FileReader(filePilihan))) {
                String baris;
                String pemisah = ",";

                em.getTransaction().begin();

                while ((baris = br.readLine()) != null) {
                    String[] data = baris.split(pemisah);

                    // validasi data
                    if (data.length < 4) {
                        continue;
                    }

                    String id = data[0].trim();
                    String nama = data[1].trim();
                    String alamat = data[2].trim();
                    String noHp = data[3].trim();

                    if (!id.isEmpty() && !nama.isEmpty()) {
                        PasienKecantikanEntity p = new PasienKecantikanEntity();
                        p.setId(id);
                        p.setNama(nama);
                        p.setAlamat(alamat);
                        p.setNoHp(noHp);
                        em.persist(p);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data tidak lengkap: " + baris);
                    }
                }

                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Sukses diinput");
                showTable();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "File tidak ditemukan");
            } catch (IOException ex) {
                Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Gagal membaca file");
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat upload");
            } finally {
                em.close();
                emf.close();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();
            System.out.println("yang dipilih : " + filePilihan.getAbsolutePath());

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PBO_P12PU");
            EntityManager em = emf.createEntityManager();

            try (BufferedReader br = new BufferedReader(new FileReader(filePilihan))) {
                String baris;
                String pemisah = ",";

                em.getTransaction().begin();

                while ((baris = br.readLine()) != null) {
                    if (baris.trim().isEmpty()) {
                        continue; // ← lewati baris kosong
                    }
                    String[] data = baris.split(pemisah);

                    // validasi jumlah kolom
                    if (data.length < 5) {
                        System.err.println("Data tidak lengkap: " + baris);
                        continue;
                    }

                    String id = data[0].replace("\uFEFF", "").trim(); // hilangkan karakter BOM
                    String idTreatment = data[1].trim();    // PK
                    String dokter = data[2].trim();
                    String treatment = data[3].trim();
                    String harga = data[4].trim();
                    String tanggal = data.length > 5 ? data[5].trim() : "";

                    if (!idTreatment.isEmpty() && !id.isEmpty()) {
                        DataTreatmentEntity t = new DataTreatmentEntity();

                        // cari pasien berdasarkan ID (FK)
                        PasienKecantikanEntity pasien = em.find(PasienKecantikanEntity.class, id.trim());
                        if (pasien == null) {
                            System.err.println("⚠️ Pasien dengan ID " + id + " tidak ditemukan, dilewati.");
                            continue; // lewati baris ini
                        }

                        // hubungkan relasi pasien ke treatment
                        t.setPasien(pasien);
                        t.setIdTreatment(idTreatment);
                        t.setDokter(dokter);
                        t.setNamaTreatment(treatment);

                        // konversi harga
                        try {
                            t.setHarga(!harga.isEmpty() ? new BigDecimal(harga) : BigDecimal.ZERO);
                        } catch (NumberFormatException e) {
                            System.err.println("Format harga tidak valid: " + harga);
                            t.setHarga(BigDecimal.ZERO);
                        }

                        // simpan tanggal (varchar)
                        if (!tanggal.isEmpty()) {
                            try {
                                java.util.Date date = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(tanggal);
                                String formattedDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(date);
                                t.setTanggal(formattedDate);
                            } catch (java.text.ParseException e) {
                                System.err.println("Format tanggal tidak valid: " + tanggal);
                                t.setTanggal(tanggal); // simpan apa adanya
                            }
                        } else {
                            t.setTanggal(""); // kosongkan kalau tidak ada tanggal
                        }

                        // simpan ke database
                        em.persist(t);
                    } else {
                        System.err.println("❌ Data tidak lengkap: " + baris);
                    }
                }

                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "✅ Sukses diinput");
                showTableTreatment();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "File tidak ditemukan");
            } catch (IOException ex) {
                Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Gagal membaca file");
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat upload");
            } finally {
                em.close();
                emf.close();
            }
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    public void showTable() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load driver PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Koneksi ke database
            conn = DriverManager.getConnection(koneksi, user, password);

            // Query tabel data_pasien_kecantikan (huruf kecil semua sesuai di PostgreSQL)
            String sql = "SELECT id, nama, alamat, no_hp FROM data_pasien_kecantikan ORDER BY id";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            // Tampilkan hasil ke JTable
            this.jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Tutup koneksi agar tidak bocor
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(DataKlinikKecantikan.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public void showTableTreatment() {
        // Definisikan header kolom sesuai data yang ingin ditampilkan
        String[] kolom = {"ID Treatment", "ID Pasien", "Treatment", "Dokter", "Harga", "Tanggal"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0);
        jTable2.setModel(model);  // Set ulang model JTable dengan header yang baru

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PBO_P12PU");
        EntityManager em = emf.createEntityManager();

        try {
            // Query ambil data treatment + pasien terkait (JOIN FETCH supaya pasien termuat)
            List<DataTreatmentEntity> listTreatment = em.createQuery(
                    "SELECT t FROM DataTreatmentEntity t JOIN FETCH t.pasien", DataTreatmentEntity.class)
                    .getResultList();

            for (DataTreatmentEntity t : listTreatment) {
                model.addRow(new Object[]{
                    t.getIdTreatment(),
                    t.getPasien() != null ? t.getPasien().getId() : "",
                    t.getNamaTreatment(),
                    t.getDokter(),
                    t.getHarga(),
                    t.getTanggal()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal load data treatment: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    /**
     * Method ini akan dipanggil saat pengguna menekan Enter atau Tab setelah
     * mengisi tfIdPasien
     */
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new DataKlinikKecantikan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CetakPasienbt;
    private javax.swing.JButton DeleteTreatmentbt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
