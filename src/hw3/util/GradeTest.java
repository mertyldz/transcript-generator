package hw3.util;

public class GradeTest {

    public static void main(String[] args) {

        // Enhanced for loop to control Grade Enum and its toString method.
        for(Grade grade : Grade.values()){
            System.out.println(grade);
        }
    }
}
