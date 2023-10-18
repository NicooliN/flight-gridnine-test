package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface FlightFilter {

    void getAllFlights(List<Flight> flights);


    List<Flight> removeFlightsDepartureBeforeNow(List<Flight> flights);

    List<Flight> removeFlightsArrivalBeforeDeparture(List<Flight> flights);

    List<Flight> removeFlightsHardstandMoreTwoHours(List<Flight> flights);
}
