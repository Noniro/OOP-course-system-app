public class Teacher {
    private String name;
    private String ID;

    private CourseManager courseManager;

    public Teacher(String name, String teacher_ID , CourseManager courseManager) {
        this.name = name;
        this.ID = ID;
        this.courseManager = courseManager;
    }
    public String getName() {
        return name;
    }
    public String get_ID() {
        return ID;
    }
    public void createCourse(String type, String coursename, int capacity) {
        courseManager.createCourse(type, coursename, capacity);
    }




}


