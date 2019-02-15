package berlinclock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BerlinClock {

    private TimeDisplayer timeDisplayer;

    public BerlinClock() throws ParseException {
        Date time = new Date();
        timeDisplayer = new TimeDisplayer(time);
    }

    public BerlinClock(Date time) {
        timeDisplayer = new TimeDisplayer(time);
    }

    public void print(){
        System.out.println( timeDisplayer );
    }

    public static void main(String[] args) {
        try {
            BerlinClock berlinclock = new BerlinClock();
            berlinclock.print();
        }
        catch ( ParseException e ) {
            System.out.println("Impossible to get current date");
        }
    }


}
