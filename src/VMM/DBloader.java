/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VMM;
import java.sql.*;
/**
 *
 * @author DELL
 */
public class DBloader 
{
public static ResultSet executeSQL(String sql) throws Exception
   {
         // ####code starts
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!!");
            
            //create connection to the mysql databases
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/movie_db","root", "system");
            System.out.println("Connection build");
            
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement created");
            
            ResultSet rs = (ResultSet) stmt.executeQuery(sql);
            System.out.println("ResultSet created");
            return rs;
   }
}
