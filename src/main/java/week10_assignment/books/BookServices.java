package week10_assignment.books;

import java.io.*;
import java.util.Scanner;

public class BookServices {
    Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

    public static void main(String[] args){
        BookServices bs = new BookServices();
        bs.run();
    }
    public void createBook(){
        try{
            System.out.println("Enter the book's details below");
            System.out.print("Book's Name: ");
            String bookName = br.readLine();

            System.out.print("Book's Author: ");
            String bookAuthor = br.readLine();

            System.out.print("Book's Price: ");
            Double price = validateDouble(br.readLine());

            Book newBook = new Book(bookName, bookAuthor, price);
            writeBookToFile(newBook);
            System.out.println("Your details have been saved");
        }catch (IOException e){
            System.out.println("IO Exception " + e);
        }
    }

    public void displayBookInfo(){
        try(BufferedReader br = new BufferedReader(new FileReader("books.txt"))){
            String str;
            while((str = br.readLine()) != null){
                System.out.println(str);
            }

        }catch(IOException exc){
            System.out.println("IO Error: " + exc);
        }
    }

    public void run(){
        System.out.println("To create book, enter 1\nTo display book details, enter 2\nTo exit enter 3");
        System.out.print(">>");
        int input = validateInput(sc.next());

        switch (input){
            case 1:
                createBook();
                break;
            case 2:
                displayBookInfo();
                break;
            case 3:
                System.exit(0);
            default:
                run();
        }
    }

    public int validateInput(String input){
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException exc){
            System.out.println("Expecting a number. Please try again");
            return validateInput(sc.next());
        }
    }


    public Double validateDouble(String input){
        try{
            return Double.parseDouble(input);
        }catch (NumberFormatException exc){
            System.out.println("Price must be a number");
            System.out.print("Enter another price: ");
            return validateDouble(sc.next());
        }
    }

    public void writeBookToFile(Book book){
        try(FileWriter fw = new FileWriter("books.txt", true)){
            fw.write("Book name: ");
            fw.write(book.getBookName());
            fw.write(", Book author: ");
            fw.write(book.getAuthorName());
            fw.write(", Book price: ");
            fw.write(String.valueOf(book.getPrice()));
        }catch(IOException exc){
            System.out.println("I/O Error occurred: " + exc);
        }
    }
}
