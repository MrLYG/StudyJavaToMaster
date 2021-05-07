package per.lyg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.lyg.domain.Dept;
import per.lyg.mapper.DeptMapper;
import per.lyg.service.DeptService;

import java.util.List;

/**
 * @author hp
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        List<Dept> depts = deptMapper.findAll();

        return depts;
    }
}
