package test.berlinclock;

import berlinclock.InlineDisplayer;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class InlineDisplayerTest {

    @Test
    public void getSecondStringTest() {
        LocalTime time = LocalTime.of(18, 41, 32);
        InlineDisplayer displayer = new InlineDisplayer(time);

        assertThat(displayer.getSecondString(), is(equalTo("1")));
    }

    @Test
    public void getFiveBlockHourStringTest() {
        LocalTime time = LocalTime.of(13, 46, 17);
        InlineDisplayer displayer = new InlineDisplayer(time);

        String expected = "1100";

        assertThat(displayer.getFiveBlockHourString(), is(equalTo(expected)));
    }

}