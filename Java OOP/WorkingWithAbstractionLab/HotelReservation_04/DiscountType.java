package HotelReservation_04;

public enum DiscountType {
    VIP ("VIP", 20),
    SECONDVISIT ("SecondVisit", 10),
    NONE ("None", 0);

    private String type;
    private int discount;


    DiscountType(String type, int discount) {
        this.discount = discount;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
