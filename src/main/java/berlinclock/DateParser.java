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

    public int getSeconds() {
        return calendar.get(Calendar.SECOND);
    }
}
