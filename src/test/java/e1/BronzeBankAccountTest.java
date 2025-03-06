package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends CoreBankAccountTest {

    private static final int INITIAL_DEPOSIT = 1000;
    private static final int CONDITIONAL_ACCOUNT_FEE = 1;

    @BeforeEach
    void init(){
        super.account = super.factory.createBronzeBankAccount();
    }

    @Test
    public void testWithdrawWithFee() {
        int withdrawAmount = 100;
        int expectedAmount = INITIAL_DEPOSIT - withdrawAmount - CONDITIONAL_ACCOUNT_FEE;
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(withdrawAmount);
        assertEquals(expectedAmount, this.account.getBalance());
    }

    @Test
    public void testWithdrawWithoutFee() {
        int withdrawAmount = 99;
        int expectedAmount = INITIAL_DEPOSIT - withdrawAmount;
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(withdrawAmount);
        assertEquals(expectedAmount, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int illegalAmount = INITIAL_DEPOSIT + 1;
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(illegalAmount));
    }

}
