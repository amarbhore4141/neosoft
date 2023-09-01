package javaEightExamples;

public class Student implements Comparable<Student> {
    private int id;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public int compareTo(Student student) {

//    return this.name.compareTo(student.name);
        return student.getName().compareTo(this.name);

    }
}
