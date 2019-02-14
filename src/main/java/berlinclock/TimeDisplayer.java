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
}
