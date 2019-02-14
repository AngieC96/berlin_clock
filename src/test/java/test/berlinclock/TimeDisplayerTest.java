package test.berlinclock;

import berlinclock.TimeDisplayer;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;


public class TimeDisplayerTest {

    @Test
    public void  computeSecondStatusTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("12:41:32");
        TimeDisplayer timedisplayer = new TimeDisplayer(time);

        assertThat(timedisplayer.computeSecondStatus(), is(equalTo('O')));
    }

    @Test
    public void computeFiveBlockHourStatusTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("17:41:32");
        TimeDisplayer timedisplayer = new TimeDisplayer(time);

        char[] expected = {'Y', 'Y', 'Y', 'O'};

        assertArrayEquals(timedisplayer.computeFiveBlockHourStatus(), expected);
    }
}