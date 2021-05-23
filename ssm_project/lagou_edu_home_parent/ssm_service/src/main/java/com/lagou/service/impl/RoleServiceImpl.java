package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.domain.RoleResourceRelation;
import com.lagou.domain.Role_menu_relation;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> allRole = roleMapper.findAllRole(role);
        return allRole;
    }

    @Override
    public List<Integer> findMenuByRoleId(Integer roleid) {
        List<Integer> menuByRoleId = roleMapper.findMenuByRoleId(roleid);

        return menuByRoleId;
    }

    @Override
    public void roleContextMenu(RoleMenuVo roleMenuVo) {

        //1. 清空中间表的关联关系
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());

        //2. 为角色分配菜单

        for (Integer mid : roleMenuVo.getMenuIdList()) {

            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setRoleId(roleMenuVo.getRoleId());

            //封装数据
            Date date = new Date();
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);

            role_menu_relation.setCreatedBy("s" +
                    "" +
                    "ystem");
            role_menu_relation.setUpdatedby("system");


            roleMapper.roleContextMenu(role_menu_relation);
        }

    }

    @Override
    public void deleteRole(Integer roleid) {

        // 调用根据roleid清空中间表关联关系
        roleMapper.deleteRoleContextMenu(roleid);

        roleMapper.deleteRole(roleid);
    }

    @Override
    public void roleContextResource(Integer roleID, List<Integer> resourceId) {
        roleMapper.deleteRoleRelationShip(roleID);
        List<RoleResourceRelation> roleResourceRelations = new ArrayList<>();

        for (int i = 0; i < resourceId.size() ; i++) {
            RoleResourceRelation r = new RoleResourceRelation();
            Date date = new Date();
            r.setRoleId(roleID);
            r.setResourceId(resourceId.get(i));
            r.setCreatedTime(date);
            r.setUpdatedTime(date);
            r.setCreatedBy("system");
            r.setUpdatedby("system");
            roleResourceRelations.add(r);
        }
        System.out.println(roleResourceRelations);

        for (RoleResourceRelation roleResourceRelation : roleResourceRelations) {
            roleMapper.roleContextResource(roleResourceRelation);
        }
    }
}
