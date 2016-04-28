package com.aug.jeff.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbUtil {
    /**
     * 将 JavaBean 转化为 XML
     * @param 要转化的  Bean 对象
     * @return 转换后的结果
     */
    public static String convertBeanToXml(Object obj) {
        return convertToXml(obj, "UTF-8");
    }

    /**
     * 将 JavaBean 转化为 XML
     * @param 要转化的  Bean 对象
     * @param 转化的编码格式
     * @return 转换后的结果
     */
    private static String convertToXml(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 决定是否在转换成 xml 时同时进行格式化（即按标签自动换行，否则即是一行的xml）
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // xml的编码方式
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 将 XML 转化为 JavaBean
     * @param xml 数据源
     * @param 要转化的数据类型
     * @return 转换后的结果
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertXmlToBean(String xml, Class<T> c) {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return t;
    }
}
