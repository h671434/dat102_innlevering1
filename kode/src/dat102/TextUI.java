package dat102;


import java.util.InputMismatchException;
import java.util.Scanner;

public class TextUI {
    public Film lesFilm(){

        int movieNum = isInt("What is the movie? ");
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
        
    }



}
