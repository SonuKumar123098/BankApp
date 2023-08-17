import java.util.UUID;

public class SBIAccount implements BankAccountInterface{
    private String name;
    private String accountNo;
    private double balance;
    private final double minBalance=1500;
    private String password;
    private final double rateOfInterest=4.0;
    private final String IFSCCode="SBIN234";

    /**
     * default constructor
     */
    public SBIAccount() {
    }
    /**
     * parametric constructor
     * @param name
     * @param balance
     * @param password
     */
    public SBIAccount(String name, double balance, String password) {
        this.name = name;
        this.accountNo =String.valueOf(UUID.randomUUID());
        this.balance = balance;
        this.password = password;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public double fetchBalance(String password) {
        if(this.password.equals(password)){
            System.out.println("your current balance is "+ this.balance);
            return this.balance;
        }
        System.out.println("incorrect password!");
        return -1.0;
    }

    @Override
    public String addMoney(double money) {
        this.balance+=money;
        return "money added successfully to your account";
    }

    @Override
    public String withdrawMoney(double money, String password) {
        if(password.equals(this.password)){
            if(money+minBalance<=this.balance){
                this.balance-=money;
                System.out.println("your current balance is"+ this.balance);
                return "money debited successfully from your account";
            }
            return "insufficient balance!";
        }
        return "incorrect password!";
    }

    @Override
    public double interest(double year) {
        return (balance*rateOfInterest*year)/100.0;
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(oldPassword.equals(this.password)){
            this.password=newPassword;
            return "password has been changed successfully";
        }
        return "incorrect oldPassword !";
    }

    @Override
    public String toString() {
        return "SBIAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", balance=" + balance +
                ", minBalance=" + minBalance +
                ", password='" + password + '\'' +
                ", rateOfInterest=" + rateOfInterest +
                ", IFSCCode='" + IFSCCode + '\'' +
                '}';
    }
}
