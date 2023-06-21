package P05CarSalesmanExercises;

import static java.lang.System.out;

public class Car {
    String model;
    Engine engine;
    String weight;
    String color;

    Car() {
        weight = "n/a";
        color =  "n/a";
    }

    void setModel(String m){
        model = m; }
    void setEngine(Engine e){
        engine = e; }
    void setWeight(int w){
        weight = String.valueOf(w); }
    void setColor(String c){
        color = c; }

    String getModel() {
        return model; }
    Engine getEngine() {
        return engine; }
    String getWeight() {
        return weight; }
    String getColor() {
        return color; }

    @Override
    public String toString() {
        return String.valueOf(out.printf(
                "%s:%n" +
                        "\t%s:%n" +
                        "\t\tPower: %d%n" +
                        "\t\tDisplacement: %s%n" +
                        "\t\tEfficiency: %s%n" +
                        "\tWeight: %s%n" +
                        "\tColor: %s%n"
                , this.getModel()
                , this.getEngine().getModel()
                , this.getEngine().getPower()
                , this.getEngine().getDisplacement()
                , this.getEngine().getEfficiency()
                , this.getWeight()
                , this.getColor()
        ));
    }
}
