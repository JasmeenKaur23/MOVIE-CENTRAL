
import VMM.DBloader;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import javax.swing.JOptionPane;

public class myClient {

    public static String api = "9c6f3092062b986495d45a7abceec30d";

    public static String topUpcoming() {
        try {
            HttpResponse<String> res = Unirest.get("https://api.themoviedb.org/3/movie/upcoming?api_key=" + api).asString();
            if (res.getStatus() == 200) {
                return res.getBody();
            } else {
                return "server error";
            }
        } catch (Exception ex) {
            return ex.toString();
        }
    }

    public static String toptrending() {
        try {
            //String api="9c6f3092062b986495d45a7abceec30d";
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/movie/top_rated?api_key=" + api).asString();
            if (response.getStatus() == 200) {
                String res = response.getBody();

                return res;
            }
        } catch (UnirestException ex) {
            ex.printStackTrace();

        }
        return null;

    }

    public static String search_movies(String movie) {
        try {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/movie?query=" + movie + "&include_adult=false&language=en-US&page=1&api_key=" + api).asString();
            if (response.getStatus() == 200) {
                
                String res = response.getBody();

                return res;
            }
           
        } catch (UnirestException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public static String searchTV(String tv) {
        try {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/tv?api_key=" + api + "&language=en-US&page=1&query=" + tv + "&include_adult=false" + api).asString();
            if (response.getStatus() == 200) {
                String res = response.getBody();

                return res;
            }
        } catch (UnirestException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public static String searchActor(String Actor) {
        try {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/person?query=" + Actor + "&include_adult=false&language=en-US&page=1&api_key=" + api).asString();
            if (response.getStatus() == 200) {
                String res = response.getBody();

                return res;
            }
        } catch (UnirestException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public static String searchMovieHouse(String Movie_House) {
        try {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/company?api_key=" + api + "&query=" + Movie_House + "&page=1").asString();
            if (response.getStatus() == 200) {
                String res = response.getBody();

                return res;
            }
        } catch (UnirestException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public static String Searchmultitask(String name) {
        try {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/multi?api_key=" + api + "&language=en-US&query=" + name + "&page=1&include_adult=false").asString();
            if (response.getStatus() == 200) {
                String res = response.getBody();

                return res;
            }
            // search_movies.jt.setVisible(false);

        } catch (UnirestException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String addtofavtv(int id) {
    String ans ="";
        try {
            ResultSet rs = DBloader.executeSQL("select * from fav_tv where email ='" + global.email + "'and id =" + id);
            if (rs.next()) {
                rs.deleteRow();
                ans= "fail";
            } else {
                System.out.println(global.email);
                rs.moveToInsertRow();
                rs.updateString("email", global.email);
                rs.updateInt("id", id);
                rs.insertRow();
                ans= "pass";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return ans;
    }

    public static String addtofavMovie(int id) {
String ans="";
        try {
            ResultSet rs = DBloader.executeSQL("select * from fav_movie where email ='" + global.email + "'and id =" + id);
            if (rs.next()) {
                rs.deleteRow();
                ans="fail";

            } else {
                System.out.println(global.email);
                rs.moveToInsertRow();
                rs.updateString("email", global.email);
                rs.updateInt("id", id);
                rs.insertRow();
                ans="pass";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
return ans;
    }
    public static String favMovie_check(int id) {
String ans="";
        try {
            ResultSet rs = DBloader.executeSQL("select * from fav_movie where email ='" + global.email + "'and id =" + id);
            if (rs.next()) {
                
                ans="pass";

            } else {
                
                ans="fail";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return ans;
    }
    public static String addtofavtv_check(int id) {
//       String ans ="";
//        try {
//            ResultSet rs = DBloader.executeSQL("select * from fav_tv where email ='" + global.email + "'and id =" + id);
//            if (rs.next()) {
//                //rs.deleteRow();
//                ans="pass";
//            } else {
//                System.out.println(global.email);
//                rs.moveToInsertRow();
//              rs.updateString("email", global.email);
//                rs.updateInt("id", id);
//                rs.insertRow();
//                ans="fail";
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return ex.toString();
//        }
//        return ans;
//

        String ans = "";
        try {
            ResultSet rs = DBloader.executeSQL("select * from fav_tv where email ='" + global.email + "'and id =" + id);
            if (rs.next()) {

                ans = "pass";

            } else {

                ans = "fail";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return ans;
    }
        
    

    public static String showfav_movie(int id)
{
    String ans="";
        try {
            HttpResponse<String> res=Unirest.get("https://api.themoviedb.org/3/movie/" + id + "?api_key=" + api + "&language=en-US").asString();
            ans=res.getBody();
        } catch (UnirestException ex) {
            ex.printStackTrace();
        }
        return ans;
}
     public static String showfav_tv(int id)
{
    String ans="";
        try {
            HttpResponse<String> res=Unirest.get("https://api.themoviedb.org/3/tv/" + id + "?api_key=" + api + "&language=en-US").asString();
            ans=res.getBody();
        } catch (UnirestException ex) {
            ex.printStackTrace();
        }
        return ans;
}

//    public static String buttoncheck()
//    {//our own playist like .....favourites 
//        String ans1="";
//        try {
//            
//            ResultSet rs = DBloader.executeSQL("select * from fav_movie a inner join fav_tv b on a.email = b.email where a.email ='" + global.email +"'");
//    
//            while(rs.next())
//            {
//                int id = rs.getInt("id");
//                ans1 += id+"$";
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return ex.toString();
//        }
//        
//        return ans1;
//    }
   
    public static String buttoncheck() {
        String ans1 = "";
        try {
            ResultSet rs = DBloader.executeSQL("select * from fav_movie where email ='" + global.email + "'");
            while (rs.next()) {
                int id = rs.getInt("id");
                ans1 += id + "$";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return ans1;
    }
public static String buttoncheck1() {
        String ans1 = "";
        try {
            ResultSet rs = DBloader.executeSQL("select * from fav_tv where email ='" + global.email + "'");
            while (rs.next()) {
                int id = rs.getInt("id");
                ans1 += id + "$";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.toString();
        }
        return ans1;
    }


    

}
    


