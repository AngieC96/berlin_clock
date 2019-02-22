package berlinclock;

import java.time.LocalTime;

public class CharacterDisplayer extends TimeDisplayer {

    public CharacterDisplayer(LocalTime time) {
        super(time);
    }

    public String getSecondString() {
        String template = "           %c           ";
        return String.format(template, statusComputer.computeSecondStatus());
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

    public String getFiveBlockMinuteString() {
        String template = " %c %c %c %c %c %c %c %c %c %c %c ";
        char[] status = statusComputer.computeFiveBlockMinuteStatus();

        return String.format(template, status[0], status[1], status[2], status[3], status[4],
                status[5], status[6], status[7], status[8], status[9], status[10]);
    }

    public String getSingleBlockMinuteString() {
        String template = "   %c    %c     %c    %c   ";
        char[] status = statusComputer.computeSingleBlockMinuteStatus();

        return String.format(template, status[0], status[1], status[2], status[3]);
    }

    public String toString() {
        return getSecondString() + '\n' +
                getFiveBlockHourString() + '\n' +
                getSingleBlockHourString() + '\n' +
                getFiveBlockMinuteString() + '\n' +
                getSingleBlockMinuteString() + '\n';
    }
}
