package com.chengzi.exercise.mybatis.domain;

/**
 * 城子
 */
public class Student {
    private String studentID;//主键
    private String studentName;//姓名
    private String gender;//性别
    private String age;//年龄

    public Student() {
    }

    //带参构造函数，初始化实体类是调用
    public Student(String studentID, String studentName, String gender, String age) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.gender = gender;
        this.age = age;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
