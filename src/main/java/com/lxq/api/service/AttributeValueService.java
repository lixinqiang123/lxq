package com.lxq.api.service;

import com.lxq.api.entity.po.AttrValue;

import java.util.Map;

public interface AttributeValueService {
    Map queryAttrValue(Integer id);

    void addAttrValue(AttrValue attrValue);

    void updateValue(AttrValue attrValue);
}
