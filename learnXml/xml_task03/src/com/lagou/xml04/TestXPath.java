package com.lagou.xml04;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class TestXPath {

    /*
    *  使用selectSingleNode() 方法 查询自定的节点信息
    *
    * */
    @Test
    public void test1() throws DocumentException {

        //1.创建XML解析对象
        SAXReader reader = new SAXReader();

        //2.解析XML 获取 文档对象
        Document document = reader.read("H:\\jdbc_work\\xml_task03\\src\\com\\lagou\\xml04\\book.xml");

        //3.通过selectSingleNode() 方法获取 name节点
        Node node1 = document.selectSingleNode("/bookstore/book/name");
        System.out.println("节点的名称: " + node1.getName());
        System.out.println("书名: " + node1.getText());

        //4.获取第二本书的书名
        Node node2 = document.selectSingleNode("/bookstore/book[3]/name");
        System.out.println("书名: " + node2.getText());
    }


    /*
    * 使用 selectSIngleNode() 方法获取 属性值 或者 通过属性值获取到节点信息
    *
    * */
    @Test
    public void test2() throws DocumentException {

        SAXReader reader = new SAXReader();

        Document document = reader.read("H:\\jdbc_work\\xml_task03\\src\\com\\lagou\\xml04\\book.xml");

        //1.获取第一个booke节点中的  id属性的值
        Node node1 = document.selectSingleNode("/bookstore/book/attribute::id");
        System.out.println("第一个book的id属性值: " + node1.getText() );

        //2.获取最后一个book节点的 id属性值
        Node node2 = document.selectSingleNode("/bookstore/book[last()]/attribute::id");
        System.out.println("最后一个book节点中的属性值: " + node2.getText());

        //3.通过id的值 获取book2节点 中的书名
        Node node3 = document.selectSingleNode("/bookstore/book[@id='book2']");

        String name = node3.selectSingleNode("name").getText();
        System.out.println("id为book2的 节点的书名是: " + name);

    }

    /*
    *  使用selectNodes() 获取所有指定名称 的节点
    *
    * */
    @Test
    public void test3() throws DocumentException {

        SAXReader reader = new SAXReader();

        Document document = reader.read("D:\\IDEA\\IdeaWorkSpaces\\StudyJavaToMaster\\learnXml\\xml_task03\\src\\com\\lagou\\xml04\\book.xml");

        //1.查询所有的节点
        List<Node> list = document.selectNodes("//*");

        for (Node node : list) {
            System.out.println("节点名: " + node.getName());
        }

        System.out.println("--------------------------------------");
        //2.获取所有的书名
        List<Node> list1 = document.selectNodes("//bookstore/book/*");
        for (Node node : list1) {
            System.out.println("书名: " + node.getText());
        }
        System.out.println("--------------------------------------");
        //3.获取 id值为 book1 的节点中的所有内容
        List<Node> list2 = document.selectNodes("/bookstore/book[@id='book1']//*");
        for (Node node : list2) {
            System.out.println(node.getName() + " = " + node.getText());
        }
    }
}
