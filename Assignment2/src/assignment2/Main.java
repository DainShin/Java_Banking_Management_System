package assignment2;


import static assignment2.Bank.BranchLocations.LONDON;

public class Main {

    public static void main(String[] args) {

//        Bank b = new Bank("az", "LONDON");
//        System.out.println(b);
//        Account a = new Account("hsdfsgewrei", 0000123,-100.9999);
//        System.out.println(a);

        Account a1 = new Account("k   '''' En", 78, -6777277.415);
        Account a2 = new Account("Cb     ''''a", 8, 51.395);
//        System.out.println(a1.equals(a2));

        System.out.println(a1.getAccountName());
        System.out.println(a2.getAccountName());
        System.out.println(a1.getAccountNumber());
        System.out.println(a2.getAccountNumber());
        System.out.println(a1.getAccountBalance());
        System.out.println(a2.getAccountBalance());

    }

}