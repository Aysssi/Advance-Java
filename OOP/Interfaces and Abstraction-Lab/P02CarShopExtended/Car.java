package LabInterfacesAndAbstraction.P02CarShopExtended;

public interface Car {
    int TIERS = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();


}
