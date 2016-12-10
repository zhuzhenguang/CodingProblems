package com.thoughtworks.conference;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.exparity.hamcrest.date.DateMatchers.after;
import static org.exparity.hamcrest.date.DateMatchers.before;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * TrackTest
 * <p>
 * Created by napoleon on 05/12/2016.
 */
public class TrackTest {
    @Test
    public void should_contain_lunch_in_track() {
        Conference conference = new Conference(inputs());
        List<Track> tracks = conference.tracks();

        tracks.forEach(track -> {
            List<TrackItem> trackItems = track.items();

            TrackItem lunch = LunchIn(trackItems);
            assertThat(lunch, notNullValue());
            assertThat(lunch.startTime().toString(), equalTo("12:00PM"));
        });
    }

    @Test
    public void should_contain_networking_event() {
        Conference conference = new Conference(inputs());
        List<Track> tracks = conference.tracks();

        tracks.forEach(track -> {
            List<TrackItem> trackItems = track.items();

            TrackItem networkingEvent = LastItemOf(trackItems);
            assertThat(networkingEvent, notNullValue());
            assertThat(networkingEvent.startTime().date(), both(
                    after(new Time(4).date())).and(
                    before(new Time(5).date())));
            assertThat(networkingEvent.topic(), is("Networking Event"));
        });
    }

    private TrackItem LastItemOf(List<TrackItem> trackItems) {
        Optional<TrackItem> trackItem = trackItems.stream().reduce((first, second) -> second);
        return trackItem.isPresent() ? trackItem.get() : null;
    }

    private TrackItem LunchIn(List<TrackItem> trackItems) {
        Optional<TrackItem> lunch = trackItems.stream().filter(item -> item.topic().equals("Lunch")).findFirst();
        return lunch.isPresent() ? lunch.get() : null;
    }

    private String[] inputs() {
        return new String[]{
                "Writing Fast Tests Against Enterprise Rails 60min Overdoing it in Python 45min",
                "Lua for the Masses 30min",
                "Ruby Errors from Mismatched Gem Versions 45min Common Ruby Errors 45min",
                "Rails for Python Developers lightning Communicating Over Distance 60min Accounting-Driven Development 45min",
                "Woah 30min",
                "Sit Down and Write 30min",
                "Pair Programming vs Noise 45min",
                "Rails Magic 60min",
                "Ruby on Rails: Why We Should Move On 60min Clojure Ate Scala (on my project) 45min Programming in the Boondocks of Seattle 30min Ruby vs. Clojure for Back-End Development 30min Ruby on Rails Legacy App Maintenance 60min",
                "A World Without HackerNews 30min",
                "User Interface CSS in Rails Apps 30min"
        };
    }
}
