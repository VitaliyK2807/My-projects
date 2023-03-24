package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

import static java.time.format.TextStyle.SHORT;
import static java.util.Calendar.*;

public class Birthdays {

    public static void main(String[] args) {

        int day= 31;
        int month =12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        String text = "";
        DateTimeFormatter formater = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        int i = 0;

        if (birthday.isBefore(today)) {
            while (today.isAfter(birthday) || today.isEqual(birthday)) {
                text = text + (i + " - ") + formater.format(birthday) +
                        (" - " + birthday.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US)) +
                        System.lineSeparator();
                i++;
                birthday = LocalDate.of(++year, month, day);
            }
        } else if (birthday.isAfter(today)) {

        }  else {
            text = text + (i + " - ") + formater.format(birthday) +
                    (" - " + birthday.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US)) +
                    System.lineSeparator();
        }
        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        
        return text;
    }
}
