package com.lxq.api.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Attributes {


       private Integer   id;    //主键

       private String    name;  //属性名   color

       private String    nameCH;  //属性中文名   颜色

       private Integer   typeId;   //分类的主键

       private String    type;     //属性的类型    0 下拉框     1 单选框      2  复选框   3  输入框

       private Integer   isSKU;  //是否为sku属性

       private Integer   isDel;   //逻辑删除


        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
       @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
       private Date      createDate;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
       @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
       private Date updateDate;

       private String    author; //操作人


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCH() {
        return nameCH;
    }

    public void setNameCH(String nameCH) {
        this.nameCH = nameCH;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIsSKU() {
        return isSKU;
    }

    public void setIsSKU(Integer isSKU) {
        this.isSKU = isSKU;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
