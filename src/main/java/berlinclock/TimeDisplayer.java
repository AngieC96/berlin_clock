package berlinclock;

import java.time.LocalTime;

public abstract class TimeDisplayer {

    protected StatusComputer statusComputer;

    public TimeDisplayer(LocalTime time) {
        statusComputer = new StatusComputer(time);
    }

    public abstract String getFiveBlockHourString();

    public abstract String getSingleBlockHourString();

    public abstract String getSecondString();

    public abstract String getSingleBlockMinuteString();

    public abstract String getFiveBlockMinuteString();

    public abstract String toString();


}
