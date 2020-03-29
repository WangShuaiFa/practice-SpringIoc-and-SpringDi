package SpringAop;

public class UserDao {
    private boolean flag;
    public void add(){
        System.out.println("数据库访问层……");
    }

    public void setFlag(boolean flag) {
        System.out.println("this is flag: "+flag);
        this.flag=flag;
    }
}

