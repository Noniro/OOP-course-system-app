package RegisterationSystem;

import RegisterationSystem.Course.Course;
import RegisterationSystem.Course.CourseManager;
import RegisterationSystem.Facade.StudentFacade;
import RegisterationSystem.Facade.TeacherFacade;
import RegisterationSystem.Facade.UserFacade;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create Teacher
        Teacher teacher1 = new Lecturer("Noam", "1234", "1234");
        Teacher teacher2 = new Teacher("Noy", "12345", "12345");
        Teacher teacher3 = new Teacher("Niko", "123456", "12345");
        //create RegistrationManage
        RegistrationManage registrationManage = RegistrationManage.getInstance();
        //register Teacher
        registrationManage.registerUser(teacher1);
        registrationManage.registerUser(teacher2);
        registrationManage.registerUser(teacher3);
        //login Teacher
        TeacherFacade teacher1facade =(TeacherFacade) registrationManage.login("1234", "1234");
        TeacherFacade teacher2facade =(TeacherFacade) registrationManage.login("12345", "12345");
        TeacherFacade teacher3facade =(TeacherFacade) registrationManage.login("123456", "12345");
        //create CourseManager
        CourseManager courseManager = CourseManager.getInstance();
        //create Course
        teacher1facade.createCourse("must", "Math", 1, 20);
        teacher2facade.createCourse("must", "History", 2, 10);
        teacher3facade.createCourse("must", "Science", 3, 1);
        //create Student
        Student student1 = new Student("Tom", "1111", "1234");
        Student student2 = new Student("Jerry", "2222", "1234");
        Student student3 = new Student("Spike", "3333", "1234");
        //register Student
        registrationManage.registerUser(student1);
        registrationManage.registerUser(student2);
        registrationManage.registerUser(student3);
        //login Student
        StudentFacade student1facade = (StudentFacade) registrationManage.login("1111", "1234");
        StudentFacade student2facade = (StudentFacade) registrationManage.login("2222", "1234");
        StudentFacade student3facade = (StudentFacade) registrationManage.login("3333", "1234");
        //register Student to Course
        Map<String, Course> courses = student1facade.getCourses();
        student1facade.addToShoppingCart(courses.get("Math"));
        student1facade.addToShoppingCart(courses.get("History"));
        student1facade.addToShoppingCart(courses.get("Science"));
        student1facade.checkout();
        student2facade.addToShoppingCart(courses.get("Science")); //full
        student2facade.checkout();
        //asking student 2 if he wants to enter the waiting list
        System.out.println("Do you want to enter the waiting list? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("yes")) {
            student2facade.requestNotificationForCourse(courses.get("Science"));
            System.out.println("You are in the waiting list for Science");
        }

















    }

}
