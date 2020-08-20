package com.pps;

import com.pps.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * @author
 * @discription;
 * @time 2020/7/30 17:24
 */
public class Applicaation {



    public  static  void  main(String args[]) throws IOException {

        String resource = "SqlMappingConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession();

        User user1 = new User();
        user1.setName("ttttttt");

        int insert = sqlSession.insert("com.pps.mapper.UserMapper.insert", user1);
        sqlSession.commit();
      /*  HashMap user = sqlSession.selectOne("com.pps.mapper.UserMapper.findUserById", 1);
        System.out.println(user);*/
        // 释放资源
        sqlSession.close();



    }

}
