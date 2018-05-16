package com.example.springbootreids;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootReidsApplicationTests {

	@Test
	public void contextLoads() {
	}


    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void set(){
        redisTemplate.opsForValue().set("test:set","testValue1");
    }

    @Test
    public void set1(){
        Map<String, Object> map = new HashMap<>();
        map.put("userid","11111");
        map.put("sex","1");
        map.put("age","16");
        redisTemplate.opsForValue().set("11111",map);
    }

    @Test
    public void get(){
        Map<String, Object> map = (Map<String, Object>) redisTemplate.opsForValue().get("map:11122211");
        System.out.println(map.toString());
    }

    @Test
    public void  delete(){
        redisTemplate.delete("11111");
    }
}

class user {
    private String userid;
    private int bb;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getBb() {
        return bb;
    }

    public void setBb(int bb) {
        this.bb = bb;
    }

    @Override
    public String toString() {
        return "user{" +
                "userid='" + userid + '\'' +
                ", bb=" + bb +
                '}';
    }
}
