package com.quest.day20.one;

import java.util.Comparator;

public class TrackDurationComparator implements Comparator<Track> {
    @Override
    public int compare(Track o1, Track o2) {
        return Double.compare(o1.getDuration(), o2.getDuration());
    }
}
