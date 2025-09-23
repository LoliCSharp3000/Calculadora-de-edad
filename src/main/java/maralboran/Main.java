package maralboran;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate today = LocalDate.now();
        int year, month, day, edad;
        System.out.println("escribe tu año de nacimiento:");
        year = sc.nextInt();
        System.out.println("escribe tu mes de nacimiento:");
        month = sc.nextInt();
        System.out.println("escribe tu dia de nacimiento");
        day = sc.nextInt();
        try {
            LocalDate client = LocalDate.of(year, month, day);
            if(client.isAfter(today)){
                System.out.println("la fecha no puede ser futura");
            }else{
                Period period = Period.between(client, today);
                edad = period.getYears();
                System.out.println("Tienes " + edad + " años");
            }
        } catch (Exception e) {
            
            
            System.out.println("Escribiste la edad mal");
        }
        sc.close();
    }
}