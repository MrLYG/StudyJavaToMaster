package dao;

import entity.Question;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    public static List<Question> questions = new ArrayList<>();; //questions 集合用于保存所有question的信息
    private static String docIP = "ExamSystemServer\\src\\dao\\questions.txt" ; //用于记录保存题目信息文件的地址默认为"d:/studentM.txt"


}
