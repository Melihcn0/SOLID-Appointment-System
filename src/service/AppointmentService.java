package app.service;
import app.model.*;
import app.repository.*;
import app.notification.*;
import java.time.LocalDateTime;
import java.util.UUID;
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final NotificationService notificationService;

    public AppointmentService(AppointmentRepository appointmentRepository, NotificationService notificationService) {
        this.appointmentRepository = appointmentRepository;
        this.notificationService = notificationService;
    }

    public Appointment bookAppointment(String doctorName, Customer customer, LocalDateTime dateTime) {

        String id = UUID.randomUUID().toString();

        Appointment appointment = new Appointment(id, doctorName, customer, dateTime);

        appointmentRepository.save(appointment);

        notificationService.sendConfirmation(appointment);

        return appointment;
    }
}
