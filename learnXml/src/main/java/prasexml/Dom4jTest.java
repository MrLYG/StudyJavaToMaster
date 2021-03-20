package prasexml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Dom4jTest {
     //test时Juint的常用注解，选择函数名字 右键Run as Junit Test

    @Test
     public void testParseXML() throws DocumentException, IOException {
        String path = "D:\\IDEA\\IdeaWorkSpaces\\StudyJavaToMaster\\learnXml\\xml_task03\\src\\com\\lagou\\xml04\\book.xml"; //本地xml路径
        SAXReader reader = new SAXReader();
        Document doc = reader.read(path); // 读取XML文件
        Element root = doc.getRootElement();
        printChild( root);
//        FileWriter out = new FileWriter( path );
//        doc.write(out);
//        out.flush();
//        out.close();
    }

    public void printChild(Element root) {
        @SuppressWarnings("unchecked")
        List<Element> childList = root.elements();
        for (Element e : childList) {
            if (e.elements().size() == 0) {

                //修改该内容
                e.setText("0000");
                System.out.println(e.getName() + " " + e.getText());
            } else {
                printChild(e);
            }
        }
    }




    public void revise(Element root) {
        @SuppressWarnings("unchecked")
        List<Element> childList = root.elements();
//        System.out.println(root.getName()+" "+root.getText());
        for (Element e : childList) {
            if (e.elements().size() == 0) {
                @SuppressWarnings("unchecked")
                List<Attribute> attributeList = e.attributes();
//                for (Attribute a : attributeList) {
//                    System.out.println(a.getName() + ":" + a.getValue());
//                }

//                System.out.println(e.getName() + " " + e.getText());
            } else {
//                System.out.println(e.getName());
                List<Attribute> attributeList = e.attributes();
//                for (Attribute a : attributeList) {
//                    System.out.println(a.getName() + ":" + a.getValue()+"======================");
//                }
                printChild(e);
            }
        }
    }
 }
