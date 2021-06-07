package models;

import java.io.Serializable;

/**
 * @BelongsProject: zk_product
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-07-23 13:05
 * @Description: 订单表
 */
public class Order implements Serializable {

    private String id;
    private int pid;
    private int userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Order() {
    }

    public Order(String id, int pid, int userid) {
        this.id = id;
        this.pid = pid;
        this.userid = userid;
    }
}
