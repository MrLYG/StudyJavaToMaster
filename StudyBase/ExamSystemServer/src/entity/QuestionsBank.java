package entity;

import java.io.Serializable;
import java.util.Arrays;

public class QuestionsBank implements Serializable {
    private static final long serialVersionUID = -4721648010435034459L;
    private String questionsBankId; //题库ID

    @Override
    public String toString() {
        return "QuestionsBank{" +
                "questionsBankId='" + questionsBankId + '\'' +
                ", questions=" + Arrays.toString(questions) +
                '}';
    }

    public String getQuestionsBankId() {
        return questionsBankId;
    }

    public void setQuestionsBankId(String questionsBankId) {
        this.questionsBankId = questionsBankId;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    private Question[] questions; //数组中保存多个题目对象
}
