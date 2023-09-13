import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChainblockImplTest {

    private static ChainblockImpl chainblock;

    @Before
    public void init() {
        chainblock = new ChainblockImpl();
    }

    @Test
    public void TestAddShouldWorkProperly() {
        //Transaction
        // Collection.add
        //AssertEqual(coll. size)

        Transaction transaction = (Transaction) new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);

        chainblock.add(transaction);

        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void TestAddShouldFindDuplicate() {
        Transaction transaction = (Transaction) new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);

        chainblock.add(transaction);
        chainblock.add(transaction);
        assertEquals(1, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestChangeTransactionStatusShouldThrowException() {

        chainblock.changeTransactionStatus(1, TransactionStatus.ABORTED);


    }

    @Test
    public void TestChangeTransactionStatusShouldWorkProperly() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);


        chainblock.add(transaction);

        chainblock.changeTransactionStatus(1, TransactionStatus.ABORTED);
        Transaction actual = chainblock.getById(1);

        assertEquals(TransactionStatus.ABORTED, actual.getStatus());

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestGetByIdThrowException() {

        chainblock.getById(1);

    }

    @Test
    public void TestGetByIdStatusShouldWorkProperly() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);

        chainblock.add(transaction);

        Transaction actual = chainblock.getById(1);

        assertEquals(transaction, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestRemoveTransactionByIdThrowException() {

        chainblock.removeTransactionById(1);

    }

    @Test
    public void TestRemoveTransactionByIdShouldWorkProperly() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);

        chainblock.add(transaction);

        chainblock.removeTransactionById(1);

        assertEquals(0, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestGetByTransactionStatusThrowException() {

        chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

    }

    @Test
    public void TestGetByTransactionStatusShouldWorkProperly() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);

        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 200);

        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Alex", "Tedi", 200);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction2, transaction);
        List<Transaction> actual = (List<Transaction>) chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertArrayEquals(expected.toArray(), actual.toArray());
        // assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestGetAllSenderWithTransactionStatusThrowException() {

        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);

    }

    @Test
    public void TestGetAllSenderTransactionStatusShouldWorkProperly() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);

        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Maria", "Gosho", 200);

        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Atanas", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<String> expected = List.of(transaction2.getFrom(), transaction.getFrom());
        List<String> actual = (List<String>) chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertArrayEquals(expected.toArray(), actual.toArray());

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestGetAllReceiverWithTransactionStatusThrowException() {

        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);

    }

    @Test
    public void TestGetAllReceiverTransactionStatusShouldWorkProperly() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);

        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Maria", "Gosho", 200);

        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Atanas", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<String> expected = List.of(transaction2.getTo(), transaction.getTo());
        List<String> actual = (List<String>) chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertArrayEquals(expected.toArray(), actual.toArray());

    }

    @Test
    public void TestGetAllOrderByAmountDescendingThenByIdShouldWorkProperly() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);

        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Maria", "Gosho", 100);

        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Atanas", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction3, transaction, transaction2);
        List<Transaction> actual = (List<Transaction>) chainblock.getAllOrderedByAmountDescendingThenById();

        assertArrayEquals(expected.toArray(), actual.toArray());

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestGetBySenderOrderedByAmountDescendingThrowException() {

        chainblock.getBySenderOrderedByAmountDescending("Pesho");

    }

    @Test
    public void TestGetBySenderOrderedByAmountDescendingShouldWorkProperly() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);

        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Alex", "Gosho", 200);

        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Atanas", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction2, transaction);
        List<Transaction> actual = (List<Transaction>) chainblock.getBySenderOrderedByAmountDescending("Alex");

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestGetByReceiverOrderedByAmountThenByIdThrowException() {

        chainblock.getByReceiverOrderedByAmountThenById("Dani");

    }

    @Test
     public void TestGetByReceiverOrderedByAmountThenByIdShouldWorkProperly() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 200);

        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Maria", "Tedi", 200);

        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Tedi", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction3,transaction, transaction2);
        List<Transaction> actual = (List<Transaction>) chainblock.getByReceiverOrderedByAmountThenById("Tedi");

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void TestGetByTransactionStatusAndMaximumAmountShouldReturnEmptyList() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 200);

        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Maria", "Tedi", 200);

        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Tedi", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);


        List<Transaction> actual = (List<Transaction>) chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL,50);

        assertEquals(new ArrayList<>(), actual);
    }

    @Test
    public void TestGetByTransactionStatusAndMaximumAmountShouldWorkProperly() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);

        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Maria", "Gosho", 200);

        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Tedi", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction2,transaction);
        List<Transaction> actual = (List<Transaction>) chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL,300);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestGetBySenderAndMinimumAmountDescendingThrowException() {

        chainblock.getBySenderAndMinimumAmountDescending("Niki",70);

    }
    @Test
    public void TestGetBySenderAndMinimumAmountDescendingShouldWorkProperly() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);

        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 200);

        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Misho", 60);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction2,transaction);
        List<Transaction> actual = (List<Transaction>) chainblock.getBySenderAndMinimumAmountDescending("Alex",100);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestGetByReceiverAndAmountRangeThrowException() {

        chainblock.getByReceiverAndAmountRange("Moni",70, 180);

    }
    @Test
    public void TestGetByReceiverAndAmountRangeShouldWorkProperly() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);

        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 200);

        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Tedi", 100);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction2,transaction,transaction3);
        List<Transaction> actual = (List<Transaction>) chainblock.getByReceiverAndAmountRange("Tedi",100,205);

        assertEquals(expected, actual);
    }

    @Test
    public void TestGetAllInAmountRangeShouldEmptyList() {

   List<Transaction> actual = (List<Transaction>)   chainblock.getAllInAmountRange(10, 180);

   assertEquals(new ArrayList<>(),actual);
    }
    @Test
    public void TestGetAllInAmountRangeShouldWorkProperly() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 100);

        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Alex", "Tedi", 200);

        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Tedi", 100);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction,transaction2,transaction3);
        List<Transaction> actual = (List<Transaction>) chainblock.getAllInAmountRange(100,205);

        assertEquals(expected, actual);
    }
}
