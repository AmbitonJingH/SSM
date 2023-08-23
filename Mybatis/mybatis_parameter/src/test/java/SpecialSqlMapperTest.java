
/*
 * @author  AmbitionJingH
 * @date  2023/8/22 23:14
 * @version 1.0
 */

import com.atguigu.mybatis.mapper.SpecialSqlMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialSqlMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> list = mapper.getUserByLike("s");
        System.out.println(list);
    }
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        mapper.deleteMoreUser("12,20");
    }

    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> list = mapper.getUserList("t_user");
        System.out.println(list);
    }

    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        User user = new User(null, "user3", "123456", 30, "女", "123456@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
