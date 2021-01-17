package com.lxq.api.dao;

import com.lxq.api.entity.po.AttrValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AttributeValueDao {

    @Select("select * from shop_attr_value where 1=1 and attrId=#{id}")
    List<AttrValue> queryAttrValue(Integer id);
}