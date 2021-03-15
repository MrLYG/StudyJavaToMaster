package www.lagou.entity;/*
 * @Author 白沙
 * @create 2021/3/13 0013 2:37
 */

public class Transaction {
    private int id;
    private String carDid;
    private String traType;
    private double traMoney;
    private String traDate;
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarDid() {
        return carDid;
    }

    public void setCarDid(String carDid) {
        this.carDid = carDid;
    }

    public String getTraType() {
        return traType;
    }

    public void setTraType(String traType) {
        this.traType = traType;
    }

    public double getTraMoney() {
        return traMoney;
    }

    public void setTraMoney(double traMoney) {
        this.traMoney = traMoney;
    }

    public String getTraDate() {
        return traDate;
    }

    public void setTraDate(String traDate) {
        this.traDate = traDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", carDid='" + carDid + '\'' +
                ", traType='" + traType + '\'' +
                ", traMoney=" + traMoney +
                ", traDate='" + traDate + '\'' +
                ", account=" + account +
                '}';
    }
}
