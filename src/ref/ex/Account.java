package ref.ex;

public class Account {
    int balance;    // 잔액

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if(balance < amount)
            System.out.println("잔액 부족");
        else
           balance -= amount;
    }
}
