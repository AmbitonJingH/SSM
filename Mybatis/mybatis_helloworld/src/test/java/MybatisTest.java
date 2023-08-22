
/*
 * @author  AmbitionJingH
 * @date  2023/8/22 12:41
 * @version 1.0
 */

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test() throws IOException {
        //获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象SqlSession，是Mybatis提供的操作数据库的对象
        SqlSession sqlSession = sessionFactory.openSession();
        //获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int rows = mapper.insertUser();
        if(rows>0)
            System.out.println("添加成功");
        else
            System.out.println("添加失败");
        //提交事务
        sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();

    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int rows = mapper.updateUser();
        if(rows>0)
            System.out.println("修改成功");
        else
            System.out.println("修改失败");
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int rows = mapper.deleteUser();
        if(rows>0)
            System.out.println("删除成功");
        else
            System.out.println("删除失败");
        sqlSession.close();
    }

    @Test
    public void testSelect(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        if(user!=null)
            System.out.println(user);
        else
            System.out.println("该用户不存在");
        sqlSession.close();
    }
    @Test
    public void testSelect1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        if(userList!=null)
            System.out.println(userList);
        else
            System.out.println("不存在");
        sqlSession.close();
    }
}
