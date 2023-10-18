package com.gridnine.testing;

import com.gridnine.testing.builder.FlightBuilder;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilterService;

import java.util.List;

public class Main {
    public static void main(String[] args) {



        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilterService service = new FlightFilterService();

        List<Flight> flightWithOutDBF = service.removeFlightsDepartureBeforeNow(flights);

        List<Flight> flightWithOutABD = service.removeFlightsArrivalBeforeDeparture(flights);

        List<Flight> flightWithOutHMTH = service.removeFlightsHardstandMoreTwoHours(flights);


        System.out.println("Все тестовые полеты: ");
        service.getAllFlights(flights);

        System.out.println("Полеты с исключением вылета до текущего момента времени:");
        service.getAllFlights(flightWithOutDBF);

        System.out.println("Полеты с исключением сегментов с датой прилёта раньше даты вылета:");
        service.getAllFlights(flightWithOutABD);

        System.out.println("Полеты с исключением стоянки судна более двух часов:");
        service.getAllFlights(flightWithOutHMTH);
    }




}