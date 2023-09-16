package carTrip;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private final String DEFAULT_MODEL = "Honda";
    private final double DEFAULT_tankCAPACITY = 60;
    private final double DEFAULT_fuelAMOUNT = 10;
    private final double DEFAULT_fuelCONSUMPTION = 9;
    private Car car;


    @Before
    public void before(){
        this.car = new  Car(DEFAULT_MODEL,DEFAULT_tankCAPACITY,DEFAULT_fuelAMOUNT,DEFAULT_fuelCONSUMPTION);
    }
    @Test
    public void TestGetModelShouldWorkCorrectly(){

       assertEquals(DEFAULT_MODEL,this.car.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetModelShouldThrowIfModelIsNull(){

        this.car.setModel(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void TestSetModelShouldThrowIfModelIsEmptyString(){

        this.car.setModel("");
    }
    @Test
    public void TestSetModelShouldSetCorrectly(){
       String newModel = "Audi";
        this.car.setModel (newModel);

        assertEquals(newModel,this.car.getModel());

    }

    @Test
    public void TestGetTankCapacityShouldWorkCorrectly(){

        assertEquals(DEFAULT_tankCAPACITY,this.car.getTankCapacity(),0.0);

    }
    @Test
    public void TestSetTankCapacityShouldWorkCorrectly(){

        double newTankCapacity = 50;
        this.car.setTankCapacity(newTankCapacity);

        assertEquals(newTankCapacity,this.car.getTankCapacity(),0.0);

    }
    @Test
    public void TestGetFuelAmountShouldWorkCorrectly(){

        assertEquals(DEFAULT_fuelAMOUNT,this.car.getFuelAmount(),0.0);

    }
    @Test
    public void TestSetFuelAmountShouldWorkCorrectly(){

        double newFuelAmount = 20;
        this.car.setFuelAmount(newFuelAmount);

        assertEquals(newFuelAmount,this.car.getFuelAmount(),0.0);

    }
    @Test(expected = IllegalArgumentException.class)
    public void TestSetFuelAmountShouldThrowIfAmountCreateThanCapacity(){

        this.car.setFuelAmount(DEFAULT_tankCAPACITY + 1);

    }

    @Test
    public void TestGetFuelConsumptionShouldWorkCorrectly(){

        assertEquals(DEFAULT_fuelCONSUMPTION,this.car.getFuelConsumptionPerKm(),0.0);

    }
    @Test
    public void TestSetFuelConsumptionShouldWorkCorrectly(){

        double newFuelConsumption = 7;
        this.car.setFuelConsumptionPerKm(newFuelConsumption);

        assertEquals(newFuelConsumption,this.car.getFuelConsumptionPerKm(),0.0);

    }
    @Test(expected = IllegalArgumentException.class)
    public void TestSetFuelConsumptionShouldThrowWithNegativeConsumption(){

        this.car.setFuelConsumptionPerKm( -1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorShouldThrowIfModelIsEmpty(){

        new Car("" ,1.0,1.0,10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorShouldThrowIfModelIsNull(){

        new Car(null ,1.0,1.0,10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorShouldThrowIfFuelAmountGreaterThanCapacity(){

        new Car("BMV" ,1.0,2.0,10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestConstructorShouldThrowFuelConsumptionIsNegative(){

        new Car("BMV" ,1.0,2.0,-8);
    }

    @Test(expected = IllegalStateException.class)
    public void TestDriveShouldThrowIfNotEnoughFuel(){
        //Default amount is 10 and consumption is 9/100 so 2km trip
        //would require 181 of fuel;
        this.car.drive(2.0);
    }

    @Test
    public void TestDriveShouldUseFuel(){

        this.car.drive(1.0);

        assertEquals(DEFAULT_fuelAMOUNT - DEFAULT_fuelCONSUMPTION, this.car.getFuelAmount(),0.0);
    }
    @Test
    public void TestDriveShouldReturnCorrectResult(){

        String result = this.car.drive(1.0);


        assertEquals("Have a nice trip",result);
    }

    @Test(expected =  IllegalStateException.class)
        public void TestRefuelShouldThrowIfFuelIsMoreThanEnough(){

        this.car.refuel(DEFAULT_tankCAPACITY + 1);
    }
    @Test
    public void TestRefuelShouldWorkProperly(){

        double amount = 10.0;

        this.car.refuel(amount);

        assertEquals( amount + DEFAULT_fuelAMOUNT,this.car.getFuelAmount(),0.0);
    }


}
