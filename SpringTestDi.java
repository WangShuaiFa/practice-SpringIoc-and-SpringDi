package SpringAop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTestDi {
    public static void main(String[] args) {
        //没有用Spring的创建方式
        //UserEntity userEntity1 = new UserEntity();
        //spring ioc容器加载
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-003.xml");
        System.out.println("spring容器加载");
        //set注入
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("UserService");
        //p标签注入
        UserService userService1 = (UserService) classPathXmlApplicationContext.getBean("UserService1");
        userService.add();
        System.out.println(userService);

    }
}
