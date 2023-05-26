package org.ibatis.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactoryBuilder() {}

    public SqlSessionFactory build(InputStream inputStream) throws Exception {
        SAXReader reader = new SAXReader();
        // Document document = reader.read(Resources.getResourcesAsStream("ibatis-config.xml"));
        Document document = reader.read(inputStream);
        Element envsElt = (Element) document.selectSingleNode("/configuration/environments");
        String defaultEnv = envsElt.attributeValue("default");
        System.out.println(defaultEnv);

        Element environmentElt = (Element) document.selectSingleNode("/configuration/environments/environment[@id='"+defaultEnv+"']");
        Element dataSourceElt = environmentElt.element("dataSource");
        DataSource dataSource = getDataSource(dataSourceElt);

        Element transactionManagerElt = environmentElt.element("transactionManager");
        TransactionManager transactionManager = getTransactionManager(transactionManagerElt, dataSource);

        Element mappers = envsElt.element("mappers");
        Map<String, MappedStatement> mappedStatements = getMappedStatements(mappers);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory(transactionManager, mappedStatements);
        return sqlSessionFactory;
    }

    public Map<String, MappedStatement> getMappedStatements(Element mappers) {
        Map<String, MappedStatement> mappedStatements = new HashMap<>();
        mappers.elements().forEach(e -> {
            Element mapperElt = (Element) e;
            String resource = mapperElt.attributeValue("resource");
            SAXReader saxReader = new SAXReader();
            try {
                Document document = saxReader.read(Resources.getResourcesAsStream(resource));
                Element mapper = (Element) document.selectSingleNode("/mapper");
                String namespace = mapper.attributeValue("namespace");

                mapper.elements().forEach(el -> {
                    Element elt = (Element) el;
                    String sqlId = elt.attributeValue("id");
                    String sql = elt.getTextTrim();
                    String parameterType = elt.attributeValue("parameterType");
                    String resultType = elt.attributeValue("resultType");
                    String sqlType = elt.getName().toLowerCase();

                    MappedStatement mappedStatement = new MappedStatement(sqlId, resultType, sql, parameterType, sqlType);
                    mappedStatements.put(namespace + "." + sqlId, mappedStatement);
                });
            } catch (DocumentException ex) {
                throw new RuntimeException(ex);
            }
        });
        return mappedStatements;
    }

    public TransactionManager getTransactionManager(Element transactionManagerElt, DataSource dataSource) {
        String type = transactionManagerElt.attributeValue("type").toUpperCase();
        TransactionManager transactionManager = null;
        if ("JDBC".equals(type)) {
            transactionManager = new JDBCTransaction(dataSource, false);
        } else if ("MANAGED".equals(type)) {

        }
        return transactionManager;
    }


    public DataSource getDataSource(Element dataSourceElt) {
        Map<String, String> dataSourceMap = new HashMap<>();
        dataSourceElt.elements().forEach(e -> {
            Element elt = (Element) e;
            dataSourceMap.put(elt.attributeValue("name"), elt.attributeValue("value"));
        });

        String dataSourceType = dataSourceElt.attributeValue("type").toUpperCase();
        DataSource dataSource = null;

        if ("UNPOOLED".equals(dataSourceType)) {
            dataSource = new UnpooledDataSource(dataSourceMap.get("driver"),dataSourceMap.get("url"), dataSourceMap.get("username"), dataSourceMap.get("password"));
        } else if ("POOLED".equals(dataSourceType)) {

        } else if ("JNDI".equals(dataSourceType)) {

        }

        return dataSource;
    }
}
