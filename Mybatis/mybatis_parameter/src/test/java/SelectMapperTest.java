
/*
 * @author  AmbitionJingH
 * @date  2023/8/22 19:18
 * @version 1.0
 */

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest{
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> userList = mapper.getAllUser();
        userList.forEach(System.out::println);
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        int count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testgetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userByIdToMap = mapper.getUserByIdToMap(4);
        System.out.println(userByIdToMap);
    }

    @Test
    public void testgetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
//        List<Map<String, Object>> list = mapper.getAllUserToMap1();
//        System.out.println(list);
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println(map);


    }
}
