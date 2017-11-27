package car_shop_extended;

public interface Rentable extends Car {

    Integer minRentDay = 0;
    Double pricePerDay = 0.0;

    Integer getMinRentDay();
    Double getPricePerDay();


}
