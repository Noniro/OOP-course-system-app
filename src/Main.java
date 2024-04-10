public class Main {
    public static void main(String[] args) {
        CourseManager courseManager = new CourseManager();
        Teacher teacher = new Teacher("John", "1", courseManager);
        Tutor tutor = new Tutor("Tom", "2", courseManager);
        Lecturer lecturer = new Lecturer("Liam", "3", courseManager);

        teacher.createCourse("choose", "Science 101", 3);
        tutor.createCourse("must", "Math 101", 5);
        lecturer.createCourse("seminar", "English 101", 10);
        Student alice = new Student("Alice", "4");
        Student bob = new Student("Bob", "5");
        Student charlie = new Student("Charlie", "6");
        Student david = new Student("David", "7");
        Student eve = new Student("Eve", "8");
        alice.registerCourse(courseManager, "Science 101");
        alice.registerCourse(courseManager, "Math 101");
        bob.registerCourse(courseManager, "Science 101");
        bob.registerCourse(courseManager, "Math 101");
        charlie.registerCourse(courseManager, "Science 101");
        charlie.registerCourse(courseManager, "Math 101");
        david.registerCourse(courseManager, "Science 101");
        david.registerCourse(courseManager, "Math 101");
        eve.registerCourse(courseManager, "Science 101");
        eve.registerCourse(courseManager, "Math 101");
        eve.registerCourse(courseManager, "English 101");


    }
}
