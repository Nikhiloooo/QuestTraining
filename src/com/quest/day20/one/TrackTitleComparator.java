package com.quest.day20.one;

import java.util.Comparator;

public class TrackTitleComparator implements Comparator<Track> {
    @Override
    public int compare(Track t1, Track t2) {
        return t1.getTitle().compareToIgnoreCase(t2.getTitle());
    }
}