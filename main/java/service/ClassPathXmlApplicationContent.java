package service;

import Entity.UserEntity;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ClassPathXmlApplicationContent{
    private String XmlPath;

    public ClassPathXmlApplicationContent(String xmlpath){
        this.XmlPath=xmlpath;
    }
    public Object SpringIoc(String beanId) throws ParserConfigurationException, SAXException, DocumentException,
            ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
      /*
      1.读取xml配置文件*/
        // 创建SAXReader对象
        SAXReader reader = new SAXReader();
        // 读取文件 转换成Document，获取当前项目路径
        Document document = reader.read(this.getClass().getClassLoader().getResourceAsStream(XmlPath));
        //获取节点对象
        Element rootElement = document.getRootElement();
        //找出根节点的所有element元素
        List<Element> elements = rootElement.elements();
        Object instance=null;
        if(elements!=null){
            //2.获取每个bean配置，获取class
            for (Element sonElement:elements) {
                //获得beanid
                String sonbenId = sonElement.attributeValue("id");
                if(!beanId.equals(sonbenId)){
                    continue;
                }
                //通过sonElement获得class
                String beanClassPath =  sonElement.attributeValue("class");
                //3.拿到class地址，进行反射实例化对象，再通过反射api为私有变量赋值
                Class<?> forName = Class.forName(beanClassPath);
                //实例化class
               instance = forName.newInstance();
               //拿到成员属性
                List<Element> sonSonEleList = sonElement.elements();
                for (Element sonSonEle: sonSonEleList) {
                    //获取每个bean中的id,name
                    String name = sonSonEle.attributeValue("name");
                    String value = sonSonEle.attributeValue("value");
                    //使用反射为name和value进行赋值
                    /*Field fieldName = forName.getDeclaredField(name);*/
                    Field fieldName = forName.getDeclaredField(name);
                    fieldName.setAccessible(true);
                    fieldName.set(instance,value);
                }
            }
        }
            return instance;


      /*  // 1.读取xml配置文件
        // 获取xml解析器
        SAXReader saxReader = new SAXReader();
        // this.getClass().getClassLoader().getResourceAsStream("xmlPath")
        // 获取当前项目路径
        Document read = saxReader.read(this.getClass().getClassLoader().getResourceAsStream(XmlPath));
        // 获取跟节点对象
        Element rootElement = read.getRootElement();
        List<Element> elements = rootElement.elements();
        Object obj = null;
        for (Element sonEle : elements) {
            // 2.获取到每个bean配置 获取class地址
            String sonBeanId = sonEle.attributeValue("id");
            if (!beanId.equals(sonBeanId)) {
                continue;
            }
            String beanClassPath = sonEle.attributeValue("class");
            // 3.拿到class地址 进行反射实例化对象 ，使用反射api 为私有属性赋值
            Class<?> forName = Class.forName(beanClassPath);
            obj = forName.newInstance();
            // 拿到成员属性
            List<Element> sonSoneleme = sonEle.elements();
            for (Element element : sonSoneleme) {
                String name = element.attributeValue("name");
                String value = element.attributeValue("value");
                // 使用反射api 为私有属性赋值
                Field declaredField = forName.getDeclaredField(name);
                //运行往私有成员赋值
                declaredField.setAccessible(true);
                declaredField.set(obj, value);
            }

        }
        // 3.拿到class地址 进行反射实例化对象 ，使用反射api 为私有属性赋值
        return obj;*/
    }

    public static void main(String[] args) throws IllegalAccessException, DocumentException, SAXException, InstantiationException, NoSuchFieldException, ParserConfigurationException, ClassNotFoundException {
        //调用ClassPathXmlApp
        ClassPathXmlApplicationContent pathXmlApplicationContent = new ClassPathXmlApplicationContent("user.xml");
        Object bean = pathXmlApplicationContent.SpringIoc("user1");
        UserEntity userEntity= (UserEntity) bean;
        System.out.println("userEntity is "+userEntity.getName()+userEntity.getId());

    }

}
