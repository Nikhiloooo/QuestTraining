package com.quest.day20.one;

import java.util.List;

public interface PlaylistOperations {
    void addTrack(Track track) throws DuplicateTrackException;
    void removeTrack(String title);
    List<Track> findDuplicates();
    List<Track> search(String keyword);
    void displayTracks();
    void sortTracksByDuration();
    void sortTracksByTitle();
    void shuffleTracks();
    List<Track> getTracks();
     void displayTracksSortedByRating();
}
