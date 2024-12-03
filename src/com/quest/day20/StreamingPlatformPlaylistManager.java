package com.quest.day20;

import java.util.Scanner;

public class StreamingPlatformPlaylistManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User("Nikhil");
        System.out.println("Welcome to the Playlist Manager!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Playlist");
            System.out.println("2. Delete Playlist");
            System.out.println("3. Add Track to Playlist");
            System.out.println("4. Remove Track from Playlist");
            System.out.println("5. Display Tracks in Playlist");
            System.out.println("6. Search Tracks");
            System.out.println("7. Sort Tracks by Duration");
            System.out.println("8. Sort Tracks by Title");
            System.out.println("9. Shuffle Tracks");
            System.out.println("10. Merge Playlists");
            System.out.println("11. Mark/Unmark Favorite Track");
            System.out.println("12. Display Favorites");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1: // Create Playlist
                        System.out.print("Enter playlist name: ");
                        String playlistName = scanner.nextLine();
                        user.createPlaylist(playlistName);
                        System.out.println("Playlist created successfully.");
                        break;

                    case 2: // Delete Playlist
                        System.out.print("Enter playlist name to delete: ");
                        playlistName = scanner.nextLine();
                        user.deletePlaylist(playlistName);
                        System.out.println("Playlist deleted successfully.");
                        break;

                    case 3: // Add Track to Playlist
                        System.out.print("Enter playlist name to add track: ");
                        playlistName = scanner.nextLine();
                        Playlist playlist = user.getPlaylist(playlistName);

                        // Manually input track details
                        System.out.print("Enter track ID: ");
                        String trackId = scanner.nextLine();
                        System.out.print("Enter track title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter track artist: ");
                        String artist = scanner.nextLine();
                        System.out.print("Enter track duration: ");
                        double duration = scanner.nextDouble();
                        System.out.print("Enter track rating (1-5): ");
                        int rating = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        Track track = new Track(trackId, title, artist, duration, rating);
                        playlist.addTrack(track);
                        System.out.println("Track added successfully.");
                        break;

                    case 4: // Remove Track from Playlist
                        System.out.print("Enter playlist name to remove track: ");
                        playlistName = scanner.nextLine();
                        playlist = user.getPlaylist(playlistName);

                        System.out.print("Enter track ID to remove: ");
                        trackId = scanner.nextLine();
                        track = new Track(trackId, "", "", 0, 0);
                        playlist.removeTrack(track);
                        System.out.println("Track removed successfully.");
                        break;

                    case 5: // Display Tracks in Playlist
                        System.out.print("Enter playlist name to display tracks: ");
                        playlistName = scanner.nextLine();
                        playlist = user.getPlaylist(playlistName);
                        playlist.displayTracks();
                        break;

                    case 6: // Search Tracks
                        System.out.print("Enter keyword to search for tracks: ");
                        String keyword = scanner.nextLine();
                        for (Playlist p : user.getPlaylists()) {
                            p.search(keyword).forEach(System.out::println);
                        }
                        break;

                    case 7: // Sort Tracks by Duration
                        System.out.print("Enter playlist name to sort by duration: ");
                        playlistName = scanner.nextLine();
                        playlist = user.getPlaylist(playlistName);
                        playlist.sortTracksByDuration();
                        System.out.println("Tracks sorted by duration.");
                        break;

                    case 8: // Sort Tracks by Title
                        System.out.print("Enter playlist name to sort by title: ");
                        playlistName = scanner.nextLine();
                        playlist = user.getPlaylist(playlistName);
                        playlist.sortTracksByTitle();
                        System.out.println("Tracks sorted by title.");
                        break;

                    case 9: // Shuffle Tracks
                        System.out.print("Enter playlist name to shuffle: ");
                        playlistName = scanner.nextLine();
                        playlist = user.getPlaylist(playlistName);
                        playlist.shuffleTracks();
                        System.out.println("Tracks shuffled.");
                        break;

                    case 10: // Merge Playlists
                        System.out.print("Enter first playlist name to merge: ");
                        String playlist1 = scanner.nextLine();
                        System.out.print("Enter second playlist name to merge: ");
                        String playlist2 = scanner.nextLine();
                        System.out.print("Enter new playlist name: ");
                        String newPlaylistName = scanner.nextLine();
                        user.mergePlaylists(playlist1, playlist2, newPlaylistName);
                        System.out.println("Playlists merged.");
                        break;

                    case 11: // Mark/Unmark Favorite Track
                        System.out.print("Enter track ID to mark/unmark as favorite: ");
                        trackId = scanner.nextLine();
                        track = new Track(trackId, "", "", 0, 0);
                        if (user.getFavoriteTracks().contains(track)) {
                            user.removeTrackFromFavorites(track);
                            System.out.println("Track unmarked as favorite.");
                        } else {
                            user.addTrackToFavorites(track);
                            System.out.println("Track marked as favorite.");
                        }
                        break;

                    case 12:
                        user.displayAllFavorites();
                        break;

                    case 13: // Exit
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
