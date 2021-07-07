package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Dom4jTest {
    //
    @Test
    public void parse() throws DocumentException {
        //创建SAXReader输入流，去读取xml配置文件，生成document对象
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/books.xml");
        System.out.println(document);
    }

    @Test
    public void test() throws Exception {
        //创建SAXReader输入流
        SAXReader saxReader = new SAXReader();
        //读取xml配置文件，生成document对象
        Document document = saxReader.read("src/books.xml");
        //通过document对象获取根元素
        Element rootElement = document.getRootElement();
        //通过根元素获取子元素，如果有多个相同的子元素，可以使用elements
        List<Element> book = rootElement.elements("book");
        //遍历输出所有子元素
        for (Element ele : book) {
            //获取name子元素
            Element nameElement = ele.element("name");
            //获取子元素标签当中文本内容
            String nameText = nameElement.getText();
            //获取子元素author标签当中的文本内容
            String authorText = ele.elementText("author");
            //获取price标签当中的文本内容
            String priceText = ele.elementText("price");
            //获取子元素标签的属性值
            String snText = ele.attributeValue("sn");

            System.out.println(new Book(snText,nameText, BigDecimal.valueOf(Double.parseDouble(priceText)),authorText));
        }
    }
}
