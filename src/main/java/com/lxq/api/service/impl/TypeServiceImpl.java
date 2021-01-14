package com.lxq.api.service.impl;

import com.lxq.api.dao.TypeDao;
import com.lxq.api.entity.po.Type;
import com.lxq.api.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service   //声明业务逻辑处理层
public class TypeServiceImpl implements TypeService {


    //注入dao层
    @Autowired
    private TypeDao typeDao;


    @Override
    public List<Type> queryType() {

        List<Type> typeList=typeDao.queryType();
        return typeList;
    }

    @Override
    public List<Type> queryTypeByPid(Integer pid) {

        List<Type> typeList=typeDao.queryTypeByPid(pid);
        return typeList;
    }

    @Override
    public void addType(Type type) {


        typeDao.addType(type);
    }

    @Override
    public void update(Integer pid, String name, Integer isDel,Integer id) {
        Map map = new HashMap();

        map.put("pid",pid);
        map.put("name",name);
        map.put("isDel",isDel);
        map.put("id",id);
        typeDao.update(map);
    }
}
