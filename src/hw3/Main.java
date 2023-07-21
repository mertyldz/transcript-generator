package hw3;

import hw3.main.CourseGrade;
import hw3.main.Transcript;
import hw3.util.Grade;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Main {
    public static void main(String[] args) {

        // -----Check every constructor if it inserts default values-----

        // -----Check for long course department name-----
//        CourseGrade courseGrade = new CourseGrade("LongText", 201, 3, Grade.A);
//        System.out.println(courseGrade);

        // -----Check for course department name that is undefined-----
//        CourseGrade courseGrade1 = new CourseGrade("NOT", 201, 3, Grade.C);
//        System.out.println(courseGrade1);

        // -----Check for course code between 100 and 599-----
//        CourseGrade courseGrade2 = new CourseGrade("COMP", 99, 3, Grade.C);
//        System.out.println(courseGrade2);
//        CourseGrade courseGrade3 = new CourseGrade("COMP", 601, 3, Grade.B);
//        System.out.println(courseGrade3);


        // -----Check for course grade either 3 or 4-----
//        CourseGrade courseGrade4 = new CourseGrade("COMP", 601, 2, Grade.D);
//        System.out.println(courseGrade4);
//        CourseGrade courseGrade5 = new CourseGrade("COMP", 601, 5, Grade.F);
//        System.out.println(courseGrade5);

        // -----Check if rounding works-----
//        CourseGrade courseGrade6 = new CourseGrade("ECE", 401);
//        courseGrade6.setGradeTaken(1.4);
//        System.out.println(courseGrade6);

//        CourseGrade courseGrade7 = new CourseGrade("ME");
//        courseGrade7.setGradeTaken(1.5);
//        System.out.println(courseGrade7);

        // Check Transcript
        CourseGrade calculus = new CourseGrade("MATH", 101, 3, Grade.A);
        CourseGrade oop = new CourseGrade("CENG", 102, 4, Grade.B);
        CourseGrade cProgramming = new CourseGrade("ECE", 201, 4, Grade.D);
        CourseGrade dataScience = new CourseGrade("COMP", 302, 3, Grade.B);
        Transcript transcript = new Transcript(20150245);

        transcript.addCourseTaken(calculus);
        transcript.addCourseTaken(oop);
        transcript.addCourseTaken(cProgramming);
        transcript.addCourseTaken(dataScience);
        System.out.println(transcript);

    }
}