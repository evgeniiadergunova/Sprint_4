package task2.formData;

public class OrderScooterWhoForm {
    public OrderScooterWhoForm(String name, String surname, String address, int metroStationIndex, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStationIndex = metroStationIndex;
        this.phoneNumber = phoneNumber;
    }

    public final String name;
    public final String surname;
    public final String address;
    public final String phoneNumber;
    public final int metroStationIndex;
}
