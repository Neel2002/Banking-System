public interface Calculate_interest {
    private void interest(long amt, int time, int rate){
        long interest = amt * time * rate / 100;
        System.out.println("amount : " + amt);
        System.out.println("interest : " + interest);
    }
}
