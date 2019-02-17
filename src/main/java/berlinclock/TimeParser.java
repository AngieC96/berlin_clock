package berlinclock;

import java.time.LocalTime;

public class TimeParser {

    private LocalTime time;

    public TimeParser(LocalTime time) {
        this.time = time;
    }

    public int getParitySecond() {
        return time.getSecond() % 2 == 0 ? 1 : 0;
    }

    public int getFiveBlockMinute() {
        return time.getMinute() / 5;
    }

    public int getSingleBlockMinute(){
        return time.getMinute() % 5;
    }

    public int getSingleBlockHour() {
        return time.getHour() % 5;
    }

    public int getFiveBlockHour(){
        return time.getHour() / 5;
    }

}
