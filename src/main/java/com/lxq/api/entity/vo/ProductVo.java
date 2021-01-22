package com.lxq.api.entity.vo;

public class ProductVo {

    //页数
    private  Integer page;

    //每页显示的条数
    private  Integer size;

    //起始下标
    private  Integer startIndex;

    //根据商品名称查询
    private  String  serchname;

    //根据品牌名称进行查询
    private  Integer branid;

    private  String  name;

    private  String imgPath;

    private  Integer price;

    private Integer sortNum;

    private Integer id;

    private Integer stocks;

    private String  brandname;

    //品牌id
    private Integer bid;

    //类型id
    private Integer typeId;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public String getSerchname() {
        return serchname;
    }

    public void setSerchname(String serchname) {
        this.serchname = serchname;
    }

    public Integer getBranid() {
        return branid;
    }

    public void setBranid(Integer branid) {
        this.branid = branid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStocks() {
        return stocks;
    }

    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }
}
