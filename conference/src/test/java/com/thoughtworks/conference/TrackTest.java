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
            List<Talk> talks = track.talks();

            Talk lunch = LunchIn(talks);
            assertThat(lunch, notNullValue());
            assertThat(lunch.startTime().toString(), equalTo("12:00PM"));
        });
    }

    @Test
    public void should_contain_networking_event() {
        Conference conference = new Conference(inputs());
        List<Track> tracks = conference.tracks();

        tracks.forEach(track -> {
            List<Talk> talks = track.talks();

            Talk networkingEvent = LastItemOf(talks);
            assertThat(networkingEvent, notNullValue());
            assertThat(networkingEvent.startTime().date(), both(
                    after(new Time(4).date())).and(
                    before(new Time(5).date())));
            assertThat(networkingEvent.topic(), is("Networking Event"));
        });
    }

    @Test
    public void should_contain_WritingFastTestsAgainstEnterpriseRails() {
        Conference conference = new Conference(inputs());

        List<Track> tracks = conference.tracks();

        Track track1 = tracks.get(0);
        Talk talk1 = track1.talks().get(0);
        assertThat(talk1, notNullValue());
        assertThat(talk1.topic(), equalTo("Writing Fast Tests Against Enterprise Rails"));
        assertThat(talk1.startTime().toString(), equalTo("09:00AM"));
    }

    private Talk LastItemOf(List<Talk> talks) {
        Optional<Talk> trackItem = talks.stream().reduce((first, second) -> second);
        return trackItem.orElse(null);
    }

    private Talk LunchIn(List<Talk> talks) {
        Optional<Talk> lunch = talks.stream().filter(item -> item.topic().equals("Lunch")).findFirst();
        return lunch.orElse(null);
    }

    private String[] inputs() {
        return new String[]{
                "Writing Fast Tests Against Enterprise Rails 60min",
                "Overdoing it in Python 45min",
                "Lua for the Masses 30min",
                "Ruby Errors from Mismatched Gem Versions 45min",
                "Common Ruby Errors 45min",
                "Rails for Python Developers lightning",
                "Communicating Over Distance 60min",
                "Accounting-Driven Development 45min",
                "Woah 30min",
                "Sit Down and Write 30min",
                "Pair Programming vs Noise 45min",
                "Rails Magic 60min",
                "Ruby on Rails: Why We Should Move On 60min ",
                "Clojure Ate Scala (on my project) 45min ",
                "Programming in the Boondocks of Seattle 30min ",
                "Ruby vs. Clojure for Back-End Development 30min ",
                "Ruby on Rails Legacy App Maintenance 60min",
                "A World Without HackerNews 30min",
                "User Interface CSS in Rails Apps 30min"
        };
    }
}
