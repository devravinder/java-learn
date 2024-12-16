package com.paravar.practice.practice3.files;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TestFiles {

    // Test methods
    public static void main(String[] args) {

        /*
         We are using try() with resource...so the resource will get close  automatically.
           else we have to do manually

         Note:-
           InputStream (OutputStream) are abstract class
               FileInputStream(FileOutputStream) are implementation


         Note:-
           java.io = part of Java 1.0 - blocking in nature
           java.nio = part of java 1.4 - non-blocking in nature // more useful



        * */

        /*
         Readers:-
           - FileInputStream:
                 - reads data in raw (binary) format
                 - suitable for binary files ( image, videos )

           - BufferedInputStream:
                 - Wraps an InputStream (e.g., FileInputStream) for efficient reading
                              of binary files via buffering.

                - Buffer means a temporary storage area for data.
                     - used to reduce the number of system calls to the disk.
                     - collects some chunk of data from InputStream & gives

                - reads data in raw (binary) format
                - suitable for large files ( image, videos )


            - FileReader:
                 - Reads character data from files.
                     Converts bytes into characters using the default charset.

                 - it is special case of InputStream with char converter
                 - Efficient for text files; no buffering.
                 - useful for small files


            - BufferedReader:
                 - Wraps a Reader (e.g., FileReader) for efficient reading of character files.
                 - it buffers data from FileReader
                 - useful for large files

            - Scanner:
                - Reads and parses tokens, such as words or numbers, from input (e.g., file).
                - special type of text reader with parsing
                - it can even read from System.in ( console )


       Writers:-

           - FileOutputStream
           - BufferedOutputStream:
           - FileWriter
           - BufferedWriter

           these above are opposite to their counter readers


           - PrintWriter:-
              - provides methods to write formatted text to an output stream or file
              - special type of writer with formatting
                 - like System.out.printf()
                 - we can even write System.out  ( console )




      RandomAccessFile:-
        - It is special type of File Descriptor
        - It can read & write a file a random ( given ) posting

        * */

        String newFile = "./src/files/newFile.txt";
        String fileWriter = "./src/files/fileWriter.txt";
        String bufferedWriter = "./src/files/bufferedWriter.txt";
        String fileOutputStream = "./src/files/fileOutputStream.txt";
        String bufferedOutputStream = "./src/files/bufferedOutputStream.txt";
        String largeFile = "./src/files/MOCK_DATA.csv";

        // Demonstrate different methods
        System.out.println("======create file=====");
        createFile(newFile);


        System.out.println("=======File Writer=========");
        writeFileUsingFileWriter(fileWriter);
        System.out.println("========File Reader=====");
        readFileUsingFileReader(fileWriter);


        System.out.println("=========== Buffered Writer=========");
        writeFileUsingBufferedWriter(bufferedWriter);
        System.out.println("====== Buffered Reader ======");
        readFileUsingBufferedReader(bufferedWriter);


        System.out.println("========== File Output Stream =======");
        writeFileUsingFileOutputStream(fileOutputStream);
        System.out.println("=========== File Input Stream=======");
        readFileUsingFileInputStream(fileOutputStream);

        System.out.println("======== Buffered Output Stream ======== ");
        writeFileUsingBufferedOutputStream(bufferedOutputStream);
        System.out.println("========== Buffered Input Stream =======");
        readFileUsingBufferedInputStream(bufferedOutputStream);

        System.out.println("======== copy using stream========");
        copyFileUsingStreams(largeFile,  largeFile+"_copy.csv");

        System.out.println("======== copy using buffered stream ======");
        copyLargeFileUsingBufferedStreams(largeFile, largeFile+"_copy_buffered.csv");

        System.out.println("======== copy nio ==========");
        copyFileUsingNIO(largeFile,  largeFile+"_nio_copy.csv");


        System.out.println("======= reverse by line ==========");
        reverseFileLineByLine(largeFile,  largeFile+"_reverse_line.csv");

        System.out.println("========reverse by char ===========");
        reverseFileCharacterByCharacter(largeFile, largeFile+"_reverse_char.csv");

        System.out.println("========== reverse large file by line ");
        /*
        *  Important
        *
        * */
        reverseLargeFileLineByLine(largeFile,  largeFile+"_reverse_line_large.csv");
    }

    public static void createFile(String path) {
        // we can create in many ways

        try {
            Path filePath = Paths.get(path);
            if (Files.exists(filePath))
                System.out.println(" file " + path + " already exists");
            else
                Files.createFile(filePath);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        /*
        try (PrintWriter writer = new PrintWriter(path)){
            writer.println("hello");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        */

    }

    // 5. Write file using FileWriter
    public static void writeFileUsingFileWriter(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Hello World\n");
            writer.write("Good to see\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 1. Read file using FileReader
    public static void readFileUsingFileReader(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character); // Character by character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileUsingBufferedWriter(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("BufferedWriter 1\n");
            writer.write("BufferedWriter 2\n");
            writer.newLine();
            writer.write(" after empty line BufferedWriter 3\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. Read file using BufferedReader
    public static void readFileUsingBufferedReader(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Line by line
            }
            System.out.println("File read using BufferedReader.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileUsingFileOutputStream(String path) {
        try (FileOutputStream fos = new FileOutputStream(path, true)) {
            fos.write("\nAppending FileOutputStream 1 \n".getBytes());
            fos.write("\nAppending FileOutputStream 2 \n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. Read file using FileInputStream
    public static void readFileUsingFileInputStream(String filePath) {
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            int byteData;
            while ((byteData = inputStream.read()) != -1) {
                System.out.print((char) byteData); // Byte by byte
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileUsingBufferedOutputStream(String filePath) {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath))) {

            outputStream.write(" BufferedOutputStream 1\n".getBytes());
            outputStream.write(" BufferedOutputStream 2\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 4. Read file using BufferedInputStream
    public static void readFileUsingBufferedInputStream(String filePath) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath))) {

            /*
            // this is slow to many system calls

            int byteData;
            while ((byteData = inputStream.read()) != -1) {
                System.out.print((char) byteData); // Byte by byte
            }
            */


            // Imp
            byte[] buffer = new byte[1024]; // Buffer size
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, bytesRead));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 6. Write file using BufferedWriter

    // 7. Copy file using File Streams
    public static void copyFileUsingStreams(String sourcePath, String destinationPath) {
        try (FileInputStream in = new FileInputStream(sourcePath);
             FileOutputStream out = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[1024]; // Buffer size
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 9. Copy large file using Buffered Streams
    public static void copyLargeFileUsingBufferedStreams(String sourcePath, String destinationPath) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourcePath));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destinationPath))) {

            byte[] buffer = new byte[8192]; // Larger buffer for large files
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 8. Copy file using NIO
    public static void copyFileUsingNIO(String sourcePath, String destinationPath) {
        try {
            Files.copy(Paths.get(sourcePath), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied using NIO.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 10. Reverse file content line-by-line
    public static void reverseFileLineByLine(String sourcePath, String destinationPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath))) {

            List<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            for (int i = lines.size() - 1; i >= 0; i--) {
                writer.write(lines.get(i));
                writer.newLine();
            }
            System.out.println("File reversed line-by-line.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 11. Reverse file character-by-character
    public static void reverseFileCharacterByCharacter(String sourcePath, String destinationPath) {
        try (RandomAccessFile inputFile = new RandomAccessFile(sourcePath, "r");
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath))) {

            long fileLength = inputFile.length();
            int bufferSize = 1024; // Size of the buffer (1024 bytes)
            byte[] buffer = new byte[bufferSize];

            // Read the file in chunks of bufferSize
            for (long i = fileLength - 1; i >= 0; i -= bufferSize) {
                int bytesRead = (int) Math.min(bufferSize, fileLength - i); // Adjust the last chunk size
                inputFile.seek(i); // Set the file pointer to the appropriate position
                inputFile.readFully(buffer, 0, bytesRead); // Read bytes into the buffer

                // Reverse the buffer and write it to the output file
                for (int j = bytesRead - 1; j >= 0; j--) {
                    writer.write((char) buffer[j]); // Write byte as char
                }
            }

            System.out.println("File reversed character-by-character.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reverseLargeFileLineByLine(String sourcePath, String destinationPath) {
        try (RandomAccessFile inputFile = new RandomAccessFile(sourcePath, "r");
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath))) {

            long fileLength = inputFile.length();
            int bufferSize = 1024; // Buffer size (1 KB)
            byte[] buffer = new byte[bufferSize];
            String incompleteLine = "";


            long currentPostion = fileLength - 1;

            while (currentPostion > 1) {
                int bytesToRead = (int) Math.min(bufferSize, currentPostion);
                currentPostion -= bytesToRead;
                inputFile.seek(currentPostion); // Set the file pointer
                inputFile.readFully(buffer, 0, bytesToRead);

                String data =  new String(buffer, 0, bytesToRead) + incompleteLine;

                String[] lines = data.split("\n");
                incompleteLine = lines[0];

                /*
                 // writing all the lines at once
                String[] properLines = new String[lines.length - 1];

                int i = 1, j=properLines.length-1;
                while(j>=0){
                    properLines[j]=lines[i];
                    i++;
                    j--;
                }
                writer.write(String.join("\n", properLines));
                writer.newLine();

                 */
                // writing line by line
                for (int i = lines.length - 1; i > 0; i--) {
                    writer.write(lines[i]);
                    writer.newLine();
                }
            }
            writer.write(incompleteLine);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
