import java.time.LocalDateTime;
package app.model;
public class Appointment {
    private final String id;
    private final String doctorName;
    private final Customer customer;
    private final LocalDateTime dateTime;

    public Appointment(String id, String doctorName, Customer customer, LocalDateTime dateTime) {
        this.id = id;
        this.doctorName = doctorName;
        this.customer = customer;
        this.dateTime = dateTime;
    }

    public String getId() { return id; }

    public String getDoctorName() { return doctorName; }

    public Customer getCustomer() { return customer; }

    public LocalDateTime getDateTime() { return dateTime; }
}
