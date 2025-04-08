package org.softuni.exam.structures;

import org.softuni.exam.entities.Airline;
import org.softuni.exam.entities.Flight;

public class AirlinesManagerImpl implements AirlinesManager {
    @Override
    public void addAirline(Airline airline) {

    }

    @Override
    public void addFlight(Airline airline, Flight flight) {

    }

    @Override
    public boolean contains(Airline airline) {
        return false;
    }

    @Override
    public boolean contains(Flight flight) {
        return false;
    }

    @Override
    public void deleteAirline(Airline airline) throws IllegalArgumentException {

    }

    @Override
    public Iterable<Flight> getAllFlights() {
        return null;
    }

    @Override
    public Flight performFlight(Airline airline, Flight flight) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Iterable<Flight> getCompletedFlights() {
        return null;
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
