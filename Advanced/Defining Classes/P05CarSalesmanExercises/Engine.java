package P05CarSalesmanExercises;

public class Engine {
 private    String model;
   private   int power;
  private   String displacement;
   private  String efficiency;

    Engine() {
        displacement = "n/a";
        efficiency = "n/a";
    }

    void setModel(String m){
     model = m; }
    void setDisplacement(int d){
     displacement = String.valueOf(d); }
    void setEfficiency(String e){
     efficiency = e; }
    void setPower(int p){
     power = p; }

    String getModel() {
     return model; }
    int getPower() {
     return power; }
    String getDisplacement() {
     return displacement; }
    String getEfficiency() {
     return efficiency; }
}
