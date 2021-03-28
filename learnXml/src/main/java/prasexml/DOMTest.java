package prasexml;

import org.junit.Test;
import org.w3c.dom.*;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class DOMTest {
    
    @Test
    public void DOMTest() throws IOException, SAXException, ParserConfigurationException {

        // 获取 DocumentBuilderFactory的实例
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        //获取DOM模式的解析器对象
        DocumentBuilder db = dbf.newDocumentBuilder();
        //输入流读取xml文档

        File file = new File("D:\\123.XML");
        Document document = db.parse("D:\\123.XML");

        Element documentElement = document.getDocumentElement();
        NodeList nodeList = document.getChildNodes();
        int flags = 0;

        for(int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            domxml(node);

        }
        System.out.println("9999999999999");
    }


    public void domxml(Node node){
        NodeList childNodes = node.getChildNodes();
        for(int x = 0; x <childNodes.getLength(); x++){

            Node children = childNodes.item(x);
//            System.out.println(children.getChildNodes().getLength());

            if(children.getNodeType() == 3){
                String nodeValue = children.getNodeValue();
                System.out.println("------------------------");
                System.out.println(children.getNodeType());
                System.out.println(nodeValue);

            }

            domxml(children);
        }

    }

}