package LabWorkingWithAbstraction.P04HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    Season season;
    Discount type;

    public static double calculateHolidayPrice(double pricePerDay, int days, Season season, Discount discountType) {
        double totalPrice = pricePerDay * days;

        totalPrice = totalPrice * season.getMultiplayer();

        totalPrice = totalPrice - totalPrice * (discountType.getPercent() / 100);

        return totalPrice;
    }
}