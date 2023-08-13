public interface BankAccountInterface {
    double fetchBalance(String password);

    String addMoney(double money);

    String withdrawMoney(double money, String password);

    double interest(double year);

    String changePassword(String oldPassword, String newPassword);
}
