package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends AbstractCoreBankAccountTest {

    private static final int INITIAL_DEPOSIT = 1000;
    private static final int WITHDRAW_AMOUNT = 200;
    private static final int ACCOUNT_FEE = 1;

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount(
                new CoreBankAccount()
        );
    }

    @Test
    public void testCanWithdraw() {
        int expectedAmount = INITIAL_DEPOSIT - WITHDRAW_AMOUNT - ACCOUNT_FEE;
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(WITHDRAW_AMOUNT);
        assertEquals(expectedAmount, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int illegalAmount = INITIAL_DEPOSIT + 1;
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(illegalAmount));
    }

}