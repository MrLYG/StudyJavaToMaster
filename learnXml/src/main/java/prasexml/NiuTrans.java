package prasexml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class NiuTrans {
    private static String xmlPath = "prasexml\\content.XML";

    @Test
    public void praseXml() throws DocumentException {
        //1.创建XML解析对象
        SAXReader reader = new SAXReader();

        //2.解析XML 获取 文档对象
        Document document = reader.read(xmlPath);

    }

}
