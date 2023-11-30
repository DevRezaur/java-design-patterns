package main.prototype_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver class
 */
public class PrototypePattern {

    public static void main(String[] args) {
        // Creating a student object and loading some data to it
        Student student1 = new Student();
        student1.loadData();

        // Cloning student1 object and creating student2 from it.
        Student student2 = (Student) student1.getClone();

        // Doing some modification in student2 object, student1 should not be affected
        student2.getStudentList().add("Rezaur Rahman");

        // Printing the studentList from student1 & student2 objects
        System.out.println(student1.getStudentList());
        System.out.println(student2.getStudentList());
    }
}

/**
 * Interface with getClone() method.
 * To use prototype pattern in any class, we have to implement this interface.
 */
interface Prototype {
    Prototype getClone();
}

/**
 * Demo class where we will implement prototype pattern.
 * For that we are implementing Prototype interface.
 */
class Student implements Prototype {

    private List<String> studentList;

    public Student() {
        studentList = new ArrayList<>();
    }

    public Student(List<String> studentList) {
        this.studentList = studentList;
    }

    public void loadData() {
        studentList.add("Student 1");
        studentList.add("Student 2");
        studentList.add("Student 3");
        studentList.add("Student 4");
    }

    public List<String> getStudentList() {
        return studentList;
    }

    /**
     * Instead of creating a new empty object each time, we are cloning the exiting object.
     *
     * @return Student
     */
    @Override
    public Prototype getClone() {
        List<String> studentList = new ArrayList<>(this.getStudentList());
        return new Student(studentList);
    }
}
