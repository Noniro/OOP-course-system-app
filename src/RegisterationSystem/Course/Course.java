package RegisterationSystem.Course;

import RegisterationSystem.*;
import RegisterationSystem.Observer;

import java.util.*;

public abstract class Course implements Subject {
    private final HashSet<RegisterationSystem.User> User;
    private String name;
    private  int ID;
    private int capacity;
    private Teacher teacher;
    private List<Observer> waitlistObservers;
    public Course(String name, int capacity, int ID, Teacher teacher) {
        this.name = name;
        this.capacity = capacity;
        this.User = new HashSet<>();
        this.ID =ID;
        this.teacher = teacher;
        this.waitlistObservers = new ArrayList<>();
    }

// factory method pattern
    public static Course createCourse(String type, String name, int capacity, int ID, Teacher teacher) {
        switch (type.toLowerCase()) {
            case "choose":
                return new Course_choose(name, capacity , ID, teacher);
            case "must":
                return new Course_must(name, capacity, ID, teacher);
            case "seminar":
                return new Course_seminar(name, capacity , ID,teacher);
            default:
                throw new IllegalArgumentException("Invalid course type: " + type);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        waitlistObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        waitlistObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : waitlistObservers) {
            observer.update(new Notification("New spot available in " + this.name + " course. "+ (User.size()-capacity) + " spots available"));
        }
    }

    public boolean isFull() {
        return User.size() >= capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getUserCount() {
        return User.size();
    }

    public boolean addUser(User user) {
        if (User.size() < capacity) {
            User.add(user);
            return true;
        }
        return false;
    }

    public void removeFromCourse(User user) {
        if (User.remove(user)) {
            User.remove(user);
            System.out.println(user.getUserName() + " unregistered from course " + name);
            for (Observer u : waitlistObservers) {
                u.update(new Notification(name + " New spot available in " + this.name + " course. "+ (User.size()-capacity) + " spots available"));
            }
        }
        else {
            throw new IllegalArgumentException("RegisterationSystem.User " + user.getUserName() + " is not registered for course " + name);
        }

    }

    public HashSet<User> getUsers() {
        return User;
    }

    public boolean isUserRegistered(Student student) {
        return User.contains(student);
    }
}
