package prasexml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JDOM {
    public static void main(String[] args) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        builder.setValidation(false);
        builder.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        File file = new File("D:\\123.xml");
        Document doc = builder.build(new File(file.getAbsolutePath()));
        Element root = doc.getRootElement();
        System.out.println(root.getName());
        List<Element> list = root.getChildren();
        System.out.println(list.size());
        for(int x = 0; x<list.size(); x++){
            Element e = list.get(x);
            String name = e.getName();
            System.out.println(name + "=" + e.getText());
            System.out.println("==================");
        }
    }
}
