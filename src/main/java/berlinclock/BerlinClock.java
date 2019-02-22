package berlinclock;

import java.time.LocalTime;

import static java.lang.Thread.sleep;

public class BerlinClock {

    private TimeDisplayer timeDisplayer;

    public BerlinClock() {
        LocalTime time = LocalTime.now();
        timeDisplayer = new CharacterDisplayer(time);
    }

    public BerlinClock(boolean withColors) {
        LocalTime time = LocalTime.now();

        if (withColors) {
            timeDisplayer = new ColoredDisplayer(time);
        } else {
            timeDisplayer = new CharacterDisplayer(time);
        }
    }

    public BerlinClock(LocalTime time) {
        timeDisplayer = new CharacterDisplayer(time);
    }

    public BerlinClock(LocalTime time, boolean withColors) {
        if (withColors) {
            timeDisplayer = new ColoredDisplayer(time);
        } else {
            timeDisplayer = new CharacterDisplayer(time);
        }
    }

    public void print() {
        System.out.println(timeDisplayer);
    }

    public static void main(String[] args) throws InterruptedException {
        boolean withColors = false;

        if (args.length > 0 && args[0].equals("-c")) withColors = true;

        while (true) {
            System.out.print("\033[H\033[2J"); // To clean the screen

            BerlinClock berlinclock = new BerlinClock(withColors);
            berlinclock.print();

            sleep(1000);
        }
    }


}
