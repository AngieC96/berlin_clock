package test.berlinclock;

import berlinclock.DateParser;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class DateParserTest {

    @Test
    public void getSingleBlockHourTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = format.parse("12:11:32");

        DateParser parser = new DateParser(date);
        assertThat(parser.getSingleBlockHour(), is(equalTo(2)));
    }

    @Test
    public void testGetFiveBlockHour() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = format.parse("23:34:02");

        DateParser parser = new DateParser(date);
        assertThat(parser.getFiveBlockHour(), is(equalTo(4)));
    }

    @Test
    public void getSecondsTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = format.parse("10:52:33");

        DateParser parser = new DateParser(date);
        assertThat(parser.getSeconds(), is(equalTo(33)));
    }

    @Test
    public void getMinutesTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = format.parse("11:52:33");

        DateParser parser = new DateParser(date);
        assertThat(parser.getMinutes(), is(equalTo(52)));
    }

    @Test
    public void getHoursTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = format.parse("23:52:33");

        DateParser parser = new DateParser(date);
        assertThat(parser.getHours(), is(equalTo(23)));
    }

}