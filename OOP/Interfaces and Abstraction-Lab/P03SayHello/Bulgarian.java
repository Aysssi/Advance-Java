package LabInterfacesAndAbstraction.P03SayHello;

public class Bulgarian implements Person{
    private String name;


    public Bulgarian(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String  sayHello() {
       return  "Здравей";
    }
}
