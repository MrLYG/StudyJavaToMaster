package client;

import entity.Grade;
import entity.Question;
import entity.QuestionsBank;
import model.Message;

import java.io.IOException;
import java.util.Arrays;

public class ExamOperateUtil {

    public int startExam(ClientInitClose cic) throws IOException, ClassNotFoundException {
        System.out.println("请该学员输入自己的学号");
        String sId = ClientScanner.getSc().next();
        Message m = new Message("startExam",sId);
        cic.getOos().writeObject(m);


        //获取返回的题库
        Message res = (Message) cic.getOis().readObject();
        QuestionsBank questionsBank = (QuestionsBank) res.getT();

        int sumQuestions = questionsBank.getQuestions().length; //总测试题目数量
        int sumCorrect = 0; //答对题目数量
        for (Question q: questionsBank.getQuestions() ) {
            System.out.println(q.getqContent());
            System.out.println(Arrays.toString(q.getChoices()));
            System.out.println("请输入你的答案");
            String answer = ClientScanner.getSc().next();
            if(answer.equals(q.getCorrectChoice())){
                sumCorrect++;
            }
        }
        System.out.println("总共答对了"+sumCorrect+"道题");
        int grade = sumCorrect/sumQuestions * 100;
        System.out.println("成绩为:"+grade);
        //将成绩存入成绩表
        Grade g =new Grade(sId, questionsBank.getQuestionsBankId(),String.valueOf(grade));

        Message mG = new Message("restoreGrade",g);
        cic.getOos().writeObject(mG);
        System.out.println("测试完成");
        return grade;
    }
}
