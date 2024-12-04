package com.quest.day20.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Playlist implements PlaylistOperations {
    private String name;
    private List<Track> tracks;

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", tracks=" + tracks +
                '}';
    }

    // Implementing the PlaylistOperations interface methods
    @Override
    public void addTrack(Track track) throws DuplicateTrackException    {
        if(tracks.contains(track))
            throw new DuplicateTrackException("Exception! Track already exists...");
        else
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
                if (tracks.get(i).getId().equals(tracks.get(j).getId())||tracks.get(i).getTitle().equalsIgnoreCase(tracks.get(j).getTitle())) {
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
            if(track.getTitle().equalsIgnoreCase(keyword) || track.getArtist().equalsIgnoreCase(keyword)) {
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
            System.out.println("Tracks in " + name + "'s  playlist:");
            for (Track track : tracks) {
                System.out.println(track);
            }
        }
    }

    @Override
    public void sortTracksByDuration() {
        tracks.sort(new TrackDurationComparator());
        System.out.println("Tracks sorted by duration.");
        System.out.println(tracks);
    }

    @Override
    public void sortTracksByTitle() {
        tracks.sort(new TrackTitleComparator());
        System.out.println("Tracks sorted by title.");
        System.out.println(tracks);
    }

    @Override
    public void shuffleTracks() {
        Collections.shuffle(tracks);
        System.out.println("Tracks shuffled.");
    }


@Override
    public void displayTracksSortedByRating() {
        tracks.sort( new Comparator<Track>() {
            @Override
            public int compare(Track t1, Track t2) {
                return t2.getRating() - t1.getRating();
            }
        });

        System.out.println("Tracks sorted by rating (highest to lowest):");
        for (Track track : tracks) {
            System.out.println(track);
        }
    }
}
