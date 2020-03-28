package SpringAop;

public class UserService {
    private UserDao userDao;
    public void add(){
        System.out.println("业务逻辑层……");
        userDao.add();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
