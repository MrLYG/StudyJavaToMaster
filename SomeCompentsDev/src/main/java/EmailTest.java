import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.io.*;

import org.apache.commons.mail.util.MimeMessageParser;
import org.apache.commons.mail.util.MimeMessageParser;
import org.apache.commons.mail.util.MimeMessageUtils;
import org.junit.Test;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailTest {


    @Test
    public void test() throws IOException, MessagingException {
        File file = new File("D:\\em.eml");
        MimeMessage mm = MimeMessageUtils.createMimeMessage(null, file);
        String emailType = mm.getContentType();
        Object contentMultipart = mm.getContent();
        //判断contentMultipart =m m.getContent()获取的内容到底是Multipart | HTML | TEXT
        if (contentMultipart instanceof Multipart) {
            //将contentMultipart转换为Multipart类型，向下进行操作
            Multipart multipart = (Multipart) contentMultipart;
            System.out.println("该邮件内容由--"+multipart.getCount()+"部分组成");

            //获取multipart邮件内容所包含的bodypart 从而获取邮件内容
            BodyPart bodyPart = multipart.getBodyPart(0);
            //如果bodyPart是文本内容则解析
            if(bodyPart.getContent() instanceof String){
//                System.out.println(bodyPart.getContent());
                //翻译bodyPart中的文本内容并返回一个BodyPart类型
                BodyPart transedBodyPart=getTransedBodyPart((String) bodyPart.getContent());
//                transedBodyPart.addHeader("Content-Transfer-Encoding", "UTF-8");
//                transedBodyPart.setHeader("Content-Transfer-Encoding", "UTF-8");

                System.out.println(multipart.getBodyPart(0).getContent());

                //新建一个Multipart类型的对象
                Multipart multipart1 = new MimeMultipart();
                //把返回的transedBodyPart加入到multipart对象中
                multipart1.addBodyPart(transedBodyPart,0);

                //把Multipart设置为MimeMessage对象中的邮件内容
                mm.setContent(multipart1);
                //保存对MimeMessage对象的修改！！！
                mm.saveChanges();
                System.out.println("-------------------------");

                Multipart content = (Multipart) mm.getContent();
                System.out.println(content.getBodyPart(0).getContent());
            }else {
                System.out.println("邮件的内容解析出的第一个bodypart不为String类型");
            }
        }
//        File file1 = new File("D:\\em17.txt");
//        if(!file.exists()){
//            file1.mkdir();
//        }
//        OutputStream outputStream = new FileOutputStream(file1);
//        mm.writeTo(outputStream);
        System.out.println(emailType);

//        System.out.println(content);
    }

    private BodyPart getTransedBodyPart(String o){
        try {
            BodyPart bodyPart = new MimeBodyPart();
//            bodyPart.setHeader("Content-Transfer-Encoding", "UTF-8");
//            String res = " akadjsfklaj9oiwejnfosdjfoiadsjf;okjweoifjoisadjfoidjfowiejfidsjojfd;iofhaeohfpewihfoe;w";
            String res = "亲爱的云冈,\n" +
                    "\n" +
                    "\n" +
                    "来自东北大学的问候!作为一个友好的提醒，以下信息会议将在24小时后开始。\n" +
                    "\n" +
                    "\n" +
                    "当你考虑读研时，东北大学工程研究生院邀请你参加一个关于电信网络女士学习更多的核心课程，选修机会，体验式学习机会，课程项目，以及你将在项目中获得的技能。节目总监彼得·奥莱利将主持会议，并将有一名在校学生和招生工作人员参加。活动物流如下。\n" +
                    "\n" +
                    "\n" +
                    "信息会话的细节:\n" +
                    "2021年3月9日\n" +
                    "9:00am-10:00am\n" +
                    "注册在这里\n" +
                    "\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "\n" +
                    "关于O ' reilly博士\n" +
                    "\n" +
                    "\n" +
                    "Peter O 'Reilly获得都柏林大学电气工程硕士学位，科罗拉多州立大学电气工程硕士学位，佐治亚理工学院应用数学硕士学位。1983年，他获得佐治亚理工学院电气工程博士学位。\n" +
                    "\n" +
                    " O 'Reilly博士自2002年东北大学电信网络项目启动以来一直担任该项目的主管。\n" +
                    "\n" +
                    " 从1983年到2001年，O 'Reilly博士在GTE实验室和Verizon Communications工作。在GTE和Verizon任职期间，他发起、指导和开展了电信技术、网络、架构和服务领域的研究。他还规划管理了许多大型软件开发项目，这些项目跨越多个地点和组织实体。他的两个项目获得了华纳奖，这是GTE的最高技术奖。\n" +
                    "\n" +
                    " O 'Reilly博士是IEEE Network的高级技术编辑，此前曾担任编辑委员会和总编成员。在此之前，他曾担任IEEE/ACM网络学报的技术编辑，并担任IEEE期刊关于通信选定领域的一期“宽带ISDN及以上的电路交换”的客座编辑。\n" +
                    "\n" +
                    " 他是IEEE的高级成员，ACM和Sigma Xi的成员。\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "\n" +
                    "关于东北大学工程研究生院\n" +
                    "\n" +
                    "\n" +
                    "东北大学工程研究生院包括一流的、高选择性的R1研究项目，将严谨的学术与经验学习和聚合研究相结合，为下一代工程领导者应对全球社会的复杂挑战做好准备。\n" +
                    "\n" +
                    "\n" +
                    "欲了解更多入学要求、常见问题以及与在校生联系的机会，请点击 在这里.\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "\n" +
                    "感谢您考虑东北大学的研究生教育，我们期待在活动中与您见面!\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "真诚地,\n" +
                    "\n" +
                    "\n" +
                    "工程研究生院\n" +
                    " 工程学院\n" +
                    " 东北大学\n" +
                    " 马萨诸塞州的波士顿\n" +
                    " 有入学问题吗?点击 在这里\n" +
                    "https://coe.northeastern.edu/academic-programs/\n" +
                    " 连接上 脸谱网, 推特, Instagram, 微博";


            bodyPart.setContent(res,"text/plain; charset=gb2312");
//            bodyPart.setText(res);
//            bodyPart.setContent(new String(res.getBytes("UTF-8"),
//                    "UTF-8"),"text/plain; charset=UTF-8");

            return bodyPart;
        } catch (MessagingException  e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
                 File file = new File("D:\\em.eml");
                 try {
                     MimeMessage mimeMessage = MimeMessageUtils.createMimeMessage(null, file);
//                     MimeMessage mimeMessage1 = MimeMessageUtils.createMimeMessage();
                     MimeMessageParser parser = new MimeMessageParser(mimeMessage);
                     System.out.println("发件人："+parser.getFrom());
                     System.out.println("主题："+parser.getSubject());
                     System.out.println("收件人："+parser.getTo());
//                     System.out.println(parser.parse().getPlainContent());
                     String text = "1";

                     BodyPart body = new MimeBodyPart();
                     body.setContent(text, "text/plain");
                     Multipart mp = new MimeMultipart("related");
                     mp.addBodyPart(body);
                     mimeMessage.setContent(mp);
                     mimeMessage.setText(text);

                         File file1 = new File("D:\\em4.eml");
                         if(!file.exists()){
                             file1.mkdir();
                         }
                         OutputStream outputStream = new FileOutputStream(file1);
                         mimeMessage.writeTo(outputStream);
//                         mimeMessage.setContent();
                     System.out.println("-------------------------");
//                     System.out.println(mimeMessage.getContent());
                     System.out.println(parser.parse().getPlainContent());  //结果为空
                         System.out.println(parser.parse().getHtmlContent()); //结果为空
                         //parse.parse()方法返回的也是MimeMessageParser对象，不调用parse()方法就无法的到邮件内容，只能得到主题和收件人等信息
//                         if(parser.parse().hasPlainContent()){  //这里一定要调用parser.parse方法
//                                 System.out.println(parser.parse().getPlainContent());
//                             }



                     } catch (MessagingException e) {
                         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                     } catch (IOException e) {
                         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                     } catch (Exception e) {
                         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                     }


             }
 }