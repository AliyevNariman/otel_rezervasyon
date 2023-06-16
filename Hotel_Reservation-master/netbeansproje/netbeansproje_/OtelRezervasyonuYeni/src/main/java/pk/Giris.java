package pk;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pk.DatabaseIslemleri;
import static pk.DatabaseIslemleri.select;
import pk.MusteriBilgileri;

public class Giris extends javax.swing.JFrame {

   
    
    public Giris() {
        initComponents();
        DatabaseIslemleri.connection();

    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        eposta = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        gir = new javax.swing.JButton();
        gorsif = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("E-Mail : ");

        jLabel2.setText("Şifre : ");

        eposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                epostaActionPerformed(evt);
            }
        });

        gir.setText("Giriş Yap");
        gir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girActionPerformed(evt);
            }
        });

        gorsif.setText("Şifreyi göster");
        gorsif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gorsifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gorsif)
                        .addGap(77, 77, 77)
                        .addComponent(gir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eposta, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(eposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gir)
                    .addComponent(gorsif))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void girActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girActionPerformed

        String SQL = "SELECT * FROM MusteriBilgileri "
                + "WHERE MusteriMail = '"+eposta.getText()+"' and "
                + "MusteriParola = '"+pass.getText().toString()+"'";
        ResultSet MusteriBilgi = select(SQL);
        try {
            MusteriBilgi.last();
            if(MusteriBilgi.getRow() == 0) JOptionPane.showMessageDialog(null, "Mail veya Şifre Yanlış");
            else {
                MusteriBilgi.afterLast();
                while(MusteriBilgi.previous()) {
                    MusteriBilgileri.MusteriID = MusteriBilgi.getInt("MusteriID");
                    MusteriBilgileri.MusteriTC = MusteriBilgi.getString("MusteriTC");
                    MusteriBilgileri.MusteriAdi = MusteriBilgi.getString("MusteriAdi");
                    MusteriBilgileri.MusteriSoyadi = MusteriBilgi.getString("MusteriSoyadi");
                    MusteriBilgileri.MusteriTel = MusteriBilgi.getString("MusteriTel");
                    MusteriBilgileri.MusteriMail = MusteriBilgi.getString("MusteriMail");
                }
                Rezervasyon rk = new Rezervasyon();
                rk.show();
                dispose();
            }
        } catch (SQLException ex) {
            
        }
        
    }//GEN-LAST:event_girActionPerformed

    private void gorsifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gorsifActionPerformed
        if (gorsif.isSelected()){
            pass.setEchoChar((char)0);
        }
        else{
            pass.setEchoChar('*');
        }
    }//GEN-LAST:event_gorsifActionPerformed

    private void epostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_epostaActionPerformed
        
    }//GEN-LAST:event_epostaActionPerformed

   
    public static void main(String args[]) {
      
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
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Giris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField eposta;
    private javax.swing.JButton gir;
    private javax.swing.JCheckBox gorsif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField pass;
    // End of variables declaration//GEN-END:variables

    private RezervasyonKayit RezervasyonKayit() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
}
