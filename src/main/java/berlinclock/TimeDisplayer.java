package berlinclock;

import java.util.Date;

public class TimeDisplayer {

    private TimeParser timeParser;

    public TimeDisplayer(Date time) {
        timeParser = new TimeParser(time);
    }

    public char computeSecondStatus(){
        char second = 'O';
        if (timeParser.getSeconds() == 1) second = 'R';
        return second;
    }

    public char[] computeFiveBlockHourStatus() {
        char[] template = {'O', 'O', 'O', 'O'};
        int nOn = timeParser.getFiveBlockHour();

        for (int i = 0; i < nOn; i++) {
            template[i] = 'Y';
        }

        return template;
    }

    public char[] computeSingleBlockHourStatus() {
        char[] template = {'O', 'O', 'O', 'O'};
        int nOn = timeParser.getSingleBlockHour();

        for (int i = 0; i < nOn; i++) {
            template[i] = 'Y';
        }

        return template;
    }
}
