package com.chengzi.exercise.mybatis.service.impl;

import com.chengzi.exercise.mybatis.dao.StudentDao;
import com.chengzi.exercise.mybatis.domain.Student;
import com.chengzi.exercise.mybatis.service.StudentService;
import com.chengzi.exercise.mybatis.util.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = SqlSessionUtil.getSqlSession().getMapper(StudentDao.class);

    /**
     * 根据ID查单条
     */
    @Override
    public Student queryByID(String ID) {
        return studentDao.queryByID(ID);
    }

    @Override
    public List<Student> queryByInfo(Student student) {
        return studentDao.queryByInfo(student);
    }

    @Override
    public List<Student> queryByMap(Map<String, Object> studentMap) {
        return studentDao.queryByMap(studentMap);
    }

    @Override
    public int queryCount() {
        return studentDao.queryCount();
    }

    @Override
    public List<Map<String, Object>> queryList() {
        return studentDao.queryList();
    }

    @Override
    public int insertInfo(Student student) {
        return studentDao.insertInfo(student);
    }

    @Override
    public List<Map<String, Object>> selectByCon02() {
        return studentDao.selectByCon02();
    }

    @Override
    public List<Student> queryInName(String[] nameArr) {
        return studentDao.queryInName(nameArr);
    }

    @Override
    public List<Student> selectByCon01(Student student) {
        return studentDao.selectByCon01(student);
    }

}
