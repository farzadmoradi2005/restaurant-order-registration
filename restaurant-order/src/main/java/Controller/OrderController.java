package Controller;

import Model.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderController {
    public void SubmitOrder(String orderDetails , boolean isTakeaway , int orderPrice ) throws SQLException {
        Order order = new Order(orderDetails , isTakeaway , orderPrice);
        String URL = "jdbc:postgresql://localhost:5432/test";
        String USER = "farzad";
        String PASS = "12345";
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        String query = "INSERT INTO Order (order_id , user_id , order_details , order_status , can_edit , is_takeaway , address , order_date) VALUES (?, ?, ?,?,?,?,?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, order.getOrderId());
        ps.setString(2 , order.getUser().getUserName());
        ps.setString(3 , order.getOrderDetails());
        ps.setBoolean(4 , order.isOrderStatus());
        ps.setBoolean(5 , order.isCanEdit());
        ps.setBoolean(6 , isTakeaway);
        ps.setString(7 , order.getAddress());
        ps.setDate(8 , order.getOrderDate());
    }
}
