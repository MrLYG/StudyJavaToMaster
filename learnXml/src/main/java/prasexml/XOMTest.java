package prasexml;

import nu.xom.*;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.xerces.parsers.SAXParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XOMTest {
    public static void main(String[] args) throws SAXException, ParserConfigurationException {

        XMLReader xmlreader = XMLReaderFactory.createXMLReader();
        xmlreader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        SAXParser xerces = new SAXParser();
//        xerces.setDTDSource();
//        XMLReader xerces = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
        xerces.setFeature("http://xml.org/sax/features/validation", false);
        xerces.setFeature("http://xml.org/sax/features/external-parameter-entities",false);
        xerces.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd",false);
        xerces.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);


//        xerces.setEntityResolver(new IgnoreDTDEntityResolver());
        Builder builder = new Builder(xerces);


        try {
            File f = new File("D:\\123.XML");
            Document doc = builder.build(f);
            Element rootElement = doc.getRootElement();
//            Nodes rootNodes = doc.query("//*");
//            for (Node n: rootNodes) {
//                System.out.println("---------------");
////                System.out.println(n.getValue());
//                Text t = (Text) n;
//                System.out.println(t.getValue());
//            }
            System.out.println(1);

//            doc.getRootElement().insertChild();

            recuseDom(rootElement);
            Elements childElements = rootElement.getChildElements();
            System.out.println(childElements.size());

            System.out.println(childElements.size());

            Iterator it = childElements.iterator();
//            while(it.hasNext()){
//                Element elem = (Element) it.next();
//                Elements childElements1 = elem.getChildElements();
//                Iterator it1 = childElements1.iterator();
//                while(it1.hasNext()){
//                    Element elem2 = (Element) it.next();
//                    Elements childElements2 = elem.getChildElements();
//                    for (Element e :childElements2 ) {
//
//                        System.out.println("--------------------------");
//                        System.out.println( e.getLocalName());
//
//                        System.out.println(e.getValue());
//                        System.out.println("***************************");
//
//                    }
//                }
//
//            }
        }
        catch (Exception ex) {
            System.err.println(ex);

        }


    }

    public static void recuseDom(Element e){
//        Elements childElements = e.getChildElements();
//
//        if(childElements.size()>=1){
//            recuseDom(e);
//        }else {
//            System.out.println("--------------------------");
//            System.out.println(e.getLocalName());
//            System.out.println(e.getValue());
//            System.out.println("***************************");
//            return;
//        }
////        if(childElements.size()>0){
////            recuseDom(es);
////        }else {
////
////            System.out.println("--------------------------");
//////                System.out.println( e.get);
////
////            System.out.println(e.getValue());
////            System.out.println("***************************");
////        }
////
        @SuppressWarnings("unchecked")
        Elements childList = e.getChildElements();
        Iterator it = childList.iterator();
        while(it.hasNext()){
            Element e1 = (Element) it.next();
            if(e1.getChildCount()>2){
                System.out.println("---------------");

                System.out.println(e1.getChildCount());
                System.out.println(e1.getLocalName());
                System.out.println(e1.getQualifiedName());
                System.out.println(e1.getValue());
            }

            recuseDom(e1);
        }


    }

    public static void recuseNode(Node node){

    }
}
