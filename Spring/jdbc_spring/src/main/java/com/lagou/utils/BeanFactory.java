package com.lagou.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {


    private static Map<String,Object> iocmap = new HashMap<>();

    // 程序启动时，初始化对象实例
    static {

        //1.读取配置文件
        InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");

        //2.解析xml（dom4j）
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(resourceAsStream);
         //3.编写xpath表达式
            String xpath = "//bean";

         //4.获取到所有的bean标签
            List<Element> list = document.selectNodes(xpath);

         //5.遍历并使用反射创建对象实例，存到map集合（ioc容器）中
            for (Element element : list) {
                String id = element.attributeValue("id");
                //className : com.lagou.dao.impl.UserDaoImpl
                String className = element.attributeValue("class");
                //使用反射生成实例对象
                Object o = Class.forName(className).newInstance();
                // 存到map中 key:id value:o
                iocmap.put(id,o);
            }




        } catch (DocumentException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }


        public static Object getBean(String beanId){
            Object o = iocmap.get(beanId);
            return o;
        }


}
