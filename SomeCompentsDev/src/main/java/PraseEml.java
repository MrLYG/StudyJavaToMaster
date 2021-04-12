import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.*;

public class PraseEml {

    public static void main(String[] args) throws Exception {
        parserFile("D:\\em.eml");


    }

    public static void parserFile(String emlPath) throws Exception {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        File file = new File(emlPath);
        InputStream inMsg;
        inMsg = new FileInputStream(file);
        Message msg = new MimeMessage(session, inMsg);

//        parseEml(msg);
        msg.saveChanges();
        File file1 = new File("D:\\em20.eml");
        if(!file.exists()){
            file1.mkdir();
        }
        OutputStream outputStream = new FileOutputStream(file1);
        msg.writeTo(outputStream);

    }



    private static void parseEml(Message msg) throws Exception {
        Map<Object, Object> map = new HashMap<>(10);
        // 发件人信息
        Address[] froms = msg.getFrom();
        if (froms != null) {
            InternetAddress addr = (InternetAddress) froms[0];
            System.out.println("发件人地址:" + addr.getAddress());
            map.put("fjrAddress",addr.getAddress());
            System.out.println("发件人显示名:" + addr.getPersonal());
            map.put("fjrName", addr.getPersonal());

        }
        //收件人信息
        Address[] tos = msg.getAllRecipients();
        List<String> sjrAddressList = new ArrayList<>();
        for (Address a : tos) {
            InternetAddress addr = (InternetAddress)a;
            System.out.println("====>收件人地址：" + addr.getAddress());
            sjrAddressList.add(addr.getAddress());
        }
        map.put("sjrAddressList", sjrAddressList);

        msg.setSubject("1111111");
        System.out.println("邮件主题:" + msg.getSubject());
        map.put("subject", msg.getSubject());
        // getContent() 是获取包裹内容, Part相当于外包装
        Object o = msg.getContent();
        if (o instanceof Multipart) {
            Multipart multipart = (Multipart) o;
            reMultipart(multipart);
        } else if (o instanceof Part) {
            Part part = (Part) o;
            rePart(part);
        } else {
            System.out.println("类型" + msg.getContentType());
            map.put("type", msg.getContentType());
            System.out.println("内容" + msg.getContent());
            map.put("content", msg.getContent());
        }

    }


    /**
     * 解析内容
     *
     * @param part
     * @throws Exception
     */
    private static void rePart(Part part) throws Exception {
        if (part.getContentType().startsWith("text/plain")) {



//            System.out.println("文本内容：" + part.getContent());

//            String text = (String) part.getContent();
//            System.out.println("文本内容：" + text);
            String s = "亲爱的云冈,\n" +
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
//            part.setContent();

            Multipart multipart = new MimeMultipart();
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(s);
            multipart.addBodyPart(messageBodyPart);

            part.setContent(multipart);



            System.out.println("文本内容：" + part.getContent());
        } else {
            // System.out.println("HTML内容：" + part.getContent());
        }
    }

    /**
     * 接卸包裹（含所有邮件内容(包裹+正文+附件)）
     * @param multipart
     * @throws Exception
     */
    private static void reMultipart(Multipart multipart) throws Exception {
        // System.out.println("邮件共有" + multipart.getCount() + "部分组成");
        // 依次处理各个部分
        for (int j = 0, n = multipart.getCount(); j < n; j++) {
            // System.out.println("处理第" + j + "部分");
            Part part = multipart.getBodyPart(j);// 解包, 取出 MultiPart的各个部分,
            // 每部分可能是邮件内容,
            // 也可能是另一个小包裹(MultipPart)
            // 判断此包裹内容是不是一个小包裹, 一般这一部分是 正文 Content-Type: multipart/alternative
            if (part.getContent() instanceof Multipart) {
                Multipart p = (Multipart) part.getContent();// 转成小包裹
                // 递归迭代
                reMultipart(p);
            } else {
                rePart(part);
            }
        }
    }
}
