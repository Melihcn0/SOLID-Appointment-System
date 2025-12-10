package app.notification;
import app.model.Appointment;
public class EmailNotificationService implements NotificationService {

    @Override
    public void sendConfirmation(Appointment appointment) {
        System.out.println("EMAIL SENT TO: " + appointment.getCustomer().getEmail());
        System.out.println("Subject: Randevu Onayı");
        System.out.println("Body: " + appointment.getDoctorName() + " ile "
                + appointment.getDateTime() + " tarihindeki randevunuz onaylanmıştır.");
    }
}
