package bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BankTests {

    private Bank bank;


    @Before
    public void SetUp(){
        this.bank = new Bank("Dani", 7);
    }

    @Test
    public void TestConstructor(){
        assertEquals("Dani",this.bank.getName());
        assertEquals(7,this.bank.getCapacity());
        assertEquals(0,this.bank.getCount());
    }

    @Test
    public void TestGetName (){

        assertEquals("Dani",this.bank.getName());
    }

    @Test(expected = NullPointerException.class)
    public void TestSetNameIfNullThrowException (){

        this.bank = new Bank(null, 5) ;
    }

    @Test(expected = NullPointerException.class)
    public void TestSetNameIfIsEmptyThrowException () {

        this.bank = new Bank("", 5);
    }

    @Test
    public void TestSetNameWorkProperly (){

        this.bank = new Bank("Ivan", 5);
        assertEquals("Ivan", this.bank.getName());
    }
    @Test
    public void TestGetCapacity (){

        assertEquals(7,this.bank.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetCapacityIfLessZeroThrowException (){

       this.bank = new Bank("Dimo", -1) ;
    }

    @Test
    public void TestSetCapacityWorkCorrectly () {

        bank = new Bank("Tedi", 5);
        assertEquals(5,this.bank.getCapacity());
    }

    @Test
    public void TestGetCount0 (){

        assertEquals(0,this.bank.getCount());
    }
    @Test
    public void TestGetCount (){

        Client client = new Client("Bank");
        this.bank.addClient(client);
        assertEquals(1,bank.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void TestAddClientThrowException (){

        Client client1 = new Client("Bank1");
        Client client2 = new Client("Bank2");
        Client client3 = new Client("Bank3");
        Client client4 = new Client("Bank4");
        Client client5 = new Client("Bank5");
        Client client6 = new Client("Bank6");
        Client client7 = new Client("Bank7");
        Client client8 = new Client("Bank8");

        this.bank.addClient(client1);
        this.bank.addClient(client2);
        this.bank.addClient(client3);
        this.bank.addClient(client4);
        this.bank.addClient(client5);
        this.bank.addClient(client6);
        this.bank.addClient(client7);
        this.bank.addClient(client8);


    }
    @Test
    public void TestAddClientWorkProperly (){

        Client client1 = new Client("Bank1");
        Client client2 = new Client("Bank2");
        Client client3 = new Client("Bank3");


        this.bank.addClient(client1);
        this.bank.addClient(client2);
        this.bank.addClient(client3);

         assertEquals(3, this.bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
       public void TestRemovedClientIfNotExistThrowException(){

      this.bank.removeClient("Bay");
    }

    @Test
    public void TestRemovedClientIfClientNotExistThrowMessage(){
        Client client = new Client("Niki");
        this.bank.addClient(client);

        String expected = String.format("Client named %s does not exist!","Rey");
        String actual = null;

        try {
            this. bank.removeClient("Rey");
        }catch (IllegalArgumentException ex){
         actual = ex.getMessage();
        }


        assertEquals(expected,actual);
    }

    @Test
    public void TestRemovedClientWorkProperly(){
       Client client = new Client("Niki");
       this.bank.addClient(client);

       assertEquals(1,this.bank.getCount());
       this. bank.removeClient("Niki");

       assertEquals(0,this.bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestLoanWithdrawalIfNotExistThrowException(){

        this.bank.loanWithdrawal("Bay bay");
    }

    @Test
    public void TestLoanWithdrawalIfClientNotExistThrowMessage(){

        String expected = String.format("Client named %s does not exist!","Rey rey");
        String actual = null;

        try {
            this. bank.loanWithdrawal("Rey rey");
        }catch (IllegalArgumentException ex){
            actual = ex.getMessage();
        }


        assertEquals(expected,actual);
    }

    @Test
    public void TestLoaWorkProperly(){
        Client client = new Client("Emi");
        this.bank.addClient(client);

        this. bank.loanWithdrawal("Emi");

        Assert.assertFalse(client.isApprovedForLoan());
    }
    @Test
    public void TestStatistics(){
        Client client = new Client("Ay");
        Client client2 = new Client("Bay");
        Client client3 = new Client("Ay bay");
        this.bank.addClient(client);

        this.bank.addClient(client2);
        this.bank.addClient(client3);

        String expected = String.format("The client %s is at the %s bank!", String.join(", ", List.of(client.getName(), client2.getName(), client3.getName())), "Dani");
        String actual = this.bank.statistics();
        
        assertEquals(expected, actual);
    }

}
