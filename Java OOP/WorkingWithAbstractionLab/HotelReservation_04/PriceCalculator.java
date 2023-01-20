package HotelReservation_04;

public class PriceCalculator {

    public static double calculator(double pricePerDay, int numberOfDays, DiscountType discountType, Season season) {

        double totalPrice = pricePerDay * numberOfDays * season.getMultiplyCoefficient();
        double calculatedPrice = totalPrice - (totalPrice * discountType.getDiscount() / 100);
        return calculatedPrice;
    }
}
