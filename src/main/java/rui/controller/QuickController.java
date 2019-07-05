package rui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rui.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class QuickController {

    @Value("${name}")
    private String name;
    @RequestMapping("quick")
    @ResponseBody
    public String quick() {
        return "hello SpringBoot";
    }

    @RequestMapping("quick2")
    @ResponseBody
    public String quick2() {
        return "name:" + name;
    }

    @RequestMapping("show1")
    public String show1(Model model) {
        model.addAttribute("msg", "thymeleaf");
        model.addAttribute("date", new Date());
        model.addAttribute("sex", "男");
        return "index";
    }

    @RequestMapping("show2")
    public String show2(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "张三", "123"));
        list.add(new User(2, "李四", "345"));
        list.add(new User(3, "王五", "234"));
        model.addAttribute("list", list);
        return "index2";
    }

    @RequestMapping("show3")
    public String show3(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("u1", new User(1, "张三", "123"));
        map.put("u2", new User(2, "李四", "345"));
        map.put("u3", new User(3, "王五", "234"));
        model.addAttribute("map", map);
        return "index3";
    }

    @RequestMapping("show4")
    private String show4(HttpServletRequest request) {
        request.setAttribute("request", "HttpServletRequest");
        request.getSession().setAttribute("session", "HttpSession");
        request.getSession().getServletContext().setAttribute("application", "application");
        return "index1";
    }
}
