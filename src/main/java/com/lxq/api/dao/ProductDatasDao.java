package com.lxq.api.dao;


import com.lxq.api.entity.po.ProductAttrdatas;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductDatasDao {


    @Insert("<script>" +
            "insert into shop_productdatas (proId,attrData,storcks,price)" +
            "values <foreach collection='list' item='a' separator=','> (#{a.proId},#{a.attrData},#{a.storcks},#{a.price})" +
            " </foreach>" +
            "</script>")
    void addList(List<ProductAttrdatas> attrdatasList);


    @Select("select * from shop_productdatas where proId=#{pid}")
    List<ProductAttrdatas> queryProductDataById(Integer pid);
}
