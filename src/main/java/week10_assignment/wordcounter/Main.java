package week10_assignment.wordcounter;

import java.io.*;

public class Main {

    public static String wordsCounter(String fileName, String searchWord){
        int counter = 0;
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){

            while((line = br.readLine()) != null){
                String[] strs = line.split(" ");
                for(String word: strs){
                    if(word.equalsIgnoreCase(searchWord)){
                        counter++;
                    }
                }
            }
        }catch (IOException  | NullPointerException e){
            System.out.println("I/O Exception occurred: " + e);
            e.printStackTrace();
        }
        return (counter + " occurrences of '" + searchWord + "' were found");
    }

    public static void main(String[] args){
       System.out.println(wordsCounter("test.txt", "hello"));
    }
}
