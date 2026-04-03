/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author DELL
 */
public class top_upcoming extends javax.swing.JFrame {

    /**
     * Creates new form Top_upcoming
     */
    JLabel plb ;
 
    public top_upcoming() {
        initComponents();
        //setVisible(true);
        call();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
          int h=(int)d.getHeight();
          int w=(int)d.getWidth();
          plb = new JLabel();
           plb.setBounds(0, 0, w, h);
    
    ImageIcon ic = new ImageIcon("src\\myuploads\\bg3.jpg");
    Image ic1 = ic.getImage().getScaledInstance(plb.getWidth(), plb.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon ic2 = new ImageIcon(ic1);
    plb.setIcon(ic2);
    
    add(plb);
     ImageIcon ic41 = new ImageIcon("src\\myuploads\\canvatopup.png");
        Image ic51 = ic41.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic61 = new ImageIcon(ic51);
        jLabel2.setIcon(ic61);
     
    ImageIcon ic4 = new ImageIcon("src\\myuploads\\left-arrow1.png");
        Image ic5 = ic4.getImage().getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic6 = new ImageIcon(ic5);
        jb.setIcon(ic6);
          
          
          setSize(w,h);
          setVisible(true);
          
    }
    public void getMovies()
    {
        String ans = myClient.topUpcoming();
        System.out.println(ans);
    }
    void call() {
        String ans11 =myClient.topUpcoming();
        System.out.println("below email");
        System.out.println(global.email);
       // jp.removeAll();
        int x = 10;
        int y = 10;
        System.out.println(ans11);
        JSONObject obj = new JSONObject(ans11);
        JSONArray arr = obj.getJSONArray("results");
        System.out.println(arr.length());
        for (int i = 0; i < arr.length(); i++) {
            String name = "";
            String date1 = "";
            JSONObject ob = (JSONObject) (arr.get(i));

            String photo1 = ob.get("poster_path").toString();
            String desc = (String) ob.get("overview");
            design_1 obj1 = new design_1();
            //obj1.bt.setVisible(false);
            try {
                ImageIcon ic = new ImageIcon(new URL("https://image.tmdb.org/t/p/w200" + photo1));
                Image ic2 = ic.getImage().getScaledInstance(obj1.photo.getWidth(), obj1.photo.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon ic3 = new ImageIcon(ic2);
                obj1.photo2.setIcon(ic3);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("------->" + desc);
            String overview = "";

            String[] n = desc.split("(?<=\\G.{" + 39 + "})");
            for (String string : n) {
                overview += string + " " + "\n" + " ";
            }

            if (ob.has("title")) {
                name = (String) ob.get("title");

            }
            if (ob.has("original_title")) {
                name = (String) ob.get("original_title");
            }

            if (ob.has("name")) {
                name = (String) ob.get("name");
            }
            if (ob.has("original_name")) {
                name = (String) ob.get("original_name");
            }
            obj1.title.setText(name);
            if (ob.has("release_date")) {
                date1 = (String) ob.get("release_date");
            }
            if (ob.has("first_air_date")) {
                date1 = (String) ob.get("first_air_date");
            }
            obj1.date2.setText(date1);
            obj1.jTextArea1.setText(overview);
            obj1.setBounds(x, y, 300, 440);
            if (x < 670) {
                x += 330;
            } else {
                y += 420;
                x = 10;
            }

            //System.out.println(x);
           int id = ob.getInt("id");
//            String abc = myclient.buttoncheck();
//            StringTokenizer st = new StringTokenizer(abc, "$");
//            while (st.hasMoreTokens()) {
//                int id1 = Integer.parseInt(st.nextToken());
//                if (id1 == id) {
//                    ImageIcon ic4 = new ImageIcon("C:\\Users\\apram\\Downloads\\star.png");
//                    Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//                    ImageIcon ic6 = new ImageIcon(ic5);
//                    obj1.bt.setIcon(ic6);
//                } else {
//                    ImageIcon ic4 = new ImageIcon("C:\\Users\\apram\\Downloads\\star (1).png");
//                    Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//                    ImageIcon ic6 = new ImageIcon(ic5);
//                    obj1.bt.setIcon(ic6);
//
//                }
//            }

///////
//
    String abc = myClient.favMovie_check(id);
            if (abc.equals("pass")) {
                ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart.png");
                Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon ic6 = new ImageIcon(ic5);
                obj1.bt.setIcon(ic6);
            }
             else if (abc.equals("fail")) {//empty
               ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart (1).png");
                Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon ic6 = new ImageIcon(ic5);
                obj1.bt.setIcon(ic6);
            } else {
                JOptionPane.showMessageDialog(this, "Pls check");
            }
            
            obj1.bt.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                   // String ans = myClient.topUpcoming();
                   String ans = myClient.addtofavMovie(id);
                    if (ans.equals("pass")) {
                        ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart.png");
                        Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic6 = new ImageIcon(ic5);
                        obj1.bt.setIcon(ic6);

                    } else if (ans.equals("fail")) {
                        ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart (1).png");
                        Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic6 = new ImageIcon(ic5);
                        obj1.bt.setIcon(ic6);
                    } else {
                        System.out.println("oops");
                    }

                }
            });



            jp1.add(obj1);
            jp1.repaint();
            obj1.repaint();

//            System.out.println(name + "----" + photo1 + "------" + desc + "-----" + date1);
//            System.out.println("-----------------------------------------------");

        }
        jp1.setPreferredSize(new Dimension(400, (440 * arr.length()) / 2));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jp1 = new javax.swing.JPanel();
        jb = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        getContentPane().setLayout(null);

        jp1.setBackground(new java.awt.Color(255, 102, 102));
        jp1.setForeground(new java.awt.Color(153, 255, 255));
        jp1.setLayout(null);
        jScrollPane1.setViewportView(jp1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(470, 130, 1030, 650);

        jb.setBackground(new java.awt.Color(255, 0, 0));
        jb.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActionPerformed(evt);
            }
        });
        getContentPane().add(jb);
        jb.setBounds(40, 40, 100, 50);

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 48)); // NOI18N
        jLabel2.setText("TOP UPCOMING ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(530, 20, 940, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActionPerformed
        // TODO add your handling code here:
        home_page obj = new home_page();
        setVisible(true);
        dispose();
    }//GEN-LAST:event_jbActionPerformed

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
            java.util.logging.Logger.getLogger(top_upcoming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(top_upcoming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(top_upcoming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(top_upcoming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new top_upcoming().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb;
    public javax.swing.JPanel jp1;
    // End of variables declaration//GEN-END:variables
}

