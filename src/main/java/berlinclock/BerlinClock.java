package berlinclock;

import java.time.LocalTime;

import static java.lang.Thread.sleep;

public class BerlinClock {

    private TimeDisplayer timeDisplayer;

    public BerlinClock() {
        LocalTime time = LocalTime.now();
        timeDisplayer = new TimeDisplayer(time);
    }

    public BerlinClock(LocalTime time) {
        timeDisplayer = new TimeDisplayer(time);
    }

    public void print() {
        System.out.println(timeDisplayer);
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            BerlinClock berlinclock = new BerlinClock();
            berlinclock.print();

            sleep(1000);
        }
    }


}
