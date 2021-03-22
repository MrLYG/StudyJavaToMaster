package prasexml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.xml.sax.SAXException;

public class Dom4jTest {
     //test时Juint的常用注解，选择函数名字 右键Run as Junit Test
    @Test
     public void testParseXML() throws DocumentException, IOException, SAXException {
        String path = "D:\\IDEA\\IdeaWorkSpaces\\StudyJavaToMaster\\learnXml\\src\\main\\java\\prasexml\\content.xml"; //本地xml路径
        SAXReader reader = new SAXReader();
        reader.setValidation(false);
        reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        Document doc = reader.read(path); // 读取XML文件
        Element root = doc.getRootElement();
        printChild( root);
        FileWriter out = new FileWriter( path );
        doc.write(out);
        out.flush();
        out.close();
    }

    public void printChild(Element root) {
        @SuppressWarnings("unchecked")
        List<Element> childList = root.elements();
        for (Element e : childList) {
            if (e.elements().size() == 0) {

                //修改该内容

                System.out.println(e.getName() + " " + e.getText());
                e.setText("1111111111");
                System.out.println(e.getName() + " " + e.getText());
                System.out.println("---------------");
            } else {
                printChild(e);
            }
        }
    }
 }
