import java.util.Objects;

public class Student implements Users{
    private String name;
    private String ID;

    public Student(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    @Override
    public String getUserName() {
        return name;
    }
    public String getID() {
        return ID;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return ID.equals(student.ID);
    }
    public void registerCourse(CourseManager courseManager, String courseName) {
        courseManager.registerUser(courseName, ID);
    }
    public void unregisterCourse(CourseManager courseManager, String courseName) {
        courseManager.unregisterUser(courseName, ID);
    }
    @Override
    public void update(String notification) {

    }
}
