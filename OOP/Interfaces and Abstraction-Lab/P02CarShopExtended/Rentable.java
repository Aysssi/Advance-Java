package LabInterfacesAndAbstraction.P02CarShopExtended;

public interface Rentable extends Car{
    Integer getMinRenDay();

    Integer getMinRentDay();

    Double getPricePerDay();
}
