package com.quest.day20.one;

import java.util.*;

public class StreamingPlatformPlaylistManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, User> users = new HashMap<>();
        User currentUser = null;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1.  Create user");
            System.out.println("2.  Create playlist");
            System.out.println("3.  Delete playlist");
            System.out.println("4.  Get playlist by name");
            System.out.println("5.  Display all playlists");
            System.out.println("6.  Rate tracks of a playlist");
            System.out.println("7.  Mark favorite track");
            System.out.println("8.  Unmark favorite track");
            System.out.println("9.  Display favorite tracks");
            System.out.println("10. Add new track to playlist");
            System.out.println("11. Remove track from playlist");
            System.out.println("12. Search track by name/artist");
            System.out.println("13. Display all tracks in playlist");
            System.out.println("14. Sort tracks by duration");
            System.out.println("15. Sort tracks by title");
            System.out.println("16. Shuffle tracks");
            System.out.println("17. Switch user");
            System.out.println("18. Exit");
            System.out.println("19. Merge Playlists");
            System.out.println("20. Find Duplicates in Playlist");
            System.out.println("21. Display Tracks Sorted by Rating");
            System.out.print("\nEnter your choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1: // Create user
                        System.out.print("Enter username: ");
                        String username = sc.nextLine();
                        if (users.containsKey(username)) {
                            System.out.println("User already exists.");
                        } else {
                            currentUser = new User(username);
                            users.put(username, currentUser);
                            System.out.println("User created successfully.");
                        }
                        break;

                    case 2: // Create playlist
                        if (currentUser == null) {
                            System.out.println("No user selected. Please create or select a user first.");
                        } else {
                            System.out.print("Enter playlist name: ");
                            String playlistName = sc.nextLine();
                            try {
                                currentUser.createPlaylist(playlistName);
                                System.out.println("Playlist created successfully.");
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;

                    case 3: // Delete playlist
                        if (currentUser == null) {
                            System.out.println("No user selected. Please create or select a user first.");
                        } else {
                            System.out.print("Enter playlist name to delete: ");
                            String playlistName = sc.nextLine();
                            try {
                                currentUser.deletePlaylist(playlistName);
                                System.out.println("Playlist deleted successfully.");
                            } catch (NoSuchElementException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;

                    case 4: // Get playlist by name
                        if (currentUser == null) {
                            System.out.println("No user selected. Please create or select a user first.");
                        } else {
                            while (true) {
                                System.out.print("Enter playlist name: ");
                                String playlistName = sc.nextLine();
                                try {
                                    Playlist playlist = currentUser.getPlaylist(playlistName);
                                    playlist.displayTracks();
                                    break; // Exit loop if successful
                                } catch (NoSuchElementException e) {
                                    System.out.println("Playlist not found. Try again.");
                                }
                            }
                        }
                        break;

                    case 5: // Display all playlists
                        if (currentUser == null) {
                            System.out.println("No user selected. Please create or select a user first.");
                        } else {
                            currentUser.displayAllPlaylists();
                        }
                        break;

                    case 6: // Rate tracks of a playlist
                        if (currentUser == null) {
                            System.out.println("No user selected. Please create or select a user first.");
                        } else {
                            System.out.print("Enter playlist name: ");
                            String playlistName = sc.nextLine();
                            try {
                                Playlist playlist = currentUser.getPlaylist(playlistName);
                                System.out.print("Enter track ID to rate: ");
                                String trackId = sc.nextLine();
                                System.out.print("Enter rating (1-5): ");
                                int rating = Integer.parseInt(sc.nextLine());
                                for (Track track : playlist.getTracks()) {
                                    if (track.getId().equals(trackId)) {
                                        track.setRating(rating);
                                        System.out.println("Track rated successfully.");
                                        break;
                                    }
                                }

                            } catch (NoSuchElementException e) {
                                System.out.println("Playlist or track not found.");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;

                        case 7: // Mark favorite track
                            if (currentUser == null) {
                                System.out.println("No user selected. Please create or select a user first.");
                            } else {
                                System.out.print("Enter playlist name: ");
                                String playlistName = sc.nextLine();
                                Playlist playlist = currentUser.getPlaylist(playlistName);
                                System.out.print("Enter track ID to mark as favorite: ");
                                String trackId = sc.nextLine();
                                for (Track track : playlist.getTracks()) {
                                    if (track.getId().equals(trackId)) {
                                        currentUser.addTrackToFavorites(track);
                                        System.out.println("Track marked as favorite.");
                                        break;
                                    }
                                }
                            }
                            break;

                        case 8: // Unmark favorite track
                            if (currentUser == null) {
                                System.out.println("No user selected. Please create or select a user first.");
                            } else {
                                System.out.print("Enter playlist name: ");
                                String playlistName = sc.nextLine();
                                Playlist playlist = currentUser.getPlaylist(playlistName);
                                System.out.print("Enter track ID to unmark as favorite: ");
                                String trackId = sc.nextLine();
                                for (Track track : playlist.getTracks()) {
                                    if (track.getId().equals(trackId)) {
                                        currentUser.removeTrackFromFavorites(track);
                                        System.out.println("Track removed from favorites.");
                                        break;
                                    }
                                }
                            }
                            break;

                        case 9: // Display favorite tracks
                            if (currentUser == null) {
                                System.out.println("No user selected. Please create or select a user first.");
                            } else {
                                currentUser.displayAllFavorites();
                            }
                            break;

                        case 10: // Add track to playlist
                            if (currentUser == null) {
                                System.out.println("No user selected. Please create or select a user first.");
                            } else {
                                System.out.print("Enter playlist name: ");
                                String playlistName = sc.nextLine();
                                Playlist playlist = currentUser.getPlaylist(playlistName);
                                System.out.print("Enter track ID: ");
                                String trackId = sc.nextLine();
                                System.out.print("Enter track title: ");
                                String title = sc.nextLine();
                                System.out.print("Enter artist name: ");
                                String artist = sc.nextLine();
                                System.out.print("Enter duration (in minutes): ");
                                double duration = sc.nextDouble();
                                System.out.print("Enter rating (1-5): ");
                                int rating = sc.nextInt();
                                sc.nextLine(); // consume newline
                                Track track = new Track(trackId, title, artist, duration, rating);
                                try {
                                    playlist.addTrack(track);
                                    System.out.println("Track added to playlist.");
                                } catch (DuplicateTrackException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;

                        case 11: // Remove track from playlist
                            if (currentUser == null) {
                                System.out.println("No user selected. Please create or select a user first.");
                            } else {
                                System.out.print("Enter playlist name: ");
                                String playlistName = sc.nextLine();
                                Playlist playlist = currentUser.getPlaylist(playlistName);
                                System.out.print("Enter track ID to remove: ");
                                String trackId = sc.nextLine();
                                playlist.removeTrack(trackId);
                                System.out.println("Track removed.");
                            }
                            break;

                        case 12: // Search track
                            if (currentUser == null) {
                                System.out.println("No user selected. Please create or select a user first.");
                            } else {
                                System.out.print("Enter playlist name: ");
                                String playlistName = sc.nextLine();
                                Playlist playlist = currentUser.getPlaylist(playlistName);

                                if (playlist != null) {
                                    System.out.print("Enter keyword to search (title/artist): ");
                                    String keyword = sc.nextLine();
                                    List<Track> results = playlist.search(keyword); // Perform search within playlist

                                    if (results.isEmpty()) {
                                        System.out.println("No tracks found.");
                                    } else {
                                        for (Track track : results) {
                                            System.out.println(track); // Display matching tracks
                                        }
                                    }
                                } else {
                                    System.out.println("Playlist not found.");
                                }
                            }
                            break;


                        case 13: // Display all tracks in playlist
                            if (currentUser == null) {
                                System.out.println("No user selected. Please create or select a user first.");
                            } else {
                                System.out.print("Enter playlist name: ");
                                String playlistName = sc.nextLine();
                                Playlist playlist = currentUser.getPlaylist(playlistName);
                                playlist.displayTracks();
                            }
                            break;

                        case 14: // Sort tracks by duration
                            if (currentUser == null) {
                                System.out.println("No user selected. Please create or select a user first.");
                            } else {
                                System.out.print("Enter playlist name: ");
                                String playlistName = sc.nextLine();
                                Playlist playlist = currentUser.getPlaylist(playlistName);
                                playlist.sortTracksByDuration();

                            }
                            break;

                        case 15: // Sort tracks by title
                            if (currentUser == null) {
                                System.out.println("No user selected. Please create or select a user first.");
                            } else {
                                System.out.print("Enter playlist name: ");
                                String playlistName = sc.nextLine();
                                Playlist playlist = currentUser.getPlaylist(playlistName);
                                playlist.sortTracksByTitle();

                            }
                            break;

                        case 16: // Shuffle tracks
                            if (currentUser == null) {
                                System.out.println("No user selected. Please create or select a user first.");
                            } else {
                                System.out.print("Enter playlist name: ");
                                String playlistName = sc.nextLine();
                                Playlist playlist = currentUser.getPlaylist(playlistName);
                                playlist.shuffleTracks();
                                System.out.println("Tracks shuffled.");
                            }
                            break;

                        case 19:
                            // Merge playlists
                            System.out.print("Enter the name of the first playlist to merge: ");
                            String playlist1 = sc.nextLine();
                            System.out.print("Enter the name of the second playlist to merge: ");
                            String playlist2 = sc.nextLine();
                            System.out.print("Enter the name of the new merged playlist: ");
                            String newPlaylistName = sc.nextLine();

                            try {
                                currentUser.mergePlaylists(playlist1, playlist2, newPlaylistName);
                            } catch (NoSuchElementException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 20:
                            // Find duplicates in a playlist
                            System.out.print("Enter playlist name to find duplicates: ");
                            String playlistForDuplicates = sc.nextLine();
                            try {
                                Playlist playlist = currentUser.getPlaylist(playlistForDuplicates);
                                List<Track> duplicates = playlist.findDuplicates();
                                if (duplicates.isEmpty()) {
                                    System.out.println("No duplicate tracks found.");
                                } else {
                                    System.out.println("Duplicate tracks:");
                                    for (Track t : duplicates) {
                                        System.out.println("- " + t.getTitle() + " by " + t.getArtist());
                                    }
                                }
                            } catch (NoSuchElementException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                    case 21://sort by rating
                        if (currentUser == null) {
                            System.out.println("No user selected. Please create or select a user first.");
                        } else {
                            System.out.print("Enter playlist name: ");
                            String playlistName = sc.nextLine();
                            Playlist playlist = currentUser.getPlaylist(playlistName);
                            playlist.displayTracksSortedByRating();
                        }
                        break;


                    case 17: // Switch user
                        currentUser = null;
                        System.out.println("Switched user.");
                        break;

                    case 18: // Exit
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }

        }
    }
}

