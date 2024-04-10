import java.util.*;

public abstract class Course implements Subject{
    private final HashSet<Users> Users;
    private String name;
    private int capacity;
    private List<Users> waitlistObservers;

    public Course(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.Users = new HashSet<>();

        this.waitlistObservers = new ArrayList<>();
    }



    public static Course createCourse(String type, String name, int capacity) {
        switch (type.toLowerCase()) {
            case "choose":
                return new Course_choose(name, capacity);
            case "must":
                return new Course_must(name, capacity);
            case "seminar":
                return new Course_seminar(name, capacity);
            default:
                throw new IllegalArgumentException("Invalid course type: " + type);
        }
    }


    @Override
    public void registerObserver(Users observer) {
        waitlistObservers.add(observer);
    }

    @Override
    public void removeObserver(Users observer) {
        waitlistObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Users observer : waitlistObservers) {
            observer.update(name);
        }
    }


    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getUserCount() {
        return Users.size();
    }

    public boolean addUser(Users user) {
        if (Users.size() < capacity) {
            Users.add(user);
            return true;
        } else {
            waitlistObservers.add(user);
            return false;
        }
    }

    public void removeFromCourse(String userID) {
        Users user2remove = new Student(null,userID);
        if (Users.remove(user2remove)) {
            Users.remove(user2remove);
            System.out.println(user2remove.getUserName() + " unregistered from course " + name);
        }
        for (Users u : waitlistObservers) {
            u.update(name + " New spot available in " + this.name + " course");
        }
    }

    public HashSet<Users> getUsers() {
        return Users;
    }
}
