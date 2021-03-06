package com.lxq.api.controller;

import com.lxq.api.entity.po.Attributes;
import com.lxq.api.entity.vo.AttributeVo;
import com.lxq.api.entity.vo.ResultData;
import com.lxq.api.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController  //代表类上加@controller  该类下的每个方法里都默认加了 @responsebody
@CrossOrigin     //解决跨域问题
@RequestMapping("api/attribute/")
public class AttributeController {


    @Autowired
    private AttributeService attributeService;


    //根据id查询
    @GetMapping("queryAttrById")
    public ResultData queryAttrById(Integer id){

        Attributes attributes=attributeService.queryAttrById(id);

        return ResultData.success(attributes);
    }

    //查询
    @GetMapping("getData")
    public ResultData getData(AttributeVo attributeVo){

        Map attributesList=attributeService.queryAttribute(attributeVo);

        return ResultData.success(attributesList);
    }


    //新增接口
    @PostMapping("add")
    public ResultData add(Attributes attributes){

        Map map = new HashMap();

        attributeService.addAttribute(attributes);
        map.put("dataId",attributes.getId());
        return ResultData.success(map);
    }


    //修改接口
    @PostMapping("update")
    public ResultData update(Attributes attributes){

        attributeService.updateAttribute(attributes);
        return ResultData.success(null);
    }


    //逻辑删除
    @PostMapping("deleteAttribute")
    public ResultData deleteAttribute(Integer id){

        attributeService.deleteAttribute(id);
        return ResultData.success(null);
    }


    //根据分类id查询对应的 sku数据 和非sku数据
    @GetMapping("queryAttrDataById")
    public ResultData queryAttrDataById(Integer typeId){

        Map attrData=attributeService.queryAttr(typeId);

        return ResultData.success(attrData);
    }

}
