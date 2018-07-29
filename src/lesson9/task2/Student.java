package lesson9.task2;

import java.util.Iterator;
import java.util.List;

public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private int age;
    private double averageYearGrade;

    public Student(String firstName, String lastName, int age, double averageYearGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.averageYearGrade = averageYearGrade;
    }

    public static Student maxAverageGradeStudent(List<Student> list){
        Student temp = list.get(0);
        double tempGrade = temp.averageYearGrade;

        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().averageYearGrade > tempGrade){
                tempGrade = iterator.next().averageYearGrade;
                temp = iterator.next();
            }
        }

        return temp;
    }

    public static void printStudents(List<Student> list){
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Override
    public int compareTo(Student student) {
        int result = this.firstName.compareTo(student.firstName);
        result = result == 0 ? this.lastName.compareTo(student.lastName) : result;

        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", averageYearGrade=" + averageYearGrade +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getAverageYearGrade() {
        return averageYearGrade;
    }


}
