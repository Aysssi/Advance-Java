package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ComputerManagerTests {
    private Computer computer;

    @Before
    public void SetUp() {

        this.computer = new Computer("Dell", "Latitude", 2000);

    }


    @Test
    public void TestGetManufacturer() {

        assertEquals("Dell", this.computer.getManufacturer());

    }


    @Test(expected = IllegalArgumentException.class)
    public void TestAddComputerIfDuplicateThrowException() {

        ComputerManager manager = new ComputerManager();
        manager.addComputer(new Computer("Dell", "Latitude", 2000));
        manager.addComputer(new Computer("Dell", "Latitude", 2000));

    }

    @Test
    public void TestAddComputerIfDuplicateThrowExceptionMessage() {
        String expected = "This computer already exists.";
        String actual = null;

        try {
            ComputerManager manager = new ComputerManager();
            manager.addComputer(new Computer("Dell", "Latitude", 2000));
            manager.addComputer(new Computer("Dell", "Latitude", 2000));
        } catch (IllegalArgumentException ex) {

            actual = ex.getMessage();
        }

        assertEquals(expected, actual);
    }

    @Test
    public void TestAddComputerShouldWouldProperly() {

        ComputerManager manager = new ComputerManager();
        manager.addComputer(new Computer("Dell", "Latitude1", 2000));
        manager.addComputer(new Computer("Dell", "Latitude2", 2500));

        int expected = 2;
        int actual = manager.getCount();
        assertEquals(expected, actual);
    }

    @Test
    public void TestRemoveComputerShouldWouldProperly() {

        ComputerManager manager = new ComputerManager();
        manager.addComputer(new Computer("Dell", "Latitude1", 2000));
        manager.addComputer(new Computer("Dell", "Latitude2", 2500));

        int expected = 2;
        int actual = manager.getCount();
        assertEquals(expected, actual);

        manager.removeComputer("Dell", "Latitude2");
        assertEquals(1, manager.getCount());

    }

    @Test
    public void TestGetComputerManufactureIfNotExistShouldThrowExceptionMessage() {
        String expected = "There is no computer with this manufacturer and model.";
        String actual = null;

        try {
            ComputerManager manager = new ComputerManager();
            manager.getComputer("Dell", "Latitude1");
        } catch (IllegalArgumentException ex) {
            actual = ex.getMessage();
        }

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestGetComputerManufactureIfNotExistShouldThrowException() {

        ComputerManager manager = new ComputerManager();
        manager.getComputer("Dell", "Latitude77777");

    }

    @Test
    public void TestGetComputersByManufacturer() {
        ComputerManager manager = new ComputerManager();
        List<Computer> computers = List.of(
                new Computer("Dell2", "Latitude3", 2000),
                new Computer("Dell1", "Latitude2", 1800),
                new Computer("Dell", "Latitude", 1500));

        computers.forEach(c -> manager.addComputer(c));

        List<Computer> expected = computers.stream()
                .filter(c -> c.getManufacturer().equals("Dell"))
                .collect(Collectors.toList());

        List<Computer> actual = manager.getComputersByManufacturer("Dell");
        assertEquals(expected, actual);
        assertEquals(expected.size(), actual.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestValidateNullValueShouldTrowException (){

        ComputerManager manager = new ComputerManager();

        manager.addComputer(null);

    }


}
