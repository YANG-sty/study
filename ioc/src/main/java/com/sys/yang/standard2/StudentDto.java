package com.sys.yang.standard2;

import java.util.Arrays;
import java.util.List;

/**
 * @author yangLongFei 2020-12-24-19:22
 */
public class StudentDto {
    private Student student;
    private List<Score> scoreList;
    private String[] stringArray;

    public StudentDto(Student student, List<Score> scoreList, String[] stringArray) {
        this.student = student;
        this.scoreList = scoreList;
        this.stringArray = stringArray;
    }

    public StudentDto() {

    }


    @Override
    public String toString() {
        return "StudentDto{" +
                "student=" + student +
                ", scoreList=" + scoreList +
                ", stringArray=" + Arrays.toString(stringArray) +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public String[] getStringArray() {
        return stringArray;
    }

    public void setStringArray(String[] stringArray) {
        this.stringArray = stringArray;
    }
}
