package dao;

import entity.Question;
import entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuestionDao {
    public static List<Question> questions = new ArrayList<>();; //questions 集合用于保存所有question的信息
    private static String docIP = "ExamSystemServer\\src\\dao\\questions.txt" ; //用于记录保存题目信息文件的地址默认为"d:/studentM.txt"

    /**
     *
     *自定义静态方法，用于系统打开时，自动读取题目信息文件
     */
    {
        ObjectInputStream ois = null;
        Object obj = null;
        try {
            File file = new File(docIP);
            ois = new ObjectInputStream(new FileInputStream(file ));
            obj = ois.readObject();
            questions = (ArrayList)obj;
        } catch (EOFException e){   //若文件初始为空，则List集合指向null
            questions = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != ois){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void addQuestions(List<Question> clientQuestions) {
        questions.addAll(clientQuestions);
    }

    public void closeQuestions() {
        writeStudentsInfo();
        return;
    }
    /**
     * 将list集合中所有信息写入到文件中
     */
    public void writeStudentsInfo(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(docIP));
            oos.writeObject(questions);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != oos){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return;
    }

    public void reviseQuestion(Question question) {
        Iterator<Question> it = questions.iterator();
        Question rQ = new Question();
        int index = -1;
        while (it.hasNext()){
            Question q = it.next(); //用于保存被删除学生的信息
            if(question.getqId().equals(q.getqId())){
                index = questions.indexOf(q); //获取元素的位置
                q.setqContent(question.getqContent());
                q.setChoices(question.getChoices());
                q.setCorrectChoice(question.getCorrectChoice());
                rQ = q;

            }
        }
        if(index == -1) return;
        questions.set(index,rQ);//将修改的stu存入集合中
        System.out.println("学生"+rQ+"已修改完毕");
        itStus();
        return;
    }

    //遍历考题信息
    public void itStus(){
        Iterator<Question> it = questions.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    /**
     * 根据id查询题目
     * @param question
     * @return
     */
    public List<Question> findQuestion(Question question) {
        List ss = new ArrayList(); //ss用于存放查询结果

        //通过迭代器，遍历学生信息集合
        Iterator<Question> it = questions.iterator();
        while (it.hasNext()){
            Question q = it.next(); //用于保存被删除学生的信息
            if(question.getqId().equals(q.getqId())){
                ss.add(q);
            }
        }
        return ss;
    }
}
