package app.repository;
import app.model.Appointment;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class InMemoryAppointmentRepository implements AppointmentRepository {

    private final List<Appointment> appointments = new ArrayList<>();

    @Override
    public void save(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public List<Appointment> findByCustomerId(String customerId) {
        return appointments.stream()
                .filter(a -> a.getCustomer().getId().equals(customerId))
                .collect(Collectors.toList());
    }
}
