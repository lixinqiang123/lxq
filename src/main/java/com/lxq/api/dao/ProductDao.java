package com.lxq.api.dao;


import com.lxq.api.entity.po.Product;
import com.lxq.api.entity.vo.ProductVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProductDao {

    /*
    * 新增
    * */
    @Insert("insert into shop_product (name,title,brandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,updateDate,author,isDel) " +
            "value(#{name},#{title},#{brandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{updateDate},#{author},#{isDel})")

    @Options(useGeneratedKeys = true, keyProperty = "id")  //此注解是为了 新增后返回主键id
    public void addProduct(Product product);

    Long queryProductCount(ProductVo productVo);

    List<Product> queryProductLimit(ProductVo productVo);

    @Update("update shop_product set name=#{name},brandId=#{brandId},price=#{price},imgPath=#{imgPath},sortNum=#{sortNum}," +
            "updateDate=#{updateDate},author=#{author},isDel=#{isDel} where id=#{id}")
    void updateProd(Product product);
}
