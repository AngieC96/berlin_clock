package berlinclock;

import java.time.LocalTime;

import static java.lang.Thread.sleep;

public class BerlinClock {

    private TimeDisplayer timeDisplayer;

    public BerlinClock() {
        LocalTime time = LocalTime.now();
        timeDisplayer = new TimeDisplayer(time);
    }

    public BerlinClock(boolean withColors) {
        LocalTime time = LocalTime.now();
        timeDisplayer = new TimeDisplayer(time, withColors);
    }

    public BerlinClock(LocalTime time) {
        timeDisplayer = new TimeDisplayer(time);
    }

    public BerlinClock(LocalTime time, boolean withColors) {
        timeDisplayer = new TimeDisplayer(time, withColors);
    }

    public void print() {
        System.out.println(timeDisplayer);
    }

    public static void main(String[] args) throws InterruptedException {
        boolean withColors = false;

        if (args.length > 0 && args[0].equals("-c")) withColors = true;

        while (true) {
            BerlinClock berlinclock = new BerlinClock(withColors);
            berlinclock.print();

            sleep(1000);
        }
    }


}
