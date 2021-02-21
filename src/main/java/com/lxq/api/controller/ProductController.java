package com.lxq.api.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.model.JsonFormat;
import com.lxq.api.dao.ProductDatasDao;
import com.lxq.api.entity.po.Product;
import com.lxq.api.entity.po.ProductAttrdatas;
import com.lxq.api.entity.vo.ProductVo;
import com.lxq.api.entity.vo.ResultData;
import com.lxq.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController   //注解代表 类上加@Controller   此类的每个方法上都加@ResponseBody
@CrossOrigin   //解决跨域问题
@RequestMapping("api/product/")   //提供一个访问地址
public class ProductController {


    @Autowired  //注入
    private ProductService productService;


    @Autowired
    private ProductDatasDao productDatasDao;

    //商品基本信息的新增
    @PostMapping("addProduct")
    @Transactional
    public void addProduct(Product product,String attr,String sku){

        //先新增商品的基本信息
        productService.addProduct(product);

        //创建数据对象 集合
        List<ProductAttrdatas> attrdatasList=new ArrayList<>();

        //将attr字符串数组 转换成json数组
        JSONArray array = JSONObject.parseArray(attr);

        //循环遍历
        for (int i = 0; i <array.size() ; i++) {

            //创建需要赋值的对象
            ProductAttrdatas pdas= new ProductAttrdatas();

            //需要赋值的id
            pdas.setProId(product.getId());

            //需要赋值的数据
            pdas.setAttrData(array.get(i).toString());

            //然后把对象添加到list集合中
            attrdatasList.add(pdas);

        }



        //在将sku数据 进行转换成 数组对象
        JSONArray jsonArray = JSONObject.parseArray(sku);
        for (int i = 0; i <jsonArray.size() ; i++) {

            //得到具体一个json对象
            JSONObject objjson = (JSONObject) jsonArray.get(i);

            //在创建需要赋值的对象
            ProductAttrdatas pdas= new ProductAttrdatas();

            //商品的主键id
            pdas.setProId(product.getId());

            //处理sku数据里的 价格和库存数据
            pdas.setPrice(objjson.getDouble("skuprice"));
            pdas.setStorcks(objjson.getInteger("stocksku"));

            //库存和价格 给字段赋完值后 移除掉两个key 防止重复存放到里面
            objjson.remove("skuprice");
            objjson.remove("stocksku");
            //获取每一条数据
            pdas.setAttrData(jsonArray.get(i).toString());

            //添加到集合里
            attrdatasList.add(pdas);
        }


        //最终进行批量新增
        productDatasDao.addList(attrdatasList);

    }



    //查询
    @GetMapping("getData")
    public ResultData getData(ProductVo productVo){

        Map productlist=productService.queryProductData(productVo);

        return ResultData.success(productlist);
    }

    //修改商品的基本信息
    @PostMapping("updateProduct")
    public ResultData updateProduct(Product product){

        productService.updateProd(product);

        return ResultData.success(null);
    }


    //根据商品id查询数据
    @GetMapping("queryProductDataById")
    public ResultData queryProductDataById(Integer pid){

        List<ProductAttrdatas> productAttrdatasList=productDatasDao.queryProductDataById(pid);

        return ResultData.success(productAttrdatasList);
    }
}
