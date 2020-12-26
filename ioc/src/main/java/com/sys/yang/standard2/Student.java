package com.sys.yang.standard2;

/**
 * @author yangLongFei 2020-12-24-16:10
 */
public class Student {
    private int id;
    private String name;
    private String age;

    private Score score;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", score=" + score +
                '}';
    }

    public Student() {
        System.out.println("student 无参构造函数 com.sys.yang.standard2.Student.Student()");
    }

    public Student(int id, String name, String age) {
        System.out.println("student 有参构造函数 com.sys.yang.standard2.Student.Student(int, java.lang.String, java.lang.String)");
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, String age, Score score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
