package com.thoughtworks.conference;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Time
 * <p>
 * Created by napoleon on 06/12/2016.
 */
public class Time {
    private Date date;

    Time(int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, hour);
        calendar.set(Calendar.MINUTE, minute);
        date = calendar.getTime();
    }

    Time(int hour) {
        this(hour, 0);
    }

    private Time(Date date) {
        this.date = date;
    }

    Date date() {
        return date;
    }

    @Override
    public String toString() {
        return new SimpleDateFormat("hh:mmaa").format(date);
    }

    public Time addMinutes(int time) {
        return new Time(new Date(date.getTime() + (time * 60000)));
    }
}
