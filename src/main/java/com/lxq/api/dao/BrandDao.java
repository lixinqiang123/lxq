package com.lxq.api.dao;


import com.lxq.api.entity.po.Brand;
import com.lxq.api.entity.vo.BrandVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BrandDao {


    Long queryBrandCount(BrandVo brandVo);

    List<Brand> queryBrandLimit(BrandVo brandVo);

    void addBrand(Brand brand);

    Brand queryBrandById(Integer id);

    void updateBrand(Brand brand);

    void deleteBrand(Integer  id);
}
