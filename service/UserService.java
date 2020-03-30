package SpringAop.service;

import SpringAop.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/*相当于<bean id="userService" class="com.itmayiedu.service.UserService">
		<property name="userDao" ref="userDao"></property>
	</bean>
* */
@Service
public class UserService {
    /**
     * @Resource 默认以 属性名称 userDao 去找bean对象
     */
    @Resource
    private UserDao userDao;

    public void add(){
      //  int i=1/0;
        System.out.println("业务逻辑层……");
        userDao.add();
    }

    public void setUserDao(UserDao userDao) {

        this.userDao = userDao;
    }
}
