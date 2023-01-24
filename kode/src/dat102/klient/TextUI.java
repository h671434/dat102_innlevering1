package dat102.klient;


import dat102.Film;
import dat102.Sjanger;
import dat102.adt.FilmArkivADT;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUI {
    public Film lesFilm(){

        int movieNum = isInt("What is the movie number? ");
        String producer = isString("What is the producer? ");
        String title = isString("What is the title? ");
        int year = isInt("What year was the movie released? ");
        Sjanger genre = getSjang();
        String company = isString("what company? ");

        if((genre == null) || (movieNum == -1) || (year == -1)){
            return null;
        }

        return new Film(movieNum, producer, title, year, genre, company);
    }

    private int isInt(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        int rightInt = -1;
        for(int i = 0; i < 3 && rightInt == -1; i++) {
            try {
                rightInt = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("please enter an int");
                in.nextLine(); //clear invalid input
            }
        }
        return rightInt;
    }
    private String isString(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }

    private Sjanger getSjang(){
        Scanner in = new Scanner(System.in);
        System.out.println("What is the genre? ");
        Sjanger rightSjang = null;
        for(int i = 0; i < 3 && rightSjang == null; i++) {
            rightSjang = Sjanger.finnSjanger(in.nextLine());
            if(rightSjang == null){
                System.out.println("please try again and enter a valid genre ");
            }
        }
        return rightSjang;
    }

    public void showMovie(Film movie){
        String[] movieInfo = movie.toString().split(" ");
        for(String i : movieInfo){
            System.out.println(i);
        }
    }

    public void showMovieWithStringInTitle(FilmArkivADT filma, String part){
        Film[] matches = filma.searchTitle("part");
        for(Film match : matches){
            showMovie(match);
            System.out.println("\nnext movie:");
        }
    }
    public void showMovieFromProducer(FilmArkivADT filma, String keyword){
        Film[] movies = filma.getMovieList();
        for(Film f : movies){
            if(f.getProducer().equals(keyword)){
                showMovie(f);
            }
        }
    }

    public void showStats(FilmArkivADT filma){
        for(Sjanger sj : Sjanger.values()){
            System.out.println(sj.toString().toLowerCase() + ": " + filma.numInGenre(sj));
        }
        System.out.println("Total number of movies: " + filma.amount());

    }



}
