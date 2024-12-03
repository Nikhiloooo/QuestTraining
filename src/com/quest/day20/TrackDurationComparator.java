package com.quest.day20;

import java.util.Comparator;

public class TrackDurationComparator implements Comparator<Track> {
    @Override
    public int compare(Track o1, Track o2) {
        return Double.valueOf(o1.getDuration()).compareTo(o2.getDuration());
    }
}