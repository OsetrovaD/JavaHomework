package lesson9rightversion.task2;

import java.util.Iterator;
import java.util.List;

public class Student implements Comparable<Student> {

    private String firstName;
    private String secondName;
    private int age;
    private double averageYearGrade;

    public Student(String firstName, String secondName, int age, double averageYearGrade) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.averageYearGrade = averageYearGrade;
    }

    public static Student maxAverageGradeStudent(List<Student> list) {
        Student temp = new Student("", "", 0, 0);
        double tempGrade = temp.averageYearGrade;

        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().averageYearGrade > tempGrade) {
                tempGrade = iterator.next().averageYearGrade;
                temp = iterator.next();
            }
        }

        return temp;
    }

    public static void printStudents(List<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", averageYearGrade=" + averageYearGrade +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int result = this.firstName.compareTo(o.firstName);
        result = result == 0 ? this.secondName.compareTo(o.secondName) : result;

        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public double getAverageYearGrade() {
        return averageYearGrade;
    }
}
