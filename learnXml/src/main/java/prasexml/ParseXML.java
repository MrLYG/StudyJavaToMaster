package prasexml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @ClassName: ParseXML
 * @Description: 递归解析xml
 * @author: SM（sm0210@qq.com）
 *
 *
 * <?xml version="1.0" encoding="UTF-8"?>
<xml>
<CustList>
<TName>SMToUserName</TName>
<FName>SMFromUserName</FName>
<CTime>SMCreateTime1348831860</CTime>
<MType>SMMsgType</MType>
<Content>SMContent</Content>
<MId>SMMsgId1234567890123456</MId>
<SrcLabel>SMSrcLabel</SrcLabel>
<Code>00</Code>

</CustList>

<CustList>
<TName>2SMToUserName</TName>
<FName>2SMFromUserName</FName>
<CTime>2SMCreateTime1348831860</CTime>
<MType>2SMMsgType</MType>
<Content>2SMContent</Content>
<MId>2SMMsgId1234567890123456</MId>
<SrcLabel>2SMSrcLabel</SrcLabel>
<Code>200</Code>

<SMCust>
<SM1>sm1val</SM1>
<SM2>sm2val</SM2>
</SMCust>

<SMCust>
<SM1>sm3val</SM1>
<SM2>sm4val</SM2>
</SMCust>


</CustList>

<Code>1200</Code>
<Content>Success</Content>
</xml>
 *
 */
public class ParseXML {
    /**
     * 递归遍历传入节点下所有节点元素
     * @param element
     */
    public static void getElementList(Element element) {
        List<?> elements = element.elements();
//        try {
//            parentId = element.attribute("id").getText(); //取得id属性的值
//        } catch (NullPointerException e) {
//            parentId = "";
//        }

        /**
         * 判断是否包含子节点，如果包含子节点则进行递归查询
         */
        if (!elements.isEmpty()) {
            Iterator<?> it = elements.iterator();
            while (it.hasNext()) {
                Element elem = (Element) it.next();

//                System.out.println("path:" + elem.getPath()); //输出节点路径
//                System.out.println("parentId:" + parentId);   //输出父节点id
//                for (Iterator<?> it1 = elem.attributeIterator(); it1.hasNext();) {
//                    Attribute attribute = (Attribute) it1.next();
//                    System.out.println(attribute.getName() + ":" + attribute.getText()); //输出节点属性名称和属性值
//                }
//                if(elem.elements().size()==0){
//
//                }
                System.out.println("------------------------");
                System.out.println("复合+"+elem.hasMixedContent());
                System.out.println(elem.getNodeType());
                System.out.println("value:" +elem.getName()+"--------"+elem.getText()); //输出节点内容
//                if(elem.hasMixedContent()){
//                    getElementList(elem); // 递归遍历
//                }else {
//                    System.out.println("value:" +elem.getName()+"--------"+elem.getText()); //输出节点内容
//
//                }


                System.out.println(elem.elements().size());
                System.out.println("**********************");
                getElementList(elem); // 递归遍历

            }
        }
    }


    /**
     * main 方法
     * @param args
     */
    public static void main(String[] args) throws DocumentException, SAXException {
        String path = "D:\\123.xml"; //本地xml路径

        SAXReader reader = new SAXReader();

        reader.setValidation(false);
        reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        Document doc = reader.read(path); // 读取XML文件

        Element root = doc.getRootElement(); // 获取XML根元素


        getElementList(root);

    }


}