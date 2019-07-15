package rui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import rui.model.User;

import javax.validation.Valid;

@Controller
public class UserController {
    @RequestMapping("addUser")
    public String showAdd(@ModelAttribute("aa") User user) {
        return "add";
    }

    /**
     * BindingResult封装了校验结果，Valid开启对象的数据校验
     * @param user
     * @param result
     * @return
     */
    @RequestMapping("save")
    public String saveUser(@Valid @ModelAttribute("aa") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        System.out.println(user);
        return "success";
    }
}
