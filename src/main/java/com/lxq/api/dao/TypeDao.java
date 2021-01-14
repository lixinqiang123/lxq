package com.lxq.api.dao;


import com.lxq.api.entity.po.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper  //持久层

public interface TypeDao {


    List<Type> queryType();

    List<Type> queryTypeByPid(Integer pid);

    void addType(Type type);

    void update(Map map);
}
