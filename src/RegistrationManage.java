import java.util.ArrayList;
import java.util.List;

public class RegistrationManage {
    private static final int MAX_USERS = 100; // Maximum number of users
    private int totalUsers = 0; // Total number of users
    private List<Users> registeredUsers; // List to store registered users

    public RegistrationManage() {
        this.registeredUsers = new ArrayList<>();
    }

    // Method to register a new user
    public void registerUser(Users user) {
        if (totalUsers < MAX_USERS) {
            registeredUsers.add(user);
            totalUsers++;
            System.out.println("User registered: " + user.getUserName());
        } else {
            System.out.println("Maximum number of users reached.");
        }
    }

    // Method to unregister a user
    public void unregisterUser(Users user) {
        registeredUsers.remove(user);
        totalUsers--;
        System.out.println("User unregistered: " + user.getUserName());
    }

    // Getters and setters
    public List<Users> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(List<Users> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public int getTotalUsers() {
        return totalUsers;
    }
}
