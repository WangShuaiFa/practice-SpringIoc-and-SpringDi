package SpringAop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTestIoc {
    public static void main(String[] args) {
        //没有用Spring的创建方式
        //UserEntity userEntity1 = new UserEntity();
        //spring ioc容器加载
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-002.xml");
        System.out.println("spring容器加载");
        //spring ioc测试xml方式创建对象
        UserEntity userEntity = (UserEntity) classPathXmlApplicationContext.getBean("getUserEntity");
        System.out.println(userEntity.toString());
    }
}
