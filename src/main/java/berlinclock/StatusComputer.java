package berlinclock;

import java.util.Date;

public class StatusComputer {

    private TimeParser timeParser;

    public StatusComputer(Date time) {
        timeParser = new TimeParser(time);
    }

    public char computeSecondStatus(){
        char template = 'O';
        if (timeParser.getSeconds() == 1) template = 'R';
        return template;
    }

    public char[] computeFiveBlockHourStatus() {
        char[] template = {'O', 'O', 'O', 'O'};
        int nOn = timeParser.getFiveBlockHour();

        for (int i = 0; i < nOn; i++) {
            template[i] = 'R';
        }

        return template;
    }

    public char[] computeSingleBlockHourStatus() {
        char[] template = {'O', 'O', 'O', 'O'};
        int nOn = timeParser.getSingleBlockHour();

        for (int i = 0; i < nOn; i++) {
            template[i] = 'R';
        }

        return template;
    }

    public char[] computeFiveBlockMinuteStatus(){
        char[] template = {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'};
        int nOn = timeParser.getFiveBlockMinute();

        for (int i = 0; i < nOn; i++) {
            template[i] = (((i+1) % 3) == 0) ? 'R' : 'Y';
        }

        return template;
    }

    public char[] computeSingleBlockMinuteStatus() {
        char[] template = {'O', 'O', 'O', 'O'};
        int nOn = timeParser.getSingleBlockMinute();

        for (int i = 0; i < nOn; i++) {
            template[i] = 'Y';
        }

        return template;
    }

}
