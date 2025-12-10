package app.notification;
import app.model.Appointment;
public interface NotificationService {
    void sendConfirmation(Appointment appointment);
}
