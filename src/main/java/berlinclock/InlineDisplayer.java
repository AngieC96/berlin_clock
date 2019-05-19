package berlinclock;

import java.time.LocalTime;

public class InlineDisplayer extends TimeDisplayer {

    public InlineDisplayer(LocalTime time) {
        super(time);
    }

    public String getSecondString() {
        String template = "%c";
        return String.format(template, statusComputer.computeSecondStatus() == 'R' ? '1' : '0');
    }

    public String getFiveBlockHourString() {
        String template = "%c%c%c%c";
        char[] status = statusComputer.computeFiveBlockHourStatus();
        char[] binary = new char[4];

        for (int i = 0; i < status.length; i++) {
            binary[i] = status[i] == 'R' ? '1' : '0';
        }

        return String.format(template, binary[0], binary[1], binary[2], binary[3]);
    }

    public String getSingleBlockHourString() {
        String template = "%c%c%c%c";
        char[] status = statusComputer.computeSingleBlockHourStatus();
        char[] binary = new char[4];

        for (int i = 0; i < status.length; i++) {
            binary[i] = status[i] == 'R' ? '1' : '0';
        }

        return String.format(template, binary[0], binary[1], binary[2], binary[3]);
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
