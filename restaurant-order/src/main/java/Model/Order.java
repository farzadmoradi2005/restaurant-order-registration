package Model;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

public class Order {
    private User user;
    private int orderId;
    private static int counter = 0;
    private String orderDetails;
    private boolean orderStatus;
    private boolean canEdit;
    private boolean isTakeaway;
    private String Address;
   private final LocalDateTime orderDate;
    private int orderPrice;
    public Order(User user, String orderDetails , boolean isTakeaway , int orderPrice ) {
        this.user = user;
        this.orderDetails = orderDetails;
        this.isTakeaway = isTakeaway;
        this.orderPrice = orderPrice;
        this.orderId = counter++;
        this.orderStatus = true;
        this.canEdit = true;
        this.orderDate = LocalDateTime.now();
    }

}
