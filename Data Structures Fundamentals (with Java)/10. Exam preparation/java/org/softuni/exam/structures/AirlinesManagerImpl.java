package org.softuni.exam.structures;

import org.softuni.exam.entities.Airline;
import org.softuni.exam.entities.Flight;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AirlinesManagerImpl implements AirlinesManager {

    Map<String, Airline> airlines = new LinkedHashMap<>();
    Map<String, Flight> flights = new LinkedHashMap<>();
    Map<String, Flight> completedFlights = new LinkedHashMap<>();
    Map<String, List<Flight>> flightsByAirline = new LinkedHashMap<>();

    @Override
    public void addAirline(Airline airline) {
        airlines.put(airline.getId(), airline);
        flightsByAirline.put(airline.getId(), new ArrayList<>());
    }

    @Override
    public void addFlight(Airline airline, Flight flight) {
        if (!contains(airline)) {
            throw new IllegalArgumentException();
        }

        flights.put(flight.getId(), flight);
        List<Flight> currentAirlineFlights = flightsByAirline.get(airline.getId());
        currentAirlineFlights.add(flight);


    }

    @Override
    public boolean contains(Airline airline) {
        return airlines.containsKey(airline.getId());
    }

    @Override
    public boolean contains(Flight flight) {
        return flights.containsKey(flight.getId());
    }

    @Override
    public void deleteAirline(Airline airline) throws IllegalArgumentException {
        if (!contains(airline)) {
            throw new IllegalArgumentException();
        }
        airlines.remove(airline.getId());
        List<Flight> removedAirlineFlights = flightsByAirline.get(airline.getId());
        for (Flight flight : removedAirlineFlights) {
            flights.remove(flight.getId());
        }
    }

    @Override
    public Iterable<Flight> getAllFlights() {
        return flights.values();
    }

    @Override
    public Flight performFlight(Airline airline, Flight flight) throws IllegalArgumentException {

        if (!contains(airline) || !contains(flight)) {
            throw new IllegalArgumentException();
        }

        Flight completedFlight = flights.get(flight.getId());
        completedFlight.setCompleted(true);

        return completedFlight;
    }

    @Override
    public Iterable<Flight> getCompletedFlights() {
        return flights.values()
                .stream()
                .filter(Flight::isCompleted)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Flight> getFlightsOrderedByNumberThenByCompletion() {
        return null;
    }

    @Override
    public Iterable<Airline> getAirlinesOrderedByRatingThenByCountOfFlightsThenByName() {
        return null;
    }

    @Override
    public Iterable<Airline> getAirlinesWithFlightsFromOriginToDestination(String origin, String destination) {
        return null;
    }
}
