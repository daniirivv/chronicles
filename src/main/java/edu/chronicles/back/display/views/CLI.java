package edu.chronicles.back.display.views;

import edu.chronicles.back.display.dtos.BookDto;

import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {

    private static final String ANSI_RED = "\u001b[31m";
    private static final String ANSI_CYAN = "\u001b[36m";
    private static final String ANSI_RESET = "\u001b[0m";

    private final Scanner in = new Scanner(System.in);

    public void welcome(){
        System.out.println("""
                
                --- WELCOME TO CHRONICLES ---
                
                
                """);
    }

    public void showMenu(){
        System.out.println("""
                Choose what you want to do:
                1. Create new book entry
                2. Retrieve an existing book entry
                3. Update an existing book entry
                4. Delete an existing book entry
                ...
                
                0. Exit
                """);
    }

    public int readOption() throws InputMismatchException {
        int input = 0;
        try{
            input = Integer.parseInt(askForInput("Elige opción: "));
        } catch(Exception e){
            showError("Opción no válida.");
        }

        return input;
    }

    public String askForInput(String s) {
        System.out.print(s);
        return in.nextLine();
    }

    public void showSuccess(String s) {
        System.out.println(ANSI_CYAN + "Success: " + s + ANSI_RESET + '\n');
    }

    public void showError(String error){
        System.out.println(ANSI_RED + "Error: " + error + ANSI_RESET + '\n');
    }

    public BookDto askForBookCreationData(){
        String title =  askForInput("Introduce el titulo del libro: ");
        BookDto dto = askForAllBookFieldsExceptTitle();

        return new BookDto.Builder()
                .title(title)
                .author(dto.author())
                .pages(dto.pages())
                .releaseDate(dto.releaseDate())
                .completed(dto.completed())
                .rating(dto.rating())
                .build();
    }

    private BookDto askForAllBookFieldsExceptTitle() {
        String author =  askForInput("Introduce el autor del libro: ");
        int pages =  Integer.parseInt(askForInput("Introduce el número de páginas del libro: "));
        Year releaseDate = Year.of(Integer.parseInt(askForInput("Introduce la fecha de salida del libro: ")));
        boolean completed = Boolean.parseBoolean(askForInput("¿Lo has terminado? (true, false): "));
        Integer rating = null;
        if (completed){
            rating =  Integer.parseInt(askForInput("Introduce tu valoración (1-5): "));
        }

        return BookDto.builder()
                .author(author)
                .pages(pages)
                .releaseDate(releaseDate)
                .completed(completed)
                .rating(rating)
                .build();
    }

    public BookDto askForUpdatedBookData() {
        return askForAllBookFieldsExceptTitle();
    }
    
    public void printBookEntry(BookDto bookEntry){
        System.out.println(bookEntry.toString());
    }
    
}
