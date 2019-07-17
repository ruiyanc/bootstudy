package rui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import rui.model.User;
import rui.utils.JsonUtils;
import rui.utils.RedisClient;

@RestController
@RequestMapping("redis")
public class RedisTestController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private RedisClient redisClient;

    @GetMapping("add")
    public ModelAndView add() {
        redisTemplate.opsForValue().set("name","张三");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        return mv;
    }

    @GetMapping("get")
    public String get() {
        String name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
        return "ok";
    }

    @GetMapping("save_user")
    public ModelAndView saveUser() {
        ModelAndView mv = new ModelAndView();
        User user = new User(1, "abc", "123");
        String s = JsonUtils.obj2String(user);
        redisClient.set("base:user:1", s);
        mv.setViewName("success");
        return mv;
    }

}
