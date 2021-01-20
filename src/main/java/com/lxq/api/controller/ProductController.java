package com.lxq.api.controller;


import com.lxq.api.entity.po.Product;
import com.lxq.api.entity.vo.ResultData;
import com.lxq.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   //注解代表 类上加@Controller   此类的每个方法上都加@ResponseBody
@CrossOrigin      //解决跨域问题
@RequestMapping("api/product/")   //提供一个访问地址
public class ProductController {


    @Autowired  //注入
    private ProductService productService;


    //商品基本信息的新增
    @PostMapping("addProduct")
    public ResultData addProduct(Product product){

        productService.addProduct(product);

        return ResultData.success(null);
    }
}
