package jdbc.maven.two;
import java.sql.*;
import java.sql.DriverManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
@SuppressWarnings("unused")
public class empmapper {
    /**
     * @param args
     */
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        // TODO Auto-generated method stub
            try{
                ObjectMapper objMap=new ObjectMapper();
                EmpModel empModel=new EmpModel();
                empModel.setEmpId(101);
                empModel.setName("roy");
                empModel.setNotes("Hello manish how are you");
                Connection con=null;
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/glau","root","");
                PreparedStatement pstmt=con.prepareStatement("INSERT INTO emp(Empld,Name,Notes) VALUES(?,?,?)");
                pstmt.setInt(1,102 );
                pstmt.setString(2, "Manish");
                pstmt.setString(3, "Hello manish how are you");
                pstmt.execute();
            }
            catch(Exception e){e.printStackTrace();}
            }
    }
