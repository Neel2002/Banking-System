public interface Calculate_interest {
    // abstract method
    void interest(long amt, int time, int rate);
}

class Inter implements Calculate_interest{

    public void interest(long amt, int time, int rate){
        long interest = amt * time * rate / 100;
        System.out.println("amount : " + amt);
        System.out.println("interest : " + interest);
    }
}
