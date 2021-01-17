package com.lxq.api.service.impl;

import com.lxq.api.dao.AttributeValueDao;
import com.lxq.api.entity.po.AttrValue;
import com.lxq.api.service.AttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class AttributeValueServiceImpl  implements AttributeValueService {


    @Autowired
     private AttributeValueDao attributeValueDao;

    @Override
    public Map queryAttrValue(Integer id) {

        Map map = new HashMap();
        List<AttrValue> attrValues=attributeValueDao.queryAttrValue(id);
        map.put("data",attrValues);
        return map;
    }


    @Override
    public void addAttrValue(AttrValue attrValue) {
        attributeValueDao.addAttrValue(attrValue);
    }
}
