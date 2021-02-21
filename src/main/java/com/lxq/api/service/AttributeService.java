package com.lxq.api.service;
import com.lxq.api.entity.po.Attributes;
import com.lxq.api.entity.vo.AttributeVo;
import java.util.Map;

public interface AttributeService {
    Map queryAttribute(AttributeVo attributeVo);

    void addAttribute(Attributes attributes);

    void updateAttribute(Attributes attributes);

    void deleteAttribute(Integer id);

    Attributes queryAttrById(Integer id);

    Map queryAttr(Integer typeId);
}
