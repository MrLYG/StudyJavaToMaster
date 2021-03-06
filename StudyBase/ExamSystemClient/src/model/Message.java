package model;

import java.io.Serializable;

public class Message<T> implements Serializable {
    private static final long serialVersionUID = 1508758434281146107L;

    private String type; //消息的类型
    private T t;   //消息的具体内容

    public Message() {
    }

    public Message(String type, T t) {
        this.type = type;
        this.t = t;
    }


    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type='" + type + '\'' +
                ", t=" + t +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
