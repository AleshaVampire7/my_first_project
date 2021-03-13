package Entities;
//Object of our app
public class Grade {
    private int id;
    private String course;
    private int grade;
    private int lessonnumber;

    public Grade(int id, String course, int grade, int lessonnumber) {
        this.id = id;
        this.course = course;
        this.grade = grade;
        this.lessonnumber = lessonnumber;
    }

    public Grade(String course, int grade, int lessonnumber) {
        this.course = course;
        this.grade = grade;
        this.lessonnumber = lessonnumber;
    }

    public Grade(int id, String course, int grade) {
        this.course=course;
        this.grade=grade;
        this.id=id;
    }

    public Grade(String course, int grade) {
        this.course=course;
        this.grade=grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setLessonnumber(int lessonnumber) {
        this.lessonnumber = lessonnumber;
    }

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    public int getLessonnumber() {
        return lessonnumber;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", course='" + course + '\'' +
                ", grade=" + grade +
                ", lessonnumber=" + lessonnumber +
                '}';
    }
}
