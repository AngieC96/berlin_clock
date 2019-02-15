package test.berlinclock;

import berlinclock.StatusComputer;
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
    public void getFiveBlockHourStringTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date time = format.parse("12:41:32");
        TimeDisplayer timeDisplayer = new TimeDisplayer(time);

        String expected = "   R    R     O    O   ";

        assertThat(timeDisplayer.getFiveBlockHourString(), is(equalTo(expected)));
    }

}