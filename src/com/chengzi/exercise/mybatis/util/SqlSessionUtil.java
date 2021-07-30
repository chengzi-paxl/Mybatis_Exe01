package com.chengzi.exercise.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 该类中的方法与字段均是静态的，直接使用类名调用
 * <p>
 * 城子
 */
public class SqlSessionUtil {

    /**
     * 将构造方式声明为私有的，使其不能被实例化为对象
     */
    private SqlSessionUtil() {
    }

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    //保护线程安全,使同时只能有一条数据对数据库进行操作
    private static ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();


    /**
     * 获取一个SqlSession对象
     */
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = t.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 释放资源
     *
     * @param sqlSession 需要关闭的SqlSession对象
     */
    public static void myClose(SqlSession sqlSession) {
        sqlSession.close();
        t.remove();
    }

}
