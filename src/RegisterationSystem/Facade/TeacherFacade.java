package RegisterationSystem.Facade;

import RegisterationSystem.Course.CourseManager;
import RegisterationSystem.Facade.UserFacade;
import RegisterationSystem.RegistrationManage;
import RegisterationSystem.Teacher;
import RegisterationSystem.User;

public class TeacherFacade implements UserFacade {
    private RegistrationManage registrationManage;
    private CourseManager courseManager;
    private final Teacher teacher;

public TeacherFacade(RegistrationManage registrationManage, CourseManager courseManager, Teacher teacher) {
        this.registrationManage = registrationManage;
        this.courseManager = courseManager;
        this.teacher = teacher;
    }

    public void createCourse(String type, String coursename,int ID , int capacity) {
        courseManager.createCourse(type, coursename, capacity, ID, teacher);
    }
    public void deleteCourse(String courseID) {
        courseManager.deleteCourse(courseID);
    }
    public void assignUserToCourse(String course, User user) {
        courseManager.registerUserToCourse(course, user);

    }
    public void unassignUserFromCourse(String course, User user) {
        courseManager.unregisterUser(course, user);
    }
    public void unregisterUserFromSystem(User user) { //teacher is OP.
        registrationManage.unregisterUser(user);
    }

}
