package edu.chronicles.display.views;

import edu.chronicles.display.dtos.BookCreateDto;

import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {

    private static final String ANSI_RED = "\u001b[31m";
    private static final String ANSI_CYAN = "\u001b[36m";
    private static final String ANSI_RESET = "\u001b[0m";

    private final Scanner scanner = new Scanner(System.in);

    public void welcome(){
        System.out.println("""
                
                --- WELCOME TO CHRONICLES ---
                
                
                """);
    }

    public void showMenu(){
        System.out.println("""
                Choose what you want to do:
                1. Create new book entry
                ...
                
                0. Exit
                """);
    }

    public int readOption() throws InputMismatchException {
        System.out.print("Elige opción: ");
        return scanner.nextInt();
    }

    public void showError(String error){
        System.out.println(ANSI_RED + "Error: " + error + ANSI_RESET);
    }

    public String askForParam(String s) {
        System.out.print(s);
        return scanner.nextLine();
    }

    public BookCreateDto askForBookData(){
        String title =  askForParam("Introduce el titulo del libro: ");
        String author =  askForParam("Introduce el autor del libro: ");
        int numPages =  Integer.parseInt(askForParam("Introduce el número de páginas del libro: "));
        Year releaseDate = Year.of(Integer.parseInt(askForParam("Introduce la fecha de salida del libro: ")));
        boolean completed = Boolean.parseBoolean(askForParam("¿Lo has terminado? (0--> no, 1--> si)"));
        int rating =  Integer.parseInt(askForParam("Introduce tu valoración: "));

        return new BookCreateDto(title, author, numPages, releaseDate, completed, rating);
    }

    public void showSuccessfullOutput(String s) {
        System.out.println(ANSI_CYAN + "Success: " + s + ANSI_RESET);
    }
}
