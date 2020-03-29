package SpringAop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    /**
     * @Resource 默认以 属性名称 userDao 去找bean对象
     */
    @Resource
    private UserDao userDao;

    @Autowired
    private Aop aop;
    public void add(){
        aop.begin();
        System.out.println("业务逻辑层……");
        userDao.add();
        aop.commit();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
