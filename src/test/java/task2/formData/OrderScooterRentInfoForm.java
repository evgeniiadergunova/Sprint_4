package task2.formData;

public class OrderScooterRentInfoForm {
    public OrderScooterRentInfoForm(String date, String rentDatesDropdownItem, String scooterColor, String commentForCourier) {
        this.date = date;
        this.rentDatesDropdownItem = rentDatesDropdownItem;
        this.scooterColor = scooterColor;
        this.commentForCourier = commentForCourier;
    }

    public final String date;

    public final String rentDatesDropdownItem;

    public final String scooterColor;

    public final String commentForCourier;
}
