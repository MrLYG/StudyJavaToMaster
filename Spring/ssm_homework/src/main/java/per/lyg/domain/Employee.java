package per.lyg.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author hp
 */
@Data
public class Employee {
    private Integer emp_id;
    private String  emp_name;
    private Integer dept_id;
    private String  job_name;
    private Date join_date;
    private String  telephone;
}
