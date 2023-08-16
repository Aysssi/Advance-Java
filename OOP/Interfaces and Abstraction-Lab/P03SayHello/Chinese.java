package LabInterfacesAndAbstraction.P03SayHello;

public class Chinese implements Person {
    private String name;


    public Chinese(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String  sayHello() {
      return  "Djydjybydjy";
    }
}
