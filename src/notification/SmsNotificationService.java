public class SmsNotificationService implements NotificationService {

    @Override
    public void sendConfirmation(Appointment appointment) {
        System.out.println("SMS SENT TO: " + appointment.getCustomer().getName());
        System.out.println("Message: " + appointment.getDoctorName()
                + " ile " + appointment.getDateTime() + " randevunuz onaylanmıştır.");
    }
}
