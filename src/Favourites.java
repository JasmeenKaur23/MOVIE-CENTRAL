
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.json.JSONObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author DELL
 */
public class Favourites extends javax.swing.JFrame {

    /**
     * // * Creates new form Favourites
     */
    JLabel lb;

    public Favourites(String name) {
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int h = (int) d.getHeight();
        int w = (int) d.getWidth();
        lb = new JLabel();
        lb.setBounds(0, 0, w, h);
        
        ImageIcon ic = new ImageIcon("src\\myuploads\\fav.jpg");
        Image ic1 = ic.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic2 = new ImageIcon(ic1);
        lb.setIcon(ic2);
        
        add(lb);
        setSize(w, h);
        setVisible(true);
        
        ImageIcon ic4 = new ImageIcon("src\\myuploads\\left-arrow1.png");
        Image ic5 = ic4.getImage().getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic6 = new ImageIcon(ic5);
        jb.setIcon(ic6);
        
        
        
        setSize(w, h);
        setVisible(true);
        
        if (name.equals("movie")) {
            starmovie();
            
        } else {
            startv();
        }

        // Add a component listener to adjust the image size when the label size changes
    }

    // Method to load and set the image
    //starmovie();
    //////
    void starmovie() {
        int x = 10;
        int y = 10;
        
        String ans1 = myClient.buttoncheck();
        System.out.println("Result from buttoncheck: " + ans1);        
        StringTokenizer st = new StringTokenizer(ans1, "$");
        while (st.hasMoreTokens()) {
            int id = Integer.parseInt(st.nextToken());
            String ans = myClient.showfav_movie(id);
            JSONObject obj = new JSONObject(ans);
            
            design_1 obj1 = new design_1();
            // Create a new instance for each movie
            obj1.bt.setVisible(false);
            if (obj.has("poster_path")) {
                try {
                    String ph = obj.get("poster_path").toString();
                    ImageIcon ic = new ImageIcon(new URL("https://image.tmdb.org/t/p/w200" + ph));
                    Image ic2 = ic.getImage().getScaledInstance(obj1.photo.getWidth(), obj1.photo.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon ic3 = new ImageIcon(ic2);
                    obj1.photo2.setIcon(ic3);
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            }
            
            if (obj.has("title")) {
                String name = obj.get("title").toString();
                obj1.title.setText(name);
            } else if (obj.has("original_title")) {
                String name = obj.get("original_title").toString();
                obj1.title.setText(name);
            } else if (obj.has("name")) {
                String name = obj.get("name").toString();
                obj1.title.setText(name);
            } else if (obj.has("original_name")) {
                String name = obj.get("original_name").toString();
                obj1.title.setText(name);
            }
            
            if (obj.has("overview")) {
                String desc = obj.get("overview").toString();
                String overview = "";
                String[] n = desc.split("(?<=\\G.{" + 39 + "})");
                for (String string : n) {
                    overview += string + " " + "\n" + " ";
                }
                //obj1.jTextArea1.setText(overview);
                obj1.jTextArea1.setText(overview);
            }
            
            if (obj.has("release_date")) {
                String date = obj.get("release_date").toString();
                obj1.date2.setText(date);
            }
            
            obj1.setBounds(x, y, 300, 440);
            
            if (x < 940) {
                x += 310;
            } else {
                x = 10;
                y += 410;
            }
            
            jPanel1.add(obj1);
        }
        
        jPanel1.repaint();
        jPanel1.revalidate();
        
        int ans11 = st.countTokens();

        //jPanel1.setPreferredSize(new Dimension(1000, 1000));
        jPanel1.setPreferredSize(new Dimension(1000,2000));
        
    }

    void startv() {
        int x = 10;
        int y = 10;
        
        String ans1 = myClient.buttoncheck1();
        System.out.println("Result from buttoncheck: " + ans1);        
        StringTokenizer st = new StringTokenizer(ans1, "$");
        while (st.hasMoreTokens()) {
            int id = Integer.parseInt(st.nextToken());
            String ans = myClient.showfav_tv(id);
            JSONObject obj = new JSONObject(ans);
            
            design_1 obj1 = new design_1(); // Create a new instance for each movie
            obj1.bt.setVisible(false);
            if (obj.has("poster_path")) {
                try {
                    String ph = obj.get("poster_path").toString();
                    ImageIcon ic = new ImageIcon(new URL("https://image.tmdb.org/t/p/w200" + ph));
                    Image ic2 = ic.getImage().getScaledInstance(obj1.photo.getWidth(), obj1.photo.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon ic3 = new ImageIcon(ic2);
                    obj1.photo2.setIcon(ic3);
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            }
            
            if (obj.has("title")) {
                String name = obj.get("title").toString();
                obj1.title.setText(name);
            } else if (obj.has("original_title")) {
                String name = obj.get("original_title").toString();
                obj1.title.setText(name);
            } else if (obj.has("name")) {
                String name = obj.get("name").toString();
                obj1.title.setText(name);
            } else if (obj.has("original_name")) {
                String name = obj.get("original_name").toString();
                obj1.title.setText(name);
            }
            
            if (obj.has("overview")) {
                String desc = obj.get("overview").toString();
                String overview = "";
                String[] n = desc.split("(?<=\\G.{" + 39 + "})");
                for (String string : n) {
                    overview += string + " " + "\n" + " ";
                }
                obj1.jTextArea1.setText(overview);
            }
            
            if (obj.has("release_date")) {
                String date = obj.get("release_date").toString();
                obj1.date2.setText(date);
            }
            
            obj1.setBounds(x, y, 300, 420);
            
            if (x < 940) {
                x += 310;
            } else {
                x = 10;
                y += 410;
            }
            
            jPanel1.add(obj1);
        }
        
        jPanel1.repaint();
        jPanel1.revalidate();
        
        int ans11 = st.countTokens();
        
        jPanel1.setPreferredSize(new Dimension(1000, 2000));
    // jPanel1.setPreferredSize(400,(440/obj1)*2);
        
        
     //   jScrollPane1.getVerticalScrollBar().setUnitIncrement(16); // Adjust as needed

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(255, 153, 153));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setForeground(new java.awt.Color(255, 153, 153));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1390, 670));

        jPanel1.setBackground(new java.awt.Color(248, 222, 112));
        jPanel1.setForeground(new java.awt.Color(0, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1390, 670));
        jPanel1.setLayout(null);
        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(130, 140, 1260, 470);

        jb.setBackground(new java.awt.Color(248, 222, 112));
        jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActionPerformed(evt);
            }
        });
        getContentPane().add(jb);
        jb.setBounds(20, 30, 100, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActionPerformed
        // TODO add your handling code here:
        home_page obj = new home_page();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_jbActionPerformed
    
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
            java.util.logging.Logger.getLogger(Favourites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Favourites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Favourites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Favourites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Favourites("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb;
    // End of variables declaration//GEN-END:variables
}
