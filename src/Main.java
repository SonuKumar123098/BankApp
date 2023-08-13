// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       HDFCAccount kunal=new HDFCAccount("kunal",2000.0,"kunal456");
       System.out.println(kunal);

//       fetch balance
        System.out.println(kunal.fetchBalance("kunal456"));
//        add money
        System.out.println(kunal.addMoney(100000.0));

//        withdraw money
        System.out.println(kunal.withdrawMoney(5000.0, "kunal34"));
        System.out.println(kunal.withdrawMoney(200000.0, "kunal456"));
        System.out.println(kunal.withdrawMoney(5000.0, "kunal456"));

//        calculate interest
        System.out.println(kunal.interest(4.0));
//        change password
        System.out.println(kunal.changePassword("kunal456", "kunal567"));
        System.out.println(kunal.changePassword("kunal455", "kunal567"));
// check balance
        System.out.println(kunal.fetchBalance("kunal456"));
        System.out.println(kunal.fetchBalance("kunal567"));
    }
}