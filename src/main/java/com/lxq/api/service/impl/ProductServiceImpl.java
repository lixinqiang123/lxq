package com.lxq.api.service.impl;

import com.lxq.api.dao.ProductDao;
import com.lxq.api.entity.po.Product;
import com.lxq.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service  //声明业务逻辑处理层
public class ProductServiceImpl implements ProductService {


    @Autowired //注入
    private  ProductDao productDao;


    //新增
    public void addProduct(Product product){

        product.setCreateDate(new Date());
        product.setUpdateDate(new Date());
        product.setIsDel(0);
        product.setAuthor("admin");
        productDao.addProduct(product);
    }

}
