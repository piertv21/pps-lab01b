package e1;

public class OverdraftDecorator extends BankAccountDecorator {

    private final int overdraftLimit;

    public OverdraftDecorator(BankAccount account, int overdraftLimit) {
        super(account);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() + overdraftLimit < amount) {
            throw new IllegalStateException();
        }
        super.account.withdraw(amount);
    }
}