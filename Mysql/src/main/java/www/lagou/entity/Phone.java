package www.lagou.entity;/*
 * @Author 白沙
 * @create 2021/3/13 0013 20:34
 */

public class Phone {
    private int id;
    private String pname;
    private double price;
    private String prodate;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProdate() {
        return prodate;
    }

    public void setProdate(String prodate) {
        this.prodate = prodate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "手机{" +
                "id=" + id +
                ", 手机名称='" + pname + '\'' +
                ", 手机单价=" + price +
                ", 生产日期='" + prodate + '\'' +
                ", 手机颜色='" + color + '\'' +
                '}';
    }
}
