package org.example.com.xwcom.mybatis;

import com.xwcom.mybatis.mapper.UserMapper;
import com.xwcom.mybatis.pojo.User;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * @author Administrator
 * @date 2024/11/4
 */
public class MyTest {

    @Test
    public void test() throws IOException {
        InputStream resources = Resources.getResourceAsStream("mybatis-config.xml");

        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 2. 创建SqlSessionFactory对象
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resources);
        // 3. 创建SqlSession对象, 并且开启自动提交事务
        SqlSession sqlSession = build.openSession(true);

        User obj = new User();
        obj.setUsername("zhangsan");
        obj.setPassword("123456");
        obj.setEmail("123@qq.com");
        obj.setGender("男");
        obj.setAge(18);

        // 4. 获取UserMapper接口的实现类对象 并且写进数据库
        int insert = sqlSession.getMapper(UserMapper.class).insertUser(obj);

        System.out.println(insert);
        // 5. 关闭资源
        sqlSession.close();

    }

}
