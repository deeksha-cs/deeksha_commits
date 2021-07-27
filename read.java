package jdbc.maven.two;

import java.sql.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;
public class ReadJsonData {
    
    public static void main(String[] args)throws Exception {
        ObjectMapper objMap=new ObjectMapper();
        Connection con=null;
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/glau","root","");
        PreparedStatement pstmt=con.prepareStatement("SELECT * FROM emp");
        ResultSet rs=pstmt.executeQuery();
        while(rs.next())
        {
            EmpModel empModel=(EmpModel)objMap.readValue(rs.getString(3), EmpModel.class);
            System.out.println(empModel.getEmpId());
            System.out.println(empModel.getName());
            System.out.println(empModel.getNotes());
        }
    }
}
