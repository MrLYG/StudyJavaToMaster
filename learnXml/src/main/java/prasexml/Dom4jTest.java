package prasexml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.xml.sax.SAXException;

public class Dom4jTest {
     //test时Juint的常用注解，选择函数名字 右键Run as Junit Test
    @Test
     public void testParseXML() throws DocumentException, IOException, SAXException {
        String path = "D:\\123.XML"; //本地xml路径
        SAXReader reader = new SAXReader();
        reader.setValidation(false);
        reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        Document doc = reader.read(path); // 读取XML文件
        Element root = doc.getRootElement();

//        printChild( root);
//        FileWriter out = new FileWriter( path );
//        doc.write(out);
//        out.flush();
//        out.close();
        List<Node> list = doc.selectNodes("//*");
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println("----------------------------");
            Node node = (Node) it.next();
//            System.out.println();
            System.out.println(node.getName());
            System.out.println(node.getNodeTypeName());
            System.out.println(node.getNodeType());
            System.out.println(node.getText());
        }
    }

    public void printChild(Element root) {
        @SuppressWarnings("unchecked")
        List<Element> childList = root.elements();
        if(!childList.isEmpty()){
            Iterator it = childList.iterator();
            while(it.hasNext()){
                Element e = (Element) it.next();


                System.out.println("---------------");
                System.out.println("name="+e.getName());
                System.out.println("QName="+e.getQName());
                System.out.println(e.getNodeTypeName());
                System.out.println(e.getNodeType());
                System.out.println(e.getTextTrim());
                System.out.println(e.getNodeTypeName());
                printChild(e);
            }
//            for (Element e : childList) {
////                if(e.getText().length()>0){
////
////
////                }
//
//                System.out.println("---------------");
//                System.out.println(e.getText());
//                printChild(e);
//            }
        }else {
            return;
        }




//        if(!childList.isEmpty()) {
//            for (Element e : childList) {
//                if(e.getTextTrim()!=""){
//                    System.out.println(e.getText());
//
//                }
//
//                System.out.println("---------------");
//                printChild(e);
//            }
//        }else {
//            return;
//        }
    }
 }
