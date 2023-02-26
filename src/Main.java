import java.io.Console;
import java.sql.SQLOutput;
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

                        System.out.println("\nWelcome " + currUser.f_name);
                        int ch2;
                        if(currUser.acc_type=='s'){
                            do{
                                System.out.println("\n1. Calculate Interest \n2. Apply For Loan \n3. Show Profile \n4. Withdraw \n5. Deposit \n6. Logout");
                                System.out.print("Enter your choice: ");
                                ch2 = sc.nextInt();
                                switch (ch2) {
                                    case 1:
                                    {
                                        Calculate_interest obj = new SavingAcInterest();
                                        System.out.println("Your Balance: " + currUser.balance + "\nYour Interest: " + obj.interest(currUser.balance, sc));
                                        break;
                                    }
                                    case 2:
                                    {
                                        Approve_Loan obj = new SavingAcLoan();
                                        if(obj.loanIsApproved(currUser.balance, sc)){
                                            System.out.println("Congratulations! Loan is Approved");
                                        }
                                        else{
                                            System.out.println("\nSorry! Loan is Rejected! ");
                                        }
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Name: " + currUser.f_name + "\nUsername: " + currUser.u_name + "\nYour Balance: " + currUser.balance);
                                        System.out.println("Account Type: Saving");
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
                                        continue NewSession;
                                    }
                                    default:{
                                        System.out.println("Invalid Choice! ");
                                    }
                                }
                            }while (ch2!=6);
                        }
                        else{  // if user have current account then it will not show calculate interest option
                            do{
                                System.out.println("\n1. Apply For Loan \n2. Show Profile \n3. Withdraw \n4. Deposit \n5. Logout");
                                System.out.print("Enter your choice: ");
                                ch2 = sc.nextInt();
                                switch (ch2) {
                                    case 1:
                                    {
                                        Approve_Loan obj = new CurrentAcLoan();
                                        if(obj.loanIsApproved(currUser.balance, sc)){
                                            System.out.println("Congratulations! Loan is Approved");
                                        }
                                        else{
                                            System.out.println("\nSorry! Loan is Rejected! ");
                                        }
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Name: " + currUser.f_name + "\nUsername: " + currUser.u_name + "\nYour Balance: " + currUser.balance);
                                        System.out.println("Account Type: Current");
                                        break;
                                    }
                                    case 3:{
                                        currUser.withdraw(sc);
                                        break;
                                    }
                                    case 4:{
                                        currUser.deposit(sc);
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("Thank You");
                                        continue NewSession;
                                    }
                                    default:{
                                        System.out.println("Invalid Choice! ");
                                    }
                                }
                            }while (ch2!=5);
                        }
                    }
                    else {
                        System.out.println("\nInvalid username or password");
                    }
                    break;
                }
                case 2: {
                    User currUser = new User();
                    currUser.registration(userData.userDetails, sc);
                    break;
                }
                case 3:
                {
                    System.out.print("\nEnter Username to change Password: ");
                    String userName = sc.next();
                    User currUser = userData.getUser(userName);
                    currUser.changePassword(sc);
                    break;
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
        String p = new String(passw);
        return p;
    }
}