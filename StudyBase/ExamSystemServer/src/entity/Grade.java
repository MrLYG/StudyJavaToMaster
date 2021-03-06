package entity;

import java.io.Serializable;

/**
 * 创建成绩类，对应成绩表；
 */
public class Grade implements Serializable {
    private static final long serialVersionUID = 6559214268784552045L;
    private String sid ;
    private String questionsBankId; //用于保存对应的题库
    private String grade; //对应题库的成绩

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getQuestionsBankId() {
        return questionsBankId;
    }

    public void setQuestionsBankId(String questionsBankId) {
        this.questionsBankId = questionsBankId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "sid='" + sid + '\'' +
                ", questionsBankId='" + questionsBankId + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public Grade(String sid, String questionsBankId, String grade) {
        this.sid = sid;
        this.questionsBankId = questionsBankId;
        this.grade = grade;
    }
}
