package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.Duration;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private BrazilianTaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, BrazilianTaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        double minutes = Duration.between(carRental.getStartDate(), carRental.getEndDate()).toMinutes();
        double hours = minutes / 60;
        double basicPayment = (hours <= 12) ? pricePerHour * Math.ceil(hours) : pricePerDay * Math.ceil(hours / 24);
        double tax = taxService.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
