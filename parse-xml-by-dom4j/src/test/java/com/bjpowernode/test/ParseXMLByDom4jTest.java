package com.bjpowernode.test;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ParseXMLByDom4jTest {
    @Test
    public void testParseMybatisConfigXML() throws Exception{
        SAXReader reader = new SAXReader();
        Document document = reader.read(ClassLoader.getSystemResourceAsStream("mybatis-config.xml"));

        Element environmentElt = (Element) document.selectSingleNode("/configuration/environments");
        String defaultId = environmentElt.attributeValue("default");
        System.out.println(defaultId);

        environmentElt = (Element) document.selectSingleNode("/configuration/environments/environment[@id='"+defaultId+"']");
        Element transactionManager = environmentElt.element("transactionManager");
        String transactionManagerType = transactionManager.attributeValue("type");
        System.out.println(transactionManagerType);

        Element dataSource = environmentElt.element("dataSource");
        String dataSourceType = dataSource.attributeValue("type");
        System.out.println(dataSourceType);

        Map<String, String> dataSourceMap = new HashMap<>();

        for (Object obj : dataSource.elements()) {
            Element elt = (Element) obj;
            dataSourceMap.put(elt.attributeValue("name"), elt.attributeValue("value"));
        }

        dataSourceMap.forEach((k,v) -> System.out.println(k + " : " + v));


        Element mappersElt = (Element) document.selectSingleNode("/configuration/environments/mappers");
        for (Object obj : mappersElt.elements()) {
            Element mapperElt = (Element) obj;
            System.out.println(mapperElt.attributeValue("resource"));
        }
    }

    @Test
    public void testSQlMapper() throws Exception {
        InputStream is = ClassLoader.getSystemResourceAsStream("sqlmapper.xml");
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(is);

        Element element = (Element) document.selectSingleNode("/mapper");
        Attribute namespace = element.attribute("namespace");
        System.out.println(namespace);

        element.elements().forEach(statement -> {
            Element e = (Element) statement;
            String name = e.getName();
            System.out.println(name);
            if ("select".equals(name)) {
                String resultType = e.attributeValue("resultType");
                System.out.println("resultType: " + resultType);
            }
            String s = e.attributeValue("id");
            System.out.println(s);
            String textTrim = e.getTextTrim();
            System.out.println(textTrim);
        });

    }
}
