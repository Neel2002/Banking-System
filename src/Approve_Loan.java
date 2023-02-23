import java.util.Scanner;

public interface Approve_Loan {
    // abstract method
    abstract boolean loanIsApproved(long balance, Scanner sc);
}

class SavingAcLoan implements Approve_Loan{
    public boolean loanIsApproved(long balance, Scanner sc){
        if(balance < 100000){
            System.out.println("You Do not have enough balance! ");
            return false;
        }
        System.out.println("Maximum amount of loan can be approved: " + balance*1.5);
        System.out.println("Enter Loan Amount: ");
        long loan = sc.nextLong();
        if(loan < balance*1.5){
            return true;
        }
        else{
            return false;
        }

    }
}

class CurrentAcLoan implements Approve_Loan{
    public boolean loanIsApproved(long balance, Scanner sc){
        if(balance < 500000){
            System.out.println("You Do not have enough balance! ");
            return false;
        }
        System.out.println("Maximum amount of loan can be approved: " + balance*3);
        System.out.println("Enter Loan Amount: ");
        long loan = sc.nextLong();
        if(loan < balance*3){
            return true;
        }
        else{
            return false;
        }
    }
}
