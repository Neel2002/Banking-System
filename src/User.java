import java.util.Formatter;
import java.util.HashMap;

public class User
{
    int Account_no;
    String f_name,u_name,password;;
    long balance;
    char acc_type;// c or s

    User(int id,String name,String uname,String password,long bal, char type)
    {
        this.Account_no =2000;
        this.f_name=name;
        this.u_name=uname;
        this.password=password;
        this.balance=bal;
        this.acc_type=type;
    }
}
class UserData
{
    HashMap<Integer,User> userDetails =new HashMap<>();

    public UserData()
    {
        userDetails.put(1,new User(1,"Neel Shah","neel","neel",2000000L,'c'));
        userDetails.put(2,new User(2,"Pratish Soni","pratish","pratish",100000L,'s'));
        userDetails.put(3,new User(3,"Tanish Patel","tanish","tanish",250000L,'c'));
        userDetails.put(4,new User(4,"Jinal Thakor","jinal","jinal",200000L,'s'));
    }
    public void getData(User user)
    {
        Formatter fmt=new Formatter();
        fmt.format("\n%10 %15 %15","Account Number","Full Name","User Name");
        System.out.println("\n------------------------------------------------------------\n");
        fmt.format("%10 %15 %15",user.Account_no,user.f_name,user.u_name);
        System.out.println(fmt);

    }
}
