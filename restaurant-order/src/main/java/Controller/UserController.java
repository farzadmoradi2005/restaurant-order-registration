package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserController {
    public void signUp(String userName, String password) throws SQLException {
        String URL = "jdbc:postgresql://localhost:5432/Restaurant_Order";
        String USER = "RestaurantAdmin";
        String PASS = "RestaurantAdmin";
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        String sql = "INSERT INTO users (userName, password) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setString(2, password);
        ps.executeUpdate();
        con.close();
    }
}
