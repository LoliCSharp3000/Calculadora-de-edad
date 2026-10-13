package maralboran;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean fin = true;
        Scanner sc = new Scanner(System.in);
        LocalDate today = LocalDate.now();
        while(fin){
            LocalDate client = pedirFechaNacimiento(sc, today);
            if (client != null) {
                Period period = calcularFecha(client, today);
                mostrarResultado(period, client, today);
                fin = false;
            }
        }
        sc.close();
    }

    public static LocalDate pedirFechaNacimiento(Scanner sc, LocalDate today){
        try {
            int year, month, day;
            System.out.println("escribe tu año de nacimiento:");
            year = sc.nextInt();
            System.out.println("escribe tu mes de nacimiento:");
            month = sc.nextInt();
            System.out.println("escribe tu dia de nacimiento");
            day = sc.nextInt();
            LocalDate client = LocalDate.of(year, month, day);
            return client.isAfter(today) ? lanzarError() : client;
        } catch(InputMismatchException e){
            System.out.println("Usted tiene que poner un numero");
            sc.nextLine();
        } catch(DateTimeException e){
            System.out.println("La fecha intru¡oducida no existe");
        } catch(IllegalArgumentException e){
            System.out.println(e);
        }
        return null;
    }

    public static Period calcularFecha(LocalDate client, LocalDate today){
        return Period.between(client, today);
    }

    public static void mostrarResultado(Period period, LocalDate client, LocalDate today){
        System.out.println("Tienes " + period.getYears() + " años, " + period.getMonths() + " meses y " + period.getDays() + " dias.");
        System.out.println("Has vivido " + ChronoUnit.DAYS.between(client, today) + " dias.");
    }

    private static LocalDate lanzarError() {
        throw new IllegalArgumentException("La fecha no puede ser futura");
    }
}