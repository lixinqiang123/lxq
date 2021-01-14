package com.lxq.api.controller;

import com.lxq.api.entity.vo.AttributeVo;
import com.lxq.api.entity.vo.ResultData;
import com.lxq.api.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
