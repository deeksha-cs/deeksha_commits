package json.jdbc.insert;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class jtod {
   
   
   public static void main(String args[]) {
	   Read obj=new Read();
      JSONParser jsonParser = new JSONParser();
      try {
         JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("E:/cp/p_d.json"));
         JSONArray jsonArray = (JSONArray) jsonObject.get("players_data");
         Connection con =obj.ConnectToDB();
         PreparedStatement pstmt = con.prepareStatement("INSERT INTO MyPlayers values (?, ?, ?, ?, ? )");
         for(Object object : jsonArray) {
            JSONObject record = (JSONObject) object;
            int id = Integer.parseInt((String) record.get("ID"));
            String first_name = (String) record.get("First_Name");
            String last_name = (String) record.get("Last_Name");
            long date_of_birth = Date.valueOf(date).getTime();
            String place_of_birth = (String) record.get("Place_Of_Birth");
            String country = (String) record.get("Country");
            pstmt.setInt(1, id);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.setString(4, place_of_birth);
            pstmt.setString(5, country);
            pstmt.executeUpdate();
         }  
         System.out.println("Records inserted.....");
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}