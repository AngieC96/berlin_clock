package berlinclock;

import java.time.LocalTime;

public class ColoredDisplayer extends TimeDisplayer {

    public ColoredDisplayer(LocalTime time) {
        super(time);
    }

    public String getSecondString() {
        String template = "           %s           ";
        return String.format(template, statusComputer.computeSecondStatus() == 'R' ? "\033[31m▀" : "\033[37m▀");
    }

    public String getFiveBlockHourString() {
        String template = "   %s    %s     %s    %s   ";
        char[] status = statusComputer.computeFiveBlockHourStatus();
        String[] color = new String[4];

        for (int i = 0; i < status.length; i++) {
            color[i] = status[i] == 'R' ? "\033[31m▀" : "\033[37m▀";
        }

        return String.format(template, color[0], color[1], color[2], color[3]);
    }

    public String getSingleBlockHourString() {
        String template = "   %s    %s     %s    %s   ";
        char[] status = statusComputer.computeSingleBlockHourStatus();
        String[] statusCol = new String[status.length];

        for (int i = 0; i < status.length; i++) {
            statusCol[i] = status[i] == 'R' ? "\033[31m▀" : "\033[37m▀";
        }

        return String.format(template, statusCol[0], statusCol[1], statusCol[2], statusCol[3]);
    }

    public String getFiveBlockMinuteString() {
        String template = " %s %s %s %s %s %s %s %s %s %s %s ";
        char[] status = statusComputer.computeFiveBlockMinuteStatus();
        String[] color = new String[11];

        for (int i = 0; i < status.length; i++) {
            if (status[i] == 'Y') {
                color[i] = "\033[33m▀";
            } else if (status[i] == 'R') {
                color[i] = "\033[31m▀";
            } else if (status[i] == 'O') {
                color[i] = "\033[37m▀";
            }
        }

        return String.format(template, color[0], color[1], color[2], color[3], color[4],
                color[5], color[6], color[7], color[8], color[9], color[10]);
    }

    public String getSingleBlockMinuteString() {
        String template = "   %s    %s     %s    %s   ";
        char[] status = statusComputer.computeSingleBlockMinuteStatus();
        String[] color = new String[4];

        for (int i = 0; i < status.length; i++) {
            color[i] = status[i] == 'Y' ? "\033[33m▀" : "\033[37m▀";
        }

        return String.format(template, color[0], color[1], color[2], color[3]);
    }

    public String toString() {
        return getSecondString() + '\n' +
                getFiveBlockHourString() + '\n' +
                getSingleBlockHourString() + '\n' +
                getFiveBlockMinuteString() + '\n' +
                getSingleBlockMinuteString() + '\n';
    }
}
