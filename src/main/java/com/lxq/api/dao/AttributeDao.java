package com.lxq.api.dao;


import com.lxq.api.entity.po.Attributes;
import com.lxq.api.entity.vo.AttributeValue;
import com.lxq.api.entity.vo.AttributeVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttributeDao {

    Long queryAttribute(AttributeVo attributeVo);

    List<AttributeValue> queryAttributeLimit(AttributeVo attributeVo);


    @Insert("insert into shop_attribute(name,nameCH,typeId,type,isSKU,isDel,createDate,updateDate,author) " +
            "value(#{name},#{nameCH},#{typeId},#{type},#{isSKU},#{isDel},#{createDate},#{updateDate},#{author})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addAttribute(Attributes attributes);


    @Update("update shop_attribute set name=#{name},nameCH=#{nameCH},typeId=#{typeId}," +
            "type=#{type},isSKU=#{isSKU}," +
            "createDate=#{createDate},updateDate=#{updateDate}," +
            "author=#{author}" +
            " where  id=#{id}")
    void updateAttribute(Attributes attributes);


    @Update("update shop_attribute set isDel=1 where id=#{id}")
    void deleteAttribute(Integer id);

    @Select("select * from shop_attribute where id=#{id}")
    Attributes queryAttrById(Integer id);


    @Select("select * from shop_attribute where typeId=#{typeId}")
    List<Attributes> queryAttrByTypeId(Integer typeId);
}
