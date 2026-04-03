
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.json.JSONArray;
import org.json.JSONObject; 

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class top_rated_movies extends javax.swing.JFrame {

    /**
     * Creates new form top_trending
     */
    JLabel lb;

//    public top_rated_movies() {
//        initComponents();
////        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
////        int h=(int)d.getHeight();
////        int w=(int)d.getWidth();
////        setSize(w,h);
//        
//        call();
//        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//        int h = (int) d.getHeight();
//        int w = (int) d.getWidth();
//       lb.setBounds(0, 0, w, h);
//       ImageIcon ic = new ImageIcon("src\\myuploads\\movie_now.jpg");
//        Image ic1 = ic.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic2 = new ImageIcon(ic1);
//        lb.setIcon(ic2);
//        add(lb);
//        setSize(w, h);
//        setVisible(true);
//        
//
//        
//    }
    public top_rated_movies() {
    initComponents();
    
    lb = new JLabel(); // Initialize the label
    
    call();
    
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int h = (int) d.getHeight();
    int w = (int) d.getWidth();
    lb.setBounds(0, 0, w, h);
    
        //plb = new JLabel();
       

        //lb.setBounds(0, 0, w, h);
//
//        ImageIcon ic11 = new ImageIcon("src\\myuploads\\TOP UPCOMING.png");
//        Image ic12 = ic11.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic22 = new ImageIcon(ic12);
//        jLabel2.setIcon(ic22);
        
        
    ImageIcon ic = new ImageIcon("src\\myuploads\\bg3.jpg");
    Image ic1 = ic.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon ic2 = new ImageIcon(ic1);
    lb.setIcon(ic2);
    
    add(lb);
    
     ImageIcon ic41 = new ImageIcon("src\\myuploads\\TOP RATED.png");
        Image ic51 = ic41.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic61 = new ImageIcon(ic51);
        jLabel2.setIcon(ic61);
    
    
    ImageIcon ic4 = new ImageIcon("src\\myuploads\\left-arrow1.png");
        Image ic5 = ic4.getImage().getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic6 = new ImageIcon(ic5);
        jb.setIcon(ic6);
        
        
    setSize(w, h);
    setVisible(true);
}

void call() {
        String ans11 =myClient.toptrending();
        System.out.println("brelow email");
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
          //  obj1.bt.setVisible(false);
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
   String abc = myClient.favMovie_check(id);
                    if (abc.equals("pass")) {
                        ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart.png");
                        Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic6 = new ImageIcon(ic5);
                        obj1.bt.setIcon(ic6);
                    }
                       else if (abc.equals("fail")) {
                        ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart (1).png");
                        Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic6 = new ImageIcon(ic5);
                        obj1.bt.setIcon(ic6);
                    } else {
                        System.out.println("oops");
                    }
            
                   

           obj1.bt.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
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

            jp.add(obj1);
            jp.repaint();
            obj1.repaint();

//            System.out.println(name + "----" + photo1 + "------" + desc + "-----" + date1);
//            System.out.println("-----------------------------------------------");

        }
        jp.setPreferredSize(new Dimension(400, (440 * arr.length()) / 2));

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
        jScrollPane3 = new javax.swing.JScrollPane();
        jp = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 150, 2, 2);

        jp.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jpLayout = new javax.swing.GroupLayout(jp);
        jp.setLayout(jpLayout);
        jpLayout.setHorizontalGroup(
            jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1388, Short.MAX_VALUE)
        );
        jpLayout.setVerticalGroup(
            jpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jp);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(490, 150, 1030, 620);

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 3, 48)); // NOI18N
        jLabel2.setText("TOP RATED MOVIES");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(510, 30, 970, 100);

        jb.setBackground(new java.awt.Color(255, 0, 0));
        jb.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
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
            java.util.logging.Logger.getLogger(top_rated_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(top_rated_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(top_rated_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(top_rated_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new top_rated_movies().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb;
    private javax.swing.JPanel jp;
    // End of variables declaration//GEN-END:variables
}
