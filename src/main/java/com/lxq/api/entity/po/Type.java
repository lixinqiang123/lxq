package com.lxq.api.entity.po;

import java.util.Date;

public class Type {



    private Integer id; //int NULL COMMENT '主键',
    private String name; //varchar NULL COMMENT '分类名称',
    private Integer pid; //int NULL COMMENT '上级id',
    private Date    createDate; //datetime NULL COMMENT '分类的创建时间',
    private Date    updateDate; //datetime NULL COMMENT '修改时间',
    private Integer isDel; //int NULL COMMENT '是否删除（0   未删除  1 删除）',

    private String  operator;  //操作人 默认 admin


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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
