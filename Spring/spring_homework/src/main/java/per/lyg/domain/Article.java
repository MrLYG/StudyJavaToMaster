package per.lyg.domain;

import lombok.Data;

import java.util.List;
/**
 * @author 李沅罡
 */

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
