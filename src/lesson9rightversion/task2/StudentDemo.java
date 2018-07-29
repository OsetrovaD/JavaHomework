package lesson9rightversion.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDemo {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Smith", 15, 9.1));
        students.add(new Student("Jerry", "Jackson", 14, 8.6));
        students.add(new Student("Bill", "Smith", 12, 9.7));
        students.add(new Student("Bill", "Williams", 17, 7.5));

        Student.printStudents(students);
        System.out.println();

        System.out.println(Student.maxAverageGradeStudent(students));
        System.out.println();

        Collections.sort(students);
        Student.printStudents(students);
        System.out.println();

        students.sort(new StudentAverageGradeComparator());
        Student.printStudents(students);
        System.out.println();

        students.sort(new StudentAgeComparator());
        Student.printStudents(students);
    }
}
