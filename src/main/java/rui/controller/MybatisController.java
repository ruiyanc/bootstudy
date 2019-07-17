package rui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rui.dao.UserMapper;
import rui.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MybatisController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("query")
    public List<User> queryUser() {
        List<User> users = userMapper.queryUser();
        return users;
    }

}
