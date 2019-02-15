package test.berlinclock;

import berlinclock.StatusComputer;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;


public class StatusComputerTest {

    @Test
    public void  computeSecondStatusTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("12:41:32");
        StatusComputer timeDisplayer = new StatusComputer(time);

        assertThat(timeDisplayer.computeSecondStatus(), is(equalTo('O')));
    }

    @Test
    public void computeFiveBlockHourStatusTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("17:41:32");
        StatusComputer timeDisplayer = new StatusComputer(time);

        char[] expected = {'R', 'R', 'R', 'O'};

        assertArrayEquals(timeDisplayer.computeFiveBlockHourStatus(), expected);
    }

    @Test
    public void computeSingleBlockHourStatusTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("17:42:32");
        StatusComputer timeDisplayer = new StatusComputer(time);

        char[] expected = {'R', 'R', 'O', 'O'};

        assertArrayEquals(timeDisplayer.computeSingleBlockHourStatus(), expected);
    }

    @Test
    public void computeFiveBlockMinuteStatusTest() throws ParseException  {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("17:47:32");
        StatusComputer timeDisplayer = new StatusComputer(time);

        char[] expected = {'Y', 'Y', 'R', 'Y', 'Y', 'R', 'Y', 'Y', 'R', 'O', 'O' };

        assertArrayEquals(timeDisplayer.computeFiveBlockMinuteStatus(), expected);
    }

    @Test
    public void computeSingleBlockMinuteStatusTest() throws ParseException  {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("17:07:32");
        StatusComputer timeDisplayer = new StatusComputer(time);

        char[] expected = {'Y', 'Y', 'O', 'O'};

        assertArrayEquals(timeDisplayer.computeSingleBlockMinuteStatus(), expected);
    }
}