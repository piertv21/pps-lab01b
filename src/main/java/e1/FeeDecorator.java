package e1;

import java.util.function.Function;

public class FeeDecorator extends BankAccountDecorator {

    private final Function<Integer, Integer> feeLogic;

    public FeeDecorator(BankAccount account, Function<Integer, Integer> feeLogic) {
        super(account);
        this.feeLogic = feeLogic;
    }

    @Override
    public void withdraw(int amount) {
        super.account.withdraw(amount + feeLogic.apply(amount));
    }
}