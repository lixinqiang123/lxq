package com.lxq.api.service;

import com.lxq.api.entity.po.Brand;
import com.lxq.api.entity.vo.BrandVo;

import java.util.List;
import java.util.Map;

public interface BrandService {
    Map queryBrand(BrandVo brandVo);

    void addBrand(Brand brand);

    Brand queryBrandById(Integer id);

    void updateBrand(Brand brand);

    void deleteBrand(Integer id);

    List<Brand> queryBrandByIdByName();
}
