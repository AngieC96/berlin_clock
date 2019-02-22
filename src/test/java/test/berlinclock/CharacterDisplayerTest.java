package test.berlinclock;

import berlinclock.CharacterDisplayer;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class CharacterDisplayerTest {

    @Test
    public void getSecondStringTest() {
        LocalTime time = LocalTime.of(18, 41, 32);
        CharacterDisplayer displayer = new CharacterDisplayer(time);

        assertThat(displayer.getSecondString(), is(equalTo("           R           ")));

    }
    
    @Test
    public void getFiveBlockHourStringTest() {
        LocalTime time = LocalTime.of(12, 41, 32);
        CharacterDisplayer displayer = new CharacterDisplayer(time);

        String expected = "   R    R     O    O   ";

        assertThat(displayer.getFiveBlockHourString(), is(equalTo(expected)));
    }

    @Test
    public void getSingleBlockHourStringTest() {
        LocalTime time = LocalTime.of(18, 41, 32);
        CharacterDisplayer displayer = new CharacterDisplayer(time);

        String expected = "   R    R     R    O   ";

        assertThat(displayer.getSingleBlockHourString(), is(equalTo(expected)));
    }

    @Test
    public void getFiveBlockMinuteStringTest() {
        LocalTime time = LocalTime.of(12, 42, 32);
        CharacterDisplayer displayer = new CharacterDisplayer(time);

        String expected = " Y Y R Y Y R Y Y O O O ";

        assertThat(displayer.getFiveBlockMinuteString(), is(equalTo(expected)));

    }

    @Test
    public void getSingleBlockMinuteStringTest() {
        LocalTime time = LocalTime.of(12, 37, 32);
        CharacterDisplayer displayer = new CharacterDisplayer(time);

        String expected = "   Y    Y     O    O   ";

        assertThat(displayer.getSingleBlockMinuteString(), is(equalTo(expected)));

    }

    @Test
    public void toStringTest() {
        LocalTime time = LocalTime.of(17, 42, 2);
        CharacterDisplayer displayer = new CharacterDisplayer(time);

        String expected = "           R           " + '\n' +
                "   R    R     R    O   " + '\n' +
                "   R    R     O    O   " + '\n' +
                " Y Y R Y Y R Y Y O O O " + '\n' +
                "   Y    Y     O    O   " + '\n';

        assertThat(displayer.toString(), is(equalTo(expected)));
    }
}