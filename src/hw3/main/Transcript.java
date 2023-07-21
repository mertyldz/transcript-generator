package hw3.main;

import java.util.ArrayList;
import java.util.List;

public class Transcript {
    private int studentId;
    private double gpa;
    private List<CourseGrade> courseGradeList;

    public Transcript(int studentId) {
        this.studentId = studentId;
        this.gpa = 0.0;
        this.courseGradeList = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.err.println("Invalid gpa has been tried to inserted!");
        }
    }

    public List<CourseGrade> getCourseGradeList() {
        return courseGradeList;
    }

    public void setCourseGradeList(List<CourseGrade> courseGradeList) {
        this.courseGradeList = courseGradeList;
    }

    public void addCourseTaken(CourseGrade courseGrade) {
        if (this.courseGradeList != null) {
            this.courseGradeList.add(courseGrade);
        } else {
            System.err.println("Student course grades are empty!");
        }

        calculateGPA();
    }

    public void calculateGPA() {
        double weightedGrade = 0;
        int totalCourseCredit = 0;
        for (CourseGrade courseGrade : this.courseGradeList) {
            totalCourseCredit += courseGrade.getCourseCredit();
            weightedGrade += courseGrade.getCourseCredit() * courseGrade.getGradeTaken().getNumericValue();
        }
        // to reduce the number of digits after the comma
        this.gpa = (double) Math.round(weightedGrade / totalCourseCredit * 100) / 100;
    }

    @Override
    public String toString() {
        StringBuilder transcriptString = new StringBuilder("Student ID: " + this.studentId + "\n");

        for (CourseGrade courseGrade : courseGradeList) {
            transcriptString.append("Department: ").append(courseGrade.getCourseDepartment()).
                    append(" CourseCode: ").append(courseGrade.getCourseCode()).
                    append(" Credit: ").append(courseGrade.getCourseCredit()).
                    append(" Grade: ").append(courseGrade.getGradeTaken().getStringValue()).
                    append("\n");
        }

        transcriptString.append("GPA: ").append(this.gpa);
        return transcriptString.toString();
    }
}
