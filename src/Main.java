import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        UserData userData=new UserData();

        int ch;

        NewSession:
        do
        {
            System.out.print("\n1. Login \n2. Register \n3. Change Password\n4. Exit");
            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();

            switch (ch)
            {
                case 1:
                {
                    System.out.print("\nEnter UserName: ");
                    String userName = sc.next();
                    String password = hiddenPassword();
                    User currUser = new User();
                    if(currUser.loginUser(userData.userDetails,userName,password))
                    {
                        currUser=userData.getUser(userName);
                        System.out.println("\nLogin succeed");
                    }
                    else {
                        System.out.println("\nInvalid username or password");
                    }
                }
            }
        }while(ch!=4);
    }
    public  static String hiddenPassword(){
        Console c=System.console();
        char[] passw = c.readPassword("Enter Password: ");
        for(int i=0;i<passw.length;i++){
            System.out.print("*");
        }
        System.out.println("\n");
        String p = new String(passw);
        return p;
    }
}