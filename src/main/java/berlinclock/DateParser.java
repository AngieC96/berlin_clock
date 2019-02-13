package berlinclock;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateParser {

    private Calendar calendar;

    public DateParser(Date date) {
        calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
    }

    public int getParitySecond() {
        return getSeconds() % 2 == 0 ? 1 : 0;
    }

    public int getFiveBlockMinute() {
        return getMinutes() / 5;
    }

    public int getSingleBlockMinute(){
        return getMinutes() % 5;
    }

    public int getSingleBlockHour() {
        return getHours() % 5;
    }

    public int getFiveBlockHour(){
        return getHours() / 5;
    }

    public int getSeconds() {
        return calendar.get(Calendar.SECOND);
    }

    public int getMinutes() {
        return calendar.get(Calendar.MINUTE);
    }

    public int getHours() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
}
