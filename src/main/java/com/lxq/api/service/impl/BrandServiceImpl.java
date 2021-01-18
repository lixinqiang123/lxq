package com.lxq.api.service.impl;

import com.lxq.api.dao.BrandDao;
import com.lxq.api.entity.po.Brand;
import com.lxq.api.entity.vo.BrandVo;
import com.lxq.api.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Override
    public Map queryBrand(BrandVo brandVo) {

        Map map = new HashMap();
        //查询总条数
       Long brandCount=brandDao.queryBrandCount(brandVo);

       map.put("count",brandCount);

       //计算起始下标
        Integer startPage=(brandVo.getPage()-1)*brandVo.getSize();

        //给起始下标赋值
        brandVo.setStartIndex(startPage);

        //查询分页后的数据
        List<Brand> brandList=brandDao.queryBrandLimit(brandVo);

        map.put("data",brandList);
        return map;
    }


    @Override
    public void addBrand(Brand brand) {

        brand.setCreateDate(new Date());
        brand.setUpdateDate(new Date());
        brand.setIsdel(0);
        brandDao.addBrand(brand);
    }

    //根据id查询
    @Override
    public Brand queryBrandById(Integer id) {

        Brand brand=brandDao.queryBrandById(id);

        return brand;
    }


    //修改
    @Override
    public void updateBrand(Brand brand) {

        //给修改时间赋值
        brand.setUpdateDate(new Date());

        brandDao.updateBrand(brand);
    }

    @Override
    public void deleteBrand(Integer id) {


        brandDao.deleteBrand(id);

    }

    @Override
    public List<Brand> queryBrandByIdByName() {

        List<Brand> brandList=brandDao.queryBrandByIdByName();

        return brandList;
    }
}
