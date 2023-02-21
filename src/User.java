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
    }
    public void getData(UserData user)
    {
        Formatter fmt=new Formatter();
        fmt.format("%10 %15 %15","User Id","Full Name","User Name");

    }
}
