package model;

import java.io.Serializable;

public class UserMessage implements Serializable {
    private static final long serialVersionUID = 1508758434281146107L;

    private String type; //消息的类型
    private User user;   //消息的具体内容

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
