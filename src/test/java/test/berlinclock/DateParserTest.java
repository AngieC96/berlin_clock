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
    public void getSecondsTest() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = format.parse("10:52:33");

        DateParser parser = new DateParser(date);
        assertThat(parser.getSeconds(), is(equalTo(33)));
    }

}