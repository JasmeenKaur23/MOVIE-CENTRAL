
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JOptionPane;
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
public class search_movies extends javax.swing.JFrame {

    /**
     * Creates new form search_movies
     */
    String name;
    JLabel plb;

    public search_movies(String name) {
        initComponents();
        //jt.setVisible(false);
        //bt.setVisible(false);

        this.name = name;

        plb = new JLabel();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int h = (int) d.getHeight();
        int w = (int) d.getWidth();

        plb.setBounds(0, 0, w, h);

        ImageIcon ic = new ImageIcon("src\\myuploads\\bg5.jpg");
        Image ic1 = ic.getImage().getScaledInstance(plb.getWidth(), plb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic2 = new ImageIcon(ic1);
        plb.setIcon(ic2);

        add(plb);
        //setSize(w, h);

        plb.setBounds(0, 0, w, h);

        ImageIcon ic4 = new ImageIcon("src\\myuploads\\left-arrow1.png");
        Image ic5 = ic4.getImage().getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic6 = new ImageIcon(ic5);
        jb.setIcon(ic6);

        setSize(w, h);
        jLabel1.setText("SEARCHING FOR " + name);
//                 jt.setVisible(false);
//            bt.setVisible(false);
        if (name != "Movie" && name != "TV" && name != "Movie_House" && name != "Actor") {

            jLabel1.setText("SEARCHING FOR " + name);
            name = name.replace(" ", "%20");
            String abc = myClient.Searchmultitask(name);

            searchmovie(abc);
//            jt.setVisible(false);
//            bt.setVisible(false);
        }

        jLabel1.setText("SEARCHING FOR " + name);
    }
//    public search_movies()
//    {
//      initComponents();
//        setVisible(true);  
//    }

    void searchmovie(String ans) {
        System.out.println("below email");
        System.out.println(global.email);

        jPanel1.removeAll();
        int x = 10;
        int y = 0;
        
        System.out.println(ans);
        JSONObject obj = new JSONObject(ans);
        JSONArray arr = obj.getJSONArray("results");
        System.out.println(arr.length());
        for (int i = 0; i < arr.length(); i++) {
            String name = "";
            String date1 = "";

            JSONObject ob = (JSONObject) (arr.get(i));
            design_1 obj1 = new design_1();

            if (ob.has("poster_path")) {
                String photo1 = ob.get("poster_path").toString();
                if (photo1.equals("null")) {
                    continue;
                } else {
                    try {
                        ImageIcon ic = new ImageIcon(new URL("https://image.tmdb.org/t/p/w200" + photo1));
                        Image ic2 = ic.getImage().getScaledInstance(obj1.photo2.getWidth(), obj1.photo2.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic3 = new ImageIcon(ic2);
                        obj1.photo2.setIcon(ic3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (ob.has("profile_path")) {
                String photo1 = ob.get("profile_path").toString();
                if (photo1.equals("null")) {
                    continue;
                } else {
                    try {
                        ImageIcon ic = new ImageIcon(new URL("https://image.tmdb.org/t/p/w200" + photo1));
                        Image ic2 = ic.getImage().getScaledInstance(obj1.photo.getWidth(), obj1.photo.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic3 = new ImageIcon(ic2);
                        obj1.photo2.setIcon(ic3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if (ob.has("overview")) {
                String desc = ob.get("overview").toString();
                System.out.println("------->" + desc);
                String overview = "";

                String[] n = desc.split("(?<=\\G.{" + 39 + "})");
                for (String string : n) {
                    overview += string + " " + "\n" + " ";
                }
                obj1.jTextArea1.setText(overview);
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
            obj1.title.setText(name);
            obj1.setBounds(x, 20, 300, 440);

            x = x + 330;
            jPanel1.add(obj1);
            jPanel1.repaint();
            jPanel1.revalidate();
            obj1.repaint();
            y += 1;

//                 //System.out.println(x);
            int id = ob.getInt("id");
//                 String abc=myClient.buttoncheck();
//                 StringTokenizer st=new StringTokenizer(abc, "$");
//                 while(st.hasMoreTokens())
//                 {
//                     int id1=Integer.parseInt(st.nextToken());
            //                   if(id1==id)
//                     {
//                        ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star.png");
//        Image ic5=ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj1.bt.setIcon(ic6);
//                     }
//                     else
//                     {
//                          ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star (1).png");
//        Image ic5=ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj1.bt.setIcon(ic6);
//                         
//                     }
//                 }
            String abc = myClient.favMovie_check(id);
            if (abc.equals("pass")) {//coloured
                ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart.png");
                Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon ic6 = new ImageIcon(ic5);
                obj1.bt.setIcon(ic6);

            } else if (abc.equals("fail")) {//empty
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
                    String ans = myClient.addtofavMovie(id);
                    if (ans.equals("pass")) {
                        // JOptionPane.showMessageDialog(rootPane, "Fav added");

                        UIManager.put("OptionPane.messageFont", new Font("Brush Script MT", Font.BOLD, 18));
                        UIManager.put("OptionPane.messageForeground", Color.RED);
                        JOptionPane.showMessageDialog(rootPane, "FAV ADDED!!", "FAVOURITE BOX ", JOptionPane.INFORMATION_MESSAGE);

                        ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart.png");
                        Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic6 = new ImageIcon(ic5);
                        obj1.bt.setIcon(ic6);

                    } else if (ans.equals("fail")) {
                        // JOptionPane.showMessageDialog(rootPane, "Fav removed");

                        UIManager.put("OptionPane.messageFont", new Font("Brush Script MT", Font.BOLD, 18));
                        UIManager.put("OptionPane.messageForeground", Color.RED);
                        JOptionPane.showMessageDialog(rootPane, "FAV REMOVED!!", "FAVOURITE BOX ", JOptionPane.INFORMATION_MESSAGE);

                        ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart (1).png");
                        Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic6 = new ImageIcon(ic5);
                        obj1.bt.setIcon(ic6);

                    } else {
                        System.out.println("oops");
                    }

                }
            });
//// ////
//String abc = myClient.favMovie_check(id);
//if (abc.equals("pass")) {//coloured
//    ImageIcon ic4 = new ImageIcon("C:\\Users\\DELL\\OneDrive\\Documents\\NetBeansProjects\\MOVIE_DB_VMM\\src\\myuploads\\heart.png");
//    Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//    ImageIcon ic6 = new ImageIcon(ic5);
//    obj1.bt.setIcon(ic6);
//} else if (abc.equals("fail")) {//empty
//    ImageIcon ic4 = new ImageIcon("C:\\Users\\DELL\\OneDrive\\Documents\\NetBeansProjects\\MOVIE_DB_VMM\\src\\myuploads\\heart(1).png");
//    Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//    ImageIcon ic6 = new ImageIcon(ic5);
//    obj1.bt.setIcon(ic6);
//} else {
//    JOptionPane.showMessageDialog(this, "Please check");
//}
//obj1.bt.repaint(); // Ensure the button updates
//
//obj1.bt.addActionListener(new java.awt.event.ActionListener() {
//    @Override
//    public void actionPerformed(java.awt.event.ActionEvent evt) {
//        String ans = myClient.addtofavMovie(id);
//        if (ans.equals("pass")) {
//            ImageIcon ic4 = new ImageIcon("C:\\Users\\DELL\\OneDrive\\Documents\\NetBeansProjects\\MOVIE_DB_VMM\\src\\myuploads\\heart(1).png");
//            Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon ic6 = new ImageIcon(ic5);
//            obj1.bt.setIcon(ic6);
//        } else if (ans.equals("fail")) {
//            JOptionPane.showMessageDialog(rootPane, "Failed to add to favorites");
//            ImageIcon ic4 = new ImageIcon("C:\\Users\\DELL\\OneDrive\\Documents\\NetBeansProjects\\MOVIE_DB_VMM\\src\\myuploads\\heart.png");
//            Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon ic6 = new ImageIcon(ic5);
//            obj1.bt.setIcon(ic6);
//        } else {
//            System.out.println("Unexpected result");
//        }
//        obj1.bt.repaint(); // Ensure the button updates
//    }
//});////

            jPanel1.add(obj1);
            jPanel1.repaint();
            jPanel1.revalidate();
            obj1.repaint();

            // System.out.println(name+"----"+photo1+"------"+desc+"-----"+date1);
            System.out.println("-----------------------------------------------");

        }
        jPanel1.setPreferredSize(new Dimension((500 * y) / 1, 350));

    }

    void searchtv(String ans) {
        System.out.println("Below email");
        System.out.println(global.email);
        jPanel1.removeAll();
        int x = 10;
        int y = 0;
        System.out.println(ans);
        JSONObject obj = new JSONObject(ans);
        JSONArray arr = obj.getJSONArray("results");
        System.out.println(arr.length());
        for (int i = 0; i < arr.length(); i++) {
            String name = "";
            String date1 = "";

            JSONObject ob = (JSONObject) (arr.get(i));
            design_1 obj1 = new design_1();

            if (ob.has("poster_path")) {
                String photo1 = ob.get("poster_path").toString();
                if (photo1.equals("null")) {
                    continue;
                } else {
                    try {
                        ImageIcon ic = new ImageIcon(new URL("https://image.tmdb.org/t/p/w200" + photo1));
                        Image ic2 = ic.getImage().getScaledInstance(obj1.photo2.getWidth(), obj1.photo2.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic3 = new ImageIcon(ic2);
                        obj1.photo2.setIcon(ic3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (ob.has("profile_path")) {
                String photo1 = ob.get("profile_path").toString();
                if (photo1.equals("null")) {
                    continue;
                } else {
                    try {
                        ImageIcon ic = new ImageIcon(new URL("https://image.tmdb.org/t/p/w200" + photo1));
                        Image ic2 = ic.getImage().getScaledInstance(obj1.photo.getWidth(), obj1.photo.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic3 = new ImageIcon(ic2);
                        obj1.photo2.setIcon(ic3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if (ob.has("overview")) {
                String desc = ob.get("overview").toString();
                System.out.println("------->" + desc);
                String overview = "";

                String[] n = desc.split("(?<=\\G.{" + 39 + "})");
                for (String string : n) {
                    overview += string + " " + "\n" + " ";
                }
                obj1.jTextArea1.setText(overview);
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
            obj1.title.setText(name);
            obj1.setBounds(x, 20, 300, 440);

            x = x + 330;
            jPanel1.add(obj1);
            jPanel1.repaint();
            jPanel1.revalidate();
            obj1.repaint();
            y += 1;

//                 //System.out.println(x);
            int id = ob.getInt("id");
//                 String abc=myClient.buttoncheck();
//                 StringTokenizer st=new StringTokenizer(abc, "$");
//                 while(st.hasMoreTokens())
//                 {
//                     int id1=Integer.parseInt(st.nextToken());
//                     if(id1==id)
//                     {
//                        ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star.png");
//        Image ic5=ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj1.bt.setIcon(ic6);
//                     }
//                     else
//                     {
//                          ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star (1).png");
//        Image ic5=ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj1.bt.setIcon(ic6);
//                         
//                     }
//                 }
            String abc = myClient.addtofavtv_check(id);
            if (abc.equals("pass")) {//coloured
                ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart.png");
                Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon ic6 = new ImageIcon(ic5);
                obj1.bt.setIcon(ic6);

            } else if (abc.equals("fail")) { //empty
                ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart (1).png");
                Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon ic6 = new ImageIcon(ic5);
                obj1.bt.setIcon(ic6);
            } else {
                JOptionPane.showMessageDialog(this, "Pls check");
            }

//                 
            obj1.bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Hellooooo");
                    String ans = myClient.addtofavtv(id);
                    System.out.println(ans);

                    if (ans.equals("pass")) {
                        // bt.setText("Added");
                        //new entry cfeated if not exists
//                            ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star.png");
//        Image ic5=ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj1.bt.setIcon(ic6);
//JOptionPane.showMessageDialog(rootPane, "fav added");

                        UIManager.put("OptionPane.messageFont", new Font("Brush Script MT", Font.BOLD, 18));
                        UIManager.put("OptionPane.messageForeground", Color.RED);
                        JOptionPane.showMessageDialog(rootPane, "FAV ADDED!!", "FAVOURITE BOX ", JOptionPane.INFORMATION_MESSAGE);

                        ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart.png");
                        Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic6 = new ImageIcon(ic5);
                        obj1.bt.setIcon(ic6);
                    } else if (ans.equals("fail")) {
                        // bt.setText("Add");
//                             ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star (1).png");
//        Image ic5=ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj1.bt.setIcon(ic6);
//JOptionPane.showMessageDialog(rootPane, "fav removed");

                        UIManager.put("OptionPane.messageFont", new Font("Brush Script MT", Font.BOLD, 18));
                        UIManager.put("OptionPane.messageForeground", Color.RED);
                        JOptionPane.showMessageDialog(rootPane, "FAV REMOVED!!", "FAVOURITE BOX ", JOptionPane.INFORMATION_MESSAGE);

                        ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart (1).png");
                        Image ic5 = ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic6 = new ImageIcon(ic5);
                        obj1.bt.setIcon(ic6);
                    } else {
                        System.out.println("oops");
                    }

                }
            });

            jPanel1.add(obj1);
            jPanel1.repaint();
            jPanel1.revalidate();
            obj1.repaint();

            // System.out.println(name+"----"+photo1+"------"+desc+"-----"+date1);
            System.out.println("-----------------------------------------------");

        }
        jPanel1.setPreferredSize(new Dimension((500 * y) / 1, 350));

    }

    ImageIcon imageresize(String ph) {
        ImageIcon ic3 = new ImageIcon();
        try {
            design_1 obj = new design_1();
            ImageIcon ic = new ImageIcon(new URL("https://image.tmdb.org/t/p/w200" + ph));
            Image ic2 = ic.getImage().getScaledInstance(obj.photo2.getWidth(), obj.photo2.getHeight(), Image.SCALE_SMOOTH);
            ic3 = new ImageIcon(ic2);

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        return ic3;
    }

    void searchactor(String ans) {
        jPanel1.removeAll();

        int x = 10;
        int y = 0;
        JSONObject obj = new JSONObject(ans);
        JSONArray arr = obj.getJSONArray("results");
        for (int i = 0; i < arr.length(); i++) {
            JSONObject ob = arr.getJSONObject(i);
            if (ob.has("known_for")) {
                JSONArray arr1 = ob.getJSONArray("known_for");
                for (int j = 0; j < arr1.length(); j++) {
                    JSONObject ob2 = arr1.getJSONObject(j);

                    // Create a new instance of moviedesign for each iteration
                    design_1 obj7 = new design_1();

                    if (ob2.has("title")) {
                        String title = ob2.get("title").toString();
                        obj7.title.setText(title);
                        System.out.println(title);
                    }
                    if (ob2.has("original_title")) {
                        String name = ob2.get("original_title").toString();
                        obj7.title.setText(name);
                        System.out.println(name);
                    }
                    if (ob2.has("poster_path")) {
                        String photo = ob2.get("poster_path").toString();
                        if (photo.equals("null")) {
                            continue;
                        } else {
                            obj7.photo2.setIcon(imageresize(photo));
                        }
                    }
                    if (ob2.has("overview")) {
                        String desc = ob2.get("overview").toString();
                        if (desc.equals("")) {
                            continue;
                        } else {
                            System.out.println("------->" + desc);
                            String overview = "";
                            String[] n = desc.split("(?<=\\G.{" + 39 + "})");
                            for (String string : n) {
                                overview += string + " " + "\n" + " ";
                            }
                            obj7.jTextArea1.setText(overview);
                        }
                    }
                    if (ob2.has("release_date")) {
                        String date = ob2.get("release_date").toString();
                        obj7.date2.setText(date);
                        System.out.println(date);
                    }

                    int id = Integer.parseInt(ob2.get("id").toString());
//                 String abc=myclient.buttoncheck();
//                 
//                 StringTokenizer st=new StringTokenizer(abc, "$");
//                 while(st.hasMoreTokens())
//                 {
//                     int id1=Integer.parseInt(st.nextToken());
//                     if(id1==id)
//                     {
//                        ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star.png");
//        Image ic5=ic4.getImage().getScaledInstance(obj7.bt.getWidth(), obj7.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj7.bt.setIcon(ic6);
//                     }
//                     else
//                     {
//                          ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star (1).png");
//        Image ic5=ic4.getImage().getScaledInstance(obj7.bt.getWidth(), obj7.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj7.bt.setIcon(ic6);
//                         
//                     }
//                 }
//                

 String abc = myClient.addtofavtv_check(id);
            if (abc.equals("pass")) {//coloured
                ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart.png");
                Image ic5 = ic4.getImage().getScaledInstance(obj7.bt.getWidth(), obj7.bt.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon ic6 = new ImageIcon(ic5);
                obj7.bt.setIcon(ic6);

            } else if (abc.equals("fail")) { //empty
                ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart (1).png");
                Image ic5 = ic4.getImage().getScaledInstance(obj7.bt.getWidth(), obj7.bt.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon ic6 = new ImageIcon(ic5);
                obj7.bt.setIcon(ic6);
            } else {
                JOptionPane.showMessageDialog(this, "Pls check");
            }

//                 
            obj7.bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Hellooooo");
                    String ans = myClient.addtofavtv(id);
                    System.out.println(ans);

                    if (ans.equals("pass")) {
                        // bt.setText("Added");
                        //new entry cfeated if not exists
//                            ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star.png");
//        Image ic5=ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj1.bt.setIcon(ic6);
//JOptionPane.showMessageDialog(rootPane, "fav added");

                        UIManager.put("OptionPane.messageFont", new Font("Brush Script MT", Font.BOLD, 18));
                        UIManager.put("OptionPane.messageForeground", Color.RED);
                        JOptionPane.showMessageDialog(rootPane, "FAV ADDED!!", "FAVOURITE BOX ", JOptionPane.INFORMATION_MESSAGE);

                        ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart.png");
                        Image ic5 = ic4.getImage().getScaledInstance(obj7.bt.getWidth(), obj7.bt.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic6 = new ImageIcon(ic5);
                        obj7.bt.setIcon(ic6);
                    } else if (ans.equals("fail")) {
                        // bt.setText("Add");
//                             ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star (1).png");
//        Image ic5=ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj1.bt.setIcon(ic6);
//JOptionPane.showMessageDialog(rootPane, "fav removed");

                        UIManager.put("OptionPane.messageFont", new Font("Brush Script MT", Font.BOLD, 18));
                        UIManager.put("OptionPane.messageForeground", Color.RED);
                        JOptionPane.showMessageDialog(rootPane, "FAV REMOVED!!", "FAVOURITE BOX ", JOptionPane.INFORMATION_MESSAGE);

                        ImageIcon ic4 = new ImageIcon("src\\myuploads\\heart (1).png");
                        Image ic5 = ic4.getImage().getScaledInstance(obj7.bt.getWidth(), obj7.bt.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic6 = new ImageIcon(ic5);
                        obj7.bt.setIcon(ic6);
                    } else {
                        System.out.println("oops");
                    }

                }
            });
//                obj7.bt.addActionListener(new java.awt.event.ActionListener() {
//               @Override
//                    public void actionPerformed(java.awt.event.ActionEvent evt) 
//                    {
//                        String ans=myclient.addtofav(id);
//                        if(ans.equals("pass"))
//                        {
//                            ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star.png");
//        Image ic5=ic4.getImage().getScaledInstance(obj7.bt.getWidth(), obj7.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj7.bt.setIcon(ic6);
//                            
//                        }
//                        else if(ans.equals("fail"))
//                        {
//                             ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star (1).png");
//        Image ic5=ic4.getImage().getScaledInstance(obj7.bt.getWidth(), obj7.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj7.bt.setIcon(ic6);
//                        }
//                        else 
//                        {
//                            System.out.println("oops");
//                        }
//        
//                 }
//                 });

                    // Set the bounds for the new instance
                    obj7.setBounds(x, 20, 300, 440);
                    x = x + 330;
                    jPanel1.add(obj7);
                    jPanel1.repaint();
                    jPanel1.revalidate();
                    obj7.repaint();
                    y += 1;
                }
            }
        }
        jPanel1.setPreferredSize(new Dimension((500 * y) / 2, 350));
    }

    void searchmoviehouse(String ans) {

        jPanel1.removeAll();
        int x = 10;
        int y = 0;
        System.out.println(ans);
        JSONObject obj = new JSONObject(ans);
        JSONArray arr = obj.getJSONArray("results");
        System.out.println(arr.length());
        for (int i = 0; i < arr.length(); i++) {
            String name = "";
            String date1 = "";

            JSONObject ob = (JSONObject) (arr.get(i));
            design_1 obj1 = new design_1();
            obj1.bt.setVisible(false);
            if (ob.has("poster_path")) {
                String photo1 = ob.get("poster_path").toString();
                if (photo1.equals("null")) {
                    continue;
                } else {
                    try {
                        ImageIcon ic = new ImageIcon(new URL("https://image.tmdb.org/t/p/w200" + photo1));
                        Image ic2 = ic.getImage().getScaledInstance(obj1.photo1.getWidth(), obj1.photo1.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic3 = new ImageIcon(ic2);
                        obj1.photo2.setIcon(ic3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if (ob.has("logo_path")) {
                String photo1 = ob.get("logo_path").toString();
                if (photo1.equals("null")) {
                    continue;
                } else {
                    try {
                        ImageIcon ic = new ImageIcon(new URL("https://image.tmdb.org/t/p/w200" + photo1));
                        Image ic2 = ic.getImage().getScaledInstance(obj1.photo1.getWidth(), obj1.photo1.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic3 = new ImageIcon(ic2);
                        obj1.photo2.setIcon(ic3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if (ob.has("profile_path")) {
                String photo1 = ob.get("profile_path").toString();
                if (photo1.equals("null")) {
                    continue;
                } else {
                    try {
                        ImageIcon ic = new ImageIcon(new URL("https://image.tmdb.org/t/p/w200" + photo1));
                        Image ic2 = ic.getImage().getScaledInstance(obj1.photo1.getWidth(), obj1.photo1.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon ic3 = new ImageIcon(ic2);
                        obj1.photo2.setIcon(ic3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if (ob.has("overview")) {
                String desc = ob.get("overview").toString();
                System.out.println("------->" + desc);
                String overview = "";

                String[] n = desc.split("(?<=\\G.{" + 39 + "})");
                for (String string : n) {
                    overview += string + " " + "\n" + " ";
                }
                obj1.jTextArea1.setText(overview);
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

            obj1.setBounds(x, 20, 300, 440);
            x = x + 330;
            jPanel1.add(obj1);
            jPanel1.repaint();
            jPanel1.revalidate();
            obj1.repaint();
            y += 1;

            //System.out.println(x);
            int id = ob.getInt("id");
//                 String abc=myclient.buttoncheck1();
//                 StringTokenizer st=new StringTokenizer(abc, "$");
//                 while(st.hasMoreTokens())
//                 {
//                     int id1=Integer.parseInt(st.nextToken());
//                     if(id1==id)
//                     {
//                        ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star.png");
//        Image ic5=ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj1.bt.setIcon(ic6);
//                     }
//                     else
//                     {
//                          ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star (1).png");
//        Image ic5=ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj1.bt.setIcon(ic6);
//                         
//                     }
//                 }
//                 
//                obj1.bt.addActionListener(new java.awt.event.ActionListener() {
//               @Override
//                    public void actionPerformed(java.awt.event.ActionEvent evt) 
//                    {
//                        String ans=myclient.addtofav1(id);
//                        if(ans.equals("pass"))
//                        {
//                            ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star.png");
//        Image ic5=ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj1.bt.setIcon(ic6);
//                            
//                        }
//                        else if(ans.equals("fail"))
//                        {
//                             ImageIcon ic4=new ImageIcon("C:\\Users\\apram\\Downloads\\star (1).png");
//        Image ic5=ic4.getImage().getScaledInstance(obj1.bt.getWidth(), obj1.bt.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon ic6=new ImageIcon(ic5);
//       obj1.bt.setIcon(ic6);
//                        }
//                        else 
//                        {
//                            System.out.println("oops");
//                        }
//        
//                 }
//                 });

            jPanel1.add(obj1);
            jPanel1.repaint();
            jPanel1.revalidate();
            obj1.repaint();

            // System.out.println(name+"----"+photo1+"------"+desc+"-----"+date1);
            System.out.println("-----------------------------------------------");

        }
        jPanel1.setPreferredSize(new Dimension((500 * y) / 1, 350));

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
        bt = new javax.swing.JButton();
        jt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("SEARCH MOVIES");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(380, 30, 980, 80);

        bt.setBackground(new java.awt.Color(255, 153, 153));
        bt.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        bt.setText("BROWSE");
        bt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btFocusLost(evt);
            }
        });
        bt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btMouseReleased(evt);
            }
        });
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(790, 140, 240, 50);

        jt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        getContentPane().add(jt);
        jt.setBounds(310, 140, 420, 50);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1298, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 220, 1120, 500);

        jb.setBackground(new java.awt.Color(255, 153, 153));
        jb.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActionPerformed(evt);
            }
        });
        getContentPane().add(jb);
        jb.setBounds(20, 30, 100, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed

        
        
        
        // bt.setBackground(Color.black);
         
         
         
         
        if (name.equals("Movie")) {
            String name = jt.getText();
            name = name.replace(" ", "%20");
            String ans = myClient.search_movies(name);
            searchmovie(ans);
            System.out.println(ans);
        } else if (name.equals("TV")) {
            String name = jt.getText();
            name = name.replace(" ", "%20");
            String ans = myClient.searchTV(name);
            searchtv(ans);
            System.out.println(ans);
        } else if (name.equals("Actor")) {
            String name = jt.getText();
            name = name.replace(" ", "%20");
            String ans = myClient.searchActor(name);
            searchactor(ans);
            System.out.println(ans);
        } else if (name.equals("Movie_House")) {
            String name = jt.getText();
            name = name.replace(" ", "%20");
            String ans = myClient.searchMovieHouse(name);
            searchmoviehouse(ans);
            System.out.println(ans);
         
            
            
           
        }
    }//GEN-LAST:event_btActionPerformed

    private void jbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActionPerformed
        // TODO add your handling code here:
        //jButton1.setIcon(C:\Users\DELL\OneDrive\Documents\NetBeansProjects\MOVIE_DB_VMM\src\myuploads\.png);
        home_page obj = new home_page();
        setVisible(true);
        dispose();
    }//GEN-LAST:event_jbActionPerformed

    private void btFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btFocusGained
        // TODO add your handling code here:
         //  bt.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_btFocusGained

    private void btFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btFocusLost
        // TODO add your handling code here:
       bt.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_btFocusLost

    private void btMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMouseClicked
        // TODO add your handling code here:
       // bt.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_btMouseClicked

    private void btMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMouseReleased
        // TODO add your handling code here:
       // bt.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_btMouseReleased

    private void btMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMousePressed
        // TODO add your handling code here:
      //   bt.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_btMousePressed

    private void btMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMouseExited
        // TODO add your handling code here:
       //  bt.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_btMouseExited

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
            java.util.logging.Logger.getLogger(search_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search_movies("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb;
    public javax.swing.JTextField jt;
    // End of variables declaration//GEN-END:variables
}
