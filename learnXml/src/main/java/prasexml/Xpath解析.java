package prasexml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.xml.sax.SAXException;
import java.util.regex.*;
import java.io.IOException;
import java.util.List;

public class Xpath解析 {
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
        for (Node node:list) {
            Pattern p =Pattern.compile("\\s{2,}|\t|\r|\n");
            Matcher m = p.matcher(node.getText());

//            boolean isMatch = Pattern.matches(pattern, node.getText());
            System.out.println("*********************");
//            System.out.println(isMatch);
            System.out.println(m.find());
            System.out.println(node.getPath());
            System.out.println(node.getName());

            System.out.println(node.getText());
            System.out.println("---------");

        }
    }
}
