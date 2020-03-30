package SpringAop;

import org.springframework.stereotype.Repository;
//相当于<bean id="userDao" class="com.itmayiedu.dao.UserDao"></bean>
@Repository
public class UserDao {
    private boolean flag;
    public void add(){
        System.out.println("数据库访问层……flag:"+flag);
    }

    public void setFlag(boolean flag) {
        System.out.println("this is flag: "+flag);
        this.flag=flag;
    }
}

