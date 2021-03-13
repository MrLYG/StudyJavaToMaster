package work.www.lagou.entity;

/**
 * CREATE TABLE phone (
 *  id INT PRIMARY KEY  AUTO_INCREMENT,
 *  pname VARCHAR(20),-- 手机名称
 *  price DOUBLE , -- 手机单价
 *  prodate DATE , -- 生产日期
 *  color VARCHAR(20) -- 颜色
 * ) ;
 * @author 李沅罡
 */
public class Phone {
    private int id;
    private String name;
    private Double price;
    private String prodate;
    private String color;

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", prodate='" + prodate + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public Phone() {
    }

    public Phone(int id, String name, Double price, String prodate, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.prodate = prodate;
        this.color = color;
    }
}
