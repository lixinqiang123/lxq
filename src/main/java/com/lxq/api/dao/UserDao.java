package com.lxq.api.dao;


import com.lxq.api.entity.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from shop_user where 1=1 and name=#{name}")
    User queryUser(String name);

    @Insert("insert into shop_user(name,realName,password,sex,phone,email,idCard,birthday,imgUrl,eduId,deptId,createDate,updateDate)" +
            "VALUE(#{name},#{realName},#{password},#{sex},#{phone},#{email},#{idCard},#{birthday},#{imgUrl},#{eduId},#{deptId},#{createDate},#{updateDate})")
    void addUser(User user);

    @Select("select * from shop_user where 1=1 and name=#{username}")
    User queryUserByName(String username);
}
