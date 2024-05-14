package RegisterationSystem;
import RegisterationSystem.Course.CourseManager;
import RegisterationSystem.Facade.StudentFacade;
import RegisterationSystem.Facade.TeacherFacade;
import RegisterationSystem.Facade.UserFacade;

import java.util.ArrayList;
import java.util.List;

public class RegistrationManage {
    public static final RegistrationManage INSTANCE = new RegistrationManage();
    public static RegistrationManage getInstance() {
        return INSTANCE;
    } //Singleton pattern
    private static final int MAX_ACTIVE_USERS = 100; // Maximum number of active users
    private List<User> registeredUsers; // List to store registered users
    private  List<User> activeUsers;

    private RegistrationManage() {
        this.registeredUsers = new ArrayList<>();
        this.activeUsers = new ArrayList<>(MAX_ACTIVE_USERS);
    }

    // Method to register a new user
    public void registerUser(User user) {
        registeredUsers.add(user);
        System.out.println("registered: " + user.getUserName());
    }

public void registerUser(String name, String ID, String password) {
    registerUser(new Student(name, ID, password));
    System.out.println("registered: " + name);
}

// Method to unregister a user
public void unregisterUser(User user) {
    registeredUsers.remove(user);
    System.out.println("unregistered: " + user.getUserName());
}

// Getters and setters
public List<User> getRegisteredUsers() {
    return registeredUsers;
}

public void setRegisteredUsers(List<User> registeredUsers) {
    this.registeredUsers = registeredUsers;
}

public int getTotalUsers() {
    return registeredUsers.size();
}

private User getUserbyID(String ID) {
    for (User user : registeredUsers) {
        if (user.getID().equals(ID)) {
            return user;
        }
    }
    return null;
}
    public UserFacade login(String id, String password) {
        User user = getUserbyID(id);
        if (user != null) {
            System.out.println("User ID: " + user.getID());
            if (user.getPassword().equals(password)) {
                if (activeUsers.size() < MAX_ACTIVE_USERS) {
                    user.setLogin(true);
                    activeUsers.add(user);
                    if (user instanceof Student) {
                        user.setLogin(true);
                        return createStudentFacade((Student) user);
                    } else if (user instanceof Teacher) {
                        user.setLogin(true);
                        return createTeacherFacade((Teacher) user);
                    }
                }
                System.out.println("Maximum number of active users reached");
            }
            System.out.println("password incorrect");
        }
        System.out.println("Login failed");
        return null;
    }

public TeacherFacade createTeacherFacade(Teacher user) {
    return new TeacherFacade(RegistrationManage.getInstance(), CourseManager.getInstance(), user);
}

public StudentFacade createStudentFacade(Student user) {
    return new StudentFacade(RegistrationManage.getInstance(), CourseManager.getInstance(), user);
}

public void logout(User user) {
    activeUsers.remove(user);
}

public boolean isLogin(User user) {
    return user.isLogin();
}

}



