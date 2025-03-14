package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class CoreBankAccountTest {

    protected final BankAccountFactory factory = new BankAccountFactory();
    protected BankAccount account;

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        int amount = 1000;
        this.account.deposit(amount);
        assertEquals(amount, this.account.getBalance());
    }

}
