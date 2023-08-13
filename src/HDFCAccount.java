import java.util.UUID;

public class HDFCAccount implements BankAccountInterface{
    private String name;
    private double balance;
    private String accountNo;
    private String password;
    final double rateOfInterest=7.1;
    final String IFSCCode="HDFC324566";
    // default constructor
    public HDFCAccount() {
    }
    // parametrized constructor
    public HDFCAccount(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;
        this.accountNo=String.valueOf(UUID.randomUUID());
    }
    //setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // getter methods
    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getPassword() {
        return password;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    @Override
    public double fetchBalance(String password) {

        if(this.password.equals(password)){
            System.out.println("your current balance is "+ this.balance);
            return this.balance;
        }
        System.out.println(" incorrect password ! ");
        return -1.0;
    }

    @Override
    public String addMoney(double money) {
        this.balance+=money;

        return "money added successfully. updated balance is "+ this.balance;
    }

    @Override
    public String withdrawMoney(double money, String password) {
        if(this.password.equals(password)){
            if(this.balance<money){
                return "insufficient balance";
            }
            this.balance-=money;
            return "transaction successfully. after deduction new balance is "+this.balance;
        }
        return " incorrect password !";
    }

    @Override
    public double interest(double year) {
        return (this.balance* rateOfInterest*year)/100.0;
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword)){
            this.password=newPassword;
            return "password changed successfully";
        }
        return "you have entered wrong oldPassword";
    }

    @Override
    public String toString() {
        return "HDFCAccount{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", accountNo='" + accountNo + '\'' +
                ", password='" + password + '\'' +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSCCode='" + IFSCCode + '\'' +
                '}';
    }
}
