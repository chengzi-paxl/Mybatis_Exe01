package com.chengzi.exercise.mybatis.util;


import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 王朔
 */

public class TransactionInvocationHandler implements InvocationHandler {

    //业务层实现类的对象
    private Object target;


    //构造函数，初始化对象时使用
    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }


    //代理类的业务方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //创建一个SqlSession对象
        SqlSession sqlSession = null;
        //创建一个Object对象
        Object object = null;
        try {
            //获取一个SqlSession对象
            sqlSession = SqlSessionUtil.getSqlSession();
            //处理业务逻辑
            object = method.invoke(target, args);
            //执行完毕后提交事务
            sqlSession.commit();
        } catch (Exception e) {
            //出现异常则执行回滚
            sqlSession.rollback();
            //打印异常信息
            e.printStackTrace();
        } finally {
            //释放资源m
            SqlSessionUtil.myClose(sqlSession);
        }
        //返回结果
        return object;
    }

    /**
     * 获取一个代理类对象
     */ 
    public Object Proxy() {
        return Proxy.newProxyInstance
                (target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        //      类加载器                             //当前类的所有接口                      //当前类对象
    }
}
