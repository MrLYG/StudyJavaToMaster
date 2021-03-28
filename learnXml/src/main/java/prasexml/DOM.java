package prasexml;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import org.w3c.dom.NamedNodeMap;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

import org.w3c.dom.Element;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DOM {




    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory docBuiFactory = DocumentBuilderFactory.newInstance(); //newInstance通过反射机制创建DocumentBuilderFactory的实现类
        docBuiFactory.setValidating(false);
        DocumentBuilder docBuilder = docBuiFactory.newDocumentBuilder(); //通过DocumentBuilderFactoryImpl的newDocumentBuilder()函数返回DocumentBuilder对象

        docBuilder.setEntityResolver((new EntityResolver() {
            public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                if(publicId.equals("-//iBATIS.com//DTD SQL Map Config 2.0//EN")){
                    return new InputSource(new ByteArrayInputStream("<?xml version='1.0' encoding='GBK'?>".getBytes()));
                }

                return null;
            }
        }));

        Document doc = docBuilder.parse("D:\\123.XML");
    }



}
