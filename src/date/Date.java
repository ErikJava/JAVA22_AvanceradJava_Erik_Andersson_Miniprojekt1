package date;

import clock.Clock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Date extends Clock {

    public void getDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateTime = date.format(dtf);
        System.out.println(formattedDateTime);
    }

    public void changeDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Set date (yyyy-MM-dd): ");
        String newDate = scanner.nextLine();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(newDate, dtf);
        System.out.println("New Date: " + dtf.format(date));
    }
}
