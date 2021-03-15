package www.lagou.entity;/*
 * @Author 白沙
 * @create 2021/3/13 0013 2:35
 */

public class Account {
    private int id;
    private String username;
    private String card;
    private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", 用户姓名='" + username + '\'' +
                ", 银行账号='" + card + '\'' +
                ", 余额=" + balance +
                '}';
    }
}
