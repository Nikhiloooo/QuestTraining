package com.quest.day20.one;

import java.util.Objects;

public class Track {
    private String id;
    private String title;
    private String artist;
    private double duration; // in minutes
    private int rating; // Rating from 1 to 5

    public Track(String id, String title, String artist, double duration, int rating) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.rating = rating;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return id == track.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Track[" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", duration=" + duration + '\'' +
                ", rating=" + rating +
                ']';
    }
}
