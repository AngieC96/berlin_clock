package test.berlinclock;

import berlinclock.StatusComputer;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;


public class StatusComputerTest {

    @Test
    public void computeSecondStatusTest() {
        LocalTime time = LocalTime.of(12, 35, 12);
        StatusComputer statusComputer = new StatusComputer(time);

        assertThat(statusComputer.computeSecondStatus(), is(equalTo('R')));
    }

    @Test
    public void computeFiveBlockHourStatusTest() {
        LocalTime time = LocalTime.of(17, 41, 32);
        StatusComputer statusComputer = new StatusComputer(time);

        char[] expected = {'R', 'R', 'R', 'O'};

        assertArrayEquals(statusComputer.computeFiveBlockHourStatus(), expected);
    }

    @Test
    public void computeSingleBlockHourStatusTest() {
        LocalTime time = LocalTime.of(17, 42, 32);
        StatusComputer statusComputer = new StatusComputer(time);

        char[] expected = {'R', 'R', 'O', 'O'};

        assertArrayEquals(statusComputer.computeSingleBlockHourStatus(), expected);
    }

    @Test
    public void computeFiveBlockMinuteStatusTest() {
        LocalTime time = LocalTime.of(17, 47, 32);
        StatusComputer statusComputer = new StatusComputer(time);

        char[] expected = {'Y', 'Y', 'R', 'Y', 'Y', 'R', 'Y', 'Y', 'R', 'O', 'O'};

        assertArrayEquals(statusComputer.computeFiveBlockMinuteStatus(), expected);
    }

    @Test
    public void computeSingleBlockMinuteStatusTest() {
        LocalTime time = LocalTime.of(17, 7, 32);
        StatusComputer statusComputer = new StatusComputer(time);

        char[] expected = {'Y', 'Y', 'O', 'O'};

        assertArrayEquals(statusComputer.computeSingleBlockMinuteStatus(), expected);
    }
}