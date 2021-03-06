package util;

import bean.ReqXmlBean;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * xml javabean转换
 *
 * @Authuor Administrator
 * @Create 2016-09-07-17:14
 */
public class XmlBeanTransfer {
    public static String beanToXml(ReqXmlBean bean) {
        String result = "";
        return result;
    }

    public static <T> List<T> xmlToBean(T obj, String xml) {
        long lasting = System.currentTimeMillis();  //检测效率
        List<T> list = new ArrayList<>();  //创建集合
        Document document = null;
        try {
            document = DocumentHelper.parseText(xml);  //字符串转xml文件
            Element root = document.getRootElement();  //获取根节点
            List<Element> elements = root.elements();
            Element foo = null;  //二级节点
            Field[] properties = obj.getClass().getDeclaredFields();  //获得实例的属性
            Method getMethod;   //实例的get方法
            Method setMethod;   //实例的set方法
            //遍历obj.getClass().getSimpleName()节点
            Iterator iterator = elements.get(1).elementIterator();
            for (; iterator.hasNext(); ) {
                foo = (Element) iterator.next();  //下一个二级节点
                obj = (T) obj.getClass().newInstance();  //获取对象的新实例
                for (int j = 0; j < properties.length; j++) {  //遍历子孙节点
                    //实例的set方法
                    setMethod = obj.getClass().getMethod("set" + properties[j].getName().substring(0, 1).toUpperCase() + properties[j].getName().substring(1), properties[j].getType());  //获得实例的set方法，通过方法名
                    setMethod.invoke(obj, foo.elementText(properties[j].getName()));  //调用set方法
                }
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("xml转javabean结束，用时：" + (end - lasting) + " ms");
        return list;
    }
}
