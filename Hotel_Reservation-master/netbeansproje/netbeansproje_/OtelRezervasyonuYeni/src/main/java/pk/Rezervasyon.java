
package pk;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pk.MusteriBilgileri;


public class Rezervasyon extends javax.swing.JFrame {

   
    public Rezervasyon() {
        initComponents();
        lblMusteriBilgi.setText(MusteriBilgileri.MusteriAdi
                + " " + MusteriBilgileri.MusteriSoyadi
                + "(T.C.No:" + MusteriBilgileri.MusteriTC + ")");
        UpdateList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        iptal = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        rezid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        yeniRezervasyon = new javax.swing.JButton();
        lblMusteriBilgi = new javax.swing.JLabel();
        guncel1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        rezervasyonTablosu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Rezervasyonlarım");

        iptal.setText("Rezervasyonu iptal et");
        iptal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iptalActionPerformed(evt);
            }
        });

        exit.setText("Çıkış Yap");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        rezid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rezidActionPerformed(evt);
            }
        });

        jLabel2.setText("RezervasyonId");

        yeniRezervasyon.setText("+ Yeni Rezervasyon");
        yeniRezervasyon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yeniRezervasyonActionPerformed(evt);
            }
        });

        lblMusteriBilgi.setText("....");

        guncel1.setLabel("Bilgi Güncelleme");
        guncel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncel1ActionPerformed(evt);
            }
        });

        rezervasyonTablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#ID", "Oda Numarası", "Toplam Fiyat", "Başlangıç Tarihi", "Bitiş Tarihi"
            }
        ));
        rezervasyonTablosu.setEnabled(false);
        jScrollPane2.setViewportView(rezervasyonTablosu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(yeniRezervasyon, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(guncel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rezid, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(iptal, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMusteriBilgi, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblMusteriBilgi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(yeniRezervasyon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit)
                    .addComponent(iptal)
                    .addComponent(guncel1)
                    .addComponent(jLabel2)
                    .addComponent(rezid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iptalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iptalActionPerformed
        if (rezid.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Rezervasyonunuz iptali için RezervasyonId giriniz.");
        } else if (!rezid.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Rezervasyonunuz iptal edilmiştir.");
            if (DatabaseIslemleri.update("UPDATE rezervasyonbilgileri SET rezervasyondurum = 2 WHERE rezervasyonID = " + rezid.getText()) != 1) {
                JOptionPane.showMessageDialog(null, "Tekrar deneyiniz.");
            }
            UpdateList();
        }


    }//GEN-LAST:event_iptalActionPerformed

    private void UpdateList() {
        DefaultTableModel dm = (DefaultTableModel) rezervasyonTablosu.getModel();
        int rowCount = dm.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        ResultSet RezervasyonBilgi = DatabaseIslemleri.select("SELECT rb.RezervasyonID, ob.OdaNumarasi, rb.ToplamFiyat, rb.RezervasyonBaslangicTarihi, rb.RezervasyonBitisTarihi FROM RezervasyonBilgileri rb JOIN OdaBilgileri ob ON rb.OdaID = ob.OdaID WHERE rb.MusteriID = " + MusteriBilgileri.MusteriID + " and rb.RezervasyonDurum = 1 ORDER BY RezervasyonBaslangicTarihi ASC");
        try {
            RezervasyonBilgi.last();
            if (RezervasyonBilgi.getRow() != 0) {
                RezervasyonBilgi.beforeFirst();
                DefaultTableModel model = (DefaultTableModel) rezervasyonTablosu.getModel();
                while (RezervasyonBilgi.next()) {
                    model.addRow(new Object[]{RezervasyonBilgi.getInt(1), RezervasyonBilgi.getInt(2), RezervasyonBilgi.getDouble(3), RezervasyonBilgi.getString(4), RezervasyonBilgi.getString(5)});
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rezervasyon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        MusteriBilgileri.MusteriAdi = null;
        MusteriBilgileri.MusteriID = 0;
        MusteriBilgileri.MusteriMail = null;
        MusteriBilgileri.MusteriSoyadi = null;
        MusteriBilgileri.MusteriTC = null;
        MusteriBilgileri.MusteriTel = null;
        Giris giris = new Giris();
        giris.show();
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void rezidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rezidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rezidActionPerformed

    private void guncel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncel1ActionPerformed
        KayitGuncelleme kyt = new KayitGuncelleme();
        kyt.show();
        dispose();
    }//GEN-LAST:event_guncel1ActionPerformed

    private void yeniRezervasyonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yeniRezervasyonActionPerformed
        RezervasyonKayit rk = new RezervasyonKayit();
        rk.show(); 
        dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_yeniRezervasyonActionPerformed

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
            java.util.logging.Logger.getLogger(Rezervasyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rezervasyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rezervasyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rezervasyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rezervasyon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JButton guncel1;
    private javax.swing.JButton iptal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMusteriBilgi;
    private javax.swing.JTable rezervasyonTablosu;
    private javax.swing.JTextField rezid;
    private javax.swing.JButton yeniRezervasyon;
    // End of variables declaration//GEN-END:variables
}
