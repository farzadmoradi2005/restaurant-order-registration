package Model;

import java.time.LocalDateTime;

public class Order {
    private User user;
    private int orderId;
    private static int finalID;
    private static int counter = 0;
    private String orderDetails;
    private boolean orderStatus;
    private boolean canEdit;
    private boolean isTakeaway;
    private String Address;
   private final LocalDateTime orderDate;
    private int orderPrice;
    public Order(String orderDetails , boolean isTakeaway , int orderPrice ) {
        counter = finalID;
        this.user = user;
        this.orderDetails = orderDetails;
        this.isTakeaway = isTakeaway;
        this.orderPrice = orderPrice;
        this.orderId = counter;
        this.orderStatus = true;
        this.canEdit = true;
        this.orderDate = LocalDateTime.now();
        counter+=1;
        finalID = counter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public boolean isTakeaway() {
        return isTakeaway;
    }

    public void setTakeaway(boolean takeaway) {
        isTakeaway = takeaway;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}
