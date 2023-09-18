package bankAccount;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {
   private BankAccount bankAccount;

   @Before
    public void setUp(){
       this.bankAccount = new BankAccount("Alex",new BigDecimal(200));

   }

   @Test
    public void TestGetNameWorkProperly(){
       Assert.assertEquals("Alex", bankAccount.getName());
   }
    @Test(expected = IllegalArgumentException.class)
    public void TestSetNameIfInvalidLengthLessSymbols(){

        this.bankAccount = new BankAccount("Ai", new BigDecimal(10));

    }
    @Test(expected = IllegalArgumentException.class)
    public void TestSetNameIfInvalidLengthMoreSymbols(){

        this.bankAccount = new BankAccount("AbsdfAbsdfAbsdfAbsdfAbsdfAbsdfAbsdf", new BigDecimal(80));

    }
    @Test
    public void TestSetNameWorkProperly(){

        this.bankAccount = new BankAccount("Dani", new BigDecimal(150));

        Assert.assertEquals("Dani",bankAccount.getName());

    }
    @Test
    public void TestGetBalanceWorkProperly(){
        Assert.assertEquals("Alex", bankAccount.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetBalanceIfNegativeNumber(){

        this.bankAccount = new BankAccount("Ani", new BigDecimal(-80));

    }
    @Test
    public void TestSetBalanceWorkProperly(){

        this.bankAccount = new BankAccount("Tedi", new BigDecimal(200));

        Assert.assertEquals(new BigDecimal(200), this.bankAccount.getBalance());

    }
    @Test(expected = UnsupportedOperationException.class)
    public void TestDepositIfNegativeNumber(){

        this.bankAccount.deposit(new BigDecimal(-100));

    }
    @Test
    public void TestDepositWorkProperly(){

     this.bankAccount.deposit(new BigDecimal(100));


        Assert.assertEquals(new BigDecimal(300), this.bankAccount.getBalance());

    }

    @Test(expected = UnsupportedOperationException.class)
    public void TestWithdrawShouldThrowIfNotEnoughMoney(){

        this.bankAccount.withdraw(new BigDecimal(10000));
    }

    @Test
    public void TestWithdrawShouldReturnWorkCorrectly(){

        this.bankAccount.withdraw(new BigDecimal(120));
        Assert.assertEquals(new BigDecimal(80),this.bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void TestWithdrawShouldThrowIfAmountNegativeMoney(){

        this.bankAccount.withdraw(new BigDecimal(  - 50));
    }


    @Test
    public void TestWithdrawShouldSetWorkCorrectly(){

        this.bankAccount.withdraw(new BigDecimal(100));
        Assert.assertEquals(new BigDecimal(100),this.bankAccount.getBalance());
    }
}