package prasexml;

import org.junit.Test;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxTest {
    @Test
    public void t() throws ParserConfigurationException, SAXException, IOException {
//        使用SAXParserFactory创建SAX解析工厂
        SAXParserFactory spf = SAXParserFactory.newInstance();
//        通过SAX解析工厂得到解析器对象
        SAXParser sp = spf.newSAXParser();
//        通过解析器对象得到一个XML的读取器
        XMLReader xmlReader = sp.getXMLReader();
//        设置读取器的事件处理器
        xmlReader.setContentHandler((ContentHandler) new SaxTest());
//        解析xml文件
        xmlReader.parse("D\\123.xml");

    }
}
