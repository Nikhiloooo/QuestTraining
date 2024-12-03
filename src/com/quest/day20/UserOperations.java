package com.quest.day20;

public interface UserOperations {
    void createPlaylist(String name);
    void deletePlaylist(String name);
    Playlist getPlaylist(String name);
    void displayAllPlaylists();
    void mergePlaylists(String playlist1, String playlist2, String newPlaylistName);
    void addTrackToFavorites(Track track);
    void removeTrackFromFavorites(Track track);
    void displayAllFavorites();
}
