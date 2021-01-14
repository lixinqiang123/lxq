package com.lxq.api.controller;


import com.lxq.api.entity.po.Brand;
import com.lxq.api.entity.vo.BrandVo;
import com.lxq.api.entity.vo.ResultData;
import com.lxq.api.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.UUID;


/**
 * 加个注解 才能看清楚
 *
 * 是这样吗
 *
 */

@RestController  //加此注解 代表类上加@controller   方法默认加 @responsebody
@CrossOrigin     //解决跨域注解
@RequestMapping("api/brand/")
public class BrandController {


    @Autowired
    private BrandService brandService;


    //查询
    @GetMapping("getData")
    public ResultData getData(BrandVo brandVo){

        Map brandData=brandService.queryBrand(brandVo);

        return ResultData.success(brandData);
    }


    //新增
    @PostMapping("add")
    public ResultData add(Brand brand){

        brandService.addBrand(brand);

        return ResultData.success(null);
    }


    //图片上传
    @RequestMapping("uploadFile")
    public ResultData uploadFile(MultipartFile img, HttpServletRequest request){

        //获取图片的上传路径
        String realPath = request.getServletContext().getRealPath("/images");


        //创建file对象
        File file = new File(realPath);

        //判断文件夹是否存在
        if(file.exists()==false){

            //创建
            file.mkdirs();
        }

        //获取传过来的图片名称
        String originalFilename = img.getOriginalFilename();

        //创建虚假名称
        String falseName = UUID.randomUUID().toString();

        //截取图片名称
        int i = originalFilename.lastIndexOf(".");

        String houzhui = originalFilename.substring(i);

        //把截取到图片后缀 把虚假名称拼到一起
        String newName=falseName+houzhui;



        try {
            //先读流
            InputStream is = img.getInputStream();

            //写流
            FileOutputStream os = new FileOutputStream(realPath+"/"+newName);


            //创建写的子节
            byte[] by = new byte[1024*2];

            while (is.read(by)!=-1){

                os.write(by);
            }

            //关流
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResultData.success("http://192.168.1.49:8082/images/"+newName);
    }


    //修改 回显 id 必传
    @GetMapping("updateShowData")
    public ResultData updateShowData(Integer id){

        Brand brand=brandService.queryBrandById(id);

        return ResultData.success(brand);
    }


    //修改
    @PostMapping("updateBrand")
    public ResultData updateBrand(Brand brand){

        brandService.updateBrand(brand);

        return ResultData.success(null);
    }


    //删除
    @DeleteMapping("deleteBrand")
    public ResultData deleteBrand(Integer id){


        brandService.deleteBrand(id);
        return ResultData.success(null);
    }

}
