package com.chengzi.exercise.mybatis.util;

import org.apache.ibatis.session.SqlSession;

/**
 * 代理工场类
 * <p>
 * 王朔
 */
public class ServiceFactory {

    //获取一个代理对象并返回
    public static Object getService(Object service) {
        return new TransactionInvocationHandler(service).Proxy();
    }
}
