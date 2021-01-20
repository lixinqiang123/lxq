package com.lxq.api.dao;


import com.lxq.api.entity.po.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao {

    /*
    * 新增
    * */
    @Insert("insert into shop_product (name,title,brandId,typeId,productdecs,imgPath,stocks,sortNum,createDate,updateDate,author,isDel) " +
            "value(#{name},#{title},#{brandId},#{typeId},#{productdecs},#{imgPath},#{stocks},#{sortNum},#{createDate},#{updateDate},#{author},#{isDel})")
    public void addProduct(Product product);
}
