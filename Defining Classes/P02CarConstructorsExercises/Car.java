package P02CarConstructorsExercises;

public class Car {
         private String brand;
         private  String model;
         private int hordePower;

   public Car (String brand){
       this.brand = brand;
       this.model= "unknown";
       this.hordePower = -1;
   }

   public Car(String brand, String model, int hordePower){
       this.brand = brand;
       this.model = model;
       this.hordePower = hordePower;
   }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHordePower() {
        return this.hordePower;
    }

    public void setHordePower(int hordePower) {
        this.hordePower = hordePower;
    }

    public String carInfo (){

        return String.format("The car is: %s %s - %d HP.",this.getBrand(),this.getModel(),this.getHordePower());

   }
}