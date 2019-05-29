package berlinclock;

import java.time.LocalTime;

import static java.lang.Thread.sleep;

public class BerlinClock {

    public enum DisplayMode { BASE, COLOR, INLINE };

    private TimeDisplayer timeDisplayer;

    public BerlinClock(DisplayMode displayMode) {
        LocalTime time = LocalTime.now();

        switch (displayMode) {
            case BASE:
                timeDisplayer = new CharacterDisplayer(time);
                break;
            case COLOR:
                timeDisplayer = new ColoredDisplayer(time);
                break;
            case INLINE:
                timeDisplayer = new InlineDisplayer(time);
                break;
        }
    }

    public BerlinClock(LocalTime time, DisplayMode displayMode) {
        switch (displayMode) {
            case BASE:
                timeDisplayer = new CharacterDisplayer(time);
                break;
            case COLOR:
                timeDisplayer = new ColoredDisplayer(time);
                break;
            case INLINE:
                timeDisplayer = new InlineDisplayer(time);
                break;
        }
    }

    public void print() {
        System.out.println(timeDisplayer);
    }

    public static void main(String[] args) throws InterruptedException {
        DisplayMode displayMode = DisplayMode.BASE;

        if (args.length > 0 && args[0].equals("--colors")) {
            displayMode = DisplayMode.COLOR;
        } else if (args.length > 0 && args[0].equals("--inline")) {
            displayMode = DisplayMode.INLINE;
        }

        while (true) {
            System.out.print("\033[H\033[2J"); // To clean the screen

            BerlinClock berlinclock = new BerlinClock(displayMode);
            berlinclock.print();

            sleep(1000);
        }
    }


}
