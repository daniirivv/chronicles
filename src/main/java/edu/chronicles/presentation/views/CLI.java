package edu.chronicles.presentation.views;

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

    public void showSuccessfullOutput(String s) {
        System.out.println(ANSI_CYAN + "Success: " + s + ANSI_RESET);
    }
}
