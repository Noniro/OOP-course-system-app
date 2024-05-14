package RegisterationSystem;

import RegisterationSystem.Course.CourseManager;

public class Teacher implements User{
    private String name;
    private String ID;
    private String password;
    boolean isLogin;

    private CourseManager courseManager;

    public Teacher(String name, String ID ,String password) {
        this.name = name;
        this.ID = ID;
        this.password = password;
        this.isLogin = false;
    }
    public String getName() {
        return name;
    }
    public String get_ID() {
        return ID;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
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

}


