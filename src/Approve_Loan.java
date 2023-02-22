public interface Approve_Loan {
    // abstract method
    void loanIsApproved(long balance);
}

class SavingAcLoan implements Approve_Loan{
    public void loanIsApproved(long balance){
        if(balance > 100000) {
            long loanAmt = (long)(balance *1.5);
            System.out.println("Loan is approved of " + loanAmt);
        }
        else{
            System.out.println("Loan is not approved");
        }
    }
}

class CurrentAcLoan implements Approve_Loan{
    public void loanIsApproved(long balance){
        if(balance > 500000) {
            long loanAmt = balance*3;
            System.out.println("Loan is approved of " + loanAmt);
        }
        else{
            System.out.println("Loan is not approved");
        }
    }
}
