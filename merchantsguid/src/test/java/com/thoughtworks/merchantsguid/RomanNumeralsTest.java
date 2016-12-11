package com.thoughtworks.merchantsguid;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * RomanNumeralsTest
 * <p>
 * Created by napoleon on 10/12/2016.
 */
public class RomanNumeralsTest {
    @Test
    public void pish_tegj_glob_glob_should_be_42() {
        RomanComputer romanComputer = new RomanComputer();

        String result = romanComputer.compute("how much is pish tegj glob glob ?");

        assertThat("pish tegj glob glob is 42", is(result));
    }

    @Test
    public void glob_prok_Silver_should_be_68_Credits() {
        RomanComputer romanComputer = new RomanComputer();

        String result = romanComputer.compute("how many Credits is glob prok Silver ?");

        assertThat("glob prok Silver is 68 Credits", is(result));
    }

    @Test
    @Ignore
    public void glob_prok_Gold_should_be_57800_Credits() {
        RomanComputer romanComputer = new RomanComputer();

        String result = romanComputer.compute("how many Credits is glob prok Gold ?");

        assertThat("glob prok Gold is 57800 Credits", is(result));
    }
}
