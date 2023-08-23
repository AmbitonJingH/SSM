
/*
 * @author  AmbitionJingH
 * @date  2023/8/23 18:39
 * @version 1.0
 */

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DynamicMapper {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", 20, "");
        List<Emp> list = mapper.getEmpByCondition(emp);
        System.out.println(list);

    }
    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "张三", 20, "");
        List<Emp> list = mapper.getEmpByChoose(emp);
        System.out.println(list);

    }

    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = new ArrayList<>();
        list.add(new Emp(null,"小明",23,"男"));
        list.add(new Emp(null,"小李",21,"男"));
        list.add(new Emp(null,"小黄",19,"女"));
        mapper.insertMoreEmp(list);

    }

    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds = new Integer[]{5,6,7};
        mapper.deleteMoreEmp(empIds);

    }
}
