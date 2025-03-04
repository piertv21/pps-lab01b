package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends AbstractCoreBankAccountTest {

    private static final int INITIAL_DEPOSIT = 1000;
    private static final int OVERDRAFT_LIMIT = 500;

    @BeforeEach
    void init(){
        this.account = new GoldBankAccount(
                new CoreBankAccount()
        );
    }

    @Test
    public void testCanWithdraw() {
        int exampleWithdraw = 200;
        int expectedAmount = INITIAL_DEPOSIT - exampleWithdraw;
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(exampleWithdraw);
        assertEquals(expectedAmount, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawMoreThanAvailable(){
        int legalAmount = INITIAL_DEPOSIT + OVERDRAFT_LIMIT;
        this.account.deposit(INITIAL_DEPOSIT);
        assertDoesNotThrow(() -> this.account.withdraw(legalAmount));
    }

}