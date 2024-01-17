package ref.ex;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account();

        account.deposit(10000);
        account.withdraw(9000);
        account.withdraw(2000);

        System.out.println(account.balance);

        /*
        잔액 부족
        1000
         */
    }
}
