package com.quest.day20.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist implements PlaylistOperations {
    private String name;
    private List<Track> tracks;

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    // Implementing the PlaylistOperations interface methods
    @Override
    public void addTrack(Track track) throws DuplicateTrackException {
        for (Track t : tracks) {
            if (t.getId().equals(track.getId())) {
                throw new DuplicateTrackException("Track with ID " + track.getId() + " already exists in the playlist.");
            }
        }
        tracks.add(track);
    }

    @Override
    public void removeTrack(String id) {
        Track trackToRemove = null;
        for (Track track : tracks) {
            if (track.getId().equals(id)) {
                trackToRemove = track;
                break;
            }
        }
        if (trackToRemove != null) {
            tracks.remove(trackToRemove);
            System.out.println("Track removed from playlist.");
        } else {
            System.out.println("Track with ID " + id + " not found in playlist.");
        }
    }

    @Override
    public List<Track> findDuplicates() {
        List<Track> duplicates = new ArrayList<>();
        for (int i = 0; i < tracks.size(); i++) {
            for (int j = i + 1; j < tracks.size(); j++) {
                if (tracks.get(i).getId().equals(tracks.get(j).getId())) {
                    duplicates.add(tracks.get(i));
                }
            }
        }
        return duplicates;
    }

    @Override
    public List<Track> search(String keyword) {
        List<Track> result = new ArrayList<>();
        for (Track track : tracks) {
            if (track.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    track.getArtist().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(track);
            }
        }
        return result;
    }

    @Override
    public void displayTracks() {
        if (tracks.isEmpty()) {
            System.out.println("No tracks available in this playlist.");
        } else {
            System.out.println("Tracks in " + name + " playlist:");
            for (Track track : tracks) {
                System.out.println("- " + track.getTitle() + " by " + track.getArtist() + " (" + track.getDuration() + " mins)");
            }
        }
    }

    @Override
    public void sortTracksByDuration() {
        Collections.sort(tracks, new TrackDurationComparator());
        System.out.println("Tracks sorted by duration.");
    }

    @Override
    public void sortTracksByTitle() {
        Collections.sort(tracks, new TrackTitleComparator());
        System.out.println("Tracks sorted by title.");
    }

    @Override
    public void shuffleTracks() {
        Collections.shuffle(tracks);
        System.out.println("Tracks shuffled.");
    }
}
