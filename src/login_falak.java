

//import java.awt.*;
//import javax.swing.*;
//import java.sql.*;
//import VMM.DBloader;
//
//public class login_falak extends javax.swing.JFrame {
//
//    JLabel lb;
//
//    public login_falak() {
//        lb = new JLabel();
//        initComponents();
//
//       
//        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//        int h = (int) d.getHeight();
//        int w = (int) d.getWidth();
//        lb.setBounds(0, 0, w, h);
//        ImageIcon ic = new ImageIcon("src\\myUploads\\movie.jpg");
//        Image ic1 = ic.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic2 = new ImageIcon(ic1);
//        lb.setIcon(ic2);
//        add(lb);
//        setSize(w, h);
//    }
//
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    private void initComponents() {
//
//        lb1 = new javax.swing.JLabel();
//        lb2 = new javax.swing.JLabel();
//        lb3 = new javax.swing.JLabel();
//        tf1 = new javax.swing.JTextField();
//        pf1 = new javax.swing.JPasswordField();
//        bt1 = new javax.swing.JButton();
//        bt2 = new javax.swing.JButton();
//        jLabel1 = new javax.swing.JLabel();
//        bt3 = new javax.swing.JButton();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        getContentPane().setLayout(null);
//
//        lb1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
//        lb1.setForeground(new java.awt.Color(255, 255, 255));
//        lb1.setText("LOGIN");
//        getContentPane().add(lb1);
//        lb1.setBounds(700, 0, 130, 50);
//
//        lb2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
//        lb2.setForeground(new java.awt.Color(255, 255, 255));
//        lb2.setText("EMAIL");
//        getContentPane().add(lb2);
//        lb2.setBounds(490, 120, 220, 50);
//
//        lb3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
//        lb3.setForeground(new java.awt.Color(255, 255, 255));
//        lb3.setText("PASSWORD");
//        getContentPane().add(lb3);
//        lb3.setBounds(490, 260, 240, 80);
//
//        tf1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        tf1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                tf1ActionPerformed(evt);
//            }
//        });
//        getContentPane().add(tf1);
//        tf1.setBounds(780, 110, 300, 60);
//
//        pf1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        pf1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                pf1ActionPerformed(evt);
//            }
//        });
//        getContentPane().add(pf1);
//        pf1.setBounds(780, 270, 300, 60);
//
//        bt1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
//        bt1.setText("LOGIN");
//        bt1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                bt1ActionPerformed(evt);
//            }
//        });
//        getContentPane().add(bt1);
//        bt1.setBounds(640, 390, 170, 70);
//
//        bt2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
//        bt2.setText("FORGOT PASSWORD");
//        bt2.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                bt2ActionPerformed(evt);
//            }
//        });
//        getContentPane().add(bt2);
//        bt2.setBounds(910, 400, 180, 40);
//
//        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel1.setText("DONT HAVE ACCOUNT??");
//        getContentPane().add(jLabel1);
//        jLabel1.setBounds(640, 560, 170, 30);
//
//        bt3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
//        bt3.setText("CREATE");
//        bt3.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                bt3ActionPerformed(evt);
//            }
//        });
//        getContentPane().add(bt3);
//        bt3.setBounds(810, 550, 150, 50);
//
//        pack();
//    }// </editor-fold>//GEN-END:initComponents
//
//    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
//        try {
//            String email = tf1.getText();
//            String password = pf1.getText();
//            ResultSet rs = DBloader.executeSQL("Select * from user where email='" + email + "' and password='" + password + "'");
//            if (rs.next()) {
//                JOptionPane.showMessageDialog(this, "Login Successful");
//                global.email = email;
//                home_page hp = new home_page();
//            } else {
//                JOptionPane.showMessageDialog(this, "Login Failed");
//            }
//            tf1.setText("");
//            pf1.setText("");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }//GEN-LAST:event_bt1ActionPerformed
//
//    private void pf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf1ActionPerformed
//
//    }//GEN-LAST:event_pf1ActionPerformed
//
//    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
//
//    }//GEN-LAST:event_tf1ActionPerformed
//
//    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
//        user_signup obj = new user_signup();
//    }//GEN-LAST:event_bt3ActionPerformed
//
//    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
//        forgot_password_falak obj1 = new forgot_password_falak();
//    }//GEN-LAST:event_bt2ActionPerformed
//
//    public static void main(String args[]) {
//
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new login_falak().setVisible(true);
//            }
//        });
//    }
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JButton bt1;
//    private javax.swing.JButton bt2;
//    private javax.swing.JButton bt3;
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel lb1;
//    private javax.swing.JLabel lb2;
//    private javax.swing.JLabel lb3;
//    private javax.swing.JPasswordField pf1;
//    private javax.swing.JTextField tf1;
//    // End of variables declaration//GEN-END:variables
//}
