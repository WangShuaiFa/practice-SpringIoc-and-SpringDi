package SpringAop;

public class UserEntity {
    private String name;
    //无参构造函数
    public  UserEntity(){
        System.out.println("无参构造函数");
    }
    //有参构造函数
    public UserEntity(String name ,Integer age){
        System.out.println("有参构造函数name:"+name+"-----"+age);
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;

}
