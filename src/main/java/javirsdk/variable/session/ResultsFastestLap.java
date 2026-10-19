package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

public class ResultsFastestLap {
    @JsonProperty("CarIdx")
    private int carIdx = 0;
    public int getCarIdx() { return this.carIdx; }
    @JsonProperty("FastestLap")
    private int fastestLap = 0;
    public int getFastestLap() { return this.fastestLap; }
    @JsonProperty("FastestTime")
    private double fastestTime = 0;
    public double getFastestTime() { return this.fastestTime; }
    //$...
}
