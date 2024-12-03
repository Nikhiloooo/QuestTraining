package com.quest.day20.one;

import java.util.*;

public class User implements UserOperations {
    private String username;
    private Map<String, Playlist> playlists;
    private Set<Track> favoriteTracks;

    User(String username) {
        this.username = username;
        playlists = new HashMap<>();
        favoriteTracks = new HashSet<>();
    }

    @Override
    public void createPlaylist(String name) {
        if (playlists.containsKey(name)) {
            throw new IllegalArgumentException("Playlist already exists");
        }
        playlists.put(name, new Playlist(name));
    }

    @Override
    public void deletePlaylist(String name) {
        if (playlists.containsKey(name)) {
            playlists.remove(name);
        } else {
            throw new NoSuchElementException("Playlist does not exist");
        }
    }

    @Override
    public Playlist getPlaylist(String name) {
        Playlist playlist = playlists.get(name);
        if (playlist == null) {
            throw new NoSuchElementException("Playlist not found.");
        }
        return playlist;
    }

    @Override
    public void displayAllPlaylists() {
        for (Map.Entry<String, Playlist> entry : playlists.entrySet()) {
            System.out.println("Playlist: " + entry.getKey());
            entry.getValue().displayTracks();
        }
    }

    @Override
    public void mergePlaylists(String playlist1, String playlist2, String newPlaylistName) {
        Playlist p1 = playlists.get(playlist1);
        Playlist p2 = playlists.get(playlist2);

        if (p1 != null && p2 != null) {
            Playlist mergedPlaylist = new Playlist(newPlaylistName);

            for (Track track : p1.getTracks()) {
                try {
                    mergedPlaylist.addTrack(track);
                } catch (DuplicateTrackException e) {

                }
            }
            for (Track track : p2.getTracks()) {
                try {
                    mergedPlaylist.addTrack(track);
                } catch (DuplicateTrackException e) {

                }
            }
            playlists.put(newPlaylistName, mergedPlaylist);
        } else {
            throw new NoSuchElementException("One or both playlists do not exist");
        }
    }

    @Override
    public void addTrackToFavorites(Track track) {
        favoriteTracks.add(track);
    }

    @Override
    public void removeTrackFromFavorites(Track track) {
        favoriteTracks.remove(track);
    }

    @Override
    public void displayAllFavorites() {
        for (Track track : favoriteTracks) {
            System.out.println(track);
        }
    }
}
