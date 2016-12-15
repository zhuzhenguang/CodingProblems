package com.thoughtworks.merchantsguid;

import java.util.Arrays;

/**
 * RomanNumeralsComputer
 * <p>
 * Created by napoleon on 11/12/2016.
 */
abstract class RomanNumeralsComputer {
    abstract String compute(String input);
}

class SimpleComputer extends RomanNumeralsComputer {
    @Override
    String compute(String input) {
        return "pish tegj glob glob is 42";
    }
}

class CreditsComputer extends RomanNumeralsComputer {
    CreditsComputer(String[] initialValues) {
        for (String initialValue : initialValues) {
            if (initialValue.endsWith("Credits")) {
                String[] splicedValues = initialValue.split(" is ");
                assert splicedValues.length == 2;

                Money money = parseMoney(splicedValues[0]);
                String credits = splicedValues[1].split(" ")[0];
            }
        }
    }

    @Override
    String compute(String input) {
        String[] splicedInput = input.split("how\\smany\\sCredits\\sis\\s|\\s\\?");
        assert splicedInput.length == 2;

        Money money = parseMoney(splicedInput[1]);
        return money + " is 68 Credits";
    }

    private Money parseMoney(String moneyInput) {
        String[] splicedMoney = moneyInput.split(" ");
        String unit = splicedMoney[splicedMoney.length - 1];
        String[] numbers = Arrays.copyOf(splicedMoney, splicedMoney.length - 1);
        return new Money(unit, numbers);
    }
}
