package application;

import datastore.RainfallDataSource;
import datastore.RainfallDataSourceCSV;
import datastore.RainfallDataSourceRandom;
import exceptions.IllegalRainfallDataSourceException;

import java.io.FileNotFoundException;

/**
 * Predict rainfall of Cork Airport. CSV file as file input
 * Prints date and percipitation to terminal
 */
public class PredictRainfall {
    /**
     *
     * @param args
     * @throws IllegalRainfallDataSourceException
     */
    public static void main(String [] args) throws IllegalRainfallDataSourceException {
        RainfallDataSource corkAirport;

        try {
            corkAirport = new RainfallDataSourceCSV("Cork Airport", "resources/Rainfall-daily-cork-airport-1962-present.csv");
        }
        catch (IllegalRainfallDataSourceException e) {
            corkAirport = new RainfallDataSourceRandom("Cork Airport (dummy)");
            throw new IllegalRainfallDataSourceException("Problem with file");
        }
        /**
         * Print to terminal
         */
        corkAirport.getRecordingDates().forEach(System.out::println);
        corkAirport.getPrecipitation().forEach(System.out::println);
    }
}
