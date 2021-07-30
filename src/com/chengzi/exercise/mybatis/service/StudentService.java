package com.chengzi.exercise.mybatis.service;

import com.chengzi.exercise.mybatis.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    Student queryByID(String ID);


    List<Student> queryByInfo(Student student);

    List<Student> queryByMap(Map<String, Object> studentMap);

    int queryCount();

    List<Map<String, Object>> queryList();

    int insertInfo(Student student);

    List<Student> selectByCon01(Student student);

    List<Student> queryInName(String[] nameArr);

    List<Map<String, Object>> selectByCon02();
}
