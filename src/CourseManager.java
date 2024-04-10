import java.util.HashMap;
import java.util.Map;

public class CourseManager {

    private Map<String, Course> courses;

    public CourseManager() {
        this.courses = new HashMap<>();
    }

    public void createCourse(String type ,String name, int capacity) {
        if (courses.containsKey(name)) {
            System.out.println("Course " + name + " already exists");
        } else {
            Course course = Course.createCourse(type, name, capacity);
            courses.put(name, course);
            System.out.println("Course " + name + " created");
        }

    }

    public void registerUser(String courseName, String userID) {
        if (courses.containsKey(courseName)) {
            Course course = courses.get(courseName);
            Users user = new Student(null, userID); // Create a new user with the same ID
            if (course.addUser(user)) {
                course.removeObserver(user);
                System.out.println("User with ID " + userID + " registered in course " + courseName);
            } else {
                course.registerObserver(user);
                System.out.println("User with ID " + userID + " added to waitlist for course " + courseName);
            }
        } else {
            System.out.println("Course " + courseName + " does not exist");

        }

    }

    public void unregisterUser(String courseName, String userId) {
        if (courses.containsKey(courseName)) {
            Course course = courses.get(courseName);
            Users userToRemove = new Student(null, userId); // Create a new user with the same ID
            if (course.getUsers().contains(userToRemove)) {
                course.removeFromCourse(userId);
                System.out.println("User with ID " + userId + " unregistered from course " + courseName);
                course.notifyObservers();
            } else {
                System.out.println("User with ID " + userId + " is not registered in course " + courseName);
            }
        } else {
            System.out.println("Course " + courseName + " does not exist");
        }
    }


    // Getters and setters
    public Map<String, Course> getCourses() {
        return courses;
    }

    public void setCourses(Map<String, Course> courses) {
        this.courses = courses;
    }


}
// Path: src/Course.java
