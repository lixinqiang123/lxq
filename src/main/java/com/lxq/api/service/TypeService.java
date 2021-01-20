package com.lxq.api.service;

import com.lxq.api.entity.po.Attributes;
import com.lxq.api.entity.po.Type;

import java.util.List;

public interface TypeService {
    List<Type> queryType();

    List<Type> queryTypeByPid(Integer pid);

    void addType(Type type);

    void update(Integer pid, String name, Integer isDel,Integer id);

    List<Type> queryTypeBypid(Integer pid);

    List<Type> queryTypeByid(Integer id);

    List<Attributes> queryAttrByTypeId(Integer typeId);
}
