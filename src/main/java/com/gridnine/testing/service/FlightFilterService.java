package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilterService implements FlightFilter {

    public void getAllFlights(List<Flight> flights) {
        List<Flight> flightList = new ArrayList<>(flights);
        String flightsToString = flightList.toString().replaceAll("^\\[|\\]$", "");
        System.out.println(flightsToString);
    }


    @Override
    public List<Flight> removeFlightsDepartureBeforeNow(List<Flight> flights) {
       List<Flight> flightList = new ArrayList<>(flights);
        flightList.removeIf(flight -> flight.getSegments().stream()
                .anyMatch(segment -> segment.getDepartureDate()
                        .isBefore(LocalDateTime.now())));
        return flightList;
    }

    @Override
    public List<Flight> removeFlightsArrivalBeforeDeparture(List<Flight> flights) {
        List<Flight> flightList = new ArrayList<>(flights);
        flightList.removeIf(flight -> flight.getSegments().stream()
                .anyMatch(segment -> segment.getArrivalDate()
                        .isBefore(segment.getDepartureDate())));
        return flightList;
    }


    @Override
    public List<Flight> removeFlightsHardstandMoreTwoHours(List<Flight> flights){
        List<Flight> flightList = new ArrayList<>(flights);
        flightList.removeIf(flight -> {
            boolean result = false;
            List<Segment> segments = flight.getSegments();
            Duration twoHours = Duration.ofHours(2);
            for (int i = 1; i < segments.size(); i++) {
               Duration hardstandTime = Duration.between(segments.get(i).getDepartureDate(), segments.get(i - 1).getArrivalDate()).abs();
                if(hardstandTime.toMinutes() / 60 >= twoHours.toHours())
                    result = true;
            }
            return result;
        });
        return flightList;
    }


}
