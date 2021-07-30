package com.chengzi.exercise.mybatis.test;

import com.chengzi.exercise.mybatis.domain.Student;
import com.chengzi.exercise.mybatis.service.StudentService;
import com.chengzi.exercise.mybatis.service.impl.StudentServiceImpl;
import com.chengzi.exercise.mybatis.util.ServiceFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Exe01_Test01 {

    public static void main(String[] args) {
        StudentService studentService = (StudentService) ServiceFactory.getService(new StudentServiceImpl());

//        Student student = studentService.queryByID("A0001");
//
//        System.out.println(student);

//        Student student = new Student();
//        student.setStudentName("王富贵");
//        student.setAge("19");
//        List<Student> studentList = studentService.queryByInfo(student);
//        for (Student student1 : studentList) {
//            System.out.println(student1);
//        }

//        Map<String, Object> studentMap = new HashMap<String, Object>();
//        studentMap.put("name", "王富贵");
//        studentMap.put("gender", "男");
//        List<Student> students=studentService.queryByMap(studentMap);

        //查询表中的总数据条数
        {
//            int count = studentService.queryCount();
//            System.out.println(count);
        }
        //以返回值为Map形式的查询全部信息
        {
//            List<Map<String, Object>> studentList = studentService.queryList();
//            for (Map<String, Object> stringObjectMap : studentList) {
//                Set<String> set = stringObjectMap.keySet();
//                for (String s : set) {
//                    System.out.println(s + ":" + stringObjectMap.get(s));
//                }
//                System.out.println("--------------------------");
//
//            }
        }
        //插入数据
        {
//        Student student = new Student("A0007", "如意吉祥", "女", "4");
//        int check = studentService.insertInfo(student);
//        System.out.println(check);
        }
        //动态查询Sql
        {
//            Student student = new Student();
//            student.setStudentName("富贵");
//            student.setGender("男");
//            List<Student> studentList = studentService.selectByCon01(student);
//            for (Student student1 : studentList) {
//                System.out.println(student1);
//            }
        }
        //ForEach标签的使用
        {
//            String nameArr[] = {"王富贵", "平安喜乐", "如意吉祥"};
//            List<Student> studentList = studentService.queryInName(nameArr);
//            for (Student student : studentList) {
//                System.out.println(student);
//            }
        }
        //多表联查
        {
            List<Map<String, Object>> studentList = studentService.selectByCon02();
            for (Map<String, Object> stringObjectMap : studentList) {
                Set<String> set = stringObjectMap.keySet();
                for (String s : set) {
                    System.out.println(s + ":" + stringObjectMap.get(s));
                }
                System.out.println("-----------------------");
            }
        }
    }
}

