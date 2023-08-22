
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
}
