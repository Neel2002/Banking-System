import java.util.Formatter;
import java.util.HashMap;

public class User
{
    int Uid;
    String f_name,u_name, password;

    User(int id,String name,String uname,String password)
    {
        this.Uid=id;
        this.f_name=name;
        this.u_name=uname;
        this.password=password;
    }
}
class UserData
{
    HashMap<Integer,User> userDetails =new HashMap<>();

    public UserData()
    {
        userDetails.put(1,new User(1,"Neel Shah","neel","neel"));
        userDetails.put(2,new User(2,"Pratish Soni","pratish","pratish"));
        userDetails.put(3,new User(3,"Tanish Patel","tanish","tanish"));
        userDetails.put(4,new User(4,"Jinal Thakor","jinal","jinal"));
    }
    public void getData(User user)
    {
        Formatter fmt=new Formatter();
        fmt.format("%10 %15 %15","User Id","Full Name","User Name");
        System.out.println("------------------------------------------------------------");
        fmt.format("%10 %15 %15",user.Uid,user.f_name,user.u_name);
        System.out.println(fmt);

    }
}
