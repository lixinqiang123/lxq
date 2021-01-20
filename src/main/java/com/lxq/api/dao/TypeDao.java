package com.lxq.api.dao;


import com.lxq.api.entity.po.Attributes;
import com.lxq.api.entity.po.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper  //持久层

public interface TypeDao {


    List<Type> queryType();

    List<Type> queryTypeByPid(Integer pid);

    void addType(Type type);

    void update(Map map);

    @Select("select id,name,pid from shop_type where 1=1 and pid=#{pid}")
    List<Type> queryTypeBypid(Integer pid);

    @Select("select id,name,pid from shop_type where 1=1 and pid=#{id}")
    List<Type> queryTypeByid(Integer id);

    @Select("select * from shop_attribute where typeId=#{typeId}")
    List<Attributes> queryAttrByTypeId(Integer typeId);
}
