package RegisterationSystem.Course;

import RegisterationSystem.*;

import java.util.HashMap;
import java.util.Map;

public class CourseManager { // Singleton class

    private Map<String, Course> courses; //stores the flyweights

    private static final CourseManager INSTANCE = new CourseManager();

    public static CourseManager getInstance() {
        return INSTANCE;
    }

    private CourseManager() {
        this.courses = new HashMap<>();
    }

    public Course createCourse(String type, String name, int capacity, int ID, Teacher teacher) {
        if (courses.containsKey(name)) {
            System.out.println(name + " already exists");
            return courses.get(name);

        } else {
            Course course = Course.createCourse(type, name, capacity, ID, teacher);
            courses.put(name, course);
            System.out.println(name + " created");
            return course;
        }

    }
    public void deleteCourse(String courseName) {
        courses.remove(courseName);
        System.out.println(courseName + " deleted");
    }

    public boolean registerUserToCourse(String courseName, User user) {
        Course course = getCourse(courseName, user);
        if (course.isFull()) {
            System.out.println(courseName + " is full");
            return false;
        }
        course.addUser(user);
        System.out.println( user.getUserName() + " registered for course " + courseName);
        return true;
    }

    public boolean unregisterUser(String courseName, User user) {
        Course course = getCourse(courseName, user);
        course.removeFromCourse(user);
        System.out.println( user.getUserName() + " unregistered from course " + courseName);
        return true;
    }

    public Map<String, Course> getCourses() {
        return courses;
    }
    private Course getCourse(String courseName,User user) {
        RegistrationManage registrationManage = RegistrationManage.getInstance();
        if (!registrationManage.isLogin(user)) {
            throw new IllegalArgumentException( user.getUserName() + " is not logged in");
        }
        Course course =courses.get(courseName);
        if (course == null) {
            throw new IllegalArgumentException( courseName + " does not exist");
        }
        return course;
    }

    public void registerToWaitlist(String courseName, Student student) {
        Course course = getCourse(courseName, student);
        // checking if user is already registered for the course
        if (course.isUserRegistered(student)) {
            throw new IllegalArgumentException(student.getUserName() + " is already registered for course " + courseName);
        }
        course.registerObserver((Observer) student);
        System.out.println(student.getUserName() + " registered for waitlist of course " + courseName);
    }

    public void printCourses() {
        for (Map.Entry<String, Course> entry : courses.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getCapacity() + " " + entry.getValue().getUserCount());
        }
    }
}

