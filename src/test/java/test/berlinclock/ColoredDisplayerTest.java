package test.berlinclock;

import berlinclock.ColoredDisplayer;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class ColoredDisplayerTest {

    @Test
    public void getSecondStringTest() {
        LocalTime time = LocalTime.of(18, 41, 32);
        ColoredDisplayer displayer = new ColoredDisplayer(time);

        assertThat(displayer.getSecondString(), is(equalTo("           \033[31m▀           ")));
    }

    @Test
    public void getFiveBlockHourStringTest() {
        LocalTime time = LocalTime.of(12, 41, 32);
        ColoredDisplayer displayer = new ColoredDisplayer(time);

        String expected = "   \033[31m▀    \033[31m▀     \033[37m▀    \033[37m▀   ";

        assertThat(displayer.getFiveBlockHourString(), is(equalTo(expected)));
    }

    @Test
    public void getSingleBlockHourStringTest() {
        LocalTime time = LocalTime.of(6, 41, 37);
        ColoredDisplayer displayer = new ColoredDisplayer(time);

        String expected = "   \033[31m▀    \033[37m▀     \033[37m▀    \033[37m▀   ";

        assertThat(displayer.getSingleBlockHourString(), is(equalTo(expected)));
    }

    @Test
    public void getFiveBlockMinuteStringTest() {
        LocalTime time = LocalTime.of(12, 42, 32);
        ColoredDisplayer displayer = new ColoredDisplayer(time);

        String expected = " \033[33m▀ \033[33m▀ \033[31m▀ \033[33m▀ \033[33m▀ \033[31m▀ \033[33m▀ \033[33m▀ \033[37m▀ \033[37m▀ \033[37m▀ ";

        assertThat(displayer.getFiveBlockMinuteString(), is(equalTo(expected)));
    }

    @Test
    public void getSingleBlockMinuteStringTest() {
        LocalTime time = LocalTime.of(12, 37, 32);
        ColoredDisplayer displayer = new ColoredDisplayer(time);

        String expected = "   \033[33m▀    \033[33m▀     \033[37m▀    \033[37m▀   ";

        assertThat(displayer.getSingleBlockMinuteString(), is(equalTo(expected)));
    }

    @Test
    public void toStringTest() {
        LocalTime time = LocalTime.of(17, 42, 2);
        ColoredDisplayer displayer = new ColoredDisplayer(time);

        String expected = "           \033[31m▀           " + '\n' +
                "   \033[31m▀    \033[31m▀     \033[31m▀    \033[37m▀   " + '\n' +
                "   \033[31m▀    \033[31m▀     \033[37m▀    \033[37m▀   " + '\n' +
                " \033[33m▀ \033[33m▀ \033[31m▀ \033[33m▀ \033[33m▀ \033[31m▀ \033[33m▀ \033[33m▀ \033[37m▀ \033[37m▀ \033[37m▀ " + '\n' +
                "   \033[33m▀    \033[33m▀     \033[37m▀    \033[37m▀   " + '\n';

        assertThat(displayer.toString(), is(equalTo(expected)));
    }

}