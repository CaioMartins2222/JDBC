import Db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program_teste {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("Insert INTO seller " +
                            "(Name, Email, BirthDate, BaseSalary, DepartmentID)" + "VALUES" +
                    "(?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "Caio Martins");
            st.setString(2, "caio@gmail.com");
            st.setDate(3,new java.sql.Date(sdf.parse("27/05/1998").getTime()));
            st.setDouble(4, 4000.0);
            st.setInt(5, 4);

            int rowAffected = st.executeUpdate();
            if (rowAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Done! ID = " + id);
                }
            }
            else {
                System.out.println("No Rows affected: ");
            }
        }
        catch (ParseException | SQLException e){
            e.printStackTrace();
        }

        finally {
          DB.closeStatement(st);
          DB.closeConnection();
        }
    }
}
