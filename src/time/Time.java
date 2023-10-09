package time;

import clock.Clock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Time extends Clock {

    public void getTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.now();
        System.out.println(dtf.format(time));
    }

    public void changeTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Set time (HH:mm:ss): ");
        String newTime = scanner.nextLine();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse(newTime, dtf);
        System.out.println("New Time: " + dtf.format(time));
    }
}