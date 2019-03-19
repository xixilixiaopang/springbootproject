package com.shuai.springbootproject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate1;

    /**
     * 指定缓存失效日期
     * @param key 键
     * @param time 时间（秒）
     * @return
     */
    public boolean expire(String key,long time){
        try{
            if(time > 0){
                redisTemplate1.expire(key,time,TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取过期时间
     * @param key 键 不能为null
     * @return 时间（秒） 返回0代表永久有效
     */
    public long getExpire(String key){
        return redisTemplate1.getExpire(key);
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return ture 存在 false 不存在
     */
    public boolean haskey(String key){
        try{
            return redisTemplate1.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * @param key 可以传一个值或多个
     */
    public void del (String... key){
        if(key !=null && key.length > 0){
            if(key.length == 1){
                redisTemplate1.delete(key[0]);
            }else{
                redisTemplate1.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 普通缓存放入
     * @param key 键
     * @param value 值
     * @return true 成功 false 失败
     */
    public boolean set(String key,Object value){
        try{
            redisTemplate1.opsForValue().set(key,value);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取
     * @param key 键
     * @return true 成功 false 失败
     */
    public Object get(String key){
        try{
            return redisTemplate1.opsForValue().get(key);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 普通缓存放入并设置时间
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key,Object value,long time){
        try{
            if(time > 0){
                redisTemplate1.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }else{
                set(key,value);
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     * @param key 键
     * @param delta 要增加几（大于0）
     * @return
     */
    public long incr(String key,long delta){
        if(delta < 0){
            throw new RuntimeException("递增银子必须大于0");
        }
        return redisTemplate1.opsForValue().increment(key,delta);
    }

    /**
     * 递减
     * @param key 键
     * @param delta 要减少几（大于0）
     * @return
     */
    public long decr(String key,long delta){
        if(delta < 0){
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate1.opsForValue().increment(key,-delta);
    }

/*    *//**
     * HashSet
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return 值
     *//*
    public Object hget(String key,String item){

    }*/
}
