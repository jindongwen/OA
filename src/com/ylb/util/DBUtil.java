package com.ylb.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: jindongwen
 * @Date: 2020-12-15-0:19
 * @Description:OA
 * @version:1.0
 */
public class DBUtil {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> t1 = new ThreadLocal<>();

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = t1.get();
        if (sqlSession == null) {
            sqlSession = factory.openSession(true);
            t1.set(sqlSession);
        }
        return sqlSession;
    }

    public static void closeSqlSession() {
        SqlSession sqlSession = t1.get();
        if (sqlSession != null){
            sqlSession.close();
        }
        t1.set(null);
    }
}
