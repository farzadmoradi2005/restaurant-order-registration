package Controller;

import java.sql.*;

public class UserController {
    public void signUp(String userName, String password) throws SQLException {
        String URL = "jdbc:postgresql://localhost:5432/Restaurant_Order";
        String USER = "RestaurantAdmin";
        String PASS = "RestaurantAdmin";
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        String sql = "INSERT INTO users (username, password) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setString(2, password);
        ps.executeUpdate();
        con.close();
    }
    public boolean login(String userName, String password) throws SQLException {
        String URL = "jdbc:postgresql://localhost:5432/Restaurant_Order";
        String USER = "RestaurantAdmin";
        String PASS = "RestaurantAdmin";
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            con.close();
            return true;
        }
        con.close();
        return false;

    }
}
