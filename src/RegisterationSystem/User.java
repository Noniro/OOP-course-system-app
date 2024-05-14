package RegisterationSystem;

public interface User {
    String getUserName();
    String getID();
    String getPassword();
    void setLogin(boolean login);
    boolean isLogin();

}
