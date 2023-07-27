package hw3.main;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class GenerateTranscript {

    public void takeInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number of classes and grades: ");
        int numberOfCourse = scanner.nextInt();
        System.out.println("Enter Student Id:");
        int studentId = scanner.nextInt();
        Transcript transcript = new Transcript(studentId);

        for (int i = 0; i < numberOfCourse; i++) {
            System.out.print("Enter Department: ");
            String courseDepartment = scanner.next();
            System.out.print("Enter Course Code: ");
            int courseCode = scanner.nextInt();
            System.out.print("Enter Credit: ");
            int credit = scanner.nextInt();
            System.out.print("Enter Grade: ");
            double grade = scanner.nextDouble();
            CourseGrade courseGrade = new CourseGrade(courseDepartment, courseCode, credit);
            courseGrade.setGradeTaken(grade);

            transcript.addCourseTaken(courseGrade);

        }
        System.out.println(transcript);
    }

    public void takeInputFromFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filename: ");
        String fileName = scanner.next();

        // In order to get absolute path dynamically
        File currentDir = new File (".");
        String pathOfFile = currentDir.getCanonicalPath()+ "\\" + fileName;

        try {
            Path filePath = Paths.get(pathOfFile);
            List<String> myFile = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            Transcript transcript = new Transcript(Integer.parseInt(myFile.get(0)));

            for (int i = 1; i < myFile.size(); i++) {
                String row = myFile.get(i);
                String[] rowValues = row.split(" ");
                CourseGrade courseGrade = new CourseGrade(
                        rowValues[0],
                        Integer.parseInt(rowValues[1]),
                        Integer.parseInt(rowValues[2]));
                courseGrade.setGradeTaken(Double.parseDouble(rowValues[3]));

                transcript.addCourseTaken(courseGrade);
            }
            System.out.println(transcript);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        GenerateTranscript generateTranscript = new GenerateTranscript();
//        generateTranscript.takeInputFromUser();
        generateTranscript.takeInputFromFile();

    }
}
