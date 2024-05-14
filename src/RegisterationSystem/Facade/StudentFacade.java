package RegisterationSystem.Facade;

import RegisterationSystem.Course.Course;
import RegisterationSystem.Course.CourseManager;
import RegisterationSystem.Notification;
import RegisterationSystem.Observer;
import RegisterationSystem.RegistrationManage;
import RegisterationSystem.User;

import java.util.*;

public class StudentFacade implements UserFacade, Observer{
    private RegistrationManage registrationManage;
    private CourseManager courseManager;
    private User student;
    private List<Course> shoppingCart;
    private Set<Course> courses;

    public StudentFacade(RegistrationManage registrationManage, CourseManager courseManager, User student) {
        this.registrationManage = registrationManage;
        this.courseManager = courseManager;
        this.student = student;
        this.shoppingCart = new ArrayList<>();
        this.courses = new HashSet<>();
    }
    public Map<String, Course> getCourses() {
        courseManager.printCourses();
       return courseManager.getCourses();
    }

    public void unregisterCourse(Course course) {
        course.removeFromCourse(student);
    }

    public Set<Course> myCourses() {
        System.out.println("my courses:");
        return courses;
    }

    public void addToShoppingCart(Course course) {
        shoppingCart.add(course);
    }

    public void removeFromShoppingCart(Course course) {
        shoppingCart.remove(course);
    }

    public void viewShoppingCart() {
        // Print the shopping cart
        for (Course course : shoppingCart) {
            System.out.println(course.getName());
        }
    }

    public void checkout() {
        for (Course course : shoppingCart) {
            courseManager.registerUserToCourse(course.getName(), student);
        }
        shoppingCart.clear();
    }

    public void requestNotificationForCourse(Course course) {
        course.registerObserver((Observer) this);
    }

    public void cancelNotificationForCourse(Course course) {
        course.removeObserver((Observer) this);
    }

    @Override
    public void update(Notification notification) {
        System.out.println("Student " + student.getUserName() + " with ID " + student.getID() + " received notification: " + notification.getMessage());
    }
}