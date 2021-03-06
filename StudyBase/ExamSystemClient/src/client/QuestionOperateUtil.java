package client;

import entity.Question;
import entity.Student;
import model.Message;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 自定义类，完成考题相关操作
 */
public class QuestionOperateUtil {

    public void addQuestion(ClientInitClose cic) throws IOException {
//        System.out.println("请输入题号");
//        String id = ClientScanner.getSc().next();
//        System.out.println("请输入题库内容");
//        String content = ClientScanner.getSc().next();
//        System.out.println("请输入选项，每个选项之间用','隔开");
//        String choice = ClientScanner.getSc().next();
//        String[] choices = choice.split(",");
//        System.out.println("请输入正确选项");
//        String correctChoice = ClientScanner.getSc().next();
//        Question q = new Question(id,content,choices,correctChoice);
////        Message m = new Message("addStudent", s);
////        cic.getOos().writeObject(m);
//        System.out.println("题目添加成功！");
//        System.out.println(q);
        System.out.println("请输入需要导入的文件路径:注意文件内容的格式应为第一行题号，第二行考题内容，第三行选项（不同选项间逗号间隔），第四正确选项，依次循环；不允许出现空格");
//        File questionFile = new File("D:\\IDEA\\IdeaWorkSpaces\\StudyJavaToMaster\\StudyBase\\ExamSystemClient\\src\\client\\questions.txt");
        String path = ClientScanner.getSc().next();
        File questionFile = new File(path);
        BufferedReader fr = new BufferedReader(new FileReader(questionFile));
        List<Question> questions = new ArrayList<>();
//        boolean flag = true;//用于标志什么时候读取完文件，文件读取完设置为false
        while(true){

            String id = fr.readLine();
            if(null == id){
                break;
            }
            String content = fr.readLine();
            if(null == content){
                break;
            }
            String choice = fr.readLine();
            if(null == choice){
                break;
            }
            String[] choices = choice.split(",");
            String correctChoice = fr.readLine();
            if(null == choices){
                break;
            }
            Question q = new Question(id,content,choices,correctChoice);
            questions.add(q);
        }

        for (Question q: questions
             ) {
            System.out.println(q);

        }
        Message m = new Message("addQuestions",questions);
        cic.getOos().writeObject(m);

        System.out.println("题目导入成功");
        return;
    }

    /**
     * 用于通知服务端关闭question,并把数据存入到文件中
     * @param cic
     * @throws IOException
     */
    public void closeQuestion(ClientInitClose cic) throws IOException {
        Message m = new Message("closeQuestions","");
        cic.getOos().writeObject(m);
    }

    /***
     * 修改考题
     * @param cic
     */
    public void reviseQuestion(ClientInitClose cic) throws IOException {
        System.out.println("请输入题号");
        String id = ClientScanner.getSc().next();
        System.out.println("请输入题库内容");
        String content = ClientScanner.getSc().next();
        System.out.println("请输入选项，每个选项之间用','隔开");
        String choice = ClientScanner.getSc().next();
        String[] choices = choice.split(",");
        System.out.println("请输入正确选项");
        String correctChoice = ClientScanner.getSc().next();
        Question q = new Question(id,content,choices,correctChoice);
        Message m = new Message("reviseQuestion",q);
        cic.getOos().writeObject(m);
        return;
    }

    public void findQuestion(ClientInitClose cic) throws IOException, ClassNotFoundException {

        System.out.println("请输入题号");
        Question q = new Question();
        q.setqId(ClientScanner.getSc().next());
        Message m = new Message("findQuestion", q);
        cic.getOos().writeObject(m);

        //接受服务端发来的消息
        Message resM = (Message) cic.getOis().readObject();

        if("success".equals(resM.getType())){
            System.out.println("查询成功！");
        }else {
            System.out.println("查询失败请联系管理员！");
        }
        List res = (List) resM.getT();
        //通过迭代器，遍历学生信息集合
        System.out.println("所查询的题目信息为:");
        Iterator<Question> it = res.iterator();
        while (it.hasNext()){
            Question stu = it.next();
            System.out.println(stu);
        }
        return;
    }
}
