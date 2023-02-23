import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    int Account_no;
    String f_name, u_name, password;
    ;
    long balance;
    char acc_type;// c or s

    User() {
    }

    User(int id, String name, String uname, String password, long bal, char type) {
        this.Account_no = 2000;
        this.f_name = name;
        this.u_name = uname;
        this.password = password;
        this.balance = bal;
        this.acc_type = type;
    }

    boolean loginUser(HashMap<String, User> userDetails, String uname, String password) {

        if (userDetails.containsKey(uname))
        {
            User temp= userDetails.get(uname);
            System.out.println(temp.password + "==" + password);
            if(temp.password.equals(password))
                return true;
            else
                return false;
        }
        else
        {
            return false;
        }
    }

    public User deposit(User u, Scanner sc) {
        System.out.println("Enter amount you want to deposit: ");
        int depositAmt = sc.nextInt();
        u.balance += depositAmt;
        return u;
    }

    public User withdraw(User u, Scanner sc) {
        System.out.print("\nYour Balance: " + u.balance);
        int withdrawAmt;
        while (true) {
            System.out.println("Enter amount you want to withdraw: ");
            withdrawAmt = sc.nextInt();
            if (withdrawAmt <= 0) {
                System.out.println("Enter valid positive amount. ");
            } else if (withdrawAmt > u.balance) {
                System.out.print("\nInsufficient balance. Enter valid amount.");
            } else {
                break;
            }
        }
        u.balance -= withdrawAmt;
        return u;
    }
}

class UserData {
    HashMap<String, User> userDetails = new HashMap<>();

    public UserData() {
        userDetails.put("neel", new User(1, "Neel Shah", "neel", "neel", 2000000L, 'c'));
        userDetails.put("pratish", new User(2, "Pratish Soni", "pratish", "pratish", 100000L, 's'));
        userDetails.put("tanish", new User(3, "Tanish Patel", "tanish", "tanish", 250000L, 'c'));
        userDetails.put("jinal", new User(4, "Jinal Thakor", "jinal", "jinal", 200000L, 's'));
    }

    public void getData(User user) {
        Formatter fmt = new Formatter();
        fmt.format("\n%10 %15 %15", "Account Number", "Full Name", "User Name");
        System.out.println("\n------------------------------------------------------------\n");
        fmt.format("%10 %15 %15", user.Account_no, user.f_name, user.u_name);
        System.out.println(fmt);

    }

    public User getUser(String name) {
        return userDetails.get(name);
    }
}
