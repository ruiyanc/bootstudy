package rui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rui.dao.UserMapper;
import rui.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MybatisController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("query")
    @ResponseBody
    public List<User> queryUser() {
        List<User> users = userMapper.queryUser();
        return users;
    }

    @RequestMapping("show")
    public String showUser(Model model) {
        List<User> list = userMapper.queryUser();
        model.addAttribute("list", list);
        return "list";
    }
}
