package Model;

public class User {
    private String userName;
    private String password;
    private int balance;
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.balance = 100;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
