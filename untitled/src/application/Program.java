package application;

import model.entities.CarRental;
import model.entities.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();
        System.out.println("Retirada do carro: ");
        LocalDateTime startDate = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.println("Entrega do carro: ");
        LocalDateTime endDate = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental carRental = new CarRental(startDate, endDate, new Vehicle(carModel));

        sc.close();
    }
}
