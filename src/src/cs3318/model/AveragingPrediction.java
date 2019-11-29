package model;

import datastore.RainfallDataSource;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Objects;

public class AveragingPrediction extends RainfallPrediction {
    private int numberOfSamples = 3;

    public AveragingPrediction(RainfallDataSource source){
        super(source);
        Objects.requireNonNull(source);
    }

    /**
     * Public mutator method
     * @param n
     */
    public void setNumberOfSamples(int n) throws IllegalArgumentException {
        try{
            setSamples(n);
        }
        catch (IllegalArgumentException iae){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Private mutator method
     * @param n
     */
    private void setSamples (int n){
        this.numberOfSamples= n;
    }

    /**
     * Public accessor method
     * @return int numberofSamples
     */
    public int getNumberOfSamples() {
        return this.numberOfSamples;
    }


    @Override
    public Double predict(LocalDate date){
        Objects.requireNonNull(date);
        Double [] predictionData = new Double[this.numberOfSamples];
        LocalDate sampleYear;
        try {
            sampleYear = date.minus(1, ChronoUnit.YEARS);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Must be greater than 1 year");
        }

        if (this.numberOfSamples <= 0) {throw new NumberFormatException("Number of samples must be < 1 ");}
        for (int i = 0; i < this.numberOfSamples; i += 1) {
            Integer indexOfDate = data.getRecordingDates().indexOf(sampleYear);
            try {
                predictionData[i] = data.getPrecipitation().get(i);
                sampleYear = date.minus(1, ChronoUnit.YEARS);
            } catch (ArrayIndexOutOfBoundsException e){
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        return Arrays.stream(predictionData).mapToDouble(Double::doubleValue).average().orElse(Double.NaN);
    }
}
