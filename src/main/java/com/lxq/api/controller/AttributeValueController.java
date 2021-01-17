package com.lxq.api.controller;


import com.lxq.api.entity.vo.ResultData;
import com.lxq.api.service.AttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/attrvalue/")
public class AttributeValueController {


    @Autowired
    private AttributeValueService attributeValueService;


    //根据id查询
    @GetMapping("getData")
    public ResultData getData(Integer id){

        Map attrValue=attributeValueService.queryAttrValue(id);

        return ResultData.success(attrValue);
    }


}
