package per.lyg.mapper;

import org.apache.ibatis.annotations.Select;
import per.lyg.domain.Dept;

import java.util.List;

/**
 * @author hp
 */
public interface DeptMapper {
    @Select("select * from tb_dept")
    public List<Dept> findAll();

}
