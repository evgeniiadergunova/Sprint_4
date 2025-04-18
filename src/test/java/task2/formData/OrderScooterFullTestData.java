package task2.formData;

public class OrderScooterFullTestData {

    //First form
    private final OrderScooterWhoForm whoFormData;

    //Second form
    private final OrderScooterRentInfoForm rentInfoFormData;

    public OrderScooterFullTestData(OrderScooterWhoForm whoFormData, OrderScooterRentInfoForm rentInfoFormData) {
        this.whoFormData = whoFormData;
        this.rentInfoFormData = rentInfoFormData;
    }


    public OrderScooterWhoForm getWhoFormData() {
        return whoFormData;
    }


    public OrderScooterRentInfoForm getRentInfoFormData() {
        return rentInfoFormData;
    }
}
