package e1;

public class SilverBankAccount implements BankAccount {

    private static final int ACCOUNT_FEE = 1;
    private final BankAccount base;

    public SilverBankAccount(BankAccount base) {
        this.base = base;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + ACCOUNT_FEE);
    }
}
