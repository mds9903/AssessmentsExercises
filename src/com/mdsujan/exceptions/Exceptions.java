package com.mdsujan.exceptions;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exceptions {
// "Write a programme to read a file by providing a file name
// 1. Throw exception if file is not present
// 2. Catch the Exception if file is not present and throw another custom exception
// 3. List file stats - such as word count/line count etc"

    public static void main(String[] args) throws IOException, CustomFileDoesNotExist {
        // a correct path to file
        String path = "/home/sujan/IdeaProjects/AssessmentExercises/src/test.txt";
        // wrong path to a file to test exception
        String pathWrong = "/home/sujan/IdeaProjects/AssessmentExercises/src/wrong.txt";
        try {
            List<StringBuilder> lines = getTextFromFile(path); // list of lines in file
//            List<StringBuilder> lines = getTextFromFile(pathWrong);
            System.out.println("File Contents:\n" + lines);
            // 3. List file stats - such as word count/line count etc"
            System.out.println("word count: " + getWordCount(lines));
            System.out.println("line count: " + lines.size());
        } catch (FileNotFoundException e) {
            // 2. Catch the Exception if file is not present and throw another custom exception
            throw new CustomFileDoesNotExist("Custom Exception: FileDoesNotExists Exception");
        }
    }

    private static int getWordCount(List<StringBuilder> lines) {
        // returns the number of words in a string builder obj
        int count = 0;
        for (StringBuilder line : lines) {
            count += line.toString().split(" ").length;
        }
//        return fileContent.toString().split(" ").length;
        return count;
    }

    private static List<StringBuilder> getTextFromFile(String path) throws FileNotFoundException {
        // returns a string builder obj containing the text contents of a file in given path
        File file = new File(path);
        if (file.exists()) {
            // if file is present
            List<StringBuilder> lines = new ArrayList<>();
//            StringBuilder fileContent = new StringBuilder(); // to store the read content from file
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(new StringBuilder(line));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return lines;
        } else {
            // 1. Throw exception if file is not present
            throw new FileNotFoundException();
        }

    }
}
