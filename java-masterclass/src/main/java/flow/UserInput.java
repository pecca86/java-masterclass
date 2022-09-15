package flow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Scanner;

public class UserInput {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter birth date (YYYY-MM-DD)");
        String birthdate = null;
        try {
            birthdate = in.nextLine();
            calculateAge(birthdate);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid input!");
        }

        in.close();

    }

    public static void calculateAge(String birthDate) throws DateTimeParseException {
        LocalDate bd = LocalDate.parse(birthDate);
        int age = Period.between(bd, LocalDate.now()).getYears();
        System.out.println("You are " + age + " years old...");
    }
}
