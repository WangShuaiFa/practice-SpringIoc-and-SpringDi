package SpringAop;

public class ObjectFactory {
    //实例工厂方法
    public UserEntity getUserEntity(){
        System.out.println("ObjectFactory getUserEntity");
        return new UserEntity("WANG",18);
    }
    //静态工厂方法
    public static UserEntity getStaticUserEntity(){
        System.out.println("ObjectFactory getStaticUserEntity");
        return new UserEntity("staticWANG",18);
    }
}
