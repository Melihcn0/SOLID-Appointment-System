package app.ui;
import app.model.*;
import app.service.*;
import app.repository.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
public class ConsoleUI {

    private final AppointmentService appointmentService;
    private final AppointmentRepository appointmentRepository;

    public ConsoleUI(AppointmentService appointmentService,
                     AppointmentRepository appointmentRepository) {
        this.appointmentService = appointmentService;
        this.appointmentRepository = appointmentRepository;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== RANDEVU SISTEMI =====");
            System.out.println("1 - Randevu Al");
            System.out.println("2 - Randevularımı Görüntüle");
            System.out.println("3 - Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine(); 

            switch (secim) {
                case 1:
                    randevuAl(scanner);
                    break;
                case 2:
                    randevulariListele(scanner);
                    break;
                case 3:
                    System.out.println("Program sonlandırılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        }
    }

    private void randevuAl(Scanner scanner) {
        System.out.print("Müşteri ID: ");
        String customerId = scanner.nextLine();

        System.out.print("Ad Soyad: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(customerId, name, email);

        System.out.print("Doktor adı: ");
        String doctorName = scanner.nextLine();

        System.out.print("Randevu tarihi (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Saat (HH:mm): ");
        String time = scanner.nextLine();

        LocalDateTime dateTime = LocalDateTime.parse(date + "T" + time);

        Appointment appointment =
                appointmentService.bookAppointment(doctorName, customer, dateTime);

        System.out.println("Randevu oluşturuldu! ID: " + appointment.getId());
    }

    private void randevulariListele(Scanner scanner) {
        System.out.print("Müşteri ID: ");
        String customerId = scanner.nextLine();

        List<Appointment> liste = appointmentRepository.findByCustomerId(customerId);

        if (liste.isEmpty()) {
            System.out.println("Bu müşterinin hiç randevusu yok.");
            return;
        }

        System.out.println("Randevular:");
        for (Appointment a : liste) {
            System.out.println(a.getDoctorName() + " - " + a.getDateTime());
        }
    }
}
