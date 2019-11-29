package cs3318.datastore;

import cs3318.exceptions.IllegalRainfallDataSourceException;

import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public abstract class RainfallDataSource {
    private final String dataSource;
    private final String station;

    protected ArrayList<Double> precipitation;
    protected HashMap<Integer, LocalDate> recordingDates;

    public RainfallDataSource(String station, String dataSource) throws IllegalRainfallDataSourceException {
        this.dataSource = Objects.requireNonNull(dataSource);
        this.station = Objects.requireNonNull(dataSource);
        this.getDataFrom(this.dataSource);
    }

    public List<Double> getPrecipitation() {
        return Collections.unmodifiableList(this.precipitation);
    }

    public List<LocalDate> getRecordingDates() {
        return Collections.unmodifiableList(new ArrayList(this.recordingDates.values()));
    }

    public String getDataSource() {
        return this.dataSource;
    }

    protected abstract void getDataFrom(String source) throws IllegalRainfallDataSourceException;
}
