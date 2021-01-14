package com.lxq.api.dao;


import com.lxq.api.entity.po.Attributes;
import com.lxq.api.entity.vo.AttributeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttributeDao {

    Long queryAttribute(AttributeVo attributeVo);

    List<Attributes> queryAttributeLimit(AttributeVo attributeVo);
}
