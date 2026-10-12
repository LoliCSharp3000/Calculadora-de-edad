package maralboran;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate today = LocalDate.now();
        LocalDate client = pedirFecha(sc, today);
        try {
            if (client == null) {
                throw new IllegalArgumentException("La fecha esta incorrecta");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        Period period = Period.between(client, today);
        System.out.println("Tienes " + period.getYears() + " años, " + period.getMonths() + " meses y " + period.getDays() + " dias.");
        System.out.println("Has vivido " + ChronoUnit.DAYS.between(client, today) + " dias.");
        sc.close();
    }

    public static LocalDate pedirFecha(Scanner sc, LocalDate today){
        int year, month, day;
        System.out.println("escribe tu año de nacimiento:");
        year = sc.nextInt();
        System.out.println("escribe tu mes de nacimiento:");
        month = sc.nextInt();
        System.out.println("escribe tu dia de nacimiento");
        day = sc.nextInt();
        try {
            LocalDate client = LocalDate.of(year, month, day);
            return client.isAfter(today) ? lanzarError() : client;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private static LocalDate lanzarError() {
    throw new IllegalArgumentException("La fecha no puede ser futura");
}
}