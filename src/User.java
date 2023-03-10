import java.io.Console;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    int Account_no;
    String f_name, u_name, password;
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
    public void registration(HashMap<String,User> userDetails ,Scanner sc)
    {
        System.out.print("\nEnter User Name: ");
        this.u_name=sc.next();
        if(userDetails.containsKey(u_name))
        {
            System.out.println("User Name already exists");
        }
        else
        {
            Console c=System.console();
            char[] passw = c.readPassword("Enter Password: ");
            for(int i=0;i<passw.length;i++){
                System.out.print("*");
            }
            String p = new String(passw);
            this.password = p;
            System.out.print("\nEnter Full Name: ");
            this.f_name=sc.nextLine();
            sc.nextLine();
            System.out.print("Enter Balance: ");
            this.balance=sc.nextLong();

            while(true)
            {
                System.out.print("Enter Account type(1 for current, 2 for savings): ");
                int type=sc.nextInt();
                if(type==1)
                {
                    this.acc_type='c';
                    break;
                }
                else if (type==2)
                {
                    this.acc_type='s';
                    break;
                }
                else
                {
                    System.out.println("Enter Proper Account type");
                }
            }
            userDetails.put(this.u_name,(new User(userDetails.size(),this.f_name,this.u_name,this.password,this.balance,this.acc_type)));
        }
    }
    public void changePassword(Scanner sc){
        Console c=System.console();
        char[] passw = c.readPassword("\nEnter Password: ");
        for(int i=0;i<passw.length;i++){
            System.out.print("*");
        }
        String p = new String(passw);
        this.password = p;
        System.out.print("\nPassword changed successfully\n ");
    }
    public void deposit(Scanner sc) {
        int depositAmt;
        while (true) {
            System.out.print("\nEnter amount you want to deposit: ");
            depositAmt = sc.nextInt();
            if (depositAmt <= 0) {
                System.out.println("Enter valid positive amount. ");
            }
            else {
                break;
            }
        }
        this.balance += depositAmt;
        System.out.print("Your balance after deposit: "+this.balance);
        System.out.println();
    }

    public void withdraw(Scanner sc) {
        System.out.print("\nYour Balance: " + this.balance);
        int withdrawAmt;
        while (true) {
            System.out.print("\nEnter amount you want to withdraw: ");
            withdrawAmt = sc.nextInt();
            if (withdrawAmt <= 0) {
                System.out.println("\nEnter valid positive amount. ");
            } else if (withdrawAmt > this.balance) {
                System.out.print("\nInsufficient balance. Enter valid amount.");
            } else {
                break;
            }
        }
        this.balance -= withdrawAmt;
        System.out.print("Your balance after withdraw: "+this.balance);
        System.out.println();
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

//    public void getData(User user) {
//        Formatter fmt = new Formatter();
//        fmt.format("\n%10 %15 %15", "Account Number", "Full Name", "User Name");
//        System.out.println("\n------------------------------------------------------------\n");
//        fmt.format("%10 %15 %15", user.Account_no, user.f_name, user.u_name);
//        System.out.println(fmt);
//
//    }

    public User getUser(String name)
    {
        return userDetails.get(name);
    }
}
