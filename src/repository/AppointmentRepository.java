package app.repository;
import app.model.Appointment;
import java.util.List;
public interface AppointmentRepository {
    void save(Appointment appointment);

    List<Appointment> findByCustomerId(String customerId);
}
