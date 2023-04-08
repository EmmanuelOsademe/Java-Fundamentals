package org.example.input_output;

import java.io.*;

public class CharacterStream {

    public static void readCharacters(){
        try{
            char c;
            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

            System.out.print("Enter characters, period to quit: ");

            // Read Characters
            do {
                c = (char) br.read();
                System.out.println(c);
            }while(c != '.');
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readStrings(){
        try{
            String str;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter lines of text.");
            System.out.println("Enter 'stop' to quit.");

            //str = br.readLine();
            //System.out.println(str);

            do {
                str = br.readLine();
                System.out.println(str);
            }while(!str.equalsIgnoreCase("stop"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void printWriter(){
        PrintWriter pw = new PrintWriter(System.out, true);
        int i = 10;
        double d = 123.65;

        pw.println("Using a PrintWriter");
        pw.println(i);
        pw.println(d);

        pw.println(i + " + " + d + " is: " + (i+d));
    }

    public static void fileWriter(String fileName){
        String str;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter text('stop' to quit): ");

        try(FileWriter fw = new FileWriter(fileName)){
            do{
                System.out.print("> ");
                str = br.readLine();

                if(str.equalsIgnoreCase("stop")) break;

                str = str + "\n";
                System.out.println(str);
                fw.write(str);
            }while(!str.equalsIgnoreCase("stop"));
        }catch(IOException e){
            System.out.println("I/O Error: " + e);
        }
    }

    public static void fileReader(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String str;
            while((str = br.readLine()) != null){
                System.out.println(str);
            }
        }catch(IOException e){
            System.out.println("IO Error: " + e);
        }
    }

    public static void averageNumbers(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader((System.in)))){
            String str;
            int n;
            double sum = 0.0;
            double avg;
            double t;

            System.out.print("How many numbers will be averaged: ");
            str = br.readLine();
            try{
                n = Integer.parseInt(str);
            }catch(NumberFormatException e){
                System.out.println("Invalid format");
                n = 0;
            }

            System.out.println("Enter " + n + " values: ");
            for(int i = 0; i < n; i++){
                System.out.print("> ");
                str = br.readLine();

                try{
                    t = Double.parseDouble(str);
                }catch(NumberFormatException e){
                    System.out.println("Invalid format");
                    t = 0.0;
                }

                sum += t;
            }

            avg = sum/n;
            System.out.println("Average is: " + avg);
        }catch(IOException e){
            System.out.println("I/O Error: " + e);
        }
    }

    public static void main(String[] args){
        // Calling readCharacters
        //readCharacters();

        // Calling readStrings
        //readStrings();

        // Calling printWriter
        //printWriter();

        // Calling the fileWriter
        //fileWriter("test.txt");

        // Calling fileReader
        //fileReader("test.txt");

        // Calling average
        averageNumbers();
    }
}
