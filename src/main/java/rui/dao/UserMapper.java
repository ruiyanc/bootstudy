package rui.dao;

import org.apache.ibatis.annotations.Mapper;
import rui.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> queryUser();
}
