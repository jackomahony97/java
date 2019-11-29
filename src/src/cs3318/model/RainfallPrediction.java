package model;

import datastore.RainfallDataSource;
import exceptions.IllegalRainfallDataSourceException;

import java.time.LocalDate;
import java.util.Objects;

public abstract class RainfallPrediction {
    protected RainfallDataSource data;

    /**
     * Validation for source
     * @param source
     */
    public RainfallPrediction(RainfallDataSource source) throws IllegalArgumentException{
        Objects.requireNonNull(source);
        try {
            this.data = source;
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    public abstract Double predict(LocalDate date);
}
