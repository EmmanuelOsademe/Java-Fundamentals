package org.example.input_output;

import java.io.*;
import java.util.Scanner;

public class ByteStream {

    private static void readBytes(){
        try{
            byte[] data = new byte[50];
            System.out.println("Enter some characters:");
            System.in.read(data);

            System.out.print("You entered: ");
            for(byte character: data){
                System.out.print((char) character);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void writeBytes(){
        int b;
        b = 'X';

        System.out.write(b);
        System.out.write('\n');
    }

    public static void showFile(String[] fileName){
        int i;
        FileInputStream fin = null;

        // First make sure that the file has been specified
        if(fileName.length != 1){
            System.out.println("Usage: ShowFile File");
            return;
        }

        try{
            fin = new FileInputStream(fileName[0]);
            // Read bytes until EOF is encountered
            do{
                i = fin.read();
                if(i != -1){
                    System.out.print((char) i);
                }
            }while( i != -1);
        }catch(IOException e){
            if(e instanceof FileNotFoundException){
                System.out.println("File not found");
            }else{
                System.out.println("Error reading file");
            }
        }finally {
            try {
                if(fin != null){
                    fin.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void writeData (){
        int i = 10;
        double d = 1023.56;
        boolean b = true;

        try(DataOutputStream dataout = new DataOutputStream(new FileOutputStream("testdata.txt"))){
            System.out.println("Writing " + i);
            dataout.writeInt(i);

            System.out.println("Writing " + d);
            dataout.writeDouble(d);

            System.out.println("Writing " + b);
            dataout.writeBoolean(b);

            System.out.println("Writing " + 12.2 * 7.4);
            dataout.writeDouble(12.2 * 7.4);
        }catch (IOException e){
            System.out.println("Write error");
            return;
        }
    }

    public static void readData(){
        try(DataInputStream dataIn = new DataInputStream(new FileInputStream("testdata"))){
            int i = dataIn.readInt();
            System.out.println("Reading " + i);

            double d = dataIn.readDouble();
            System.out.println("Reading " + d);

            boolean b = dataIn.readBoolean();
            System.out.println("Reading " + b);

            double nextDouble = dataIn.readDouble();
            System.out.println("Reading " + d);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /*
        This method compares two file
     */
    public static void compareFiles(){
        int i = 0; int j = 0;

        try(FileInputStream f1 = new FileInputStream("testdata");
            FileInputStream f2 = new FileInputStream("testdata.txt")
        ){
            do{
                i = f1.read();
                j = f2.read();

                if(i != j)break;
            }while(i != -1 && j != -1);

            if(i != j){
                System.out.println("Files Differ.");
            }else{
                System.out.println("Files are the same.");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void randomAccess(){
        double[] data = {19.4, 10.1, 123.54, 33.0, 87.9, 72.25};
        double d;

        try(RandomAccessFile raf = new RandomAccessFile("random.dat", "rw")){
            // Write values to the file
            for(double num: data){
                raf.writeDouble(num);
            }

            // Now, read back specific values
            raf.seek(0); // Seek to first double
            d = raf.readDouble();
            System.out.println("First value is " + d);

            raf.seek(8); // Seek to second double
            d = raf.readDouble();
            System.out.println("Second value is " + d);

            raf.seek(8 * 3); // Seek to fourth double
            d = raf.readDouble();
            System.out.println("Fourth value is " +d);

            System.out.println();

            // Now read every other value.
            System.out.println("Here is every other value: ");
            for(int i = 0; i < data.length; i++){
                raf.seek(8 * i); // Seek to the ith double
                d = raf.readDouble();
                System.out.print(d + " ");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Reading bytes
        //readBytes();

        // Writing bytes
        //writeBytes();

        // Writing other datatype
        //writeData();

        // Reading other datatypes
        //readData();

        // Comparing files
        //compareFiles();

        // Random Access
        randomAccess();
    }
}
