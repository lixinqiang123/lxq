package com.lxq.api.service.impl;

import com.lxq.api.dao.AttributeDao;
import com.lxq.api.entity.po.Attributes;
import com.lxq.api.entity.vo.AttributeValue;
import com.lxq.api.entity.vo.AttributeVo;
import com.lxq.api.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service  //声明业务逻辑处理层
public class AttributeServiceImpl  implements AttributeService {


    @Autowired
    private AttributeDao attributeDao;


    @Override
    public Map queryAttribute(AttributeVo attributeVo) {

        Map map = new HashMap();

        //查询总条数
        Long attributeCount=attributeDao.queryAttribute(attributeVo);

        map.put("count",attributeCount);

        //计算起始下标
        Integer startIndex=(attributeVo.getPage()-1)*attributeVo.getSize();

        attributeVo.setStartIndex(startIndex);

        //查询分页后的数据
        List<AttributeValue> attributesList=attributeDao.queryAttributeLimit(attributeVo);

        map.put("data",attributesList);
        return map;
    }

    //新增
    @Override
    public void addAttribute(Attributes attributes) {

        attributes.setCreateDate(new Date());
        attributes.setUpdateDate(new Date());
        attributes.setAuthor("admin");
        attributes.setIsDel(0);
        attributeDao.addAttribute(attributes);
    }

    @Override
    public void updateAttribute(Attributes attributes) {

        attributes.setCreateDate(new Date());
        attributes.setUpdateDate(new Date());
        attributes.setIsDel(0);
        attributeDao.updateAttribute(attributes);
    }

    //逻辑删除
    @Override
    public void deleteAttribute(Integer id) {

        attributeDao.deleteAttribute(id);
    }

    //根据id查询
    @Override
    public Attributes queryAttrById(Integer id) {
        return attributeDao.queryAttrById(id);
    }
}
