
package pk;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class RezervasyonKayit extends javax.swing.JFrame {

    static public ArrayList<OdaTip> odaTipi = new ArrayList<OdaTip>();
    static public Double gunlukFiyat = 0.00;
    static public boolean rezerveAktif = false;

    /**
     * Creates new form RezervasyonKayit
     */
    public RezervasyonKayit() {
        initComponents();
        DatabaseIslemleri.connection();
        ResultSet OdaTipleri = DatabaseIslemleri.select("SELECT * FROM OdaTipleri");
        oda.addItem("Oda Seçiniz");
        try {
            OdaTipleri.beforeFirst();
            while (OdaTipleri.next()) {
                odaTipi.add(new OdaTip(OdaTipleri.getInt("OdaTipID"), OdaTipleri.getString("OdaTipAdi"), OdaTipleri.getDouble("Fiyat"), OdaTipleri.getInt("OdaKisiSayisi")));
                //System.out.print(odaTipi.get(oda.getSelectedIndex()) + " ");
                oda.addItem(OdaTipleri.getString("OdaTipAdi") + " (" + OdaTipleri.getString("OdaKisiSayisi") + " Kişi)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RezervasyonKayit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String tarihFormati(Date tarih) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").format(tarih);
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
        oda = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        yetiskin = new javax.swing.JSpinner();
        rezerve = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        odaFiyat = new javax.swing.JLabel();
        cikisTarihi = new com.toedter.calendar.JCalendar();
        girisTarihi = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Oda Tipi : ");

        oda.setName(""); // NOI18N
        oda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odaActionPerformed(evt);
            }
        });

        jLabel2.setText("Giriş Tarihi");

        jLabel3.setText("Kişi Sayısı :");

        rezerve.setText("Rezerve et");
        rezerve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rezerveActionPerformed(evt);
            }
        });

        jLabel6.setText("Çıkış Tarihi");

        odaFiyat.setText(" ");

        cikisTarihi.setMinimumSize(new java.awt.Dimension(300, 150));
        cikisTarihi.setPreferredSize(new java.awt.Dimension(300, 150));

        girisTarihi.setMinimumSize(new java.awt.Dimension(300, 150));
        girisTarihi.setPreferredSize(new java.awt.Dimension(300, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rezerve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(yetiskin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(317, 317, 317)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)))
                                .addComponent(odaFiyat)
                                .addGap(82, 82, 82))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(oda, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(girisTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addComponent(cikisTarihi, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(oda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(odaFiyat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yetiskin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(girisTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cikisTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rezerve, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.getAccessibleContext().setAccessibleName("Yetişkin Sayısı(+18)");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rezerveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rezerveActionPerformed
        if (oda.getSelectedIndex() != 0) {
            if (yetiskin.getValue().toString().equals("0")) {
                JOptionPane.showMessageDialog(null, "Lütfen kişi sayısını boş bırakmayınız.");
            } else {
                if (girisTarihi.getDate().getTime() / 10000 == cikisTarihi.getDate().getTime() / 10000) {
                    JOptionPane.showMessageDialog(null, "Giriş ve Çıkış Tarihi Aynı Olamaz");
                } else {
                    if (odaTipi.get(oda.getSelectedIndex() - 1).OdaKisiSayisi < ((int) yetiskin.getValue())) {
                        JOptionPane.showMessageDialog(null, "Yetişkin kişi sayısı oda kişi sayısından büyük olamaz");
                    } else {
                        Long gunSayisi = ((cikisTarihi.getDate().getTime() - girisTarihi.getDate().getTime()) / 86400000) + 1;

                        String GirisTarihi = new SimpleDateFormat("yyyy-MM-dd").format(girisTarihi.getDate());
                        String CikisTarihi = new SimpleDateFormat("yyyy-MM-dd").format(cikisTarihi.getDate());
                        ResultSet RezervasyonBilgi = DatabaseIslemleri.checkRoom(odaTipi.get(oda.getSelectedIndex() - 1).OdaTipID, GirisTarihi, CikisTarihi);
                        try {
                            RezervasyonBilgi.last();
                            if (RezervasyonBilgi.getRow() == 0) {
                                JOptionPane.showMessageDialog(null, "Uygun oda bulunmadığından rezervasyon yapılamaz");
                            } else {
                                RezervasyonBilgi.first();
                                if (JOptionPane.showOptionDialog(
                                        null,
                                        "Toplam Fiyat : " + gunSayisi * gunlukFiyat + " ₺", "Onaylıyor Musunuz?",
                                        JOptionPane.OK_CANCEL_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE,
                                        null,
                                        new String[]{"Evet", "Hayır"},
                                        "default") == 0) {
                                    String SQL = "INSERT INTO RezervasyonBilgileri "
                                            + "VALUES(NULL, "
                                            + "'" + GirisTarihi + "',"
                                            + "'" + CikisTarihi + "',"
                                            + RezervasyonBilgi.getInt("OdaID") + ","
                                            + "1,"
                                            + (gunSayisi * gunlukFiyat) + ","
                                            + MusteriBilgileri.MusteriID + ")";

                                    if (DatabaseIslemleri.insert(SQL) == 2) {
                                        JOptionPane.showMessageDialog(null, "Hata");
                                    } else {
                                        Rezervasyon rez = new Rezervasyon();
                                        rez.show();
                                        dispose();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Rezervasyon yapılmadı");
                                }
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(RezervasyonKayit.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        } else {
            if (oda.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Lütfen oda seçiniz");
            }
        }
    }//GEN-LAST:event_rezerveActionPerformed

    private void odaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odaActionPerformed
        if (oda.getSelectedIndex() == 0) {
            gunlukFiyat = 0.0;
            odaFiyat.setVisible(false);
        } else {
            gunlukFiyat = odaTipi.get(oda.getSelectedIndex() - 1).OdaFiyati;
            odaFiyat.setVisible(true);
            odaFiyat.setText("Seçilen Oda Günlük Fiyat : " + gunlukFiyat + " ₺");
        }
    }//GEN-LAST:event_odaActionPerformed

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
            java.util.logging.Logger.getLogger(RezervasyonKayit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RezervasyonKayit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RezervasyonKayit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RezervasyonKayit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RezervasyonKayit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar cikisTarihi;
    private com.toedter.calendar.JCalendar girisTarihi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> oda;
    private javax.swing.JLabel odaFiyat;
    private javax.swing.JButton rezerve;
    private javax.swing.JSpinner yetiskin;
    // End of variables declaration//GEN-END:variables
}