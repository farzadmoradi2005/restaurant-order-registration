package Controller;

import Model.Order;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;

public class OrderController {
    String URL = "jdbc:postgresql://localhost:5432/Restaurant_Order";
    String USER = "RestaurantAdmin";
    String PASS = "RestaurantAdmin";
    private Order order;
    public void SubmitOrder(String orderDetails , boolean isTakeaway , int orderPrice ) throws SQLException {
        order = new Order(orderDetails , isTakeaway , orderPrice);
        order.setUser(UserController.getCurrentUser());
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        String query = "INSERT INTO order_res ( user_id , order_details , order_status , can_edit , is_takeaway , address , order_date) VALUES ( ?, ?,?,?,?,?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1 , order.getUser().getUserName());
        ps.setString(2 , order.getOrderDetails());
        ps.setBoolean(3 , order.isOrderStatus());
        ps.setBoolean(4 , order.isCanEdit());
        ps.setBoolean(5 , isTakeaway);
        ps.setString(6, order.getAddress());
        ps.setTimestamp(7, java.sql.Timestamp.valueOf(order.getOrderDate()));
        ps.executeUpdate();
        String Query = "SELECT * FROM order_res";
        ResultSet rs = con.createStatement().executeQuery(Query);
        while (rs.next()) {
            if (rs.getTimestamp("order_date").equals(order.getOrderDate())) {
                order.setOrderId(rs.getInt("order_id"));
            }
        }
        con.close();
    }
    public int showOrderID(){
        return order.getOrderId();
    }
    public void editOrder(String orderDetails) throws SQLException {

        if(Duration.between(order.getOrderDate(), LocalDateTime.now()).toMinutes() < 10){
            order.setOrderDetails(orderDetails);
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            String Query = "SELECT * FROM order_res";
            ResultSet rs = con.createStatement().executeQuery(Query);
            while (rs.next()) {
                if (rs.getInt("order_id") == order.getOrderId()) {
                    String Query2 = "UPDATE order_res SET order_details = ? WHERE order_id = ?";
                    PreparedStatement ps = con.prepareStatement(Query2);
                    ps.setString(1 , orderDetails);
                    ps.setInt(2 , order.getOrderId());
                    ps.executeUpdate();
                }
                con.close();
            }
        }
    }
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
