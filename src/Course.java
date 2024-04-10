import java.util.*;

public abstract class Course implements Subject{
    private final HashSet<Object> Users;
    private String name;
    private int capacity;
    private Set<Users> students;
    private List<Users> observers;
    private List<Users> waitlist;

    public Course(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.Users = new HashSet<>();
        this.observers = new ArrayList<>();
        this.waitlist = new ArrayList<>();
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
            waitlist.add(user);
            return false;
        }
    }


    @Override
    public void registerObserver(Users observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(Users observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObservers() {
        for (Users observer : observers) {
            observer.update(name);
        }

    }

    public void removeFromCourse(String userID) {
        Users user2remove = new Student(null,userID);
        if (Users.remove(user2remove)) {
            students.remove(user2remove);
            System.out.println(user2remove.getUserName() + " unregistered from course " + name);
        }
        for (Users u : waitlist) {
            u.update(name + " New spot available in " + this.name + " course");
        }
    }

    public Collection<Object> getUsers() {
        return Users;
    }
}
