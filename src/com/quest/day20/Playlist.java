package com.quest.day20;

import java.util.*;

public class Playlist implements PlaylistOperations {
    private String name;
    private List<Track> tracks;

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<Track>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void addTrack(Track track) throws DuplicateTrackException {
        if (tracks.contains(track)) {
            throw new DuplicateTrackException("Track with ID " + track.getId() + " already exists");
        }
        tracks.add(track);
    }


    @Override
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);

        } else {
            throw new NoSuchElementException("Track with ID " + track.getId() + " does not exist");
        }
    }

    @Override
    public List<Track> findDuplicates() {
        List<Track> duplicates = new ArrayList<>();
        Set<String> trackIds = new HashSet<>();
        for (Track track : tracks) {
            if (!trackIds.add(track.getId())) {
                duplicates.add(track);
            }
        }
        return duplicates;
    }


    @Override
    public List<Track> search(String keyword) {
        keyword = keyword.toLowerCase();
        List<Track> result = new ArrayList<>();
        for (Track track : tracks) {
            if (track.getTitle().toLowerCase().equalsIgnoreCase(keyword) || track.getArtist().toLowerCase().equalsIgnoreCase(keyword)) {
                result.add(track);
            }
        }
        return result;
    }

    @Override
    public void displayTracks() {

        for (Track track : tracks) {
            System.out.println(track);
        }
    }

    @Override
    public void sortTracksByDuration() {
        tracks.sort(new TrackDurationComparator());
    }

    @Override
    public void sortTracksByTitle() {
        tracks.sort(new TrackTitleComparator());
    }

    @Override
    public void shuffleTracks() {
        Collections.shuffle(tracks);
    }

    @Override
    public List<Track> getTracks() {
        return this.tracks;
    }
}
