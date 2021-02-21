package com.lxq.api.service.impl;

import com.lxq.api.dao.AttributeDao;
import com.lxq.api.dao.AttributeValueDao;
import com.lxq.api.entity.po.AttrValue;
import com.lxq.api.entity.po.Attributes;
import com.lxq.api.entity.vo.AttributeValue;
import com.lxq.api.entity.vo.AttributeVo;
import com.lxq.api.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service  //声明业务逻辑处理层
public class AttributeServiceImpl  implements AttributeService {


    @Autowired
    private AttributeDao attributeDao;

    @Autowired
    private AttributeValueDao attributeValueDao;


    @Override
    public Map queryAttribute(AttributeVo attributeVo) {

        Map map = new HashMap();

        //查询总条数
        Long attributeCount=attributeDao.queryAttribute(attributeVo);

        map.put("count",attributeCount);

        //计算起始下标
        Integer startIndex=(attributeVo.getPage()-1)*attributeVo.getSize();

        attributeVo.setStartIndex(startIndex);

        //查询分页后的数据
        List<AttributeValue> attributesList=attributeDao.queryAttributeLimit(attributeVo);

        map.put("data",attributesList);
        return map;
    }

    //新增
    @Override
    public void addAttribute(Attributes attributes) {

        attributes.setCreateDate(new Date());
        attributes.setUpdateDate(new Date());
        attributes.setAuthor("admin");
        attributes.setIsDel(0);
        attributeDao.addAttribute(attributes);
    }

    @Override
    public void updateAttribute(Attributes attributes) {

        attributes.setCreateDate(new Date());
        attributes.setUpdateDate(new Date());
        attributes.setIsDel(0);
        attributeDao.updateAttribute(attributes);
    }

    //逻辑删除
    @Override
    public void deleteAttribute(Integer id) {

        attributeDao.deleteAttribute(id);
    }

    //根据id查询
    @Override
    public Attributes queryAttrById(Integer id) {
        return attributeDao.queryAttrById(id);
    }




    //根据分类id查询对应的 sku数据和非sku数据
    @Override
    public Map queryAttr(Integer typeId) {

        //声明返回的数据
        Map map = new HashMap();

        // 根据 typeid查询出所有的属性数据
        List<Attributes> attrs=attributeDao.queryAttrByTypeId(typeId);

        //声明空的list集合 存放数据
        List<Attributes> skuDatas= new ArrayList<>();

        List<Attributes> attrDatas=new ArrayList<>();

        //遍历所有属性的数据 找出sku数据和 非sku数据
        for (int i = 0; i <attrs.size(); i++) {

            //获取到某一条数据
            Attributes attributes = attrs.get(i);

            //判断此属性是不是sku
            if(attributes.getIsSKU()==1){ //是sku数据

                //在判断type 是不是输入框 如果是输入框 就没有values
                if(!attributes.getType().equals(4)){  //是sku数据

                    //获取当天这条数据的id 去attrvalue 数据库 查询出对应的数据
                    List<AttrValue> skuValues = attributeValueDao.queryAttrValue(attributes.getId());
                    //给我们的字段进行赋值
                    attributes.setValues(skuValues);
                }

                //把当前这条数据添加到集合中
                skuDatas.add(attributes);

            }else{ //不是 sku数据

                //输入框没values
                if(!attributes.getType().equals(4)){

                    //查询 此属性 对应的选项值
                    List<AttrValue> attrValues = attributeValueDao.queryAttrValue(attributes.getId());
                    attributes.setValues(attrValues);
                }

                //添加道不是 sku数据的 list集合中
                attrDatas.add(attributes);

            }

        }


        //sku数据
        map.put("skuDatas",skuDatas);

        //不是 sku的 数据
        map.put("attrDatas",attrDatas);

        //把map集合返回过去
        return map;
    }


}
