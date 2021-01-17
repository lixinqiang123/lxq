package com.lxq.api.controller;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import com.lxq.api.entity.po.Brand;
import com.lxq.api.entity.vo.BrandVo;
import com.lxq.api.entity.vo.ResultData;
import com.lxq.api.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
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


    //图片上传 上传到阿里上面
    @RequestMapping("uploadoss")
    public ResultData uploadoss(MultipartFile  img) throws IOException {

        Map map = new HashMap();

        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        String accessKeyId = "LTAI4G4uJKPBqNTmhFL2QPCG";
        String accessKeySecret = "ph6vPKpYRVXz8O5DKv4XmLH4pNYnSs";
        String bucketName = "2006lxq";

        //获取文件的真实名称
        String originalFilename = img.getOriginalFilename();

        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = "images/"+originalFilename;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);


        PutObjectResult putObjectResult = ossClient.putObject(bucketName, objectName, img.getInputStream());

        System.out.println(putObjectResult);

        map.put("data","https://"+bucketName+"."+endpoint+"/"+objectName);
        // 关闭OSSClient。
        ossClient.shutdown();
        return ResultData.success(map);
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
