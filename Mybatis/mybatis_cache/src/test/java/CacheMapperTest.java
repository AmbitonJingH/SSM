
/*
 * @author  AmbitionJingH
 * @date  2023/8/23 22:05
 * @version 1.0
 */

import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {

    /*
    * Mybatis的一级缓存：
    * Mybatis的一级缓存是SqlSession级别的，即通过同一个SqlSession查询的数据会被缓存
    * 再次使用同一个SqlSession查询统一条数据，会从缓存中获取
    * 使一级缓存失效的四种情况：
    * 1) 不同的SqlSession对应不同的一级缓存
    * 2) 同一个SqlSession但是查询条件不同
    * 3) 同一个SqlSession两次查询期间执行了任何一次增删改操作
    * 4) 同一个SqlSession两次查询期间手动清空了缓存
    *
    * Mybatis的二级缓存
    * 二级缓存是SqlSessionFactory级别，通过同一个SqlSessionFactory创建的SqlSession查询的结果会被缓存；
    * 此后若再次执行相同的查询语句，结果就会从缓存中获取
    * 二级缓存开启的条件：
    * a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
    * b>在映射文件中设置标签<cache/>
    * c>二级缓存必须在SqlSession关闭或提交之后有效
    * d>查询的数据所转换的实体类类型必须实现序列化的接口使二级缓存失效的情况：
    *   两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效
    * */
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);
        sqlSession.clearCache();//清空一级缓存
        //mapper.insertEmp(new Emp(null,"明明",25,"男"));
        Emp emp2 = mapper.getEmpById(1);
        System.out.println(emp2);

/*        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp3 = mapper1.getEmpById(1);
        System.out.println(emp3);*/
    }

    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession1 = sessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        sqlSession1.close();
        SqlSession sqlSession2 = sessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
        sqlSession2.close();
    }
}
