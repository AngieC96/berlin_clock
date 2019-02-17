package test.berlinclock;

import berlinclock.TimeParser;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class TimeParserTest {

    @Test
    public void getParitySecondTest() {
        LocalTime time = LocalTime.of(12, 35, 12);

        TimeParser parser = new TimeParser(time);
        assertThat(parser.getParitySecond(), is(equalTo(1)));
    }

    @Test
    public void getFiveBlockMinuteTest() {
        LocalTime time = LocalTime.of(12, 41, 32);

        TimeParser parser = new TimeParser(time);
        assertThat(parser.getFiveBlockMinute(), is(equalTo(8)));
    }

    @Test
    public void getSingleBlockHourTest() {
        LocalTime time = LocalTime.of(12, 11, 32);

        TimeParser parser = new TimeParser(time);
        assertThat(parser.getSingleBlockHour(), is(equalTo(2)));
    }

    @Test
    public void testGetFiveBlockHour() {
        LocalTime time = LocalTime.of(23, 34, 2);

        TimeParser parser = new TimeParser(time);
        assertThat(parser.getFiveBlockHour(), is(equalTo(4)));
    }

    @Test
    public void getSingleBlockMinuteTest() {
        LocalTime time = LocalTime.of(14, 48, 25);

        TimeParser parser = new TimeParser(time);
        assertThat(parser.getSingleBlockMinute(), is(equalTo(3)));
    }

}