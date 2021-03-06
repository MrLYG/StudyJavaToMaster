package entity;

import java.util.Arrays;
import java.util.Objects;

public class Question {
    private String qId;
    private String qContent; //题目内容
    private String[] choices; //选项用数组存储
    private String correctChoice; //正确答案

    public Question(String qId, String qContent, String[] choices, String correctChoice) {
        this.qId = qId;
        this.qContent = qContent;
        this.choices = choices;
        this.correctChoice = correctChoice;
    }

    public String getqId() {
        return qId;
    }

    public void setqId(String qId) {
        this.qId = qId;
    }

    public String getqContent() {
        return qContent;
    }

    public void setqContent(String qContent) {
        this.qContent = qContent;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public String getCorrectChoice() {
        return correctChoice;
    }

    public void setCorrectChoice(String correctChoice) {
        this.correctChoice = correctChoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(qId, question.qId) &&
                Objects.equals(qContent, question.qContent) &&
                Arrays.equals(choices, question.choices) &&
                Objects.equals(correctChoice, question.correctChoice);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(qId, qContent, correctChoice);
        result = 31 * result + Arrays.hashCode(choices);
        return result;
    }
}
