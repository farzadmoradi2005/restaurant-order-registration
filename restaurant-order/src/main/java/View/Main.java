package View;

import Controller.OrderController;
import Controller.UserController;

import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        UserController userController = new UserController();
        OrderController orderController = new OrderController();
        System.out.println("""
                1. login
                2. register""");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 1) {
            String username = sc.next();
            String password = sc.next();
            userController.login(username, password);
            System.out.println("login successful");
        }
        else if (choice == 2) {
            String username = sc.next();
            String password = sc.next();
            userController.signUp(username, password);
            System.out.println("register successful");
        }
        System.out.println("write your order details");
        String orderDetails = sc.next();
        System.out.println("is it takeaway order");
        String isTakeawayOrder = sc.next();
        if (isTakeawayOrder.equals("yes")) {
            String address = sc.next();
            boolean isTakeawayAddress = true;
            orderController.SubmitOrder(orderDetails , isTakeawayAddress , 50);
        }
        else if (isTakeawayOrder.equals("no")) {
            boolean isTakeawayAddress = false;
            orderController.SubmitOrder(orderDetails , isTakeawayAddress , 50);
        }
    }

}