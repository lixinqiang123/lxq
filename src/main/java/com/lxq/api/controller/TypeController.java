package com.lxq.api.controller;


import com.lxq.api.entity.po.Type;
import com.lxq.api.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //代表类上加@controller  方法上都加 @responsebody
@RequestMapping("api/type/")
@CrossOrigin    //解决跨域问题
public class TypeController {


    @Autowired
    private TypeService typeService;

    /**
     * 路径:http://192.168.79.1:8080/api/type/getData
     *
     * 请求方式：get
     *
     * 参数：暂定
     *
     * 返回值：{"code":,"message":"",data:[{id:,name:,}]}
     *
     * @return
     */

    @GetMapping("getData")
    public Map getData(){

        Map map = new HashMap();

        List<Type> typeList=typeService.queryType();
        if(typeList.size()==0){
            map.put("code",100);
            map.put("message","查询失败");
            map.put("data",typeList);
        }else{
            map.put("code",200);
            map.put("message","查询成功");
            map.put("data",typeList);
        }
        return map;
    }


    //查询指定pid的内容
    @GetMapping("getDataByPid")
    public Map getDataByPid(Integer pid){
        Map map = new HashMap();

        List<Type> typeList=typeService.queryTypeByPid(pid);

        if(typeList.size()==0){
            map.put("code",100);
            map.put("message","指定参数没有传或者没有指定参数对应的数据");
            map.put("data",typeList);
        }else{
            map.put("code",200);
            map.put("message","查询成功");
            map.put("data",typeList);
        }

        return map;
    }

    /**
     * 请求路径：http://192.168.79.1:8080/api/type/add
     *
     * 请求方式：post
     *
     * 参数 pid  name
     *
     * 返回值 {"code":200,"message":"新增成功","data":主键id}
     *
     * @param type
     * @return
     */

    @PostMapping("add")
    public Map add(Type type){
        Map map = new HashMap();

        typeService.addType(type);
        map.put("code",200);
        map.put("message","新增成功");
        map.put("data",type.getId());
        return map;
    }


    /**
     *
     * 路径:  http://192.168.79.1:8080/api/type/getData
     *      *
     *      * 请求方式：post
     *      *
     *      * 参数：id 必传
     *
     *             (选填)
     *              pid
     *
     *              name
     *
     *              isDel
     *      *
     *      * 返回值：{"code":,"message":"",data:[{id:,name:,}]}
     *
     * @param pid
     * @param name
     * @param isDel
     * @param id
     * @return
     */

    //修改信息
    @PostMapping("update")
    public Map update(Integer pid,String name,Integer isDel,Integer id){
        Map map = new HashMap();


        typeService.update(pid,name,isDel,id);
        return map;
    }
}
