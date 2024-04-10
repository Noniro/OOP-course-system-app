public interface Subject {
    void registerObserver(Users observer);
    void removeObserver(Users observer);
    void notifyObservers();
}
