
/*
 * @author  AmbitionJingH
 * @date  2023/8/22 18:31
 * @version 1.0
 */

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParameterTest {
    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User admin = mapper.getUserByUsername("admin");
        if(admin!=null)
            System.out.println(admin);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User admin = mapper.checkLogin("admin","123456");
        if(admin!=null)
            System.out.println(admin);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        User admin = mapper.checkLoginByMap(map);
        if(admin!=null)
            System.out.println(admin);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(new User(null,"user2","123456",33,"女","123@qq.com"));
    }

    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User admin = mapper.checkLoginByParam("user1","123456");
        if(admin!=null)
            System.out.println(admin);
    }
}
