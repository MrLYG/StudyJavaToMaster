package work.www.lagou.entity;

/**
 * @author 李沅罡
 */
public class Account {
    private int id;
    private String username;
    private String card;
    private double balance;

    public Account(int id, String username, String card, double balance) {
        this.id = id;
        this.username = username;
        this.card = card;
        this.balance = balance;
    }

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

    public Account() {
    }
}
