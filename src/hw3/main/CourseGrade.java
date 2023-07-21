package hw3.main;

import hw3.util.Grade;

import java.util.Arrays;

public class CourseGrade {
    private String courseDepartment;
    private int courseCode;
    private int courseCredit;
    private Grade gradeTaken;
    private String[] courseDepartmentArray = {"CENG", "COMP", "ECE", "ME", "MATH"}; // set method will check here.

    // Constructor with missing parameters will use default values for that field.
    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this(courseDepartment, courseCode, courseCredit, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        this(courseDepartment, courseCode, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment) {
        this(courseDepartment, 100, 4, Grade.F);
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(String courseDepartment) {
        if (courseDepartment.length() > 4) {
            System.err.println("Letter count of course department can not be bigger than 4 letter!");
            this.courseDepartment = "CENG";
        } else {
            if (Arrays.asList(courseDepartmentArray).contains(courseDepartment)) {
                this.courseDepartment = courseDepartment;
            } else {
                System.err.println("Course department does not exists!");
                this.courseDepartment = "CENG";
            }
        }
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        if (courseCode > 99 && courseCode < 600) {
            this.courseCode = courseCode;
        } else {
            System.err.println("Course code should be between 100 and 599!");
            this.courseCode = 100;
        }
    }

    public double getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        if (courseCredit == 3 || courseCredit == 4) {
            this.courseCredit = courseCredit;
        } else {
            System.err.println("Course credit should be either 3 or 4!");
            this.courseCredit = 4;
        }
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    public void setGradeTaken(double val) {
        if (val >= 0.0 && val <= 4.0) {
            double gradeForEnum = Math.round(val);
            for (Grade g : Grade.values()) {
                if (g.getNumericValue() == gradeForEnum) {
                    this.gradeTaken = g;
                    break;
                }
            }
        } else {
            System.err.println("Invalid grade entry!");
            this.gradeTaken = Grade.F;
        }
    }

    public void setGradeTaken(Grade g) {
        this.gradeTaken = g;
    }

    public String[] getCourseDepartmentArray() {
        return courseDepartmentArray;
    }

    public void setCourseDepartmentArray(String[] courseDepartmentArray) {
        this.courseDepartmentArray = courseDepartmentArray;
    }

    @Override
    public String toString() {
        return ("Department: " + this.courseDepartment + " CourseCode: " + this.courseCode + " Credit: " +
                this.courseCredit + " Grade: " + this.gradeTaken.getStringValue());
    }
}
