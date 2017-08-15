/**
 */
package com.jinbao.jaxb.util;

import java.io.StringWriter;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

/**
 * 2014-7-3，由<a href="mailto:wtkj_wangwenbo@163.com">wbw</a>创建了初始版本
 * 将xsd生成的bean转化为xml
 * 
 * @author <a href="mailto:wtkj_wangwenbo@163.com">wbw</a>
 * @date 2014-7-3-下午6:58:51
 */
public class XmlUtil {
    
    private static final String xsdPckPath = "/com/jinbao/jaxb/schema/";
    
    /**
     * 生成指定参数对象的XML
     * 
     * @param msgObj
     * @return
     */
    public static String mashaller(Object msgObj) {
        
        if (msgObj.getClass().getAnnotation(XmlRootElement.class) == null) {
            throw new IllegalArgumentException("不可解析");
        }
        
        try {
            JAXBContext context = JAXBContext.newInstance(msgObj.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //JAXB_NO_NAMESPACE_SCHEMA_LOCATION
            m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "");
            StringWriter writer = new StringWriter();
            m.marshal(msgObj, writer);
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String marshallerByXsd(Object msgObj, String xsdFileName) {
        if (msgObj.getClass().getAnnotation(XmlRootElement.class) == null) {
            throw new IllegalArgumentException("不可解析");
        }
        URL xsdUrl = XmlUtil.class.getResource(xsdPckPath + xsdFileName);
        try {
            JAXBContext context = JAXBContext.newInstance(msgObj.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setSchema(SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema").newSchema(xsdUrl));
            StringWriter writer = new StringWriter();
            m.marshal(msgObj, writer);
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
    
//    public static Object unmarshaller(String xml) {
//        try {
//            JAXBContext context = JAXBContext.newInstance( clazz);
//            Unmarshaller um = context.createUnmarshaller();
//            StringReader reader = new StringReader(xml);
//            return um.unmarshal(reader);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    
//    public static Object unmarshallerByXsd(String xml, Class<? extends CommonMessage> clazz, String xsdFileName) {
//        
//        URL xsdUrl = XmlUtil.class.getResource(xsdPckPath + xsdFileName);
//        
//        try {
//            JAXBContext context = JAXBContext.newInstance(CommonMessage.class, clazz);
//            Unmarshaller um = context.createUnmarshaller();
//            um.setSchema(SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema").newSchema(xsdUrl));
//            StringReader reader = new StringReader(xml);
//            return um.unmarshal(reader);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
