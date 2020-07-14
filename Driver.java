/*
Author: Christopher Roberts
E-mail: cmr663@psu.edu
Course: CMPSC 221
Assigment: Programming Assigment 4
Due Date: 3/17/2020
File: Online Shopping Application.java
Purpose: Java app that implements movie database that a user can search through
Compiler/IDE: IntelliJ IDEA
Operating System: MS Windows 10
References: https://www.geeksforgeeks.org/java-string-contains-method-example/
 */
import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Scanner inputStream = null;
        ArrayList<AwardWinningMovie> dataBase = new ArrayList<>();
        String title;
        String rating;
        String genre;
        String director;
        String star;
        String awardTitle;
        int awardYear;

        try {
            inputStream = new Scanner(new FileInputStream("movies.txt"));
            while (inputStream.hasNextLine()) {
                title = inputStream.nextLine();
                rating = inputStream.nextLine();
                genre = inputStream.nextLine();
                director = inputStream.nextLine();
                star = inputStream.nextLine();
                awardTitle = inputStream.nextLine();
                awardYear = Integer.parseInt(inputStream.nextLine());
                AwardWinningMovie stuff = new AwardWinningMovie(title, rating, genre, director, star, awardTitle, awardYear);
                dataBase.add(stuff);
            }
            String line = null;
            int linecount = 0;
            String label = "";
            while (inputStream.hasNextLine()) {
                if (linecount % 6 == 0) {
                    label = "Title: ";
                }
                if (linecount % 6 == 1) {
                    label = "Rating: ";
                }
                if (linecount % 6 == 2) {
                    label = "Genre: ";
                }
                if (linecount % 6 == 3) {
                    label = "Director: ";
                }
                if (linecount % 6 == 4) {
                    label = "Star: ";
                } else if (linecount % 6 == 5) {
                    label = "Award: ";
                }
                line = inputStream.nextLine();
                linecount++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Problem opening file.");
            System.exit(0);
        }
        inputStream.close();

        AwardWinningMovie temp = new AwardWinningMovie("", "", "", "", "", "", 0);
        AwardWinningMovie temp2 = new AwardWinningMovie("", "", "", "", "", "", 0);
        AwardWinningMovie temp3 = new AwardWinningMovie("", "", "", "", "", "", 0);
        Scanner choice = new Scanner(System.in);
        Scanner choice2 = new Scanner(System.in);
        Scanner choice3 = new Scanner(System.in);
        boolean menuDone = false;
        while (!menuDone) {
            temp.menu();
            String menuChoice = choice.nextLine();
            switch (menuChoice) {
                case "1":
                    boolean menuDone2 = false;
                    boolean movies = false;
                    boolean movies2 = false;
                    temp.printPopMovies(dataBase);
                    System.out.println();
                    int movieChoice;
                    while (!movies) {
                        try {
                            System.out.print("Please enter the number of the movie you would like to know more about: ");
                            movieChoice = choice2.nextInt();
                            System.out.println();
                            temp.printPopMoviesUser(movieChoice - 1, dataBase);
                            System.out.println();
                            while (!temp.checkPopNum(movieChoice)) {
                                movieChoice = getMovieChoice(dataBase, temp, choice2);
                            }
                            movies = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a number!");
                        }
                    }
                    while (!movies2) {
                        try {
                            System.out.print("Inquire about another movie (Y/N)?");
                            String replay = choice3.nextLine();
                            if (replay.toUpperCase().trim().equals("N")) {
                                movies2 = true;
                                //menuDone2 = true;
                            } else if (replay.toUpperCase().trim().equals("Y")) {
                                movieChoice = getMovieChoice(dataBase, temp, choice2);

                            } else {
                                System.out.println("Please enter Y or N!");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Please enter Y or N!");
                        }
                    }
                    break;

                case "2":
                    try {
                        String type = "";
                        boolean data;
                        System.out.print("Type T to search by title or S to search by star: ");
                        type = choice.nextLine();
                        while (!type.trim().toUpperCase().equals("T") && !type.trim().toUpperCase().equals("S")) {
                            System.out.println("Please enter T or S");
                            System.out.print("Type T to search by title or S to search by star: ");
                            type = choice.nextLine();
                        }
                        if (type.trim().toUpperCase().equals("T")) {
                            System.out.print("Please enter a movie title: ");
                            String input = choice.nextLine();
                            System.out.println();
                            temp2 = temp.searchTitle(input, dataBase);
                            if (temp.searchTitle(input, dataBase) != null) {
                                temp3.print(temp2);
                            } else System.out.println("Movie does not exist.");
                            System.out.println();
                        } else if (type.trim().toUpperCase().equals("S")) {
                            System.out.print("Please enter a movie star: ");
                            String input = choice.nextLine();
                            System.out.println();
                            temp2 = temp.searchStar(input, dataBase);
                            if (temp.searchStar(input, dataBase) != null) {
                                temp3.print(temp2);
                            } else System.out.println("Movie star does not exist.");
                            System.out.println();
                        }
                    } catch (InputMismatchException e) {
                        System.err.println("Please enter a letter!");
                    }
                    break;

                case "3":
                    menuDone = true;
                    break;
                default:
                    System.out.println("Invalid Selection, must enter number between 1-3!");
                    System.out.println();
                    break;
            }

        }
    }

    /** This method prompts for user input returns their input @param ID index, stuff arraylist of AwardWinningMovie objects */
    private static int getMovieChoice(ArrayList<AwardWinningMovie> dataBase, AwardWinningMovie temp, Scanner choice2) {
        int movieChoice = -1;
        temp.printPopMovies(dataBase);
        System.out.println();
        System.out.print("Please enter the number of the movie you would like to know more about: ");
        movieChoice = choice2.nextInt();
        System.out.println();
        temp.printPopMoviesUser(movieChoice-1,dataBase);
        System.out.println();
        return movieChoice;
    }


}
