package e1;

public class BronzeBankAccount implements BankAccount {

    private static final int CONDITIONAL_ACCOUNT_FEE = 1;
    private static final int CONDITIONAL_FEE_THRESHOLD = 100;
    private final BankAccount base;

    public BronzeBankAccount(BankAccount base) {
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
        int fee = 0;
        if(amount >= CONDITIONAL_FEE_THRESHOLD){
            fee = CONDITIONAL_ACCOUNT_FEE;
        }
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + fee);
    }
}
