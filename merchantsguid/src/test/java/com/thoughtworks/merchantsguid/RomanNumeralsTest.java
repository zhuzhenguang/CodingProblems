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
        RomanNumeralsComputer romanNumeralsComputer = new SimpleComputer();

        String result = romanNumeralsComputer.compute("how much is pish tegj glob glob ?");

        assertThat(result, is("pish tegj glob glob is 42"));
    }

    @Test
    public void glob_prok_Silver_should_be_68_Credits() {
        RomanNumeralsComputer romanNumeralsComputer = new CreditsComputer(input());

        String result = romanNumeralsComputer.compute("how many Credits is glob prok Silver ?");

        assertThat(result, is("glob prok Silver is 68 Credits"));
    }

    @Test
    @Ignore
    public void glob_prok_Gold_should_be_57800_Credits() {
        RomanNumeralsComputer romanNumeralsComputer = new CreditsComputer(input());

        String result = romanNumeralsComputer.compute("how many Credits is glob prok Gold ?");

        assertThat(result, is("glob prok Gold is 57800 Credits"));
    }

    private String[] input() {
        return new String[]{
                "glob is I",
                "prok is V",
                "pish is X",
                "tegj is L",
                "glob glob Silver is 34 Credits",
                "glob prok Gold is 57800 Credits",
                "pish pish Iron is 3910 Credits"};
    }
}
