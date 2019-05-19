package berlinclock;

import java.time.LocalTime;

public class InlineDisplayer extends TimeDisplayer {

    public InlineDisplayer(LocalTime time) {
        super(time);
    }

    public String getSecondString() {
        String template = "%s";
        return String.format(template, statusComputer.computeSecondStatus() == 'R' ? "1" : "0");
    }

    public String getSingleBlockHourString() {
        return null;
    }

    public String getFiveBlockHourString() {
        return null;
    }

    public String getSingleBlockMinuteString() {
        return null;
    }

    public String getFiveBlockMinuteString() {
        return null;
    }

    public String toString() {
        return null;
    }
}
