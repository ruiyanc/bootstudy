package rui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
