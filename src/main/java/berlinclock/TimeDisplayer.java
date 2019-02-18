package berlinclock;

import java.time.LocalTime;

public class TimeDisplayer {

    private StatusComputer statusComputer;
    private boolean withColors = false;

    public TimeDisplayer(LocalTime time) {
        statusComputer = new StatusComputer(time);
    }

    public TimeDisplayer(LocalTime time, boolean withColors) {
        statusComputer = new StatusComputer(time);
        this.withColors = withColors;
    }

    public String getFiveBlockHourString() {
        String template = "   %c    %c     %c    %c   ";
        char[] status = statusComputer.computeFiveBlockHourStatus();

        return String.format(template, status[0], status[1], status[2], status[3]);
    }

    public String getSingleBlockHourString() {
        String template = "   %c    %c     %c    %c   ";
        char[] status = statusComputer.computeSingleBlockHourStatus();

        return String.format(template, status[0], status[1], status[2], status[3]);
    }

    public String getSecondString() {
        return String.format("           %c           ", statusComputer.computeSecondStatus());
    }

    public String getSingleBlockMinuteString() {
        String template = "   %c    %c     %c    %c   ";
        char[] status = statusComputer.computeSingleBlockMinuteStatus();

        return String.format(template, status[0], status[1], status[2], status[3]);
    }

    public String getFiveBlockMinuteString() {
        String template = " %c %c %c %c %c %c %c %c %c %c %c ";
        char[] status = statusComputer.computeFiveBlockMinuteStatus();

        return String.format(template, status[0], status[1], status[2], status[3], status[4],
                status[5], status[6], status[7], status[8], status[9], status[10]);
    }

    public String getSingleBlockHourStringColored() {
        String template = "   %s    %s     %s    %s   ";
        char[] status = statusComputer.computeSingleBlockHourStatus();
        String[] statusCol = new String[status.length];

        for (int i = 0; i < status.length; i++) {
            statusCol[i] = status[i] == 'R' ? "\\e[31m█" : "\\e[37m█";
        }

        return String.format(template, statusCol[0], statusCol[1], statusCol[2], statusCol[3]);
    }

    public String toString() {
        return getSecondString() + '\n' +
                getFiveBlockHourString() + '\n' +
                getSingleBlockHourString() + '\n' +
                getFiveBlockMinuteString() + '\n' +
                getSingleBlockMinuteString() + '\n';
    }

    public String getSecondStringColored() {
        return String.format("           %s           ", statusComputer.computeSecondStatus() == 'R' ?  "\\e[31m█" : "\\e[37m█");
    }

    public String getFiveBlockHourStringColored() {
        String template = "   %s    %s     %s    %s   ";
        char[] status = statusComputer.computeFiveBlockHourStatus();
        String[] color = new String[4];

        for ( int i=0; i<status.length; i++) {
            color[i] = status[i] == 'R' ?  "\\e[31m█" : "\\e[37m█";
        }

        return String.format(template, color[0], color[1], color[2], color[3]);
    }

    public String getSingleBlockMinuteStringColored() {
        String template = "   %s    %s     %s    %s   ";
        char[] status = statusComputer.computeSingleBlockMinuteStatus();
        String[] color = new String[4];

        for ( int i=0; i<status.length; i++) {
            color[i] = status[i] == 'Y' ?  "\\e[33m█" : "\\e[37m█";
        }

        return String.format(template, color[0], color[1], color[2], color[3]);
    }

    public String getFiveBlockMinuteStringColored() {
        String template = " %s %s %s %s %s %s %s %s %s %s %s ";
        char[] status = statusComputer.computeFiveBlockMinuteStatus();
        String[] color = new String[11];

        for ( int i=0; i<status.length; i++) {
            if (status[i] == 'Y'){ color[i] = "\\e[33m█"; }
            else if (status[i] == 'R'){ color[i] = "\\e[31m█"; }
            else if (status[i] == 'O'){ color[i] = "\\e[37m█"; }
        }


        return String.format(template, color[0], color[1], color[2], color[3], color[4],
                color[5], color[6], color[7], color[8], color[9], color[10]);
    }
}
