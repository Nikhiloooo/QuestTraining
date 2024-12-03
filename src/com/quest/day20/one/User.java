package com.quest.day20.one;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class User implements UserOperations {
    private String username;
    private List<Playlist> playlists;
    private List<Track> favoriteTracks;

    public User(String username) {
        this.username = username;
        this.playlists = new ArrayList<>();
        this.favoriteTracks = new ArrayList<>();
    }

    // Implementing the UserOperations interface methods
    @Override
    public void createPlaylist(String name) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equals(name)) {
                throw new IllegalArgumentException("Playlist with the name " + name + " already exists.");
            }
        }
        playlists.add(new Playlist(name));
    }

    @Override
    public void deletePlaylist(String name) {
        Playlist playlistToDelete = null;
        for (Playlist playlist : playlists) {
            if (playlist.getName().equals(name)) {
                playlistToDelete = playlist;
                break;
            }
        }
        if (playlistToDelete != null) {
            playlists.remove(playlistToDelete);
        } else {
            throw new NoSuchElementException("Playlist with name " + name + " not found.");
        }
    }

    @Override
    public Playlist getPlaylist(String name) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equals(name)) {
                return playlist;
            }
        }
        throw new NoSuchElementException("Playlist with name " + name + " not found.");
    }

    @Override
    public void displayAllPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("No playlists available.");
        } else {
            System.out.println("Playlists of " + username + ":");
            for (Playlist playlist : playlists) {
                System.out.println("- " + playlist.getName());
            }
        }
    }

    @Override
    public void mergePlaylists(String playlist1, String playlist2, String newPlaylistName) {
        Playlist p1 = getPlaylist(playlist1);
        Playlist p2 = getPlaylist(playlist2);
        Playlist newPlaylist = new Playlist(newPlaylistName);

        newPlaylist.getTracks().addAll(p1.getTracks());
        newPlaylist.getTracks().addAll(p2.getTracks());

        playlists.add(newPlaylist);
        System.out.println("Playlists merged successfully into: " + newPlaylistName);
    }

    @Override
    public void addTrackToFavorites(Track track) {
        if (!favoriteTracks.contains(track)) {
            favoriteTracks.add(track);
            System.out.println("Track added to favorites.");
        } else {
            System.out.println("Track is already in favorites.");
        }
    }

    @Override
    public void removeTrackFromFavorites(Track track) {
        if (favoriteTracks.contains(track)) {
            favoriteTracks.remove(track);
            System.out.println("Track removed from favorites.");
        } else {
            System.out.println("Track not found in favorites.");
        }
    }

    @Override
    public void displayAllFavorites() {
        if (favoriteTracks.isEmpty()) {
            System.out.println("No favorite tracks.");
        } else {
            System.out.println("Favorite tracks:");
            for (Track track : favoriteTracks) {
                System.out.println("- " + track.getTitle() + " by " + track.getArtist());
            }
        }
    }

    public String getUsername() {
        return username;
    }
}
