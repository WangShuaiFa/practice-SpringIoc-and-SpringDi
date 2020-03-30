package SpringAop.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component //相当于xml中的配置,aop注解方式使用
@Aspect //标识为切面
public class Aop {
    @Before("execution(* SpringAop.service.UserService.add(..))")
    public void begin(){
        System.out.println("####################前置通知");
    }
    @AfterThrowing("execution(* SpringAop..service.UserService.add(..))")
    public void afterThrowing(){
        System.out.println("###################异常通知");
    }

    @After("execution(* SpringAop..service.UserService.add(..))")
    public void commit(){
        System.out.println("####################后置通知");
    }
    @AfterReturning("execution(* SpringAop..service.UserService.add(..))")
    public void afterReturn(){
        System.out.println("###################运行通知");
    }
    @Around("execution(* SpringAop..service.UserService.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("###################spring aop 环绕通知之前");
        proceedingJoinPoint.proceed();
        System.out.println("###################apring aop 运行通知之后");

    }
}
