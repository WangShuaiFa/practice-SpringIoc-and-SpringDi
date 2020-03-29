package SpringAop;

import org.springframework.stereotype.Component;

@Component //相当于xml中的配置
public class Aop {
    public void begin(){

        System.out.println("事务开启");
    }
    public void commit(){

        System.out.println("事务提交");
    }
}
