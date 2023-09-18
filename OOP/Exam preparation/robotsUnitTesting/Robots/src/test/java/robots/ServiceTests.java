package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTests {

    private Service service;

    @Before
    public void SetUp(){
        service = new Service("Valid", 8);

    }

    @Test
    public void TestConstructor(){

        Assert.assertEquals("Valid",this.service.getName());
        Assert.assertEquals(8,this.service.getCapacity());
        Assert.assertEquals(0,this.service.getCount());
    }

    @Test
    public void TestGetName (){
        Assert.assertEquals("Valid", this.service.getName());
    }

    @Test(expected = NullPointerException.class)
    public void TestSetNameIfIsEmptyThrowException (){

        service = new Service("", 5);

    }

    @Test(expected = NullPointerException.class)
    public void TestSetNameIfNullThrowException (){

        service = new Service(null, 5);

    }
    @Test
    public void TestSetNameThrowExceptionMessage (){

        String exception = "Invalid name!";
        String actual =  null;

        try {
            service = new Service(null, 5);
        }catch (NullPointerException ex){
            actual = ex.getMessage();
        }

       Assert.assertEquals(exception,actual);
    }

    @Test
    public void TestSetNameWorkCorrectly (){

        service = new Service("ValidSet", 5);

        Assert.assertEquals("ValidSet", this.service.getName());
    }

    @Test
    public void TestGetCapacity (){
        Assert.assertEquals(8, this.service.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetCapacityIfNegativeShouldThrowException (){

        service = new Service("Ayy",  -5 );
    }
    @Test
    public void TestSetCapacityIfNegativeShouldThrowExceptionMessage (){

        String exception = "Invalid capacity!";
        String actual = null;

        try {
            service = new Service("Ayy",  -5 );
        }catch (IllegalArgumentException ex){
          actual = ex.getMessage();
        }

        Assert.assertEquals(exception,actual);
    }

    @Test
    public void TestCapacityWorkCorrectly (){

        service = new Service("Valid", 1);

        Assert.assertEquals(1, this.service.getCapacity());
    }

    @Test
    public void TestGetCount(){
        Robot robot1 = new Robot("Bay");
        Robot robot2 = new Robot("Bay bay");

        this.service.add(robot1);
        this.service.add(robot2);

        int expected = 2;
        int actual = this.service.getCount();

        Assert.assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddShouldThrowExceptionWhenCapacityEqualsToSize(){

        Robot robot1 = new Robot("Valid1");
        Robot robot2 = new Robot("Valid2");
        Robot robot3 = new Robot("Valid3");
        Robot robot4 = new Robot("Valid4");
        Robot robot5 = new Robot("Valid5");
        Robot robot6 = new Robot("Valid6");
        Robot robot7 = new Robot("Valid7");
        Robot robot8 = new Robot("Valid8");
        Robot robot9 = new Robot("Valid9");

        this.service.add(robot1);
        this.service.add(robot2);
        this.service.add(robot3);
        this.service.add(robot4);
        this.service.add(robot5);
        this.service.add(robot6);
        this.service.add(robot7);
        this.service.add(robot8);
        this.service.add(robot9);
    }
    @Test
    public void TestAddShouldThrowExceptionMessageWhenCapacityEqualsToSize(){

        Robot robot1 = new Robot("Valid1");
        Robot robot2 = new Robot("Valid2");
        Robot robot3 = new Robot("Valid3");
        Robot robot4 = new Robot("Valid4");
        Robot robot5 = new Robot("Valid5");
        Robot robot6 = new Robot("Valid6");
        Robot robot7 = new Robot("Valid7");
        Robot robot8 = new Robot("Valid8");
        Robot robot9 = new Robot("Valid9");

        String expected = "Full service!";
        String actual = null;

        try {
            this.service.add(robot1);
            this.service.add(robot2);
            this.service.add(robot3);
            this.service.add(robot4);
            this.service.add(robot5);
            this.service.add(robot6);
            this.service.add(robot7);
            this.service.add(robot8);
            this.service.add(robot9);
        }catch (IllegalArgumentException ex){
           actual = ex.getMessage();
        }

       Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestAddRobotoSuccessfully(){

        Robot robot1 = new Robot("Valid1");
        Robot robot2 = new Robot("Valid2");

        this.service.add(robot1);
        this.service.add(robot2);

        Assert.assertEquals(2,this.service.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestRemoveIfRobotNotExistShouldThrowException(){

        this.service.remove("Emi");

    }
    @Test
    public void TestRemoveIfRobotNotExistShouldThrowExceptionMessage(){

        String excepted = String.format("Robot with name %s doesn't exist!", "Joy");
        String actual = null;

        try {
            this.service.remove("Joy");
        }catch (IllegalArgumentException ex){
           actual = ex.getMessage();
        }

        Assert.assertEquals(excepted,actual);
    }
    @Test
    public void TestRemoveRobotoSuccessfully(){

        Robot robot1 = new Robot("Valid1");
        Robot robot2 = new Robot("Valid2");

        this.service.add(robot1);
        this.service.add(robot2);

        Assert.assertEquals(2,this.service.getCount());

        this.service.remove("Valid2");
        Assert.assertEquals(1,this.service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void  TestForSaleShouldThrowWhenIsNul(){

        this.service.forSale("Abs");
    }

    @Test
    public void  TestForSaleShouldWorkProperly(){
        Robot robot = new Robot("NewRobot");
        this.service.add(robot);

      Robot returnedRobot = this.service.forSale("NewRobot");
      Assert.assertFalse(returnedRobot.isReadyForSale());
    }

    @Test
    public void  TestReport(){
        Robot robot1 = new Robot("Robotcho1");
        Robot robot2 = new Robot("Robotcho2");
        this.service.add(robot1);
        this.service.add(robot2);

        Assert.assertEquals("The robot Robotcho1, Robotcho2 is in the service Valid!",service.report());
    }
}

