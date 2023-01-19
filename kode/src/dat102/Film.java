package dat102;

import java.util.Objects;

public class Film {
    private int movieNum;
    private String producer;
    private String title;
    private int year;
    private Sjanger genre;
    private String company;

    public Film(){

    }
    public Film(int movieNum, String producer, String title, int year, Sjanger genre, String company){
        this.movieNum = movieNum;
        this.producer = producer;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.company = company;
    }

    public void setMovieNum(int movieNum) {
        this.movieNum = movieNum;
    }
    public void setProducer(String producer){
        this.producer = producer;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setYear(int year){
        this.year = year;
    }

    public void setGenre(Sjanger genre){
        this.genre = genre;
    }
    public void setCompany(String company){
        this.company = company;
    }

    public int getMovieNum(){
        return movieNum;
    }
    public String getProducer(){
        return producer;
    }
    public String getTitle(){
        return title;
    }
    public int getYear(){
        return year;
    }

    public Sjanger getGenre() {
        return genre;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return movieNum == film.movieNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieNum);
    }

    @Override
    public String toString(){
        return movieNum + " " + this.producer + " " + " " + this.title + " " + this.year + " " +
        this.genre.toString().toLowerCase() + " " + this.company;
    }
}
