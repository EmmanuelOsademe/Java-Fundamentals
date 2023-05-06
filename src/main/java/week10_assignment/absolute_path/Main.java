package week10_assignment.absolute_path;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void fileWriter(){
        try{
            System.out.print("Enter the filepath: ");
            String filePath = br.readLine();

            System.out.println("Enter the texts to write to file.\nTo quit, enter 'end'");
            String inputString;
            try(FileWriter fw = new FileWriter(filePath)){
                do{
                    System.out.print(">");
                    inputString = br.readLine();
                    if(inputString.equalsIgnoreCase("end")) break;
                    inputString = inputString + " ";
                    fw.write(inputString);
                }while(!inputString.equalsIgnoreCase("end"));
            }catch(IOException e){
                System.out.println("I/O exception occurred " + e);;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        fileWriter();
    }
}
