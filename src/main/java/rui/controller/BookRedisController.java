package rui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rui.model.Book;
import rui.utils.JsonUtils;

@RestController
public class BookRedisController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/test1")
    public void test1() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("book_name", "三国演义");
        String name = ops.get("book_name");
        System.out.println(name);
        Book book = new Book(1, "红楼梦", "曹雪芹");
        String s = JsonUtils.obj2String(book);
        ops.set("base:book:1", s);
        System.out.println(s);
    }
}
