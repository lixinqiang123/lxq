package com.lxq.api.service.impl;

import com.lxq.api.dao.ProductDao;
import com.lxq.api.entity.po.Product;
import com.lxq.api.entity.vo.ProductVo;
import com.lxq.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    //查询
    @Override
    public Map queryProductData(ProductVo productVo) {

        //创建map
        Map map = new HashMap();

        //查询总条数
        Long productCount=productDao.queryProductCount(productVo);

        map.put("count",productCount);

        //计算起始下标
        Integer startIndex=(productVo.getPage()-1)*productVo.getSize();

        productVo.setStartIndex(startIndex);

        //查询分页后的数据
        List<Product> products=productDao.queryProductLimit(productVo);

        map.put("data",products);
        return map;
    }

    //修改
    @Override
    public void updateProd(Product product) {

        product.setUpdateDate(new Date());
        product.setIsDel(0);
        product.setAuthor("admin");
        productDao.updateProd(product);
    }

}
