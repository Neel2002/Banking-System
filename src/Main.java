import java.io.Console;
import java.util.Formatter;
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

                        System.out.println("\nLogin succeed! Welcome " + currUser.f_name);
                        int ch2;
                        do{
                            System.out.println("1. Calculate Interest \n2. Apply For Loan \n3.Show Profile \n4.Withdraw \n5.Deposit \n6.Logout");
                            ch2 = sc.nextInt();
                            switch (ch2) {
                                case 1: {
                                    if(currUser.acc_type == 's'){
                                        Calculate_interest obj = new SavingAcInterest();
                                        System.out.println("Your Balance: " + currUser.balance + "\nYour Interest: " + obj.interest(currUser.balance, sc));
                                    }
                                    else{
                                        System.out.println("Your account type is current account");
                                    }
                                    break;
                                }
                                case 2: {
                                    Approve_Loan obj;
                                    if(currUser.acc_type == 'c'){
                                        obj = new CurrentAcLoan();
                                    }
                                    else {
                                        obj = new SavingAcLoan();
                                    }
                                    if(obj.loanIsApproved(currUser.balance, sc)){
                                        System.out.println("Congratulations! Loan Is Approved");
                                    }
                                    else{
                                        System.out.println("Sorry! Loan is Rejected! ");
                                    }
                                    break;


                                }
                                case 3:
                                {
                                    showProfile(currUser);
                                    break;
                                }
                                case 4:{
                                    currUser.withdraw(sc);
                                    break;
                                }
                                case 5:{
                                    currUser.deposit(sc);
                                    break;
                                }
                                case 6: {
                                    System.out.println("Thank You");
                                    break NewSession;
                                }
                                default:{
                                    System.out.println("Invalid Choice! ");
                                }
                            }
                        }while (ch2!=6);
                    }
                    else {
                        System.out.println("\nInvalid username or password");
                    }
                    break;
                }
                case 2:
                {
                    User currUser=new User();
                    currUser.registration(userData.userDetails ,sc);
                    break;
                }
                case 3:
                {

                }
                case 4:
                {
                    System.out.println("Thank You! ");
                    break;
                }
                default:
                {
                    System.out.println("Enter Valid Choice! ");
                    break;
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

    private static void showProfile(User currUser)
    {
        System.out.print("\nUser Profile:\n");
        System.out.println("------------------------------------------------------------");
        System.out.println("Full Name: " + currUser.f_name );
        System.out.println("Username: " + currUser.u_name);
        System.out.println("Balance: " + currUser.balance);
        if(currUser.acc_type == 'c')
        {
            System.out.println("Account Type: Current");
        }
        else
        {
            System.out.println("Account Type: Savings");
        }
        System.out.println("------------------------------------------------------------\n");
    }
}

