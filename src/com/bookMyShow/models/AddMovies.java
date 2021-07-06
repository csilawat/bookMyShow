package com.bookMyShow.models;

public class AddMovies {


    String title;
    String genre;
    String length;
    String cast;
    String director;
    String adminRating;
    String language;
    int startTimings;
    int endTimings;
    int numberOfShowsInDay;
    int firstShow;
    int intervalTime;
    int gapBetweenShows;
    int Capacity;

    public AddMovies() {
    }

    public AddMovies(String title, String genre, String length, String cast, String director, String adminRating, String language, int startTimings, int endTimings, int numberOfShowsInDay, int firstShow, int intervalTime, int gapBetweenShows, int capacity) {
        this.title = title;
        this.genre = genre;
        this.length = length;
        this.cast = cast;
        this.director = director;
        this.adminRating = adminRating;
        this.language = language;
        this.startTimings = startTimings;
        this.endTimings = endTimings;
        this.numberOfShowsInDay = numberOfShowsInDay;
        this.firstShow = firstShow;
        this.intervalTime = intervalTime;
        this.gapBetweenShows = gapBetweenShows;
        Capacity = capacity;
    }

    
    public String getTitle() {
        return title;
    }

    public AddMovies setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public AddMovies setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getLength() {
        return length;
    }

    public AddMovies setLength(String length) {
        this.length = length;
        return this;
    }

    public String getCast() {
        return cast;
    }

    public AddMovies setCast(String cast) {
        this.cast = cast;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public AddMovies setDirector(String director) {
        this.director = director;
        return this;
    }

    public String getAdminRating() {
        return adminRating;
    }

    public AddMovies setAdminRating(String adminRating) {
        this.adminRating = adminRating;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public AddMovies setLanguage(String language) {
        this.language = language;
        return this;
    }

    public int getStartTimings() {
        return startTimings;
    }

    public AddMovies setStartTimings(int startTimings) {
        this.startTimings = startTimings;
        return this;
    }

    public int getEndTimings() {
        return endTimings;
    }

    public AddMovies setEndTimings(int endTimings) {
        this.endTimings = endTimings;
        return this;
    }

    public int getNumberOfShowsInDay() {
        return numberOfShowsInDay;
    }

    public AddMovies setNumberOfShowsInDay(int numberOfShowsInDay) {
        this.numberOfShowsInDay = numberOfShowsInDay;
        return this;
    }

    public int getFirstShow() {
        return firstShow;
    }

    public AddMovies setFirstShow(int firstShow) {
        this.firstShow = firstShow;
        return this;
    }

    public int getIntervalTime() {
        return intervalTime;
    }

    public AddMovies setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
        return this;
    }

    public int getGapBetweenShows() {
        return gapBetweenShows;
    }

    public AddMovies setGapBetweenShows(int gapBetweenShows) {
        this.gapBetweenShows = gapBetweenShows;
        return this;
    }

    public int getCapacity() {
        return Capacity;
    }

    public AddMovies setCapacity(int capacity) {
        Capacity = capacity;
        return this;
    }

    public void setIntervalTime(String addMovieProperties) {
    }

    @Override
    public String toString() {
        return "AddMovies{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", length='" + length + '\'' +
                ", cast='" + cast + '\'' +
                ", director='" + director + '\'' +
                ", adminRating='" + adminRating + '\'' +
                ", language='" + language + '\'' +
                ", startTimings=" + startTimings +
                ", endTimings=" + endTimings +
                ", numberOfShowsInDay=" + numberOfShowsInDay +
                ", firstShow=" + firstShow +
                ", intervalTime=" + intervalTime +
                ", gapBetweenShows=" + gapBetweenShows +
                ", Capacity=" + Capacity +
                '}';
    }
}


