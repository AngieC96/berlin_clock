package test.berlinclock;

import berlinclock.TimeDisplayer;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class TimeDisplayerTest {

    @Test
    public void getFiveBlockHourStringTest() {
        LocalTime time = LocalTime.of(12, 41, 32);
        TimeDisplayer timeDisplayer = new TimeDisplayer(time);

        String expected = "   R    R     O    O   ";

        assertThat(timeDisplayer.getFiveBlockHourString(), is(equalTo(expected)));
    }

    @Test
    public void getSingleBlockHourStringTest() {
        LocalTime time = LocalTime.of(18, 41, 32);
        TimeDisplayer timeDisplayer = new TimeDisplayer(time);

        String expected = "   R    R     R    O   ";

        assertThat(timeDisplayer.getSingleBlockHourString(), is(equalTo(expected)));
    }

    @Test
    public void getSecondStringTest() {
        LocalTime time = LocalTime.of(18, 41, 32);
        TimeDisplayer displayer = new TimeDisplayer(time);

        assertThat(displayer.getSecondString(), is(equalTo("           R           ")));

    }

    @Test
    public void getSingleBlockMinuteStringTest() {
        LocalTime time = LocalTime.of(12, 37, 32);
        TimeDisplayer displayer = new TimeDisplayer(time);

        String expected = "   Y    Y     O    O   ";

        assertThat(displayer.getSingleBlockMinuteString(), is(equalTo(expected)));

    }

    @Test
    public void getFiveBlockMinuteStringTest() {
        LocalTime time = LocalTime.of(12, 42, 32);
        TimeDisplayer displayer = new TimeDisplayer(time);

        String expected = " Y Y R Y Y R Y Y O O O ";

        assertThat(displayer.getFiveBlockMinuteString(), is(equalTo(expected)));

    }

    @Test
    public void getSingleBlockHourStringColoredTest() {
        LocalTime time = LocalTime.of(6, 41, 37);
        TimeDisplayer timeDisplayer = new TimeDisplayer(time);

        String expected = "   \\e[31m█    \\e[37m█     \\e[37m█    \\e[37m█   ";

        assertThat(timeDisplayer.getSingleBlockHourStringColored(), is(equalTo(expected)));
    }

    @Test
    public void toStringTest() {
        LocalTime time = LocalTime.of(17, 42, 2);
        TimeDisplayer displayer = new TimeDisplayer(time);

        String expected = "           R           " + '\n' +
                "   R    R     R    O   " + '\n' +
                "   R    R     O    O   " + '\n' +
                " Y Y R Y Y R Y Y O O O " + '\n' +
                "   Y    Y     O    O   " + '\n';

        assertThat(displayer.toString(), is(equalTo(expected)));
    }

    @Test
    public void getSecondStringColoredTest() {
        LocalTime time = LocalTime.of(18, 41, 32);
        TimeDisplayer displayer = new TimeDisplayer(time);

        assertThat(displayer.getSecondStringColored(), is(equalTo("           \\e[31m█           ")));

    }

    @Test
    public void getFiveBlockHourStringColoredTest() {
        LocalTime time = LocalTime.of(12, 41, 32);
        TimeDisplayer timeDisplayer = new TimeDisplayer(time);

        String expected = "   \\e[31m█    \\e[31m█     \\e[37m█    \\e[37m█   ";

        assertThat(timeDisplayer.getFiveBlockHourStringColored(), is(equalTo(expected)));
    }
}