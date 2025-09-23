package maralboran;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate tomorow = LocalDate.now();
        int year, month, day, edad;
        System.out.println("escribe tu año de nacimiento:");
        year = sc.nextInt();
        System.out.println("escribe tu mes de nacimiento:");
        month = sc.nextInt();
        System.out.println("escribe tu dia de nacimiento");
        day = sc.nextInt();
        LocalDate client = LocalDate.of(year, month, day);
        Period period = Period.between(client, tomorow);
        edad = period.getYears();
        System.out.println("Tienes " + edad + " años");
    }
}