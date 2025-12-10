import app.repository.*;
import app.service.*;
import app.notification.*;
import app.ui.*;
public class Main {
    public static void main(String[] args) {

        AppointmentRepository repository = new InMemoryAppointmentRepository();
        NotificationService notificationService = new EmailNotificationService();

        AppointmentService appointmentService =
                new AppointmentService(repository, notificationService);

        ConsoleUI consoleUI = new ConsoleUI(appointmentService, repository);

        consoleUI.start();
    }
}
