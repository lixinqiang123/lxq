package com.lxq.api.controller;

import com.lxq.api.entity.po.Attributes;
import com.lxq.api.entity.vo.AttributeVo;
import com.lxq.api.entity.vo.ResultData;
import com.lxq.api.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController  //代表类上加@controller  该类下的每个方法里都默认加了 @responsebody
@CrossOrigin     //解决跨域问题
@RequestMapping("api/attribute/")
public class AttributeController {


    @Autowired
    private AttributeService attributeService;


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

}
