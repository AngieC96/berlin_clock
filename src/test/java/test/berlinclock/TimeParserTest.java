package test.berlinclock;

import berlinclock.TimeParser;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class TimeParserTest {

    @Test
    public void getParitySecondTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("12:41:32");

        TimeParser parser = new TimeParser(time);
        assertThat(parser.getParitySecond(), is(equalTo(1)));
    }

    @Test
    public void getFiveBlockMinuteTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("12:41:32");

        TimeParser parser = new TimeParser(time);
        assertThat(parser.getFiveBlockMinute(), is(equalTo(8)));
    }

    @Test
    public void getSingleBlockHourTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("12:11:32");

        TimeParser parser = new TimeParser(time);
        assertThat(parser.getSingleBlockHour(), is(equalTo(2)));
    }

    @Test
    public void testGetFiveBlockHour() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("23:34:02");

        TimeParser parser = new TimeParser(time);
        assertThat(parser.getFiveBlockHour(), is(equalTo(4)));
    }

    @Test
    public void getSingleBlockMinuteTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("14:48:24");

        TimeParser parser = new TimeParser(time);
        assertThat(parser.getSingleBlockMinute(), is(equalTo(3)));
    }

    @Test
    public void getSecondsTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("10:52:33");

        TimeParser parser = new TimeParser(time);
        assertThat(parser.getSeconds(), is(equalTo(33)));
    }

    @Test
    public void getMinutesTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("11:52:33");

        TimeParser parser = new TimeParser(time);
        assertThat(parser.getMinutes(), is(equalTo(52)));
    }

    @Test
    public void getHoursTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("23:52:33");

        TimeParser parser = new TimeParser(time);
        assertThat(parser.getHours(), is(equalTo(23)));
    }

}