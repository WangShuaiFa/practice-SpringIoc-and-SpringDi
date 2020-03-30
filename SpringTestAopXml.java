package SpringAop;

import SpringAop.service.UserService;
import SpringAop.xmlService.XmlUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTestAopXml {
    public static void main(String[] args) {
        //没有用Spring的创建方式
        //UserEntity userEntity1 = new UserEntity();
        //spring ioc容器加载
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-005.xml");
        System.out.println("spring容器加载");
        //正确写法，默认创建一个小写的userService对象
        XmlUserService userService = (XmlUserService) classPathXmlApplicationContext.getBean("xmlUserService");
        //错误写法，如果是大写的UserService就会报错误
       // UserService userService = (UserService) classPathXmlApplicationContext.getBean("UserService");
        userService.add();
        System.out.println(userService);
    }
}
