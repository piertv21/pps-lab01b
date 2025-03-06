package e1;

public class BankAccountFactory {

    private static final int DEFAULT_OVERDRAFT_LIMIT = 0;
    private static final int FEE = 1;
    private static final int CUSTOM_OVERDRAFT_LIMIT = 500;
    private static final int FREE_FEE_THRESHOLD = 100;

    public BankAccount createSilverBankAccount() {
        return new BankAccountDecorator(
                new OverdraftDecorator(
                        new FeeDecorator(
                                new CoreBankAccount(),
                                amount -> FEE
                        ),
                        DEFAULT_OVERDRAFT_LIMIT
                )
        );
    }

    public BankAccount createGoldBankAccount() {
        return new BankAccountDecorator(
                new OverdraftDecorator(
                        new CoreBankAccount(),
                        CUSTOM_OVERDRAFT_LIMIT
                )
        );
    }

    public BankAccount createBronzeBankAccount() {
        return new BankAccountDecorator(
                new OverdraftDecorator(
                        new FeeDecorator(
                                new CoreBankAccount(),
                                amount -> amount >= FREE_FEE_THRESHOLD ? FEE : 0
                        ),
                        DEFAULT_OVERDRAFT_LIMIT
                )
        );
    }
}