package com.lxq.api.service;

import com.lxq.api.entity.po.Product;
import com.lxq.api.entity.vo.ProductVo;

import java.util.Map;

public interface ProductService {

    public void addProduct(Product product);

    Map queryProductData(ProductVo productVo);

    void updateProd(Product product);
}
