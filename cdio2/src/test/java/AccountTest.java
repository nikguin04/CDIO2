import com.g16.game.Account;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    
    @Test
    public void addToAccountBalance() {
        Account account = new Account(1000);
        account.ModifyMoney(400);
        Assert.assertEquals(1000 + 400, account.GetMoney());
    }

    @Test
    public void subtractfromAccountBalance() {
        Account account = new Account(1000);
        account.ModifyMoney(-400);
        Assert.assertEquals(1000 - 400, account.GetMoney());
    }

    @Test
    public void testNegative() {
        Account account = new Account(1000);
        account.ModifyMoney(-4000);
        Assert.assertEquals(0, account.GetMoney());
    }

}