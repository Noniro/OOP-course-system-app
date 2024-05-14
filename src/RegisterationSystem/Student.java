package RegisterationSystem;

public class Student implements User, Observer{
    private String name;
    private String ID;
    private String password;
    private boolean isLogin;

    public Student(String name, String ID, String password) {
        this.name = name;
        this.ID = ID;
        this.password = password;
    }

    @Override
    public String getUserName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return ID.equals(student.ID);
    }

    @Override
    public void update(Notification notification) {
        System.out.println("Student " + name + " with ID " + ID + " received notification: " + notification.getMessage());
    }
}