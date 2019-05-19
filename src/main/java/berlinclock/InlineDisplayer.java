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

    public String getFiveBlockMinuteString() {
        String template = "%c%c%c%c%c%c%c%c%c%c%c";
        char[] status = statusComputer.computeFiveBlockMinuteStatus();
        char[] binary = new char[11];

        for (int i = 0; i < status.length; i++) {
            binary[i] = status[i] == 'O' ? '0' : '1';
        }

        return String.format(template, binary[0], binary[1], binary[2], binary[3], binary[4],
                binary[5], binary[6], binary[7], binary[8], binary[9], binary[10]);
    }

    public String getSingleBlockMinuteString() {
        String template = "%c%c%c%c";
        char[] status = statusComputer.computeSingleBlockMinuteStatus();
        char[] binary = new char[4];

        for (int i = 0; i < status.length; i++) {
            binary[i] = status[i] == 'Y' ? '1' : '0';
        }

        return String.format(template, binary[0], binary[1], binary[2], binary[3]);
    }

    public String toString() {
        return null;
    }
}
