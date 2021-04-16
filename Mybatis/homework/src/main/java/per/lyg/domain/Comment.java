package per.lyg.domain;

import lombok.Data;

/**
 * @author 李沅罡
 */
@Data
public class Comment {
    private Integer id;
    private String content;
    private String author;
    private Integer a_id;
}
