import java.util.Scanner;

public interface Calculate_interest {
    double interest(long balance, Scanner sc);
}

class SavingAcInterest implements Calculate_interest{
    public double interest(long balance, Scanner sc) {
        System.out.println("Enter Time (In Years): ");
        double time = sc.nextDouble();
        return balance*time*5/100;
    }
}