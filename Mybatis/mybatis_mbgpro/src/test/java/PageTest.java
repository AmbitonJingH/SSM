
/*
 * @author  AmbitionJingH
 * @date  2023/8/23 23:58
 * @version 1.0
 */

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.SimpleQuery;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {
    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //在查询之前开启分页功能
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> list = mapper.selectByExample(null);
        PageInfo<Emp> pageInfo = new PageInfo<>(list,5);
        list.forEach(System.out::println);
        System.out.println(pageInfo);
    }
}
